package com.company.island.animal;

import com.company.basics.ChanceToEat;
import com.company.basics.ResultsAction;
import com.company.basics.Position;
import com.company.island.Plants;
import com.company.island.annotations.InfoAnimal;
import com.company.island.annotations.InfoPlants;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public interface ActionAnimal {

    default void multiply(ArrayList<?> listAnimals, int index) {
        Class basicAnimal = listAnimals.get(index).getClass();
        Object objBasicAnimal = listAnimals.get(index);
        ArrayList<Object> list = new ArrayList<>();
        listAnimals.remove(index);
        for (var animal : listAnimals) {
            if (animal.getClass().getSimpleName().equalsIgnoreCase(basicAnimal.getSimpleName())) {
                try {
                    Method getChild = Animal.class.getDeclaredMethod("getMaxChildrenAnimals");
                    Method isMultiply = Animal.class.getDeclaredMethod("getMultiply");
                    int maxChildren = Integer.valueOf((int) getChild.invoke(animal));
                    int billChild = ThreadLocalRandom.current().nextInt(maxChildren+ 1);
                    isMultiply.setAccessible(true);
                    boolean multiplyFirstAnimal = Boolean.valueOf((boolean) isMultiply.invoke(objBasicAnimal));
                    boolean multiplySecondAnimal = Boolean.valueOf((boolean) isMultiply.invoke(animal));
                    if (multiplyFirstAnimal && multiplySecondAnimal) {
                        int count = 0;
                        while (billChild > count) {
                            Class clazz = Class.forName(basicAnimal.getName());
                            list.add(clazz.getDeclaredConstructor().newInstance());
                            Animal.plusCountBirth();
                            count++;
                        }
                    }
                } catch (NoSuchMethodException | InvocationTargetException |
                        IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        ResultsAction.setListAnimal(list);
    }

    default void eat(ArrayList<?> listAnimals, int index) {
        Class animal = listAnimals.get(index).getClass();
        int maxChanceEat = 0;
        Class eaten = null;
        int indexRemove = Integer.MAX_VALUE;
        InfoAnimal whoBeEat = (InfoAnimal) animal.getAnnotation(InfoAnimal.class);
        String keyMap = whoBeEat.russianName().toLowerCase(Locale.ROOT);

        for (int i = 0; i < listAnimals.size(); i++) {
            Method methodDied = null;
            boolean isLive = false;
            if (listAnimals.get(i) instanceof Animal) {
                try {
                    methodDied = Animal.class.getDeclaredMethod("isLive");
                    methodDied.setAccessible(true);
                    isLive = (boolean) methodDied.invoke(listAnimals.get(i));
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    methodDied = Plants.class.getDeclaredMethod("isLive");
                    methodDied.setAccessible(true);
                    isLive = (boolean) methodDied.invoke(listAnimals.get(i));
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            if (isLive) {
                if (ChanceToEat.mapAnimal.containsKey(keyMap)) {
                    String keyMapForEaten = null;
                    if (listAnimals.get(i).getClass().isAnnotationPresent(InfoAnimal.class)) {
                        InfoAnimal infoEatenAnimal = (InfoAnimal) listAnimals.get(i).getClass().getAnnotation(InfoAnimal.class);
                        keyMapForEaten = infoEatenAnimal.russianName().toLowerCase(Locale.ROOT);
                    } else if (listAnimals.get(i).getClass().isAnnotationPresent(InfoPlants.class)) {
                        InfoPlants infoEatenAnimal = (InfoPlants) listAnimals.get(i).getClass().getAnnotation(InfoPlants.class);
                        keyMapForEaten = infoEatenAnimal.russianName().toLowerCase(Locale.ROOT);
                    }


                    if (ChanceToEat.mapAnimal.get(keyMap).containsKey(keyMapForEaten)) {
                        if (ChanceToEat.mapAnimal.get(keyMap).get(keyMapForEaten) > maxChanceEat) {
                            maxChanceEat = ChanceToEat.mapAnimal.get(keyMap).get(keyMapForEaten);
                            indexRemove = i;
                            eaten = listAnimals.get(i).getClass();
                        }
                    }
                }
            }
        }
        if (eaten != null) {
            int randomValue = ThreadLocalRandom.current().nextInt(0, 101);
            if (randomValue <= maxChanceEat) {
                double weightFood = 0;
                if (eaten.isAnnotationPresent(InfoAnimal.class)) {
                    InfoAnimal eatenAnimal = (InfoAnimal) eaten.getAnnotation(InfoAnimal.class);
                    weightFood = eatenAnimal.weight();
                } else {
                    InfoPlants infoPlants = (InfoPlants) eaten.getAnnotation((InfoPlants.class));
                    weightFood = infoPlants.weight();
                }
                try {
                    Method setEat = Animal.class.getDeclaredMethod("setHowWeightForFullEating", double.class);
                    setEat.setAccessible(true);
                    setEat.invoke(listAnimals.get(index), weightFood);
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        ResultsAction.setIndexRemoveObj(indexRemove);

    }

    default void selectDirection(int y, int x, int speed) {
        int resultY = y;
        int resultX = x;
        int count = 0;
        //надо добавить прверку на макс в местоности
        while (count < speed) {
            int left = -1;//1
            int up = -1;//2
            int right = 1;//3
            int down = 1;//4

            if (resultX == 0) {
                left = 0;
            }
            if (resultY == 0) {
                up = 0;
            }
            if (resultX == Position.getInstance().getX() - 1) {
                right = 0;
            }
            if (resultY == Position.getInstance().getY() - 1) {
                down = 0;
            }

            int turn = ThreadLocalRandom.current().nextInt(1, 5);
            switch (turn) {
                case 1:
                    resultX = resultX + left;
                    break;
                case 2:
                    resultY = resultY + up;
                    break;
                case 3:
                    resultX = resultX + right;
                    break;
                case 4:
                    resultY = resultY + down;
                    break;
            }
            count++;
        }
        ResultsAction.setX(resultY);
        ResultsAction.setY(resultX);
    }
}


