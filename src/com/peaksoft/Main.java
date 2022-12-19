package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    private static GsonBuilder GSON_BUILDER = new GsonBuilder();
    private static Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    private static Path URI = Paths.get("./trucks.json");

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Truck[] trucks = {
                new Truck(1, "Renault", " ", Status.BASE),
                new Truck(2, "Volvo  ", " ", Status.BASE),
                new Truck(3, "DAF XT ", " ", Status.BASE),
        };

        Driver[] drivers = {
                new Driver(1, "Kurmanbek", " "),
                new Driver(2, "Ibrakhim ", " "),
                new Driver(3, "Syimyk   ", " "),
        };
        print(trucks);
        print(drivers);

        /*String jsonTruck = GSON.toJson(trucks);
        writeCarFile(json);
        String jsonDriver = GSON.toJson(drivers);
        writeDriverFile(json);*/

    System.out.println("******************************");
    while(true){
        System.out.println("Choose one of the trucks: ");
        int input = scanner.nextInt();
        scanner.nextLine();
        Service service = new TruckService();
        getInstruction();
        String action = scanner.nextLine();
        if (action.equals("1")) {
            service.changeDriver(trucks[input - 1], drivers[input - 1]);
        } else if (action.equals("2")) {
            service.startDriving(trucks[input - 1], drivers[input - 1]);
        } else if (action.equals("3")) {
            service.startRepair(trucks[input - 1], drivers[input - 1]);
        }
        print(trucks);
        print(drivers);
    }

}
    public static void print(Truck[] trucks) {
        System.out.println("~~~~~~~~~~~~ * TRUCKS * ~~~~~~~~~~~~");
        System.out.println(" #|   Bus    | Driver | State");
        System.out.println("--+-----------+------+---------");
        for (int j = 0; j < trucks.length; j++) {
            System.out.println(trucks[j]);

        }
    }

    public static void print(Driver[] drivers) {
        System.out.println("~~~~~ * DRIVERS * ~~~~~");
        System.out.println();
        System.out.println("# |    Driver   | Bus ");
        System.out.println("-----------------------");
        for (int j = 0; j < drivers.length; j++) {
            System.out.println(drivers[j]);
        }
    }
        public static void getInstruction() {
            System.out.println("Select -1- to change driver ");
            System.out.println("Select -2- to start driving ");
            System.out.println("Select -3- to start repairing ");

    }
}