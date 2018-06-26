package com.example.williambrown.inclass9;

import java.util.Date;

/**
 * Created by williambrown on 6/22/17.
 */

public class Expenses {

    private String name, category, trasactionID;
    private double amount;
    private String date;


    public Expenses(String name, String category, double amount, String date, String trasactionID){
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.trasactionID = trasactionID;
    }

    public Expenses(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTrasactionID() {
        return trasactionID;
    }

    public void setTrasactionID(String trasactionID) {
        this.trasactionID = trasactionID;
    }
}
