module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires java.sql;
    requires sqlite.jdbc;
    requires java.sql.rowset;

    opens com.example to javafx.fxml;
    exports com.example;
}