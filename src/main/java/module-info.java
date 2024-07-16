module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires java.sql;
    requires sqlite.jdbc;
    requires java.sql.rowset;
    requires java.base;

    opens com.example to javafx.fxml;

    exports com.example;

    opens com.example.javafx to javafx.fxml;

    exports com.example.javafx;
}
