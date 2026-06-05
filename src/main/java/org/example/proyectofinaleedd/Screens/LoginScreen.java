package org.example.proyectofinaleedd.Screens;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.example.proyectofinaleedd.Navigation.Navigation;
import org.example.proyectofinaleedd.Services.LoginServices;

public class LoginScreen {
    private final GridPane root = new GridPane();

    private final Label userLabel = new Label("Usuario: ");
    private final Label passwordLabel = new Label("Contraseña: ");
    private final Label informationLabel = new Label();

    private final TextField userFiled = new TextField();
    private final PasswordField passwordField = new PasswordField();

    private final Button loginButton = new Button("Acceder");

    public LoginScreen() {
        root.setAlignment(Pos.CENTER);

        root.setVgap(10);
        root.setHgap(10);

        GridPane.setHalignment(loginButton, HPos.CENTER);
        GridPane.setHalignment(informationLabel, HPos.CENTER);

        GridPane.setColumnSpan(loginButton, 2);
        GridPane.setColumnSpan(informationLabel, 2);

        root.add(userLabel, 0, 0);
        root.add(userFiled, 1, 0);

        root.add(passwordLabel, 0, 1);
        root.add(passwordField, 1, 1);

        root.add(loginButton, 0, 2);

        root.add(informationLabel, 0, 3);

        loginButton.setOnAction(_ -> {
            try {
                LoginServices.login(userFiled.getText(), passwordField.getText());
                Navigation.navigate(Navigation.SCREENS.HUB_SCREEN);
            } catch (Exception e) {
                informationLabel.setText(e.getMessage());
            }
        });
    }

    public GridPane getRoot() {
        return root;
    }
}
