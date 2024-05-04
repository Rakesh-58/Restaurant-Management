package com.restaurantmanagement;

public class Reservation {
    String name;
    String phone;
    String time;

    public Reservation(String name,String phone,String time)
    {
        this.name=name;
        this.phone=phone;
        this.time=time;
    }

    public String getPhone() {
        return phone;
    }

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }
}
