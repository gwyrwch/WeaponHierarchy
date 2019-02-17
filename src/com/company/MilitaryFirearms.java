package com.company;

public class MilitaryFirearms extends Gun {
    private String country;
    private String model;

    public MilitaryFirearms(
        String name,
        double weight,
        int price,
        int serialNumber,
        int capacity,
        int rateOfFire,
        int sightingRange,
        int muzzleVelocity,
        String country,
        String model
    ) {
        super(name, weight, price, serialNumber, capacity, rateOfFire, sightingRange, muzzleVelocity);
        this.country = country;
        this.model = model;
    }

    @Override
    public String ShowCharacteristics() {
        return super.ShowCharacteristics() + "\n" +
            String.join("\n",
                "Country: " + country,
                "Model: " + model
            );
    }
}
