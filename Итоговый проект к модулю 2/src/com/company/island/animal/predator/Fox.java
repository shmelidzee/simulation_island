package com.company.island.animal.predator;

import com.company.island.animal.Animal;
import com.company.island.animal.PredatorAnimal;
import com.company.island.annotations.Emoji;
import com.company.island.annotations.InfoAnimal;

@InfoAnimal(russianName = "Лиса", weight = 8, speed = 2, maxInOnePlace = 30)
@Emoji(emoji = "\uD83E\uDD8A")
public class Fox extends PredatorAnimal {
    private static int countFox = 0;

    public Fox() {
        super(2, 2, true, 6);
        plusCountFox();
        Animal.plusCountBirth();
    }

    public static int getCountFox() {
        return countFox;
    }

    public static void plusCountFox() {
        countFox++;
    }

    public static void minusCountFox() {
        countFox--;
    }


}
