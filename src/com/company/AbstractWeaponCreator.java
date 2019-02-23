package com.company;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public abstract class AbstractWeaponCreator {
    protected ArrayList<AbstractWeapon> listOfWeapons;

    public abstract AbstractWeapon factoryMethod();

    public static <T extends AbstractWeapon> ArrayList<T> GetListOfWeapons(Type listType, String filename)  {
        Gson gson = new Gson();
        StringBuilder wJson = new StringBuilder();
        try {
            Files.lines(Paths.get(filename), StandardCharsets.UTF_8).forEach(wJson::append);
        } catch (IOException e) {
            e.printStackTrace();
            LoggerFactory.CreaterLogger(Settings.LoggerType).Log("Json reading failed, wrong file used");
        }

        return gson.fromJson(wJson.toString(), listType);
    }
}


