package com.company.island.animal.herbivores;

import com.company.island.animal.Animal;
import com.company.island.animal.HerbivoresAnimal;
import com.company.island.annotations.Emoji;
import com.company.island.annotations.InfoAnimal;

@InfoAnimal(russianName = "Мышь", weight = 0.05, speed = 1, maxInOnePlace = 500)
@Emoji(emoji = "\uD83D\uDC01")
public class Mouse extends HerbivoresAnimal {
    private static int countMouse = 0;

    public Mouse( ) {
        super(0.01, 0.01, true, 14);
        plusCountMouse();
    }

    public static int getCountMouse() {
        return countMouse;
    }
    public static void plusCountMouse(){
        countMouse++;
    }
    public static void minusCountMouse(){
        countMouse--;
    }



}
