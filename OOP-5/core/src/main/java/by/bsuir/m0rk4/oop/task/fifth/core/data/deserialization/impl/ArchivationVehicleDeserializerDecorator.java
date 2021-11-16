package by.bsuir.m0rk4.oop.task.fifth.core.data.deserialization.impl;

import by.bsuir.m0rk4.oop.task.fifth.core.data.deserialization.VehicleDeserializer;
import by.bsuir.m0rk4.oop.task.fifth.core.entity.TransportVehicle;
import by.bsuir.m0rk4.oop.task.fifth.core.service.DataArchivator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ArchivationVehicleDeserializerDecorator extends VehicleDeserializerDecorator{

    private final DataArchivator dataArchivator;

    public ArchivationVehicleDeserializerDecorator(VehicleDeserializer vehicleDeserializer, DataArchivator dataArchivator) {
        super(vehicleDeserializer);
        this.dataArchivator = dataArchivator;
    }

    @Override
    public List<TransportVehicle> deserializeVehicles(File file) {
        file = dataArchivator.dearchivate(file);
        List<TransportVehicle> vehicles = super.deserializeVehicles(file);
        try {
            Files.delete(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}
