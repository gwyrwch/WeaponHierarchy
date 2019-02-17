package com.company;

abstract class AbstractWeapon {
    private String name;
    private double weight;
    private int price;
    private int serialNumber;

    AbstractWeapon() { }

    AbstractWeapon(String name, double weight, int price, int serialNumber) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.serialNumber = serialNumber;
    }

    public String GetName() { return name; }
    public void SetName(String name) { this.name = name; }

    public double GetWeight() { return weight; }
    public void SetWeight(double weight) { this.weight = weight; }

    public int GetPrice() { return price; }
    public void SetPrice(int price) {this.price = price; }

    public int GetSerialNumber() { return serialNumber; }
    public void SetSerialNumber(int serialNumber) { this.serialNumber = serialNumber; }

    public String ShowCharacteristics() {
        return String.join(
            "\n",
            "Name: " + name,
            "Weight: " + weight,
            "Price: " + price,
            "Serial number: " + serialNumber
        );
    }

    public abstract void UseWeapon();

}

