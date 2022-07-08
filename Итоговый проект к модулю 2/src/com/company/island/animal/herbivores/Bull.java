package com.company.island.animal.herbivores;

import com.company.island.animal.Animal;
import com.company.island.animal.HerbivoresAnimal;
import com.company.island.annotations.Emoji;
import com.company.island.annotations.InfoAnimal;

@InfoAnimal(russianName = "Буйвол", weight = 700, speed = 3, maxInOnePlace = 10)
@Emoji(emoji = "\uD83D\uDC02")
public class Bull extends HerbivoresAnimal {
    private static int countBull = 0;

    public Bull() {
        super(100, 100, true, 1);
        Animal.plusCountBirth();
        plusCountBull();
    }

    public static int getCountBull() {
        return countBull;
    }

    public static void plusCountBull() {
        countBull++;
    }

    public static void minusCountBull() {
        countBull--;
    }

}
