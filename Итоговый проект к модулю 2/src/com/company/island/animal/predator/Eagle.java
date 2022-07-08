package com.company.island.animal.predator;

import com.company.island.animal.Animal;
import com.company.island.animal.PredatorAnimal;
import com.company.island.annotations.Emoji;
import com.company.island.annotations.InfoAnimal;

@InfoAnimal(russianName = "Орел", weight = 6, speed = 3, maxInOnePlace = 20)
@Emoji(emoji = "\uD83E\uDD85")
public class Eagle extends PredatorAnimal {
    private static int countEagle = 0;

    public Eagle( ) {
        super(1,1,true, 2);
        plusCountEagle();
        Animal.plusCountBirth();
    }

    public static int getCountEagle() {
        return countEagle;
    }
    public static void plusCountEagle(){
        countEagle++;
    }
    public static void minusCountEagle(){
        countEagle--;
    }


}
