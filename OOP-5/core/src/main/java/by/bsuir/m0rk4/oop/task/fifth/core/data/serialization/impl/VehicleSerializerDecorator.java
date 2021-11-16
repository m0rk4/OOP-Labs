package by.bsuir.m0rk4.oop.task.fifth.core.data.serialization.impl;

import by.bsuir.m0rk4.oop.task.fifth.core.data.serialization.VehicleSerializer;
import by.bsuir.m0rk4.oop.task.fifth.core.entity.TransportVehicle;

import java.io.File;
import java.util.List;

public class VehicleSerializerDecorator implements VehicleSerializer {

    private final VehicleSerializer vehicleSerializerBase;

    public VehicleSerializerDecorator(VehicleSerializer vehicleSerializer) {
        this.vehicleSerializerBase = vehicleSerializer;
    }

    @Override
    public void serializeVehicles(File file, List<TransportVehicle> transportVehicles) {
        vehicleSerializerBase.serializeVehicles(file, transportVehicles);
    }
}
