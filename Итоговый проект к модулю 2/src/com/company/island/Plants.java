package com.company.island;

import com.company.island.animal.Animal;
import com.company.island.annotations.InfoPlants;
import com.company.island.annotations.Emoji;


@InfoPlants()
@Emoji(emoji = "\uD83C\uDF3F")
public class Plants {
    private boolean isLive = true;
    private static int countPlants = 0;

    public Plants() {
        plusCountPlants();
    }

    public static int getCountPlants() {
        return countPlants;
    }

    public static void plusCountPlants() {
        countPlants++;
    }

    public static void minusCountPlants() {
        countPlants--;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    private boolean isLive() {
        return isLive;
    }
}
