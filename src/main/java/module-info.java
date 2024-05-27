module gest {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires java.sql;
    requires sqlite.jdbc;
    requires java.sql.rowset;

    opens gest to javafx.fxml;
    exports gest;    
}
