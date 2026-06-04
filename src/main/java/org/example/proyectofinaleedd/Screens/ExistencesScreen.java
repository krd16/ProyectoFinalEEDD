package org.example.proyectofinaleedd.Screens;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import org.example.proyectofinaleedd.Navigation.Navigation;
import org.example.proyectofinaleedd.Services.StockServices;

public class ExistencesScreen {
    private final GridPane root = new GridPane();

    private HBox buttonsHBox = new HBox();

    private Label productNameLabel = new Label("Nombre del producto: ");
    private Label informationLabel = new Label();

    private TextField productName = new TextField();

    private Button existencesButton = new Button("Ver existencias");
    private Button backButton = new Button("Atrás");

    public ExistencesScreen() {
        root.setAlignment(Pos.CENTER);
        root.setVgap(15);
        root.setHgap(20);

        GridPane.setHalignment(buttonsHBox, HPos.CENTER);
        GridPane.setHalignment(informationLabel, HPos.CENTER);

        GridPane.setColumnSpan(buttonsHBox, 2);
        GridPane.setColumnSpan(informationLabel, 2);

        buttonsHBox.setAlignment(Pos.CENTER);
        buttonsHBox.setSpacing(20);

        buttonsHBox.getChildren().addAll(existencesButton, backButton);

        root.add(productNameLabel, 0, 0);
        root.add(productName, 1, 0);

        root.add(buttonsHBox, 0, 1);

        root.add(informationLabel, 0, 2);

        existencesButton.setOnAction(_ -> {
            try {
                informationLabel.setText("Existencias: " + StockServices.getStock(productName.getText()));
            } catch (Exception e) {
                informationLabel.setText("Error: " + e.getMessage());
            }
        });

        backButton.setOnAction(_ -> {
            Navigation.navigate(Navigation.SCREENS.HUB_SCREEN);
        });
    }

    public GridPane getRoot() {
        return root;
    }
}
