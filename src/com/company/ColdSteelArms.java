package com.company;

class ColdSteelArms extends AbstractWeapon {
    private int  bladeLength;
    private String bladeMaterial;

    public ColdSteelArms(
        String name,
        double weight,
        int price,
        int serialNumber,
        int bladeLength,
        String bladeMaterial
    ) {
        super(name, weight, price, serialNumber);
        this.bladeMaterial = bladeMaterial;
        this.bladeLength = bladeLength;
    }

    public void SharpenBlade() {
        //TODO: thread.sleep() + ...
        System.out.println("Blade is sharpened");
    }

    @Override
    public void UseWeapon() {
        System.out.println("Cold steel arms used");
    }

    @Override
    public String ShowCharacteristics() {
        return super.ShowCharacteristics() + "\n" +
            String.join(
                "\n",
                "Blade length: " + bladeLength,
                "Blade material: " + bladeMaterial
            );
    }
}