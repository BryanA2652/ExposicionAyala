/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package exposicionayala;

import exposicionayala.models.constructorss;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;


/**
 *
 * @author ROCIO
 */
public class ExposicionAyala extends Application {
    
    private TableView<constructorss> tableView;
    private ComboBox<String> countryComboBox;
    
    private String driver = "com.mysql.jdbc.Driver";
    private String cadenaconeccion = "jdbc:mysql://localhost:3306/formula01";
    private String usuario = "root";
    private String contraseña = "";
    public Connection con;
    Statement st;
    ResultSet rs;
   
   public static void main(String[] args) {
       //ExposicionAyala con = new ExposicionAyala();
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        // Crear el ComboBox y agregar los países
        countryComboBox = new ComboBox<>();
        countryComboBox.getItems().addAll("Selecciona un país", "Japanese", "French", "British");
        countryComboBox.setValue("Selecciona un país");
        countryComboBox.setOnAction(e -> {
            String selectedCountry = countryComboBox.getValue();
            if (!"Selecciona un país".equals(selectedCountry)) {
                ExposicionAyala(selectedCountry);
            }
        });

        // Crear el TableView y configurar las columnas
        tableView = new TableView<>();
        TableColumn<constructorss, Integer> idColumn = new TableColumn<>("Constructor ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("constructorId"));

        TableColumn<constructorss, String> refColumn = new TableColumn<>("Constructor Ref");
        refColumn.setCellValueFactory(new PropertyValueFactory<>("constructorRef"));

        TableColumn<constructorss, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<constructorss, String> nationalityColumn = new TableColumn<>("Nationality");
        nationalityColumn.setCellValueFactory(new PropertyValueFactory<>("nationality"));

        TableColumn<constructorss, String> urlColumn = new TableColumn<>("URL");
        urlColumn.setCellValueFactory(new PropertyValueFactory<>("url"));

        tableView.getColumns().addAll(idColumn, refColumn, nameColumn, nationalityColumn, urlColumn);

        // Layout
        VBox vbox = new VBox(10, countryComboBox, tableView);
        vbox.setPadding(new Insets(10));
        
       
        Scene scene = new Scene(vbox, 800, 600);
        
        primaryStage.setTitle("Tabla constructor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void ExposicionAyala(String nationality){
        
       ObservableList<constructorss> data = FXCollections.observableArrayList();
       
     
           
        try{
             Class.forName(driver);
            con = DriverManager.getConnection(cadenaconeccion, usuario, contraseña);
            st = con.createStatement();
            String sql = "SELECT * FROM constructorss WHERE nationality = '" + nationality + "'";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                constructorss constructor = new constructorss(
                        rs.getInt("constructorId"),
                        rs.getString("constructorRef"),
                        rs.getString("name"),
                        rs.getString("nationality"),
                        rs.getString("url")
                );
                data.add(constructor);
            }
        JOptionPane.showMessageDialog(null, "Presentacion de datos");
        JOptionPane.showMessageDialog(null, "Se establecio conexion con la BD");
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se establecio conexion"+e.getMessage());
    }finally {
            // Cerrar recursos
            try {
                 if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            
      tableView.setItems(data);

    }

    
}
