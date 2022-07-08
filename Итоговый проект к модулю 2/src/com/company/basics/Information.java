package com.company.basics;

import com.company.island.animal.Animal;
import com.company.island.animal.herbivores.*;
import com.company.island.animal.predator.*;
import com.company.island.annotations.Emoji;
import com.company.island.Plants;
import com.company.island.annotations.InfoAnimal;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Information {

    public static void printPlace() {

        SettingsSimulation settingsSimulation = SettingsSimulation.getInstance();
        ArrayList<Object>[][] list = settingsSimulation.getArrays();
        for (int i = 0; i < Position.getInstance().getY(); i++) {
            for (int j = 0; j < Position.getInstance().getX(); j++) {
                if (!list[i][j].isEmpty()) {
                    int randomValue = ThreadLocalRandom.current().nextInt(list[i][j].size());
                    Class<?> aClass = list[i][j].get(randomValue).getClass();
                    Emoji info = aClass.getAnnotation(Emoji.class);
                    System.out.printf(StartSimulation.ANSI_BLACK + "[%s]", info.emoji() + StartSimulation.ANSI_RESET);
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }

        questionAboutInfo();


    }

    private static void printInfo() {
        System.out.println(StartSimulation.ANSI_BLACK + "\nОбщая статистика нашей игры:");
        System.out.println(StartSimulation.ANSI_CYAN + "Всего растений: " + StartSimulation.ANSI_PURPLE + Plants.getCountPlants());
        System.out.println(StartSimulation.ANSI_CYAN + "Всего буйволов: " + StartSimulation.ANSI_PURPLE + Bull.getCountBull());
        System.out.println(StartSimulation.ANSI_CYAN + "Всего оленей: " + StartSimulation.ANSI_PURPLE + Deer.getCountDeer());
        System.out.println(StartSimulation.ANSI_CYAN + "Всего уток:" + StartSimulation.ANSI_PURPLE + Duck.getCountDuck());
        System.out.println(StartSimulation.ANSI_CYAN + "Всего коз: " + StartSimulation.ANSI_PURPLE + Goat.getCountGoat());
        System.out.println(StartSimulation.ANSI_CYAN + "Всего кабанов: " + StartSimulation.ANSI_PURPLE + Hog.getCountHog());
        System.out.println(StartSimulation.ANSI_CYAN + "Всего лошадей: " + StartSimulation.ANSI_PURPLE + Horse.getCountHorse());
        System.out.println(StartSimulation.ANSI_CYAN + "Всего мышей: " + StartSimulation.ANSI_PURPLE + Mouse.getCountMouse());
        System.out.println(StartSimulation.ANSI_CYAN + "Всего кроликов: " + StartSimulation.ANSI_PURPLE + Rabbit.getCountRabbit());
        System.out.println(StartSimulation.ANSI_CYAN + "Всего овец: " + StartSimulation.ANSI_PURPLE + Sheep.getCountSheep());
        System.out.println(StartSimulation.ANSI_CYAN + "Всего червяков: " + StartSimulation.ANSI_PURPLE + Worm.getCountWorm());
        System.out.println(StartSimulation.ANSI_CYAN + "Всего медведей: " + StartSimulation.ANSI_PURPLE + Bear.getCountBear());
        System.out.println(StartSimulation.ANSI_CYAN + "Всего орлов: " + StartSimulation.ANSI_PURPLE + Eagle.getCountEagle());
        System.out.println(StartSimulation.ANSI_CYAN + "Всего лис: " + StartSimulation.ANSI_PURPLE + Fox.getCountFox());
        System.out.println(StartSimulation.ANSI_CYAN + "Всего волков: " + StartSimulation.ANSI_PURPLE + Wolf.getCountWolf());
        System.out.println(StartSimulation.ANSI_CYAN + "Всего змей: " + StartSimulation.ANSI_PURPLE + Snake.getCountSnake());
        System.out.println(StartSimulation.ANSI_CYAN + "Родилось за сегодня: " + StartSimulation.ANSI_PURPLE + Animal.getCountBirthday());
        System.out.println(StartSimulation.ANSI_CYAN + "Погибло за сегодня: " + StartSimulation.ANSI_PURPLE + Animal.getCountDeath() + StartSimulation.ANSI_RESET);
        System.out.println();
    }

    private static void questionAboutInfo() {
        System.out.println(StartSimulation.ANSI_BLACK + "Желаете увидеть статистику?\n" +
                StartSimulation.ANSI_GREEN + "1.Да\n" +
                "2.Нет");
        System.out.print(StartSimulation.ANSI_BLUE + "Введите число: " + StartSimulation.ANSI_RESET);
        int numOperation = StartSimulation.scanner.nextInt();
        switch (numOperation) {
            case 1:
                printInfo();
                break;
            case 2:
                break;
            default:
                System.out.println(StartSimulation.ANSI_RED + "Введено неверное число!" + StartSimulation.ANSI_RESET);
                questionAboutInfo();

        }
    }


}
