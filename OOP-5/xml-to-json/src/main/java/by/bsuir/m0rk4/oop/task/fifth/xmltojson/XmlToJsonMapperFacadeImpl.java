package by.bsuir.m0rk4.oop.task.fifth.xmltojson;

import by.bsuir.m0rk4.oop.task.fifth.core.data.deserialization.VehicleDeserializer;
import by.bsuir.m0rk4.oop.task.fifth.core.data.deserialization.impl.XmlDeserializer;
import by.bsuir.m0rk4.oop.task.fifth.core.data.serialization.VehicleSerializer;
import by.bsuir.m0rk4.oop.task.fifth.core.data.serialization.impl.CustomSerializer;
import by.bsuir.m0rk4.oop.task.fifth.core.entity.TransportVehicle;
import by.bsuir.m0rk4.oop.task.fifth.core.service.XmlToJsonMapperFacade;
import by.bsuir.m0rk4.oop.task.fifth.core.util.ExtensionReplacer;

import java.io.File;
import java.util.List;

public class XmlToJsonMapperFacadeImpl implements XmlToJsonMapperFacade {

    private static final String JSON_EXT = ".json";

    private final VehicleDeserializer vehicleDeserializer;
    private final VehicleSerializer vehicleSerializer;

    public XmlToJsonMapperFacadeImpl() {
        this.vehicleDeserializer = new XmlDeserializer();
        this.vehicleSerializer = new CustomSerializer();
    }

    @Override
    public void map(File xmlFile) {
        List<TransportVehicle> transportVehicles = vehicleDeserializer.deserializeVehicles(xmlFile);

        String xmlFileName = xmlFile.getName();
        String jsonFilename = ExtensionReplacer.replace(xmlFileName, JSON_EXT);

        vehicleSerializer.serializeVehicles(new File(jsonFilename), transportVehicles);
    }
}
