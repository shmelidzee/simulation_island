package com.company.island.animal.herbivores;

import com.company.island.animal.Animal;
import com.company.island.animal.HerbivoresAnimal;
import com.company.island.annotations.Emoji;
import com.company.island.annotations.InfoAnimal;

@InfoAnimal(russianName = "Коза", weight = 60, speed = 3, maxInOnePlace = 140)
@Emoji(emoji = "\uD83D\uDC10")
public class Goat extends HerbivoresAnimal {
    private static int countGoat = 0;

    public Goat() {
        super(10, 10, true, 5);
        plusCountGoat();
        Animal.plusCountBirth();
    }

    public  static int getCountGoat() {
        return countGoat;
    }
    public static void plusCountGoat(){
        countGoat++;
    }
    public static void minusCountGoat(){
        countGoat--;
    }


}
