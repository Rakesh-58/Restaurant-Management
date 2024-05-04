package com.restaurantmanagement;

import javafx.scene.control.Button;

public class Menu {
    int itemId;
    String itemName;
    String category;
    String type;
    double rate;
    String img;

    public Menu(int itemId,String itemName,String category,String type,double rate,String img) {
        this.itemId=itemId;
        this.itemName=itemName;
        this.category=category;
        this.type=type;
        this.rate=rate;
        this.img=img;
    }

    public Menu(){

    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public double getRate() {
        return rate;
    }

    public String getImg() {
        return img;
    }
}

