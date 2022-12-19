package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    private static GsonBuilder GSON_BUILDER = new GsonBuilder();
    private static Gson GSON = GSON_BUILDER.setPrettyPrinting().create();

    private static Path URI = Paths.get("./trucks.json");

    public static void main(String[] args) {

        Truck[] trucks = {
                new Truck(1, "Renault Magnum", " ", Status.BASE),
                new Truck(2, "Volvo", " ", Status.BASE),
                new Truck(3, "DAF XT", " ", Status.BASE),
        };
        String json = GSON.toJson(trucks);
        System.out.println(readTruckFile());
       // writeCarFile(json);

        Truck[] trucks1 = GSON.fromJson(readTruckFile(), Truck[].class);
        for (Truck truck : trucks1) {
            System.out.println(truck);
        }
    }

    private static  void writeCarFile(String json) {

        try {
            Files.writeString(URI, json, StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readTruckFile() {
        String json = " ";
        int id;
        try {
            FileReader reader = new FileReader(String.valueOf(URI));
            while ((id = reader.read()) != -1) {
                json += (char) id;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}