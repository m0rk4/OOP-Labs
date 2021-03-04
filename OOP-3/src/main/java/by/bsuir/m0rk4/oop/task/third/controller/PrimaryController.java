package by.bsuir.m0rk4.oop.task.third.controller;

import by.bsuir.m0rk4.oop.task.third.components.*;
import by.bsuir.m0rk4.oop.task.third.data.VehicleFileProcessType;
import by.bsuir.m0rk4.oop.task.third.data.deserialization.VehicleDeserializer;
import by.bsuir.m0rk4.oop.task.third.data.deserialization.factory.VehicleDeserializerFactory;
import by.bsuir.m0rk4.oop.task.third.data.serialization.VehicleSerializer;
import by.bsuir.m0rk4.oop.task.third.data.serialization.factory.VehicleSerializerFactory;
import by.bsuir.m0rk4.oop.task.third.entity.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PrimaryController {

    private final VehicleSerializerFactory serializerFactory;
    private final VehicleDeserializerFactory deserializerFactory;
    private VehicleFileProcessType vehicleFileProcessType = VehicleFileProcessType.BINARY;

    public RadioButton bicycleRB;
    public RadioButton cartRB;
    public RadioButton sportCarRB;
    public RadioButton tractorRB;
    public RadioButton motorcycleRB;


    public BorderPane formBorderPane;

    public Button saveButton;
    public Button loadButton;

    public Button saveVehicleButton;
    public Button addVehicleButton;
    public Button deleteVehicleButton;

    public TreeView<TransportVehicle> treeView;

    public RadioButton binaryRB;
    public RadioButton customRB;
    public RadioButton xmlRB;

    private AbstractVehicleForm abstractVehicleForm = new BicycleForm();

    private List<TransportVehicle> transportVehicles;

    public PrimaryController(VehicleSerializerFactory serializerFactory, VehicleDeserializerFactory deserializerFactory) {
        this.serializerFactory = serializerFactory;
        this.deserializerFactory = deserializerFactory;
        this.transportVehicles = new LinkedList<>();
    }

    private final TreeItem<TransportVehicle> root = new TreeItem<>(new TransportVehicle() {
        @Override
        public String toString() {
            return "Transport Vehicles";
        }
    });
    private final TreeItem<TransportVehicle> mechanicalChild = new TreeItem<>(new MechanicalVehicle() {
        @Override
        public String toString() {
            return "Mechanical Vehicles";
        }
    });
    private final TreeItem<TransportVehicle> nonMechanicalChild = new TreeItem<>(new NonMechanicalVehicle() {
        @Override
        public String toString() {
            return "Non Mechanical Vehicles";
        }
    });

    private TransportVehicle currTransportVehicle;
    private TreeItem<TransportVehicle> currTransportItem;

    @FXML
    private void initialize() {
        binaryRB.setOnAction(e -> vehicleFileProcessType = VehicleFileProcessType.BINARY);
        xmlRB.setOnAction(e -> vehicleFileProcessType = VehicleFileProcessType.XML);
        customRB.setOnAction(e -> vehicleFileProcessType = VehicleFileProcessType.CUSTOM);

        saveButton.setOnAction(this::saveVehicles);
        loadButton.setOnAction(this::loadVehicles);

        formBorderPane.setCenter(abstractVehicleForm);

        root.getChildren().addAll(mechanicalChild, nonMechanicalChild);
        root.setExpanded(true);
        treeView.setRoot(root);
        treeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        treeView.setOnMouseClicked(this::clickedView);

        bicycleRB.setOnAction(e -> selectedRBForm(new BicycleForm()));
        cartRB.setOnAction(e -> selectedRBForm(new CartForm()));
        sportCarRB.setOnAction(e -> selectedRBForm(new SportCarForm()));
        tractorRB.setOnAction(e -> selectedRBForm(new TractorForm()));
        motorcycleRB.setOnAction(e -> selectedRBForm(new MotorCycleForm()));

        addVehicleButton.setOnAction(this::addVehicleForm);
        deleteVehicleButton.setOnAction(this::deleteVehicle);
        saveVehicleButton.setOnAction(this::saveVehicleForm);

    }

    private void saveVehicleForm(ActionEvent actionEvent) {
        if (currTransportVehicle != null) {
            AbstractVehicleForm center = (AbstractVehicleForm) formBorderPane.getCenter();
            Optional<TransportVehicle> transportVehicle = center.generateVehicle();
            if (transportVehicle.isPresent()) {
                TransportVehicle transportVehicleReal = transportVehicle.get();
                currTransportItem.setValue(transportVehicleReal);
                int i = transportVehicles.indexOf(currTransportVehicle);
                transportVehicles.set(i, transportVehicleReal);
                center.clear();
            } else {
                showAlert(Alert.AlertType.ERROR, "Validation", "Check data correctness.");
            }
        }
    }

    private void selectedRBForm(AbstractVehicleForm form) {
        formBorderPane.setCenter(form);
        currTransportVehicle = null;
        currTransportItem = null;
    }

    private void deleteVehicle(ActionEvent actionEvent) {
        if (currTransportVehicle != null) {
            mechanicalChild.getChildren().remove(currTransportItem);
            nonMechanicalChild.getChildren().remove(currTransportItem);
            transportVehicles.remove(currTransportVehicle);
            AbstractVehicleForm center = (AbstractVehicleForm) formBorderPane.getCenter();
            currTransportVehicle = null;
            currTransportItem = null;
            center.clear();
        }
    }

    private void clickedView(MouseEvent event) {
        ObservableList<TreeItem<TransportVehicle>> selectedItems = treeView.getSelectionModel().getSelectedItems();
        if (!selectedItems.isEmpty()) {

            currTransportItem = selectedItems.get(0);
            currTransportVehicle = currTransportItem.getValue();
            // roots
            AbstractVehicleForm center = (AbstractVehicleForm) formBorderPane.getCenter();
            if (currTransportVehicle.getBrandName() == null) {
                currTransportVehicle = null;
                currTransportItem = null;
                center.clear();
                return;
            }
            // just set forms and contents
            // and selected item
            if (currTransportVehicle instanceof Bicycle) {
                bicycleRB.setSelected(true);
                formBorderPane.setCenter(new BicycleForm());
                BicycleForm form = (BicycleForm) formBorderPane.getCenter();
                Bicycle el = (Bicycle) currTransportVehicle;
                form.setForm(el);
            } else if (currTransportVehicle instanceof Cart) {
                cartRB.setSelected(true);
                formBorderPane.setCenter(new CartForm());
                CartForm form = (CartForm) formBorderPane.getCenter();
                Cart el = (Cart) currTransportVehicle;
                form.setForm(el);
            } else if (currTransportVehicle instanceof Motorcycle) {
                motorcycleRB.setSelected(true);
                formBorderPane.setCenter(new MotorCycleForm());
                MotorCycleForm form = (MotorCycleForm) formBorderPane.getCenter();
                Motorcycle el = (Motorcycle) currTransportVehicle;
                form.setForm(el);
            } else if (currTransportVehicle instanceof SportCar) {
                sportCarRB.setSelected(true);
                formBorderPane.setCenter(new SportCarForm());
                SportCarForm form = (SportCarForm) formBorderPane.getCenter();
                SportCar el = (SportCar) currTransportVehicle;
                form.setForm(el);
            } else { // tractor
                tractorRB.setSelected(true);
                formBorderPane.setCenter(new TractorForm());
                TractorForm form = (TractorForm) formBorderPane.getCenter();
                Tractor el = (Tractor) currTransportVehicle;
                form.setForm(el);
            }
        }
    }

    private void addVehicleForm(ActionEvent actionEvent) {
        AbstractVehicleForm center = (AbstractVehicleForm) formBorderPane.getCenter();
        Optional<TransportVehicle> transportVehicle = center.generateVehicle();
        if (transportVehicle.isPresent()) {
            TransportVehicle transportVehicleReal = transportVehicle.get();
            transportVehicles.add(transportVehicleReal);
            if (transportVehicleReal instanceof MechanicalVehicle) {
                mechanicalChild.getChildren().add(new TreeItem<>(transportVehicleReal));
            } else {
                nonMechanicalChild.getChildren().add(new TreeItem<>(transportVehicleReal));
            }
            center.clear();
        } else {
            showAlert(Alert.AlertType.ERROR, "Validation", "Check data correctness.");
        }
    }

    private void loadVehicles(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("./"));
        fileChooser.setTitle("Load Vehicles");
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            VehicleDeserializer vehicleDeserializer = deserializerFactory.createVehicleDeserializer(vehicleFileProcessType);
            transportVehicles = vehicleDeserializer.deserializeVehicles(file);
            buildTreeView(transportVehicles);
        }
    }

    private void buildTreeView(List<TransportVehicle> transportVehicles) {
        ObservableList<TreeItem<TransportVehicle>> mechanicalChildChildren = mechanicalChild.getChildren();
        ObservableList<TreeItem<TransportVehicle>> nonMechanicalChildChildren = nonMechanicalChild.getChildren();
        for (TransportVehicle transportVehicle : transportVehicles) {
            if (transportVehicle instanceof MechanicalVehicle) {
                mechanicalChildChildren.add(new TreeItem<>(transportVehicle));
            } else {
                nonMechanicalChildChildren.add(new TreeItem<>(transportVehicle));
            }
        }
    }

    private void saveVehicles(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("./"));
        fileChooser.setTitle("Save Vehicles");
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            VehicleSerializer vehicleSerializer = serializerFactory.createVehicleSerializer(vehicleFileProcessType);
            vehicleSerializer.serializeVehicles(file, transportVehicles);
        }
    }

    private void showAlert(Alert.AlertType type, String title, String info) {
        Alert alert = new Alert(type);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(info);
        alert.show();
    }


}
