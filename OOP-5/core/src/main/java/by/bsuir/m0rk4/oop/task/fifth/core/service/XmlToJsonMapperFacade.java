package by.bsuir.m0rk4.oop.task.fifth.core.service;

import java.io.File;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;

public interface XmlToJsonMapperFacade {
    void map(File xmlFile);

    static Optional<XmlToJsonMapperFacade> getService(ModuleLayer layer) {
        return ServiceLoader
                .load(layer, XmlToJsonMapperFacade.class)
                .stream()
                .map(Provider::get)
                .findFirst();
    }
}
