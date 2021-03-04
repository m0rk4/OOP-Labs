package by.bsuir.m0rk4.oop.task.third.components;

import by.bsuir.m0rk4.oop.task.third.entity.MuscularPower;
import by.bsuir.m0rk4.oop.task.third.entity.NonMechanicalVehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public abstract class NonMechanicalVehicleForm extends AbstractVehicleForm {

    private final Label muscularPower = new Label("Muscular Power");
    private final ChoiceBox<String> muscularChoiceBox = new ChoiceBox<>(
            FXCollections.observableArrayList(
                    "Human",
                    "Animal",
                    "Environment"
            )
    );

    @Override
    public void clear() {
        super.clear();
    }

    public void setForm(NonMechanicalVehicle nonMechanicalVehicle) {
        super.setForm(nonMechanicalVehicle);
        MuscularPower muscularPower = nonMechanicalVehicle.getMuscularPower();
        muscularChoiceBox.getSelectionModel().select(
                muscularPower.equals(MuscularPower.HUMAN) ? 0 :
                        muscularPower.equals(MuscularPower.ANIMAL) ? 1 : 2
        );
    }

    public NonMechanicalVehicleForm() {
        super();
        ObservableList<Node> children = getChildren();
        muscularChoiceBox.getSelectionModel().select(0);
        children.addAll(
                muscularPower,
                muscularChoiceBox
        );
    }

    public MuscularPower generateMuscularPower() {
        String selectedItem = muscularChoiceBox.getSelectionModel().getSelectedItem();
        return MuscularPower.valueOf(selectedItem.toUpperCase());
    }
}
