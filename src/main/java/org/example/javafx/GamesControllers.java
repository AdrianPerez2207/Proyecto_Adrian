package org.example.javafx;

import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.models.Juego;
import org.example.repositories.JuegoRepositorio;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GamesControllers implements Initializable {

    @FXML
    private TableView<Juego> gamesTable;

    @FXML
    public TableColumn<Juego, String> gameName;

    @FXML
    public TableColumn<Juego, String> gameCategory;

    @FXML
    public TableColumn<Juego, Integer> gamePegi;

    @FXML
    public TableColumn<Juego, String> gamePlatform;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gameName.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        gameCategory.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        gamePegi.setCellValueFactory(new PropertyValueFactory<>("pegi"));
        gamePlatform.setCellValueFactory(new PropertyValueFactory<>("plataforma"));

        //Inicializamos el repositorio y recuperamos todos los juegos de la base de datos.
        JuegoRepositorio jr = new JuegoRepositorio();
        List<Juego> juegos = jr.findAll();

        //Añadimos los juegos a la tabla
        gamesTable.getItems().addAll(FXCollections.observableArrayList(juegos));
    }
}