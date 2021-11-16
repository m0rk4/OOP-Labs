package by.bsuir.m0rk4.oop.task.fifth.core.command.impl;

import by.bsuir.m0rk4.oop.task.fifth.core.command.Command;
import by.bsuir.m0rk4.oop.task.fifth.core.service.XmlToJsonMapperFacade;

import java.io.File;

public class XmlToJsonMapCommand implements Command {
    private final XmlToJsonMapperFacade xmlToJsonMapperFacade;
    private final File file;

    public XmlToJsonMapCommand(XmlToJsonMapperFacade xmlToJsonMapperFacade, File file) {
        this.xmlToJsonMapperFacade = xmlToJsonMapperFacade;
        this.file = file;
    }

    @Override
    public void execute() {
        xmlToJsonMapperFacade.map(file);
    }
}
