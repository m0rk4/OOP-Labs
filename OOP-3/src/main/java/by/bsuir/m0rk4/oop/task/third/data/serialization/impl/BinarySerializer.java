package by.bsuir.m0rk4.oop.task.third.data.serialization.impl;

import by.bsuir.m0rk4.oop.task.third.data.serialization.VehicleSerializer;
import by.bsuir.m0rk4.oop.task.third.entity.TransportVehicle;

import java.io.*;
import java.util.List;

public class BinarySerializer implements VehicleSerializer {
    @Override
    public void serializeVehicles(File file, List<TransportVehicle> transportVehicles) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(transportVehicles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
