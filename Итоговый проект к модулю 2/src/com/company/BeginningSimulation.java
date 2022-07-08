package com.company;

import com.company.island.Plants;
import com.company.island.animal.ActionAnimal;
import com.company.island.animal.Animal;
import com.company.island.animal.HerbivoresAnimal;
import com.company.island.annotations.InfoAnimal;

import com.company.basics.*;

import java.lang.reflect.*;
import java.util.ArrayList;


public class BeginningSimulation {

    public static void startСycle() {
        if (SettingsSimulation.getInstance().getEndGame() != null) {
            int howCycleSimulation = SettingsSimulation.getInstance().getTimeLiveGame();
            while (howCycleSimulation > 0) {
                if (SettingsSimulation.getInstance().getEndGame().contains("травоядные")) {
                    if (!Check.checkHerbivores()) {
                        System.out.println(StartSimulation.ANSI_RED + "Симуляция закончена, все травоядные погибли!" + StartSimulation.ANSI_RESET);
                        System.exit(0);
                    } else {
                        eventDuringAllDay();
                        afterDaySimulation();
                        if (howCycleSimulation % 3 == 0) {
                            StartSimulation.spawnPlants();
                        }
                        Information.printPlace();
                        howCycleSimulation--;
                    }
                } else {
                    if (!Check.checkPredator()) {
                        System.out.println(StartSimulation.ANSI_RED + "Симуляция закончена, все хищники погибли!" + StartSimulation.ANSI_RESET);
                        System.exit(0);
                    }
                    eventDuringAllDay();
                    afterDaySimulation();
                    if (howCycleSimulation % 3 == 0) {
                        StartSimulation.spawnPlants();
                    }
                    Information.printPlace();
                    howCycleSimulation--;
                }
            }
        } else {
            int howCycleSimulation = SettingsSimulation.getInstance().getTimeLiveGame();
            while (howCycleSimulation > 0) {
                eventDuringAllDay();
                afterDaySimulation();
                if (howCycleSimulation % 3 == 0) {
                    StartSimulation.spawnPlants();
                }
                Information.printPlace();
                howCycleSimulation--;
            }

        }
    }

    private static void afterDaySimulation() {
        Animal.setCountDeath();
        Animal.setCountBirthday();
        deleteDied();
        minusEat();
        editTurn();
        //multiply();
        editMultiply();
    }

    private static void eventDuringAllDay() {
        selectTurn();
        eat();
    }

    private static void selectTurn() {
        ArrayList<Object>[][] island = SettingsSimulation.getInstance().getArrays();
        for (int i = 0; i < Position.getInstance().getY(); i++) {
            for (int j = 0; j < Position.getInstance().getX(); j++) {
                for (int k = 0; k < island[i][j].size(); k++) {
                    Class<?> classAnimal = island[i][j].get(k).getClass();
                    if (classAnimal.isAnnotationPresent(InfoAnimal.class)) {
                        InfoAnimal infoAnimal = (InfoAnimal) classAnimal.getAnnotation(InfoAnimal.class);
                        int speed = infoAnimal.speed();
                        int maxInOnePlace = infoAnimal.maxInOnePlace();
                        boolean isTurn = false;
                        Method method = null;
                        try {
                            method = Animal.class.getDeclaredMethod("isTurn");
                            method.setAccessible(true);
                            isTurn = Boolean.valueOf((boolean) method.invoke(island[i][j].get(k)));
                        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        if (isTurn) {
                            try {
                                Method selectDirection = ActionAnimal.class.getDeclaredMethod("selectDirection", int.class, int.class, int.class);
                                selectDirection.setAccessible(true);
                                selectDirection.invoke(island[i][j].get(k), i, j, speed);
                            } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                                e.printStackTrace();
                            }

                            try {
                                Method setTurn = Animal.class.getDeclaredMethod("setTurn", boolean.class);
                                setTurn.setAccessible(true);
                                setTurn.invoke(island[i][j].get(k), false);
                            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException exception) {
                                exception.printStackTrace();
                            }

                            int turnAnimalX = ResultsAction.getX();
                            int turnAnimalY = ResultsAction.getY();
                            if (turnAnimalX == i && turnAnimalY == j) {

                            } else {
                                if ((Check.checkNearbyPlace(island[turnAnimalX][turnAnimalY], island[i][j].get(k)))) {
                                    island[turnAnimalX][turnAnimalY].add(island[i][j].get(k));
                                    island[i][j].remove(k);
                                    k--;
                                }
                            }
                        }
                    }
                }
            }
        }
        SettingsSimulation.getInstance().setArrays(island);
    }

    private static void deleteDied() {
        ArrayList<Object>[][] island = SettingsSimulation.getInstance().getArrays();
        for (int i = 0; i < Position.getInstance().getY(); i++) {
            for (int j = 0; j < Position.getInstance().getX(); j++) {
                for (int k = 0; k < island[i][j].size(); k++) {
                    boolean isLive = Check.checkDead(island[i][j].get(k));
                    if (!isLive) {
                        Class classAnimal = island[i][j].get(k).getClass();
                        String nameMethod = "minusCount" + classAnimal.getSimpleName();
                        try {
                            Method method = classAnimal.getMethod(nameMethod);
                            method.invoke(island[i][j].get(k));
                        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                        island[i][j].remove(k);
                        Animal.plusCountDeath();
                        k--;
                    }
                }
            }
        }
        SettingsSimulation.getInstance().setArrays(island);
        ;
    }

    private static void minusEat() {
        ArrayList<Object>[][] island = SettingsSimulation.getInstance().getArrays();
        for (int i = 0; i < Position.getInstance().getY(); i++) {
            for (int j = 0; j < Position.getInstance().getX(); j++) {
                for (int k = 0; k < island[i][j].size(); k++) {
                    Class animalClass = island[i][j].get(k).getClass();
                    if (animalClass.isAnnotationPresent(InfoAnimal.class)) {
                        animalClass = island[i][j].get(k).getClass().getSuperclass().getSuperclass();
                        try {
                            Method method = animalClass.getDeclaredMethod("minusCountEat");
                            method.invoke(island[i][j].get(k));
                        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        SettingsSimulation.getInstance().setArrays(island);
    }

    private static void editTurn() {
        ArrayList<Object>[][] island = SettingsSimulation.getInstance().getArrays();
        for (int i = 0; i < Position.getInstance().getY(); i++) {
            for (int j = 0; j < Position.getInstance().getX(); j++) {
                for (int k = 0; k < island[i][j].size(); k++) {
                    if (island[i][j].get(k).getClass().isAnnotationPresent(InfoAnimal.class)) {
                        Method method = null;
                        try {
                            Method setTurn = Animal.class.getDeclaredMethod("setTurn", boolean.class);
                            setTurn.setAccessible(true);
                            setTurn.invoke(island[i][j].get(k), true);
                        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        SettingsSimulation.getInstance().setArrays(island);
    }

    private static void eat() {
        ArrayList<Object>[][] island = SettingsSimulation.getInstance().getArrays();
        for (int i = 0; i < Position.getInstance().getY(); i++) {
            for (int j = 0; j < Position.getInstance().getX(); j++) {
                for (int k = 0; k < island[i][j].size(); k++) {
                    int howMuchCycleEating = 3;
                    if (island[i][j].get(k).getClass().isAnnotationPresent(InfoAnimal.class)) {
                        if (!island[i][j].get(k).getClass().getAnnotation(InfoAnimal.class).russianName().equalsIgnoreCase("гусеница")) {
                            Class<?> animal = island[i][j].get(k).getClass();

                            if (island[i][j].get(k) instanceof HerbivoresAnimal) {
                                try {
                                    Method getHowFood = Animal.class.getDeclaredMethod("getHowFood");
                                    getHowFood.setAccessible(true);
                                    howMuchCycleEating = ((int) Math.round((Double) getHowFood.invoke(island[i][j].get(k))) / 3);
                                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                            while (howMuchCycleEating > 0) {
                                try {
                                    Method eatInterface = ActionAnimal.class.getDeclaredMethod("eat", ArrayList.class, int.class);
                                    eatInterface.setAccessible(true);
                                    eatInterface.invoke(island[i][j].get(k), island[i][j], k);
                                } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                                    e.printStackTrace();

                                }
                                int indexRemove = ResultsAction.getIndexRemoveObj();
                                if (indexRemove != Integer.MAX_VALUE) {
                                    Method methodDied = null;
                                    if (island[i][j].get(indexRemove) instanceof Animal) {
                                        try {
                                            methodDied = Animal.class.getDeclaredMethod("setLive", boolean.class);
                                            methodDied.setAccessible(true);
                                            methodDied.invoke(island[i][j].get(indexRemove), false);
                                        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                                            e.printStackTrace();
                                        }
                                    } else {
                                        try {
                                            methodDied = Plants.class.getDeclaredMethod("setLive", boolean.class);
                                            methodDied.setAccessible(true);
                                            methodDied.invoke(island[i][j].get(indexRemove), false);
                                        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                                            e.printStackTrace();
                                        }
                                    }

                                }
                                howMuchCycleEating--;
                            }
                        }
                    }
                }
            }
        }
        SettingsSimulation.getInstance().setArrays(island);
    }

    private static void multiply() {
        ArrayList<Object>[][] island = SettingsSimulation.getInstance().getArrays();
        for (int i = 0; i < Position.getInstance().getY(); i++) {
            for (int j = 0; j < Position.getInstance().getX(); j++) {
                for (int k = 0; k < island[i][j].size(); k++) {
                    if (island[i][j].get(k).getClass().isAnnotationPresent(InfoAnimal.class)) {
                        try {
                            Method multiply = ActionAnimal.class.getDeclaredMethod("multiply", ArrayList.class, int.class);
                            multiply.setAccessible(true);
                            multiply.invoke(island[i][j].get(k), island[i][j], k);
                        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        ArrayList<Object> listAnimal = ResultsAction.getListAnimal();
                        for (var animal : listAnimal) {
                            island[i][j].add(animal);
                        }

                    }
                }
            }
        }
        SettingsSimulation.getInstance().setArrays(island);
    }

    private static void editMultiply() {
        ArrayList<Object>[][] island = SettingsSimulation.getInstance().getArrays();
        for (int i = 0; i < Position.getInstance().getY(); i++) {
            for (int j = 0; j < Position.getInstance().getX(); j++) {
                for (int k = 0; k < island[i][j].size(); k++) {
                    if (island[i][j].get(k).getClass().isAnnotationPresent(InfoAnimal.class)) {
                        try {
                            Method setTrue = Animal.class.getDeclaredMethod("setMultiplyTrue");
                            setTrue.setAccessible(true);
                            setTrue.invoke(island[i][j].get(k));
                        }catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        SettingsSimulation.getInstance().setArrays(island);
    }
}

