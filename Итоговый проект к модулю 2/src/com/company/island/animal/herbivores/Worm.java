package com.company.island.animal.herbivores;

import com.company.island.animal.Animal;
import com.company.island.animal.HerbivoresAnimal;
import com.company.island.annotations.Emoji;
import com.company.island.annotations.InfoAnimal;

@InfoAnimal(russianName = "Гусеница", weight = 0.01, speed = 0, maxInOnePlace = 1000)
@Emoji(emoji = "\uD83D\uDC1B")
public class Worm extends HerbivoresAnimal {
    private static int countWorm = 0;
    private boolean isLive = true;
    public Worm() {
        super(0, 0, false, 0);
        plusCountWorm();
        Animal.plusCountBirth();
    }
    public static int getCountWorm() {
        return countWorm;
    }
    public static void plusCountWorm(){
        countWorm++;
    }
    public static void minusCountWorm(){
        countWorm--;
    }

    @Override
    protected boolean isLive() {
        return isLive;
    }

    @Override
    protected void setLive(boolean live) {
        this.isLive = live;
    }
}
