package com.company.island.animal.predator;

import com.company.island.animal.Animal;
import com.company.island.animal.PredatorAnimal;
import com.company.island.annotations.Emoji;
import com.company.island.annotations.InfoAnimal;

@InfoAnimal(russianName = "Медведь", weight = 500, speed = 2, maxInOnePlace = 5)
@Emoji(emoji = "\uD83D\uDC3B")
public class Bear extends PredatorAnimal {
    private static int countBear = 0;


    public Bear( ) {
        super(80, 80, true, 3);
        plusCountBear();
        Animal.plusCountBirth();
    }

    public static int getCountBear() {
        return countBear;
    }
    public static void plusCountBear(){
        countBear++;
    }
    public static void minusCountBear(){
        countBear--;
    }

}
