package com.restaurantmanagement;

public class Order {
    int orderNo;
    int tableNo;
    String itemName;
    int quantity;
    int isCancel;
    //int isPrepare;


    public Order(int orderNo,int tableNo,String itemName,int quantity,int isCancel)
    {
        this.orderNo=orderNo;
        this.tableNo=tableNo;
        this.itemName=itemName;
        this.quantity=quantity;
        this.isCancel=isCancel;
        //this.isPrepare=isPrepare;

    }

    public int getOrderNo() {
        return orderNo;
    }

    public int getTableNo() {
        return tableNo;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIsCancel() {
        return isCancel;
    }
}
