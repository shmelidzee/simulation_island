package com.company.island.animal;

public abstract class PredatorAnimal extends Animal {
    public PredatorAnimal(double howWeightForFullEating, double howFood, boolean isTurn, int maxChildrenAnimal) {
        super(howWeightForFullEating, howFood, isTurn, maxChildrenAnimal);
    }
}
