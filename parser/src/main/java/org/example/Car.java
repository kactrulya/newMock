package org.example;

public class Car {
    protected String marka;
    protected int godVipuska;
    protected int speed;

    public  void goooing(){
        System.out.println("Машина марки: " + marka + " Едет со скоростью: " + speed );
    }

    public void stoped(){
        System.out.println("Машина года: " + godVipuska + " марки: " + marka + " затормозила!");
    }
}
