package com.company;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class Division {
    private int numberOfMilitary;
    private ArrayList<AbstractWeapon> weapons;

    public Division(int numberOfMilitary) {
        this.numberOfMilitary = numberOfMilitary;
        weapons = new ArrayList<>(numberOfMilitary);
    }

    void EquipWithWeapons() {
        MilitaryFirearmsCreator militaryFactory = new MilitaryFirearmsCreator("firearms.json");
        ColdArmsCreator coldArmsFactory = new ColdArmsCreator("coldarms.json");

        AbstractWeaponCreator[] factories = {militaryFactory, coldArmsFactory};

        for (int i = 0; i < numberOfMilitary; i++) {
            int type = ThreadLocalRandom.current().nextInt(0, 2);
            weapons.add(factories[type].factoryMethod());
        }

        LoggerFactory.CreaterLogger(Settings.LoggerType).Log("Division successfully equipped from method Division.EquipWithWeapons");
    }

    public int CountCost() {
        LoggerFactory.CreaterLogger(Settings.LoggerType).Log("Counting cost from method Division.CountCost\n...");

        int cost = 0;
        for(AbstractWeapon w : weapons)
            cost += w.GetPrice();

        LoggerFactory.CreaterLogger(Settings.LoggerType).Log("Division.CountCost: Cost is " + cost);

        return cost;
    }

    public StringBuilder ShowInformation() {
        StringBuilder out = new StringBuilder();
        for(AbstractWeapon w : weapons) {
            out.append(w.ShowCharacteristics());
            out.append("\n\n");
        }

        return out;
    }
}
