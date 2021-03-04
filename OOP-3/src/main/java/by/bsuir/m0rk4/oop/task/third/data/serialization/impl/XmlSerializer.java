package by.bsuir.m0rk4.oop.task.third.data.serialization.impl;

import by.bsuir.m0rk4.oop.task.third.data.serialization.VehicleSerializer;
import by.bsuir.m0rk4.oop.task.third.entity.TransportVehicle;
import by.bsuir.m0rk4.oop.task.third.entity.Vehicles;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XmlSerializer implements VehicleSerializer {
    @Override
    public void serializeVehicles(File file, List<TransportVehicle> transportVehicles) {
        XmlMapper xmlMapper = new XmlMapper();
        Vehicles vehicles = new Vehicles(transportVehicles);
        try {
            xmlMapper.writeValue(file, vehicles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
