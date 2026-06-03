package org.example.proyectofinaleedd;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.proyectofinaleedd.Navigation.Navigation;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        Navigation.navigate(Navigation.SCREENS.LOGIN_SCREEN);
    }
}
