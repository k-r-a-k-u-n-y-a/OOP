package com.company;

public class Cart {
    private Item[] stack;
    private int topIndex;

    public Cart(int capacity) {
        stack = new Item[capacity];
        topIndex = -1;
    }

    public boolean addItem(Item item) {
        return push(item);
    }

    private boolean push(Item item) {
        topIndex++;
        if (checkStack()) {
            stack[topIndex] = item;
            System.out.println("Item added successfully!");
            return true;
        }
        else {
            topIndex--;
            System.out.println("Error. Try again.");
            return false;
        }
    }

    public Item deleteLastAddedItem() {
        return pop();
    }

    private Item pop() {
        if (checkStack()) {
            Item temp = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return new Item(temp.name, temp.price);
        }
        else {
            return new Item(null, null);
        }
    }

    private boolean checkStack() {
        if ((topIndex > stack.length) || (topIndex < 0)) {
            System.out.print("Error. Check number of your items in cart");
            return false;
        }
        else {
            return true;
        }
    }

    public float calculateSumPrices() {
        return calculateSum();
    }

    private float calculateSum() {
        float sum = 0;

        for (int i = 0; i <= topIndex; ++i) {
            sum += stack[i].price;
        }
        return sum;
    }

    public void raiseAllItemsPrice(int raisePrice) {
        for (int i = 0; i <= topIndex; ++i) {
            stack[i].raiseItemPrice(raisePrice);
        }
    }

    public void cutAllItemsPrice(int cutPrice) {
        for (int i = 0; i <= topIndex; ++i) {
            stack[i].cutItemPrice(cutPrice);
        }
    }
}