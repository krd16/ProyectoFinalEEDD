package org.example.proyectofinaleedd.Navigation;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.proyectofinaleedd.Screens.*;

public class Navigation {
    public enum SCREENS {
        LOGIN_SCREEN,
        HUB_SCREEN,
        ADD_PRODUCT_SCREEN,
        REMOVE_PRODUCT_SCREEN,
        EXISTENCES_SCREEN
    }
    private static final Stage stage = new Stage();

    public static void navigate(SCREENS screen) {
        switch (screen) {
            case LOGIN_SCREEN -> setupStage("Iniciar sesión", new Scene(new LoginScreen().getRoot(), 300, 300));
            case HUB_SCREEN -> setupStage("Menú", new Scene(new HubScreen().getRoot(), 300, 300));
            case ADD_PRODUCT_SCREEN -> setupStage("Añadir producto", new Scene(new AddProductScreen().getRoot(), 350, 200));
            case REMOVE_PRODUCT_SCREEN -> setupStage("Quitar producto", new Scene(new RemoveProductScreen().getRoot(), 350, 200));
            case EXISTENCES_SCREEN -> setupStage("Ver existencias", new Scene(new ExistencesScreen().getRoot(), 350, 200));
        }
    }

    private static void setupStage(String title, Scene scene) {
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
