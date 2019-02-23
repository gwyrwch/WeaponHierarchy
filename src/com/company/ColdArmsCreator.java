package com.company;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ColdArmsCreator extends AbstractWeaponCreator {

    public ColdArmsCreator(String filename) {
        listOfWeapons = AbstractWeaponCreator.GetListOfWeapons(
                new TypeToken<ArrayList<ColdSteelArms>>(){}.getType(),
                filename
        );
    }

    @Override
    public AbstractWeapon factoryMethod(){
        int index = ThreadLocalRandom.current().nextInt(0, listOfWeapons.size());
        return (ColdSteelArms)listOfWeapons.get(index);
    }

}
