package com.company.basics;

import java.util.HashMap;

public class ChanceToEat {
    public static final HashMap<String, HashMap<String, Integer>> mapAnimal = new HashMap<>();
    static {
        HashMap<String, Integer> wolf = new HashMap<>();
        wolf.put("лошадь", 10);
        wolf.put("олень", 15);
        wolf.put("кролик", 60);
        wolf.put("мышь", 80);
        wolf.put("коза", 60);
        wolf.put("овца", 70);
        wolf.put("кабан", 15);
        wolf.put("утка", 40);
        wolf.put("буйвол", 10);
        mapAnimal.put("волк", wolf);

        HashMap<String, Integer> snake = new HashMap<>();
        snake.put("лиса", 15);
        snake.put("кролик", 20);
        snake.put("мышь", 40);
        snake.put("утка", 10);
        mapAnimal.put("змея", snake);

        HashMap<String, Integer> fox = new HashMap<>();
        fox.put("кролик", 70);
        fox.put("мышь", 90);
        fox.put("утка", 60);
        fox.put("гусеница", 40);
        mapAnimal.put("лиса", fox);

        HashMap<String, Integer> bear = new HashMap<>();
        bear.put("змея", 80);
        bear.put("лошадь", 40);
        bear.put("олень", 80);
        bear.put("кролик", 80);
        bear.put("мышь", 90);
        bear.put("коза", 70);
        bear.put("овца", 70);
        bear.put("кабан", 50);
        bear.put("буйвол", 20);
        bear.put("утка", 10);
        mapAnimal.put("медведь", bear);

        HashMap<String, Integer> eagle = new HashMap<>();
        eagle.put("лиса", 10);
        eagle.put("кролик", 90);
        eagle.put("мышь", 90);
        eagle.put("утка", 80);
        mapAnimal.put("орел", eagle);

        HashMap<String, Integer> horse = new HashMap<>();
        horse.put("растения", 100);
        mapAnimal.put("лошадь", horse);

        HashMap<String, Integer> deer = new HashMap<>();
        deer.put("растения", 100);
        mapAnimal.put("олень", deer);

        HashMap<String, Integer> rabbit = new HashMap<>();
        rabbit.put("растения", 100);
        mapAnimal.put("кролик", rabbit);

        HashMap<String, Integer> mouse = new HashMap<>();
        mouse.put("растения", 100);
        mouse.put("гусеница", 90);
        mapAnimal.put("мышь", mouse);

        HashMap<String, Integer> goat = new HashMap<>();
        goat.put("растения", 100);
        mapAnimal.put("коза", goat);

        HashMap<String, Integer> sheep = new HashMap<>();
        sheep.put("растения", 100);
        mapAnimal.put("овца", sheep);

        HashMap<String, Integer> hog = new HashMap<>();
        hog.put("растения", 100);
        hog.put("мышь", 50);
        hog.put("гусеница", 90);
        mapAnimal.put("кабан", hog);

        HashMap<String, Integer> bull = new HashMap<>();
        bull.put("растения", 100);
        mapAnimal.put("буйвол", bull);

        HashMap<String, Integer> duck = new HashMap<>();
        duck.put("растения", 100);
        duck.put("гусеница", 90);
        mapAnimal.put("утка", duck);

        HashMap<String, Integer> worm = new HashMap<>();
        worm.put("растения", 100);
        mapAnimal.put("гусеница", worm);
    }
}
