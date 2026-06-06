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

public class RemoveProductScreen {
    private final GridPane root = new GridPane();

    private HBox buttonsHBox = new HBox();

    private Label productNameLabel = new Label("Nombre del producto: ");
    private Label productAmountLabel = new Label("Cantidad: ");
    private Label informationLabel = new Label();

    private TextField productName = new TextField();
    private TextField productAmount = new TextField();

    private final Button removeButton = new Button("Quitar");
    private final Button backButton = new Button("Atrás");

    public RemoveProductScreen() {
        root.setVgap(15);
        root.setHgap(20);
        root.setAlignment(Pos.CENTER);

        GridPane.setHalignment(buttonsHBox, HPos.CENTER);
        GridPane.setHalignment(informationLabel, HPos.CENTER);

        GridPane.setColumnSpan(buttonsHBox, 2);
        GridPane.setColumnSpan(informationLabel, 2);

        buttonsHBox.setAlignment(Pos.CENTER);
        buttonsHBox.setSpacing(20);

        buttonsHBox.getChildren().addAll(removeButton, backButton);

        root.add(productNameLabel, 0, 0);
        root.add(productName, 1, 0);

        root.add(productAmountLabel, 0, 1);
        root.add(productAmount, 1, 1);

        root.add(buttonsHBox, 0, 2);

        root.add(informationLabel, 0, 3);

        removeButton.setOnAction(actionEvent -> {
            try {
                StockServices.removeProduct(productName.getText(), productAmount.getText());
                informationLabel.setText("Stock actualizado con éxito");
            } catch (NumberFormatException e) {
                informationLabel.setText("El campo cantidad debe se un número válido.");
            } catch (Exception e) {
                informationLabel.setText(e.getMessage());
            }
        });

        backButton.setOnAction(actionEvent -> {
            Navigation.navigate(Navigation.SCREENS.HUB_SCREEN);
        });
    }

    public GridPane getRoot() {
        return root;
    }
}
