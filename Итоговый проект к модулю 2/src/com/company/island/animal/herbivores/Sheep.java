package com.company.island.animal.herbivores;

import com.company.island.animal.Animal;
import com.company.island.animal.HerbivoresAnimal;
import com.company.island.annotations.Emoji;
import com.company.island.annotations.InfoAnimal;


@InfoAnimal(russianName = "Овца", weight = 70, speed = 3, maxInOnePlace = 140)
@Emoji(emoji = "\uD83D\uDC11")
public class Sheep extends HerbivoresAnimal {
    private static int countSheep = 0;

    public Sheep( ) {
        super(15, 15, true, 3);
        plusCountSheep();
        Animal.plusCountBirth();
    }

    public static int getCountSheep() {
        return countSheep;
    }
    public static void plusCountSheep(){
        countSheep++;
    }
    public static void minusCountSheep(){
        countSheep--;
    }


}
