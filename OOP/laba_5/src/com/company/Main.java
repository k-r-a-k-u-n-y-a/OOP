package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Person q = new Student();
        Person w = new Lecturer();

        int numberPersons = 3;
        Person[] persons = new Person[numberPersons];
        persons[0] = q;
        persons[1] = w;
        persons[2] = new Person();

        // Input
        for (int i = 0; i < numberPersons; ++i) {
            Scanner inputString = new Scanner(System.in);
            Scanner inputInt = new Scanner(System.in);
            System.out.println("Input Surname: ");
            persons[i].setSurname(inputString.nextLine());

            System.out.println("Input Name: ");
            persons[i].setName(inputString.nextLine());

            System.out.println("Input Age: ");
            persons[i].setAge(inputInt.nextInt());

            if (persons[i] instanceof Student) {
                Student student = (Student) persons[i];
                System.out.println("Input Groupe: ");
                student.setGroupe(inputString.nextLine());

                System.out.println("Input ID: ");
                student.setID(inputInt.nextInt());
            }
            else if (persons[i] instanceof Lecturer) {
                Lecturer lecturer = (Lecturer) persons[i];
                System.out.println("Input Department: ");
                lecturer.setDepartment(inputString.nextLine());

                System.out.println("Input Salary: ");
                lecturer.setSalary(inputInt.nextInt());
            }
        }

        System.out.println("Success!");

        // Result
        for (int i = 0; i < numberPersons; ++i) {
            System.out.println(persons[i].printInfo());
        }
    }
}
