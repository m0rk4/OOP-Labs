package by.bsuir.m0rk4.oop.task.third.data.deserialization.factory;

import by.bsuir.m0rk4.oop.task.third.data.VehicleFileProcessType;
import by.bsuir.m0rk4.oop.task.third.data.deserialization.VehicleDeserializer;
import by.bsuir.m0rk4.oop.task.third.data.deserialization.impl.BinaryDeserializer;
import by.bsuir.m0rk4.oop.task.third.data.deserialization.impl.CustomDeserializer;
import by.bsuir.m0rk4.oop.task.third.data.deserialization.impl.XmlDeserializer;

public class VehicleDeserializerFactory {
    public VehicleDeserializer createVehicleDeserializer(VehicleFileProcessType processType) {
        switch (processType) {
            case BINARY:
                return new BinaryDeserializer();
            case XML:
                return new XmlDeserializer();
            case CUSTOM:
                return new CustomDeserializer();
            default:
                throw new EnumConstantNotPresentException(processType.getClass(), processType.name());
        }
    }
}
