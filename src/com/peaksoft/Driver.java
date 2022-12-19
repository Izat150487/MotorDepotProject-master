package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Driver {


    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./drivers.json");

    private int id;
    private String name;
    private String bus;

    public Driver() {
    }

    public Driver(int id, String name, String bus) {
        this.id = id;
        this.name = name;
        this.bus = bus;
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

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public static String getDrivers() {
        Driver[] drivers = {new Driver(1, "driver-1", "Andrew"),
                new Driver(2, "driver-2", "Mane"),
                new Driver(3, "driver-3", "Rashword")
        };

        Gson gson = new Gson();
        String json = GSON.toJson(drivers);
        System.out.println(readDriverFile());
        writeDriverFile(json);

        Driver[] drivers1 = GSON.fromJson(readDriverFile(), Driver[].class);
        for (Driver driver : drivers1) {
            System.out.println(driver.toString());
        }

        return json;
    }

    private static  void writeDriverFile(String json) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(WRITE_PATH, json, StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readDriverFile() {
        String json = " ";

        try {
            FileReader reader = new FileReader(String.valueOf(WRITE_PATH));
            int id;
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
        return id + " |  " + name + "  |  " + bus + '\n';
    }
}
