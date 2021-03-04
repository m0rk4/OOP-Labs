module by.bsuir.m0rk.oop.task.third {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.xml;
    requires com.fasterxml.jackson.module.jaxb;

    opens by.bsuir.m0rk4.oop.task.third.entity to com.fasterxml.jackson.databind;
    opens by.bsuir.m0rk4.oop.task.third.controller to javafx.fxml;
    exports by.bsuir.m0rk4.oop.task.third;
}