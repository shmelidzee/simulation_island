package com.company.basics;

import com.company.island.animal.herbivores.*;
import com.company.island.animal.predator.*;
import com.company.island.annotations.InfoPlants;
import com.company.island.annotations.InfoAnimal;
import com.company.BeginningSimulation;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class StartSimulation {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static Scanner scanner = new Scanner(System.in);

    public void questionAboutParam() {
        int numberParametrs;
        System.out.println(ANSI_BLACK + "Приветствую тебя в нашей новой игре \"Симулятор острова\"!\n" +
                ANSI_BLACK + "Желаете изменить параметры по умолчанию?\n" +
                ANSI_GREEN + "1.Да\n" +
                ANSI_GREEN + "2.Оставить параметры по умолчанию");
        System.out.print(ANSI_BLUE + "Введите число: " + ANSI_RESET);
        numberParametrs = scanner.nextInt();
        switch (numberParametrs) {
            case 1:
                refactorParam();
                break;
            case 2:
                startGame();
                break;
            default:
                System.out.println(ANSI_RED + "Введено неверное значение, повторите попытку!\n" + ANSI_RESET);
                questionAboutParam();
        }

    }

    private void refactorParam() {
        System.out.println();
        System.out.println(ANSI_BLACK + "У нас есть возможность поменять следующие поля:\n" +
                ANSI_GREEN + "1.Размер поля\n" +
                "2.Время жизни симуляции\n" +
                "3.Дополнительные причины конца симуляции\n" +
                "0.Узнать текущие параметры");
        System.out.print(ANSI_BLUE + "Введите число: " + ANSI_RESET);
        int numSettings = scanner.nextInt();
        switch (numSettings) {
            case 1:
                refactorSizePlace();
                break;
            case 2:
                refactorTimeLive();
                break;
            case 3:
                refactorEndGame();
                break;
            case 0:
                printAllSettings();
                break;
            default:
                System.out.println(ANSI_RED + "Введено неверное значение, повторите попытку!" + ANSI_RESET);
                refactorParam();
        }
        System.out.println(ANSI_BLACK + "Желаете начать игру или еще изменить параметры?\n" +
                ANSI_GREEN + "1.Начать игру!\n" +
                "2.Поменять настройки");
        System.out.print(ANSI_BLUE + "Введите число:");
        int numOperation = scanner.nextInt();
        switch (numOperation) {
            case 1:
                System.out.println();
                startGame();
                break;
            case 2:
                refactorParam();
                break;
            default:
                System.out.println(ANSI_RED + "Ввели неверное значение!" + ANSI_RESET);
                refactorParam();
        }
    }

    private static void refactorTimeLive() {
        System.out.println(ANSI_BLACK + "\nВ данном меню мы можем поменять время жизни нашей программы");
        SettingsSimulation settingsSimulation = SettingsSimulation.getInstance();
        Class classSettingGame = settingsSimulation.getClass();
        System.out.println(ANSI_CYAN + "Сейчас время нашей жизни симуляции - " + ANSI_PURPLE + settingsSimulation.getTimeLiveGame());
        System.out.print(ANSI_BLUE + "Введите новое время симуляции(можете ввести старое значение):" + ANSI_RESET);
        int timeLive = scanner.nextInt();
        if (timeLive == settingsSimulation.getTimeLiveGame()) {

        } else {
            for (var declaredFields : settingsSimulation.getClass().getDeclaredFields()) {
                declaredFields.setAccessible(true);
                if (declaredFields.getName().equalsIgnoreCase("timeLiveGame")) {
                    try {
                        declaredFields.set(settingsSimulation, timeLive);
                        System.out.println();
                    } catch (IllegalAccessException e) {
                        System.out.println(ANSI_RED + "Ошибка в изменении такта симуляции!" + ANSI_RESET);
                    }
                }
            }
        }


    }

    private static void refactorEndGame() {
        System.out.println(ANSI_BLACK + "\nВ этом меню вы можете изменить дополнительный конец нашей симуляции");
        System.out.println("Выберите какой параметр хотите добавить:");
        SettingsSimulation settingsSimulation = SettingsSimulation.getInstance();
        System.out.println(ANSI_GREEN + "1.Оставить по умолчанию\n" +
                "2.Если умрут все травоядные\n" +
                "3.Если умрут все хищники");
        System.out.print(ANSI_BLUE + "Введите число: " + ANSI_RESET);
        int numSetting = scanner.nextInt();
        switch (numSetting) {
            case 1:
                break;
            case 2:
                settingsSimulation.setEndGame(settingsSimulation.getDiedHerbivores());
                break;
            case 3:
                settingsSimulation.setEndGame(settingsSimulation.getDiedPredator());
                break;
            default:
                System.out.println(ANSI_RED + "Введено неверное значение\n" + ANSI_RESET);
                refactorEndGame();
        }
        System.out.println();
    }

    private static void refactorSizePlace() {
        //ширина X
        Position position = Position.getInstance();
        System.out.println(ANSI_CYAN + "\nСейчас у нас размер поля: " + ANSI_PURPLE + position.getX() + "/" + position.getY());
        System.out.print(ANSI_BLUE + "Введите длину нашего поля:");
        int hight = scanner.nextInt();
        System.out.print(ANSI_BLUE + "Введите ширину нашего поля:" + ANSI_RESET);
        int width = scanner.nextInt();
        Class classPosition = position.getClass();
        for (var declaredFields : classPosition.getDeclaredFields()) {
            declaredFields.setAccessible(true);
            if (declaredFields.getName().equalsIgnoreCase("x")) {
                try {
                    declaredFields.set(Position.class, width);
                } catch (IllegalAccessException e) {
                    System.out.println(ANSI_RED + "Ошибка в изменении ширины!" + ANSI_RESET);
                }
            }
            if (declaredFields.getName().equalsIgnoreCase("y")) {
                try {
                    declaredFields.set(Position.class, hight);
                } catch (IllegalAccessException e) {
                    System.out.println(ANSI_RED + "Ошибка в изменении высоты!" + ANSI_RESET);
                }
            }
        }
        System.out.println();

    }

    private static void printAllSettings() {
        Position position = Position.getInstance();
        SettingsSimulation settingsSimulation = SettingsSimulation.getInstance();
        System.out.println(ANSI_BLACK + "\nНаша симуляция содержит следующие параметры:");
        System.out.println(ANSI_CYAN + "Размер игрового поля: " + ANSI_PURPLE + position.getY() + "/" + position.getX());
        System.out.println(ANSI_CYAN + "Время симуляции: " + ANSI_PURPLE + settingsSimulation.getTimeLiveGame());
        System.out.println(ANSI_CYAN + "Дополнительные параметры конца игры: " + ANSI_PURPLE + settingsSimulation.getEndGame());
    }

    private static void startGame() {
        Thread thread = new Thread(new MakeGamePlace());
        thread.run();
        spawnAnimals();
        BeginningSimulation.startСycle();
    }


    private static void spawnAnimals() {
        SettingsSimulation settingsSimulation = SettingsSimulation.getInstance();
        ArrayList<Class> listAnimals = new ArrayList<>();
        listAnimals.add(Bear.class);
        listAnimals.add(Eagle.class);
        listAnimals.add(Fox.class);
        listAnimals.add(Snake.class);
        listAnimals.add(Wolf.class);
        listAnimals.add(Bull.class);
        listAnimals.add(Deer.class);
        listAnimals.add(Duck.class);
        listAnimals.add(Goat.class);
        listAnimals.add(Hog.class);
        listAnimals.add(Horse.class);
        listAnimals.add(Mouse.class);
        listAnimals.add(Rabbit.class);
        listAnimals.add(Sheep.class);
        listAnimals.add(Worm.class);

        ArrayList<Object>[][] list = SettingsSimulation.getInstance().getArrays();
        for (int i = 0; i < Position.getInstance().getY(); i++) {
            for (int j = 0; j < Position.getInstance().getX(); j++) {
                for (var listAnimal : listAnimals) {
                    int randomSpawn = ThreadLocalRandom.current().nextInt(2);
                    if (randomSpawn == 1) {
                        InfoAnimal info = (InfoAnimal) listAnimal.getAnnotation(InfoAnimal.class);
                        int maxInOnePlace = info.maxInOnePlace();
                        int numberAnimalInOnePlace = ThreadLocalRandom.current().nextInt(maxInOnePlace + 1);
                        int count = 0;
                        if (numberAnimalInOnePlace > 0) {
                            while (numberAnimalInOnePlace >= count) {
                                try {
                                    Class clazz = Class.forName(listAnimal.getName());
                                    list[i][j].add(clazz.getConstructor().newInstance());
                                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                                        | InvocationTargetException | NoSuchMethodException e) {
                                    e.printStackTrace();
                                }
                                count++;
                            }

                        }
                    }

                }
            }
        }
        settingsSimulation.setArrays(list);
        spawnPlants();


    }

    public static void spawnPlants() {
        SettingsSimulation settingsSimulation = SettingsSimulation.getInstance();
        ArrayList<Object>[][] list = SettingsSimulation.getInstance().getArrays();
        Class plant = null;
        try {
            plant = Class.forName("com.company.island.Plants");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        InfoPlants info = (InfoPlants) plant.getAnnotation(InfoPlants.class);
        int maxInOnePlace = info.maxInOnePlace();
        for (int i = 0; i < Position.getInstance().getY(); i++) {
            for (int j = 0; j < Position.getInstance().getX(); j++) {
                int countPlantsThisPlace = 0;
                for (int k = 0; k < list[i][j].size() ; k++) {
                    if(list[i][j].get(k).getClass().getSimpleName().equalsIgnoreCase("plants")){
                        countPlantsThisPlace++;
                    }
                }
                int boundForRandom = 200 - countPlantsThisPlace;
                int numPlantsInOnePlace = ThreadLocalRandom.current().nextInt(boundForRandom);
                int count = 0;
                if (numPlantsInOnePlace > 0) {
                    while (numPlantsInOnePlace > count) {
                        try {
                            Class clazz = Class.forName(plant.getName());
                            list[i][j].add(clazz.getConstructor().newInstance());
                        } catch (IllegalAccessException | InvocationTargetException
                                | NoSuchMethodException | ClassNotFoundException | InstantiationException e) {
                            e.printStackTrace();
                        }
                        count++;
                    }
                }
            }
        }
        settingsSimulation.setArrays(list);
    }


}





