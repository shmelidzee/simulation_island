package com.company.island.animal.predator;

import com.company.island.animal.Animal;
import com.company.island.animal.PredatorAnimal;
import com.company.island.annotations.Emoji;
import com.company.island.annotations.InfoAnimal;

@InfoAnimal(russianName = "Змея", weight = 15, speed = 1, maxInOnePlace = 30)
@Emoji(emoji = "\uD83D\uDC0D")
public class Snake extends PredatorAnimal {
    private static int countSnake = 0;

    public Snake( ) {
        super(3,3,true, 20);
        plusCountSnake();
        Animal.plusCountBirth();
    }

    public static int getCountSnake() {
        return countSnake;
    }
    public static void plusCountSnake(){
        countSnake++;
    }
    public static void minusCountSnake(){
        countSnake--;
    }

}
