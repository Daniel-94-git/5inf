module com.example.todolistfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.todolistfx to javafx.fxml;
    exports com.example.todolistfx;
}