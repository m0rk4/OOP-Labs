import by.bsuir.m0rk4.oop.task.fifth.core.service.DataArchivator;
import by.bsuir.m0rk4.oop.task.fifth.archivation.DataArchivatorImpl;

module archivation {
    requires core;

    provides DataArchivator with DataArchivatorImpl;
}