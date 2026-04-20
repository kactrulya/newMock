package org.example;

public class Electriccar extends Car{
    private String battery;

    public void setBattery(String battery){
        this.battery = battery;
    }

    public void Saybet(){
        System.out.println("У машины марки " + marka + " Года выпуска " + godVipuska + " Заряд батареи " + battery );
    }
}
