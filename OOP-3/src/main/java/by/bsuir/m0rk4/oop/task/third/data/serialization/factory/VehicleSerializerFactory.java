package by.bsuir.m0rk4.oop.task.third.data.serialization.factory;

import by.bsuir.m0rk4.oop.task.third.data.VehicleFileProcessType;
import by.bsuir.m0rk4.oop.task.third.data.deserialization.VehicleDeserializer;
import by.bsuir.m0rk4.oop.task.third.data.deserialization.impl.BinaryDeserializer;
import by.bsuir.m0rk4.oop.task.third.data.deserialization.impl.CustomDeserializer;
import by.bsuir.m0rk4.oop.task.third.data.deserialization.impl.XmlDeserializer;
import by.bsuir.m0rk4.oop.task.third.data.serialization.VehicleSerializer;
import by.bsuir.m0rk4.oop.task.third.data.serialization.impl.BinarySerializer;
import by.bsuir.m0rk4.oop.task.third.data.serialization.impl.CustomSerializer;
import by.bsuir.m0rk4.oop.task.third.data.serialization.impl.XmlSerializer;

public class VehicleSerializerFactory {
    public VehicleSerializer createVehicleSerializer(VehicleFileProcessType processType) {
        switch (processType) {
            case BINARY:
                return new BinarySerializer();
            case XML:
                return new XmlSerializer();
            case CUSTOM:
                return new CustomSerializer();
            default:
                throw new EnumConstantNotPresentException(processType.getClass(), processType.name());
        }
    }
}
