package com.company.island.animal.herbivores;

import com.company.island.animal.Animal;
import com.company.island.animal.HerbivoresAnimal;
import com.company.island.annotations.Emoji;
import com.company.island.annotations.InfoAnimal;

@InfoAnimal(russianName = "Лошадь", weight = 400, speed = 4, maxInOnePlace = 20)
@Emoji(emoji = "\uD83D\uDC0E")
public class Horse extends HerbivoresAnimal {
    private static int countHorse = 0;

    public Horse() {
        super(60, 60, true, 1);
        plusCountHorse();
        Animal.plusCountBirth();
    }

    public static  int getCountHorse() {
        return countHorse;
    }
    public static void plusCountHorse(){
        countHorse++;
    }
    public static void minusCountHorse(){
        countHorse--;
    }



}
