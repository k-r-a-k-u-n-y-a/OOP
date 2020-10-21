package com.company;

public class Student extends Person {
    private String groupe;
    private int ID;

    // Getters
    public String getGroupe() {
        return groupe;
    }

    public int getID() {
        return ID;
    }

    // Setters
    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String printInfo() {
        return "Студент группы " + getGroupe() + getSurname() + getName() + ", возраст: " + getAge() + ".\nНомер студенческого билета: " + getID();
    }
}
