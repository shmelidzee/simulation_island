package com.company.island.animal;


public abstract class Animal implements ActionAnimal {

    private static int countBirthday = 0;
    private static int countDeath = 0;
    private double howWeightForFullEating;
    private double howFood;
    private boolean isTurn;
    private boolean isLive = true;
    private int countMultiply = 3;
    private int maxChildrenAnimals;
    private boolean multiply = true;

    public int getMaxChildrenAnimals() {
        return maxChildrenAnimals;
    }

    public Animal(double howWeightForFullEating, double howFood, boolean isTurn, int maxChildrenAnimals) {
        this.howWeightForFullEating = howWeightForFullEating;
        this.howFood = howFood;
        this.isTurn = isTurn;
        this.maxChildrenAnimals = maxChildrenAnimals;
    }

    public double getHowFood() {
        return howFood;
    }

    public static int getCountBirthday() {
        return countBirthday;
    }

    public static void setCountBirthday() {
        countBirthday = 0;
    }

    public static int getCountDeath() {
        return countDeath;
    }

    public static void setCountDeath() {
        countDeath = 0;
    }

    public static void plusCountBirth() {
        countBirthday++;
    }

    public static void plusCountDeath() {
        countDeath++;
    }


    private double getHowWeightForFullEating() {
        return howWeightForFullEating;
    }

    public void minusCountEat() {
        howWeightForFullEating -= (howFood / 3);
    }

    private void setHowWeightForFullEating(double howWeightForFullEating) {
        if (this.howWeightForFullEating + howWeightForFullEating >= howFood) {
            this.howWeightForFullEating = howFood;
        } else {
            this.howWeightForFullEating += howWeightForFullEating;
        }
    }

    private boolean isTurn() {
        return isTurn;
    }

    private void setTurn(boolean turn) {
        isTurn = turn;
    }

    protected void setLive(boolean live) {
        isLive = live;
    }

    public void setMultiplyTrue() {
        multiply = true;
    }

    public void setMultiplyFalse() {
        multiply = false;
    }

    protected boolean getMultiply() {
        if (multiply == true) {
            if (countMultiply == 0) {
                return false;
            } else {
                countMultiply--;
                setMultiplyFalse();
                return true;
            }
        } else {
            return false;
        }
    }

    protected boolean isLive() {
        if (isLive == true) {
            if (howWeightForFullEating > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
