module gest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens gest to javafx.fxml;
    exports gest;
}
