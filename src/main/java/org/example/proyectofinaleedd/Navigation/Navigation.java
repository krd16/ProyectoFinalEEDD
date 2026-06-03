package org.example.proyectofinaleedd.Navigation;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.proyectofinaleedd.Screens.LoginScreen;

public class Navigation {
    public enum SCREENS {
        LOGIN_SCREEN
    }
    private static final Stage stage = new Stage();

    public static void navigate(SCREENS screen) {
        switch (screen) {
            case LOGIN_SCREEN -> setupStage("Login", new Scene(new LoginScreen().getRoot(), 300, 300));
        }
    }

    private static void setupStage(String title, Scene scene) {
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
