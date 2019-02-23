package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LoggerFactory.CreaterLogger(Settings.LoggerType).Log("Program successfully started");
        System.out.println("Enter the number of military: 12");
        Scanner in = new Scanner(System.in);
        int numOfMilitary = in.nextInt();

        Division d = new Division(numOfMilitary);
        d.EquipWithWeapons();
        System.out.println(d.CountCost());

        System.out.println(d.ShowInformation());

        LoggerFactory.CreaterLogger(Settings.LoggerType).Log("Program successfully finished");
    }



}
// /Users/gwyrwch/.m2/repository/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar