package com.company.island.animal.herbivores;

import com.company.island.animal.Animal;
import com.company.island.animal.HerbivoresAnimal;
import com.company.island.annotations.Emoji;
import com.company.island.annotations.InfoAnimal;

@InfoAnimal(russianName = "Кролик", weight = 2, speed = 2, maxInOnePlace = 15)
@Emoji(emoji = "\uD83D\uDC07")
public class Rabbit extends HerbivoresAnimal {
    private static int countRabbit = 0;

    public Rabbit() {
        super(0.45, 0.45, true, 18);
        plusCountRabbit();
        Animal.plusCountBirth();
    }

    public static int getCountRabbit() {
        return countRabbit;
    }

    public static void plusCountRabbit() {
        countRabbit++;
    }

    public static void minusCountRabbit() {
        countRabbit--;
    }

}
