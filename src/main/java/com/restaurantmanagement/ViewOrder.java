package com.restaurantmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import java.sql.*;

import static com.restaurantmanagement.Main.stage;

public class ViewOrder {

    ObservableList<Order> view= FXCollections.observableArrayList();

    @FXML
    public TableView<Order> OrderView;

    public TableColumn<Order,String> ordercol;
    public TableColumn<Order,String> tablecol;
    public TableColumn<Order,String> namecol;
    public TableColumn<Order,String> quantitycol;
    public TableColumn<Order,String> cancelcol;
    public TableColumn<Order,Void> precol;

    public void refreshTable()
    {
        try {
            view.clear();

            Connection c=Main.getConnection();
            Statement s=c.createStatement();
            ResultSet resultSet=s.executeQuery("select * from restaurant.order where is_prepared=0");

            while (resultSet.next()){
                view.add(new Order(
                        resultSet.getInt(1),
                        resultSet.getInt(6),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getInt(8)));
                OrderView.setItems(view);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void loadDate(ActionEvent e) {
        try {


            refreshTable();

            ordercol.setCellValueFactory(new PropertyValueFactory<>("orderNo"));
            tablecol.setCellValueFactory(new PropertyValueFactory<>("tableNo"));
            namecol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            quantitycol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            cancelcol.setCellValueFactory(new PropertyValueFactory<>("isCancel"));


            addButtonToTable();
            OrderView.setItems(view);
        }
        catch (Exception ep)
        {
            System.out.println(ep.getMessage());
        }
    }

    private void addButtonToTable() throws SQLException {
        Connection c = Main.getConnection();
        Statement s=c.createStatement();
        Callback<TableColumn<Order, Void>, TableCell<Order, Void>> cellFactory = new Callback<TableColumn<Order, Void>, TableCell<Order, Void>>() {
            @Override
            public TableCell<Order, Void> call(final TableColumn<Order, Void> param) {
                final TableCell<Order, Void> cell = new TableCell<Order, Void>() {

                    private final Button btn = new Button("Prepared");
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Order data = getTableView().getItems().get(getIndex());
                            try {
                                s.executeUpdate("update restaurant.order set is_prepared=1 where order_no=" + data.getOrderNo());
                            }
                            catch (Exception exe)
                            {
                                System.out.println(exe.getMessage());
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        precol.setCellFactory(cellFactory);

    }
    public void goBackToMain()
    {
        try {

            AnchorPane root1 = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(root1, 800, 600);
            stage.setTitle("BR Cafe");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
