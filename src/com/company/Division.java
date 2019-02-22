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

    private <T extends AbstractWeapon> ArrayList<T> GetListOfWeapons(Type listType, String filename)  {
        Gson gson = new Gson();
        StringBuilder wJson = new StringBuilder();
        try {
            Files.lines(Paths.get(filename), StandardCharsets.UTF_8).forEach(wJson::append);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return gson.fromJson(wJson.toString(), listType);
    }

    void EquipWithWeapons() {
        Type listType  = new TypeToken<ArrayList<MilitaryFirearms>>(){}.getType();
        ArrayList<MilitaryFirearms> listOfFireArms = GetListOfWeapons(
            new TypeToken<ArrayList<MilitaryFirearms>>(){}.getType(),
            "firearms.json"
        );
        ArrayList<ColdSteelArms> listOfColdArms = GetListOfWeapons(
            new TypeToken<ArrayList<ColdSteelArms>>(){}.getType(),
            "coldarms.json"
        );

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
