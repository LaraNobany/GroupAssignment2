package com.example.cs.groupassignment2.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.cs.groupassignment2.R;

public class order implements Serializable {
    private Item item;
    private String chosenColor;
    private int chosenSize;
    private int chosenQuantity;

    public static final ArrayList<order> orders = new ArrayList<order>();

    public order() {
    }

    public order(Item item, String chosenColor, int chosenSize, int chosenQuantity) {
        this.item = item;
        this.chosenColor = chosenColor;
        this.chosenSize = chosenSize;
        this.chosenQuantity = chosenQuantity;
    }

    public order(Item item, int chosenQuantity) {
        this.item = item;
        this.chosenQuantity = chosenQuantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getChosenColor() {
        return chosenColor;
    }

    public void setChosenColor(String chosenColor) {
        this.chosenColor = chosenColor;
    }

    public int getChosenSize() {
        return chosenSize;
    }

    public void setChosenSize(int chosenSize) {
        this.chosenSize = chosenSize;
    }

    public int getChosenQuantity() {
        return chosenQuantity;
    }

    public void setChosenQuantity(int chosenQuantity) {
        this.chosenQuantity = chosenQuantity;
    }

    public static ArrayList<order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "order{" +
                "item name=" + item.getName() +
                ", chosenColor='" + chosenColor + '\'' +
                ", chosenSize=" + chosenSize +
                ", chosenQuantity=" + chosenQuantity +
                '}';
    }


    public int CalculateTotal(List<order> items) {
        int totalPrice = 0;
        for (int i = 0; i < items.size(); i++) {
            totalPrice += items.get(i).item.getPrice();
        }
        return totalPrice;
    }

    public double tax(List<order>item){
        double x = CalculateTotal((List<order>) item);
        double total =0;
        total = x * (14/100);
        return total;
    }

    public double totalwithtax(List<order> item){
        double x = CalculateTotal(item);
        double y = tax(item);
        double t = x + y;
        return t;
    }

}
