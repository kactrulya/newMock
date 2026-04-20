package org.example;

public class Student extends Person{
    private String university;

    public void setUniversity(String university) {
        this.university = university;
    }

    public void showInfo() {
        System.out.println("Имя: " + name + ", возраст: " + age + ", учусь в " + university);
    }
}
