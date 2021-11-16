package by.bsuir.m0rk4.oop.task.fifth.core.data.serialization.impl;

import by.bsuir.m0rk4.oop.task.fifth.core.data.serialization.VehicleSerializer;
import by.bsuir.m0rk4.oop.task.fifth.core.entity.TransportVehicle;
import by.bsuir.m0rk4.oop.task.fifth.core.service.DataArchivator;

import java.io.File;
import java.util.List;

public class ArchivationVehicleSerializerDecorator extends VehicleSerializerDecorator {

    private final DataArchivator dataArchivator;

    public ArchivationVehicleSerializerDecorator(VehicleSerializer vehicleSerializer, DataArchivator dataArchivator) {
        super(vehicleSerializer);
        this.dataArchivator = dataArchivator;
    }

    @Override
    public void serializeVehicles(File file, List<TransportVehicle> transportVehicles) {
        super.serializeVehicles(file, transportVehicles);
        dataArchivator.archivate(file);
    }
}
