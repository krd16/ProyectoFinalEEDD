package org.example.proyectofinaleedd.Screens;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class HubScreen {
    private final GridPane root = new GridPane();

    private final Button addProductButton = new Button("Añadir producto");
    private final Button removeProductbutton = new Button("Quitar producto");
    private final Button consultExistencesButton = new Button("Ver existencias");

    public HubScreen() {
        root.setAlignment(Pos.CENTER);
        root.setVgap(20);

        GridPane.setColumnSpan(addProductButton, 2);
        GridPane.setColumnSpan(removeProductbutton, 2);
        GridPane.setColumnSpan(consultExistencesButton, 2);

        GridPane.setHalignment(addProductButton, HPos.CENTER);
        GridPane.setHalignment(removeProductbutton, HPos.CENTER);
        GridPane.setHalignment(consultExistencesButton, HPos.CENTER);

        root.add(addProductButton, 0, 0);
        root.add(removeProductbutton, 0, 1);
        root.add(consultExistencesButton, 0, 2);
    }

    public GridPane getRoot() {
        return root;
    }
}
