package by.bsuir.m0rk4.oop.task.third.data.deserialization.impl;

import by.bsuir.m0rk4.oop.task.third.data.deserialization.VehicleDeserializer;
import by.bsuir.m0rk4.oop.task.third.entity.TransportVehicle;
import by.bsuir.m0rk4.oop.task.third.entity.Vehicles;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class XmlDeserializer implements VehicleDeserializer {
    @Override
    public List<TransportVehicle> deserializeVehicles(File file) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            Vehicles vehicles = xmlMapper.readValue(file, Vehicles.class);
            return vehicles.getVehicles();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new LinkedList<>();
    }
}
