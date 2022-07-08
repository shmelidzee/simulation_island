package com.company.island.animal.herbivores;

import com.company.island.animal.Animal;
import com.company.island.animal.HerbivoresAnimal;
import com.company.island.annotations.Emoji;
import com.company.island.annotations.InfoAnimal;

@InfoAnimal(russianName = "Утка", weight = 1, speed = 4, maxInOnePlace = 200)
@Emoji(emoji = "\uD83E\uDD86")
public class Duck extends HerbivoresAnimal {
    private static int countDuck = 0;

    public Duck() {
        super(0.15, 0.15, true, 20);
        plusCountDuck();
        Animal.plusCountBirth();
    }

    public  static int getCountDuck() {
        return countDuck;
    }
    public static void plusCountDuck(){
        countDuck++;
    }
    public static void minusCountDuck(){
        countDuck--;
    }


}
