package com.company.island.animal.predator;

import com.company.island.animal.Animal;
import com.company.island.animal.PredatorAnimal;
import com.company.island.annotations.Emoji;
import com.company.island.annotations.InfoAnimal;

@InfoAnimal(russianName = "Волк", weight = 50, speed = 3, maxInOnePlace = 30)
@Emoji(emoji = "\uD83D\uDC3A")
public class Wolf extends PredatorAnimal {
    private static int countWolf = 0;

    public Wolf( ) {
        super(8,8,true, 13);
        plusCountWolf();
        Animal.plusCountBirth();
    }

    public static int getCountWolf() {
        return countWolf;
    }
    public static void plusCountWolf(){
        countWolf++;
    }
    public static void minusCountWolf(){
        countWolf--;
    }

}
