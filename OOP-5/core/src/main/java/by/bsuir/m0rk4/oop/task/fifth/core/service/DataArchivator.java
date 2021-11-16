package by.bsuir.m0rk4.oop.task.fifth.core.service;

import java.io.File;
import java.util.Optional;
import java.util.ServiceLoader;

public interface DataArchivator {
    void archivate(File serializedFile);
    File dearchivate(File zippedFile);

    static Optional<DataArchivator> getService(ModuleLayer layer) {
        return ServiceLoader
                .load(layer, DataArchivator.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .findFirst();
    }
}
