module org.example.proyectofinaleedd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.proyectofinaleedd to javafx.fxml;
    exports org.example.proyectofinaleedd;
}