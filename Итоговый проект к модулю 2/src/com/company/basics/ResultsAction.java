package com.company.basics;

import java.util.ArrayList;

public class ResultsAction {
    private static int x;
    private static int y;
    private static int indexRemoveObj = Integer.MAX_VALUE;
    public static ArrayList<Object> listAnimal = new ArrayList<>();

    public static ArrayList<Object> getListAnimal() {
        return listAnimal;
    }

    public static void setListAnimal(ArrayList<Object> listAnimal) {
        ResultsAction.listAnimal = listAnimal;
    }

    public static int getX() {
        return x;
    }
    public static void setX(int x) {
        ResultsAction.x = x;
    }
    public static int getY() {
        return y;
    }
    public static void setY(int y) {
        ResultsAction.y = y;
    }

    public static int getIndexRemoveObj() {
        return indexRemoveObj;
    }
    public static void setIndexRemoveObj(int indexRemoveObj) {
        ResultsAction.indexRemoveObj = indexRemoveObj;
    }
}
