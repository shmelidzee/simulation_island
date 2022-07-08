package com.company.basics;

import java.util.ArrayList;
import java.util.HashMap;

public class SettingsSimulation {
    private static SettingsSimulation INSTANCE;
    private static ArrayList<Object>[][] arrays;
    private static int timeLiveGame = 15;
    private static String endGame = null;
    private static String diedHerbivores = "Умерли все травоядные";
    private static String diedPredator = "Умерли все хищники";

    public String getDiedHerbivores() {
        return diedHerbivores;
    }

    public String getDiedPredator() {
        return diedPredator;
    }

    public String getEndGame() {
        return endGame;
    }

    public int getTimeLiveGame() {
        return timeLiveGame;
    }

    public ArrayList[][] getArrays() {
        return arrays;
    }

    public void setEndGame(String endGame) {
        SettingsSimulation.endGame = endGame;
    }

    public void setArrays(ArrayList[][] arrays) {
        SettingsSimulation.arrays = arrays;
    }

    private SettingsSimulation() {
        Position position = Position.getInstance();
        arrays = new ArrayList[position.getY()][position.getX()];
    }

    public static SettingsSimulation getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SettingsSimulation();
        }
        return INSTANCE;
    }


}


