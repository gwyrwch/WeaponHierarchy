package com.company;

public class Main {

    public static void main(String[] args) {

        //Scanner in = new Scanner(System.in);
        // int num = in.nextInt();
        LoggerFactory.CreaterLogger(Settings.LoggerType).Log("Program successfully started");

        Division d = new Division(20);
        d.EquipWithWeapons();
        System.out.println(d.CountCost());

        System.out.println(d.ShowInformation());

        LoggerFactory.CreaterLogger(Settings.LoggerType).Log("Program successfully finished");
    }



}
// /Users/gwyrwch/.m2/repository/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar