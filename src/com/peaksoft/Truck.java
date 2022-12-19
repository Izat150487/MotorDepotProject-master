package com.peaksoft;

public class Truck {

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

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", driver='" + driver + '\'' +
                ", status=" + status +
                '}';
    }
}
