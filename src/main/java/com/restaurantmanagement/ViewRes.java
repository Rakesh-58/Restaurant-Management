package com.restaurantmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.*;

import static com.restaurantmanagement.Main.stage;


public class ViewRes {
    ObservableList<Reservation> view= FXCollections.observableArrayList();

    @FXML
    public TableView<Reservation> tableView;

    public TableColumn<Reservation,String> namecol;
    public TableColumn<Reservation,String> phonecol;
    public TableColumn<Reservation,String> timecol;

    public void refreshTable()
    {
        try {
            view.clear();

            Connection c=Main.getConnection();
            Statement s=c.createStatement();
            ResultSet resultSet=s.executeQuery("select * from table_reservation");

            while (resultSet.next()){
                view.add(new Reservation(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
                tableView.setItems(view);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void loadDate() {
        try {


            refreshTable();

            namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
            phonecol.setCellValueFactory(new PropertyValueFactory<>("phone"));
            timecol.setCellValueFactory(new PropertyValueFactory<>("time"));

            tableView.setItems(view);
        }
        catch (Exception ep)
        {
            System.out.println(ep.getMessage());
        }
    }

    public void clearRes()
    {
        try {
            Connection c=Main.getConnection();
            Statement s=c.createStatement();
            s.executeUpdate("delete from table_reservation");
            s.executeUpdate("update tablelist set free_tables=3");

            refreshTable();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void goBackToMain()
    {
        try {

            AnchorPane root1 = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(root1, 800, 600);
            stage.setTitle("BR Restaurant");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
