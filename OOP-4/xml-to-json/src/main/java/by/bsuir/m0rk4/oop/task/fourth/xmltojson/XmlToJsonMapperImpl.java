package by.bsuir.m0rk4.oop.task.fourth.xmltojson;

import by.bsuir.m0rk4.oop.task.fourth.core.data.deserialization.VehicleDeserializer;
import by.bsuir.m0rk4.oop.task.fourth.core.data.deserialization.impl.XmlDeserializer;
import by.bsuir.m0rk4.oop.task.fourth.core.data.serialization.VehicleSerializer;
import by.bsuir.m0rk4.oop.task.fourth.core.data.serialization.impl.CustomSerializer;
import by.bsuir.m0rk4.oop.task.fourth.core.entity.TransportVehicle;
import by.bsuir.m0rk4.oop.task.fourth.core.service.XmlToJsonMapper;
import java.io.File;
import java.util.List;

public class XmlToJsonMapperImpl implements XmlToJsonMapper {

    private static final String EXT_PATTERN = "(?<!^)[.][^.]*$";
    private static final String JSON_EXT = ".json";

    private final VehicleDeserializer vehicleDeserializer = new XmlDeserializer();
    private final VehicleSerializer vehicleSerializer = new CustomSerializer();

    @Override
    public void map(File xmlFile) {
        List<TransportVehicle> transportVehicles = vehicleDeserializer.deserializeVehicles(xmlFile);
        String xmlFileName = xmlFile.getName();
        String jsonFilename = xmlFileName.replaceAll(EXT_PATTERN, JSON_EXT);
        vehicleSerializer.serializeVehicles(new File(jsonFilename), transportVehicles);
    }
}
