package com.peaksoft;

import java.util.Random;

public class TruckService implements Service {
    @Override
    public void changeDriver(Truck truck, Driver driver) {
        try{
            if (truck.getStatus().equals(Status.BASE)){
                truck.setDriver(driver.getName());
                driver.setBus(truck.getName());
                if(driver.getName() == null){
                    System.out.println("Свобоного водителя нет!");
                }else {
                    System.out.println("Теперь у машины " + truck.getName() + " назначен водитель " + driver.getName());
                }}
        }catch (RuntimeException e){
            e.printStackTrace();
        }

    }

    @Override
    public void startDriving(Truck truck, Driver driver) {
        if (truck.getStatus().equals(Status.BASE)){
            if (!truck.getDriver().equals("")){
                truck.setStatus(Status.ROUTE);
                System.out.println("Водитель успешно начал свой путь");
            }else {
                System.out.println("Здесь нет водителя");
            }
        }else if(truck.getStatus().equals(Status.ROUTE)){
            System.out.println("Водитель уже в пути!");
        }else {
            Random random = new Random();
            int road = random.nextInt(2);
            if (road==0){
                truck.setStatus(Status.ROUTE);
                System.out.println("Грузовик уже в пути");
            }else {
                truck.setStatus(Status.BASE);
                System.out.println("Грузовик на базе");

            }
        }

    }

    @Override
    public void startRepair(Truck truck, Driver driver) {
        if (truck.getStatus().equals(Status.BASE)){
            truck.setStatus(Status.REPAIR);
            System.out.println("Грузовик находится в СТО");
        }else if (truck.getStatus().equals(Status.ROUTE)){
            truck.setStatus(Status.REPAIR);
        }else {
            System.out.println("Грузовик в ремонте");
        }
    }
}
