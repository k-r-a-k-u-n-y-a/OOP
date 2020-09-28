package com.company;

public class Item {
    String name;
    Float price;

    public Item(String name, Float price) {
        this.name = name;
        checkPrice(price);
        this.price = price;
    }

    public void raiseItemPrice(float percent) {
        price += price * percent / 100;
        checkPrice(price);
    }

    public void cutItemPrice(float percent) {
        price -= price * percent / 100;
        checkPrice(price);
    }

    private void checkPrice(float price) {
        if (price < 0) {
            price = 0;
        }
    }
}
