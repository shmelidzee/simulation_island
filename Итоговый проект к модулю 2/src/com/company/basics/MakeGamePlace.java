package com.company.basics;

import java.util.ArrayList;

public class MakeGamePlace implements Runnable {
    @Override
    public void run() {
        SettingsSimulation settingsSimulation = SettingsSimulation.getInstance();
        ArrayList<Object>[][] list = settingsSimulation.getArrays();
        for (int i = 0; i < Position.getInstance().getY(); i++) {
            for (int j = 0; j < Position.getInstance().getX() ; j++) {
                list[i][j] = new ArrayList<>();
            }
        }
        settingsSimulation.setArrays(list);

          
    }
}
