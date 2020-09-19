package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        //========:Алгоритм действий:========//
        //1) Перечисляем коор-ты вершин многоугольника
        //2) Проверяем является ли он выпуклым
        //3) Считаем площадь


        //------------------------------Перечисляем коор-ты вершин------------------------------//
        System.out.println("Введите количество вершин многоугольника:");
        Scanner topsNumber = new Scanner(System.in);

        //Проверка вводимого числа
        if (topsNumber.hasNextInt()) {
            int intTopsNumber = topsNumber.nextInt();

            if (intTopsNumber > 2) {
                int[] arrayX = new int[intTopsNumber];
                int[] arrayY = new int[intTopsNumber];

                for (int i = 0; i < intTopsNumber; ++i) {
                    boolean checkInput = false;
                    while (!checkInput) {
                        System.out.println("Введите координаты (X, Y) вершины #" + i);
                        Scanner X = new Scanner(System.in);
                        Scanner Y = new Scanner(System.in);

                        if (X.hasNextInt() && Y.hasNextInt()) {
                            arrayX[i] = X.nextInt();
                            arrayY[i] = Y.nextInt();
                            checkInput = true;
                        }
                        else {
                            System.out.println("Вы ввели не целое число!");
                        }
                    }
                }

                for (int i = 0; i < intTopsNumber; ++i) {
                    System.out.println("Координаты вершины №" + i + ": (" + arrayX[i] + ", " + arrayY[i] + ")");
                }


                //------------------------------Проверяем выпуклый ли это многоугольник------------------------------//
                // Многоугольник будет выпуклым, если для векторов, составляющих его периметр, выполняется условие:
                // векторные произведения соседних векторов должны иметь одинаковый знак.

                //Для начала найдём координаты всех векторов:
                int[] vectorArrayX = new int[intTopsNumber];
                int[] vectorArrayY = new int[intTopsNumber];

                for (int i = 0; i < intTopsNumber; ++i) {
                    if (i == intTopsNumber - 1) {
                        vectorArrayX[i] = arrayX[0] - arrayX[i];
                        vectorArrayY[i] = arrayY[0] - arrayY[i];
                    }
                    else {
                        vectorArrayX[i] = arrayX[i + 1] - arrayX[i];
                        vectorArrayY[i] = arrayY[i + 1] - arrayY[i];
                    }
                }

                boolean ConvexPolygon = true;

                // vector a0 * an
                int composition0AndN = vectorArrayX[intTopsNumber - 1] * vectorArrayY[0] - vectorArrayX[0] * vectorArrayY[intTopsNumber - 1];
                int sign = composition0AndN / Math.abs(composition0AndN);
                int j = 0;

                while (ConvexPolygon && j < intTopsNumber - 1) {
                    int composition2v = vectorArrayX[j] * vectorArrayY[j+1] - vectorArrayX[j+1] * vectorArrayY[j];
                    int signComposition = composition2v / Math.abs(composition2v);

                    if (sign != signComposition) {
                        ConvexPolygon = false;
                    }
                    ++j;
                }

                if (ConvexPolygon) {
                    System.out.println("Многоугольник выпуклый");

                    //------------------------------Считаем площадь------------------------------//
                    int sum = (arrayX[intTopsNumber-1] + arrayX[0]) * (arrayY[intTopsNumber - 1] - arrayY[0]);
                    for (int i = 0; i < intTopsNumber - 1; ++i) {
                        sum += (arrayX[i] + arrayX[i+1]) * (arrayY[i] - arrayY[i+1]);
                    }

                    double S = 0.5 * Math.abs(sum);
                    System.out.println("Площадь = " + S);
                }
                else {
                    System.out.println("Многоугольник не выпуклый");
                }
            }
            else {
                System.out.println("Минимальное число вершин у многоугольника - 3. Введите число >= 3");
            }
        }
        else {
            System.out.println("Вы ввели не целое число вершин многоугольника!");
        }
    }
}