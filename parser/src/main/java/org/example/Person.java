package org.example;

public class Person {

    protected String name;  // protected = доступен наследникам
    protected int age;

    public void sayHello() {
        System.out.println("Привет, меня зовут " + name);
    }
    /*private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public void sayHello(){
        System.out.println("Привет, меня зовут " + name +"!");
    }

    public void showAge() {
        System.out.println("Мне " + age + " лет.");
    }*/
}
