package com.company.island.animal.herbivores;

import com.company.island.animal.Animal;
import com.company.island.animal.HerbivoresAnimal;
import com.company.island.annotations.Emoji;
import com.company.island.annotations.InfoAnimal;

@InfoAnimal(russianName = "Кабан", weight = 400, speed = 2, maxInOnePlace = 50)
@Emoji(emoji = "\uD83D\uDC16")
public class Hog extends HerbivoresAnimal {
    private static int countHog = 0;

    public Hog() {
        super(50, 50, true, 3);
        plusCountHog();
        Animal.plusCountBirth();
    }

    public static int getCountHog() {
        return countHog;
    }
    public static void plusCountHog(){
        countHog++;
    }
    public static void minusCountHog(){
        countHog--;
    }


}
