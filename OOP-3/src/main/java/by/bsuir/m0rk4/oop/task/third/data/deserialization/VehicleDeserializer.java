package by.bsuir.m0rk4.oop.task.third.data.deserialization;

import by.bsuir.m0rk4.oop.task.third.entity.TransportVehicle;

import java.io.File;
import java.util.List;

public interface VehicleDeserializer {
    List<TransportVehicle> deserializeVehicles(File file);
}
