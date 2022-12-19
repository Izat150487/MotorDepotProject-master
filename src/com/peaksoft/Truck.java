package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Truck {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./truck.json");

    private int id;
    private String name;
    private String driver;
    private Status status;

    public Truck() {
    }

    public Truck(int id, String name, String driver, Status status) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static void getTruck(String name){
        Truck[] trucks = {
                new Truck(1, "Renault Magnum", " " ,Status.BASE),
                new Truck(2, "Volvo", " ", Status.ROUTE),
                new Truck(3, "DAF XT", " ", Status.REPAIR),
        };

        String json = GSON.toJson(trucks);
        System.out.println(readTruckFile());
        writeCarFile(json);

        Truck[] truck = GSON.fromJson(readTruckFile(),Truck[].class);
        for (Truck t :truck) {
            System.out.println(t.toString());
        }
    }

    private static  void writeCarFile(String json) {

        try {
            Files.writeString(WRITE_PATH, json, StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readTruckFile() {
        String json = " ";
        int id;
        try {
            FileReader reader = new FileReader(String.valueOf(WRITE_PATH));
            while ((id = reader.read()) != -1) {
                json += (char) id;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public String toString() {
        return id + " |  " + name +"  | "+ "     |  " + status + '\n';
    }
}
