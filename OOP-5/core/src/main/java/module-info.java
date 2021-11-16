import by.bsuir.m0rk4.oop.task.fifth.core.service.DataArchivator;
import by.bsuir.m0rk4.oop.task.fifth.core.service.XmlToJsonMapperFacade;

module core {
    // javafx
    exports by.bsuir.m0rk4.oop.task.fifth.core;

    requires javafx.controls;
    requires javafx.fxml;

    opens by.bsuir.m0rk4.oop.task.fifth.core.controller to javafx.fxml;

    // plugin system
    exports by.bsuir.m0rk4.oop.task.fifth.core.service;

    exports by.bsuir.m0rk4.oop.task.fifth.core.data.deserialization.impl;
    exports by.bsuir.m0rk4.oop.task.fifth.core.data.deserialization;

    exports by.bsuir.m0rk4.oop.task.fifth.core.data.serialization.impl;
    exports by.bsuir.m0rk4.oop.task.fifth.core.data.serialization;

    exports by.bsuir.m0rk4.oop.task.fifth.core.entity;

    exports by.bsuir.m0rk4.oop.task.fifth.core.util;

    // jackson mapper
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.xml;
    requires com.fasterxml.jackson.module.jaxb;

    opens by.bsuir.m0rk4.oop.task.fifth.core.entity to com.fasterxml.jackson.databind;

    uses XmlToJsonMapperFacade;
    uses DataArchivator;
}