package com.company.island.animal.herbivores;

import com.company.island.animal.Animal;
import com.company.island.animal.HerbivoresAnimal;
import com.company.island.annotations.Emoji;
import com.company.island.annotations.InfoAnimal;

@InfoAnimal(russianName = "Олень", weight = 300, speed = 4, maxInOnePlace = 20)
@Emoji(emoji = "\uD83E\uDD8C")
public class Deer extends HerbivoresAnimal {
    private static int countDeer = 0;

    public Deer() {
        super(50, 50, true, 2);
        plusCountDeer();
        Animal.plusCountBirth();
    }

    public static int getCountDeer() {
        return countDeer;
    }
    public static void plusCountDeer(){
        countDeer++;
    }
    public static void minusCountDeer(){
        countDeer--;
    }


}
