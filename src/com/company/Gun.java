package com.company;

class Gun extends AbstractWeapon {
    private int capacity;
    private int rateOfFire;
    private int sightingRange;
    private int muzzleVelocity;
    private int numberOfCartridges;

    public Gun() {}

    public Gun(
            String name,
            double weight,
            int price,
            int serialNumber,
            int capacity,
            int rateOfFire,
            int sightingRange,
            int muzzleVelocity
    ) {
        super(name, weight, price, serialNumber);
        this.capacity = capacity;
        this.rateOfFire = rateOfFire;
        this.sightingRange = sightingRange;
        this.muzzleVelocity = muzzleVelocity;
        numberOfCartridges = capacity;
    }

    public int GetCapacity() { return capacity; }
    public int GetRateOfFire() { return rateOfFire; }
    public int GetSightingRange() { return sightingRange; }
    public int GetMuzzleVelocity() { return muzzleVelocity; }
    public int GetNumberOfCartridges() { return numberOfCartridges; }

    @Override
    public void UseWeapon() {
        if(numberOfCartridges != 0) {
            numberOfCartridges--;
            System.out.println(this.GetName() +  " used!");
        }
        else System.out.println("Cartridges run out");
    }

    public void Recharge() {
        numberOfCartridges = capacity;
    }

    @Override
    public String ShowCharacteristics() {
        return super.ShowCharacteristics() + "\n" +
            String.join(
                "\n",
                "Capacity: " + capacity,
                "Rate of fire: " + rateOfFire,
                "Sighting range: " + sightingRange,
                "Muzzle velocity: " + muzzleVelocity
            );
    }

}