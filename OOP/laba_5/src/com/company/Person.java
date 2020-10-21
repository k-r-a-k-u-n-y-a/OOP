package com.company;

public class Person {
    private String surname;
    private String name;
    private int age;

    // Getters
    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String printInfo() {
        return "Человек " + surname + name + ", возраст: " + age;
    }
}
