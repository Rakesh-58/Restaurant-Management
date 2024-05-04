package com.restaurantmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.sql.*;

import static com.restaurantmanagement.Main.getConnection;
import static com.restaurantmanagement.Main.stage;

class itemIdException extends Exception{
    public itemIdException(String message){
        super(message);
    }
}

class itemNameException extends Exception{
    public itemNameException(String message){
        super(message);
    }
}

class categoryException extends Exception{
    public categoryException(String message)
    {
        super(message);
    }
}

class typeException extends Exception{
    public typeException(String message)
    {
        super(message);
    }
}

class imgException extends Exception{
    public imgException(String message)
    {
        super(message);
    }
}

public class ChangeMenu {

    public TextField t1=new TextField();
    public TextField t2=new TextField();
    public TextField t3=new TextField();
    public TextField t4=new TextField();
    public TextField t5=new TextField();
    public TextField t6=new TextField();


    public void goToChangeMenu(ActionEvent e){
        try {
            stage.close();
            AnchorPane root= FXMLLoader.load(getClass().getResource("change-menu.fxml"));
            Scene scene=new Scene(root,800,600);
            stage.setScene(scene);
            stage.show();

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void addItem(ActionEvent e)
    {
        try {
            stage.close();
            AnchorPane troot = FXMLLoader.load(getClass().getResource("add-item.fxml"));
            Scene scene = new Scene(troot, 800, 600);
            stage.setScene(scene);
            stage.setTitle("Add Item");
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    public void add(ActionEvent e)
    {
        try {
            Menu temp=new Menu();

            if(!(t1.getText().matches("\\d+")))
            {
                throw new itemIdException("Invalid input");
            }
            temp.itemId=Integer.parseInt(t1.getText());

            if(t2.getText().equals(""))
                throw new itemNameException("Enter a value");
            temp.itemName=t2.getText();

            if(t3.getText().equals(""))
                throw new categoryException("Enter a value");
            temp.category=t3.getText();

            if(!(t4.getText().equals("veg") || t4.getText().equals("nonveg")))
                throw new typeException("Enter only veg or nonveg");
            temp.type=t4.getText();

            temp.rate=Double.parseDouble(t5.getText());

            if(t6.getText().equals(""))
                throw new imgException("Enter a value");
            temp.img=t6.getText();

            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("insert into menu values(%d,'%s','%s','%s',%f,'%s')",temp.itemId,temp.itemName,temp.category, temp.type,temp.rate,temp.img) );
        }
        catch (itemIdException ex)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Please enter a correct value in Item Id");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            t1.clear();
            t1.requestFocus();
        }
        catch (itemNameException ex)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Please enter a correct value in Item Name");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            t2.clear();
            t2.requestFocus();
        }
        catch(categoryException ex)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Please enter a correct value in Category");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            t3.clear();
            t3.requestFocus();
        }
        catch (typeException ex)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Please enter a correct value in Type");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            t4.clear();
            t4.requestFocus();
        }
        catch (NumberFormatException ex)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Please enter a correct value in Rate");
            alert.setContentText("Enter a double");
            alert.showAndWait();
            t5.clear();
            t5.requestFocus();
        }
        catch (imgException ex)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Please enter a correct value in Img URL");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            t6.clear();
            t6.requestFocus();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public void removeItem(ActionEvent e)
    {
        try {
            stage.close();
            AnchorPane troot = FXMLLoader.load(getClass().getResource("remove-item.fxml"));
            Scene scene = new Scene(troot, 800, 600);
            stage.setScene(scene);
            stage.setTitle("Remove Item");
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void remove(ActionEvent e) {

        try {
            int t = Integer.parseInt(t1.getText());
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM MENU WHERE item_id=" + t);
            t1.clear();
        }
        catch (NumberFormatException ex)
        {

            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Invalid input in the Item Id");
            alert.setContentText("Please enter a Integer.");
            alert.showAndWait();
            t1.clear();
            t1.requestFocus();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public void viewMenu(ActionEvent e)
    {
        try {
            stage.close();
            TableView<Menu> MenuView=new TableView<>();
            TableColumn<Menu, String> idcol = new TableColumn<>("Item Id");
            TableColumn<Menu, String> namecol= new TableColumn<>("Item Name");
            TableColumn<Menu, String> catcol=new TableColumn<>("Category");
            TableColumn<Menu, String> typecol=new TableColumn<>("Type");
            TableColumn<Menu, String> ratecol=new TableColumn<>("Rate");
            TableColumn<Menu, String> imgcol=new TableColumn<>("Image URL");

            ObservableList<Menu> data = FXCollections.observableArrayList();

            idcol.setCellValueFactory(new PropertyValueFactory<>("itemId"));
            idcol.setPrefWidth(75);
            namecol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            namecol.setPrefWidth(200);
            catcol.setCellValueFactory(new PropertyValueFactory<>("category"));
            catcol.setPrefWidth(100);
            typecol.setCellValueFactory(new PropertyValueFactory<>("type"));
            typecol.setPrefWidth(75);
            ratecol.setCellValueFactory(new PropertyValueFactory<>("rate"));
            ratecol.setPrefWidth(75);
            imgcol.setCellValueFactory(new PropertyValueFactory<>("img"));
            imgcol.setPrefWidth(125);

            MenuView.getColumns().addAll(idcol,namecol,catcol,typecol,ratecol,imgcol);

            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet r = statement.executeQuery("SELECT * FROM menu");

            while (r.next()) {
                data.add(new Menu(r.getInt(1), r.getString(2),r.getString(3), r.getString(4),r.getDouble(5), r.getString(6)));
            }
            connection.close();

            MenuView.setItems(data);
            MenuView.setPrefWidth(650);
            MenuView.setPrefHeight(350);
            MenuView.setLayoutX(75);
            MenuView.setLayoutY(117);

            AnchorPane root3=FXMLLoader.load(getClass().getResource("menu-view.fxml"));
            root3.getChildren().add(MenuView);
            Scene scene = new Scene(root3,800,600);

            stage.setScene(scene);
            stage.setTitle("Menu");
            stage.show();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
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
