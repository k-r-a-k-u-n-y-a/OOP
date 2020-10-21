package com.company;

public class Lecturer extends Person {
    private String department;
    private int salary;

    // Getters
    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    // Setters
    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String printInfo() {
        return "Преподаватель кафедры " + getDepartment() + getSurname() + getName() + ", возраст: " + getAge() + ".\nЗарплата: " + getSalary();
    }
}
