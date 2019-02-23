package com.company;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MilitaryFirearmsCreator extends AbstractWeaponCreator{

    public MilitaryFirearmsCreator(String filename) {
        listOfWeapons = AbstractWeaponCreator.GetListOfWeapons(
                new TypeToken<ArrayList<MilitaryFirearms>>(){}.getType(),
                filename
        );
    }

    @Override
    public AbstractWeapon factoryMethod(){
        int index = ThreadLocalRandom.current().nextInt(0, listOfWeapons.size());
        return (MilitaryFirearms)listOfWeapons.get(index);
    }

}
