import by.bsuir.m0rk4.oop.task.fifth.core.service.XmlToJsonMapperFacade;
import by.bsuir.m0rk4.oop.task.fifth.xmltojson.XmlToJsonMapperFacadeImpl;

module xmltojson {
    requires core;

    provides XmlToJsonMapperFacade with XmlToJsonMapperFacadeImpl;
}