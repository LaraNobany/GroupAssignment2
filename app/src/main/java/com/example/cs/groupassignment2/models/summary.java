package com.example.cs.groupassignment2.models;

import java.io.Serializable;
import java.util.ArrayList;

public class summary implements Serializable {
    private order order;
    private int chosenQuantity;

    public static final ArrayList<summary> summary = new ArrayList<summary>();

    public summary() {
    }

    public summary(order order, int chosenQuantity) {
        this.order = order;
        this.chosenQuantity = chosenQuantity;
    }

    public order getOrder() {
        return order;
    }

    public void setOrder(order order) {
        this.order = order;
    }

    public int getChosenQuantity() {
        return chosenQuantity;
    }

    public void setChosenQuantity(int chosenQuantity) {
        this.chosenQuantity = chosenQuantity;
    }

    public static ArrayList<summary> getSummary() {
        return summary;
    }

    @Override
    public String toString() {
        return "summary{" +
                "order=" + order +
                ", chosenQuantity=" + chosenQuantity +
                '}';
    }
}
