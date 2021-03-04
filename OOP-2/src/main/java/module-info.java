module by.bsuir.mark.task.second {
    requires javafx.controls;
    requires javafx.fxml;

    opens by.bsuir.mark.task.second.controller to javafx.fxml;
    exports by.bsuir.mark.task.second;
}