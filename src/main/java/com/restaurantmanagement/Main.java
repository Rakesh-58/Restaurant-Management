package com.restaurantmanagement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.*;

public class Main extends Application {

    static Stage stage;
    static AnchorPane root1,root2;


    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "root");
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            stage=new Stage();
            root1 = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(root1, 800, 600);
            stage.setTitle("BR Cafe");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        launch();
    }

    public void tableReservation(ActionEvent e)
    {
        try {
            stage.close();
            root2 = FXMLLoader.load(getClass().getResource("res.fxml"));
            Scene scene=new Scene(root2,800,600);
            stage.setScene(scene);
            stage.setTitle("View Reservations");
            stage.show();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void viewOrder(ActionEvent e)
    {
        try {
            stage.close();
            root2 = FXMLLoader.load(getClass().getResource("view-order.fxml"));
            Scene scene=new Scene(root2,800,600);
            stage.setScene(scene);
            stage.setTitle("View Orders");
            stage.show();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void changeMenu(ActionEvent e) {
        try {
            stage.close();
            root2 = FXMLLoader.load(getClass().getResource("change-menu.fxml"));
            Scene scene = new Scene(root2, 800, 600);
            stage.setScene(scene);
            stage.setTitle("Change Menu");
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }



}
