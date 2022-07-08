package com.company;

import com.company.island.Plants;
import com.company.island.animal.Animal;
import com.company.island.animal.herbivores.*;
import com.company.island.animal.predator.*;
import com.company.island.annotations.InfoAnimal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.spi.CalendarNameProvider;

public interface Check {

    static boolean checkNearbyPlace(ArrayList<Object> listAnimal, Object classAnimal) {
        Class<?> animal = classAnimal.getClass();
        String name = animal.getName();
        InfoAnimal infoAnimal = (InfoAnimal) animal.getAnnotation(InfoAnimal.class);
        int maxInOnePlace = infoAnimal.maxInOnePlace();
        long countInPlace = listAnimal.stream()
                .filter(s -> s.getClass().getName().equals(name))
                .count();
        if (countInPlace <= maxInOnePlace) {
            return true;
        } else {
            return false;

        }
    }

    static boolean checkDead(Object animal) {
        boolean isLive = true;
        if (animal instanceof Animal) {
            try {
                Method checkLive = Animal.class.getDeclaredMethod("isLive");
                checkLive.setAccessible(true);
                isLive = Boolean.valueOf((boolean) checkLive.invoke(animal));
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Method checkLive = Plants.class.getDeclaredMethod("isLive");
                checkLive.setAccessible(true);
                isLive = Boolean.valueOf((boolean) checkLive.invoke(animal));
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return isLive;
    }

    static boolean checkHerbivores(){
        int bill = Bull.getCountBull() + Deer.getCountDeer() + Duck.getCountDuck() + Goat.getCountGoat() + Hog.getCountHog()
                + Horse.getCountHorse() + Mouse.getCountMouse() + Rabbit.getCountRabbit() + Sheep.getCountSheep() ;
        if(bill > 0 ) {
            return true;
        }else{
            return false;
        }
    }

    static boolean checkPredator(){
        int bill = Bear.getCountBear()  + Eagle.getCountEagle() + Fox.getCountFox() + Snake.getCountSnake() + Wolf.getCountWolf();
        if(bill > 0 ) {
            return true;
        }else{
            return false;
        }
    }

}
