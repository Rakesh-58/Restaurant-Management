module com.restaurantmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.restaurantmanagement to javafx.fxml;
    exports com.restaurantmanagement;
}