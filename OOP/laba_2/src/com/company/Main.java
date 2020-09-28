package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int itemsNumber;
        int capacityCart;

        while (true) {
            itemsNumber = 0;
            capacityCart = 0;
            System.out.println("Max number of Items in Cart:");
            capacityCart = inputInt(capacityCart);

            System.out.println("How many Items you want to add in Cart?");
            itemsNumber += inputInt(itemsNumber);

            if (itemsNumber <= capacityCart) {
                break;
            }
            else {
                System.out.println("Items can't add to the Cart. Try again.");
            }
        }


        Cart Cart = new Cart(capacityCart);
        for (int i = 0; i < itemsNumber; ++i) {
            while (true) {
                String name;
                float price = 0;

                System.out.println("Item #" + i + " name:");
                Scanner newName = new Scanner(System.in);
                name = newName.nextLine();

                System.out.println("Item #" + i + " price:");
                Scanner newPrice = new Scanner(System.in);

                try {
                    price += newPrice.nextFloat();

                    Item item = new Item(name, price);
                    Cart.addItem(item);
                    break;
                } catch (InputMismatchException fg) {
                    System.out.println("You enter not Float");
                }
            }
        }


        System.out.println("Sum of items price: " + Cart.calculateSumPrices());
        System.out.println("Enter percent of rise price: ");
        int rise = 0;
        rise = inputInt(rise);
        Cart.raiseAllItemsPrice(rise);


        System.out.println("Sum of items price after rise: " + Cart.calculateSumPrices());
        System.out.println("Enter percent of cut price: ");
        int cut = 0;
        cut = inputInt(cut);
        Cart.cutAllItemsPrice(cut);

        System.out.println("Sum of items price after cut: " + Cart.calculateSumPrices());
    }


    private static int inputInt(int number) {
        number = 0;
        while (true) {
            Scanner scan = new Scanner(System.in);
            try {
                number += scan.nextInt();
                return number;
            } catch (InputMismatchException fg) {
                System.out.println("You entered not int. Try again.");
            }
        }
    }
}