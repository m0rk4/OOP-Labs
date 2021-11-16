package by.bsuir.m0rk4.oop.task.fifth.core.data.deserialization.impl;

import by.bsuir.m0rk4.oop.task.fifth.core.data.deserialization.VehicleDeserializer;
import by.bsuir.m0rk4.oop.task.fifth.core.entity.TransportVehicle;

import java.io.File;
import java.util.List;

public class VehicleDeserializerDecorator implements VehicleDeserializer {
    private final VehicleDeserializer vehicleDeserializer;

    public VehicleDeserializerDecorator(VehicleDeserializer vehicleDeserializer) {
        this.vehicleDeserializer = vehicleDeserializer;
    }

    @Override
    public List<TransportVehicle> deserializeVehicles(File file) {
        return vehicleDeserializer.deserializeVehicles(file);
    }
}
