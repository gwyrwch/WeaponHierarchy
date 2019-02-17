package com.company;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class Division {
    private int numberOfMilitary;
    private ArrayList<AbstractWeapon> weapons;

    public Division(int numberOfMilitary) {
        this.numberOfMilitary = numberOfMilitary;
        weapons = new ArrayList<>(numberOfMilitary);
    }

    private ArrayList<MilitaryFirearms> GetListOfFireArms() {
        Gson gson = new Gson();
        StringBuilder wJson = new StringBuilder();
        try {
            Files.lines(Paths.get("firearms.json"), StandardCharsets.UTF_8).forEach(s -> wJson.append(s));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Type listType  = new TypeToken<ArrayList<MilitaryFirearms>>(){}.getType();
        return gson.fromJson(wJson.toString(), listType);
    }

    private ArrayList<ColdSteelArms> GetListOfColdArms() {
        Gson gson = new Gson();
        StringBuilder wJson = new StringBuilder();
        try {
            Files.lines(Paths.get("coldarms.json"), StandardCharsets.UTF_8).forEach(s -> wJson.append(s));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Type listType  = new TypeToken<ArrayList<ColdSteelArms>>(){}.getType();
        return gson.fromJson(wJson.toString(), listType);
    }



    public void EquipWithWeapons() {
        ArrayList<MilitaryFirearms> listOfFireArms = GetListOfFireArms();
        ArrayList<ColdSteelArms> listOfColdArms = GetListOfColdArms();

        int milWithFireArms = ThreadLocalRandom.current().nextInt(0, numberOfMilitary);
        for(int i = 0; i < milWithFireArms; i++) {
            int index = ThreadLocalRandom.current().nextInt(0, listOfFireArms.size());
            weapons.add((listOfFireArms.get(index)));
        }

        int milWithColdArms = numberOfMilitary - milWithFireArms;
        for(int i = 0; i < milWithColdArms; i++) {
            int index = ThreadLocalRandom.current().nextInt(0, listOfColdArms.size());
            weapons.add((listOfColdArms.get(index)));
        }

        //TODO: read from file weapons and randomly equip each person
    }

    public int CountCost() {
        int cost = 0;
        for(AbstractWeapon w : weapons)
            cost += w.GetPrice();

        return cost;
    }

    public StringBuilder ShowInformation() {
        StringBuilder out = new StringBuilder();
        for(AbstractWeapon w : weapons) {
            out.append(w.ShowCharacteristics() + "\n\n");
        }

        return out;
    }
}
