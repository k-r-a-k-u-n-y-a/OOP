package com.company;
import segment.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input coordinates p1: \nX: ");
        double x1 = input.nextDouble();
        System.out.println("Y: ");
        double y1 = input.nextDouble();
        System.out.println("Z: ");
        double z1 = input.nextDouble();
        Point p1 = new Point(x1, y1, z1);

        System.out.println("Input coordinates p2: \nX: ");
        double x2 = input.nextDouble();
        System.out.println("Y: ");
        double y2 = input.nextDouble();
        System.out.println("Z: ");
        double z2 = input.nextDouble();
        Point p2 = new Point(x2, y2, z2);

        Segment s = new Segment(p1, p2);
        System.out.println("Length = " + s.length());
    }
}
