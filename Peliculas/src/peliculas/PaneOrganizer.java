/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peliculas;

import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class PaneOrganizer {
    private VBox root;
    private HBox hbox;
    private FlowPane flow;
    private ComboBox<Genero> generos;
    private VBox v;
    private Button btn;
    
    public PaneOrganizer() {
        root = new VBox();
        flow = new FlowPane();
        generos = new ComboBox<>();
        v = new VBox();
        hbox = new HBox(flow, v);
        v.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
        btn = new Button("Salir");
        //Mensaje de alerta javafx
        btn.setOnAction(e -> {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("¿En realidad dese salir?");
            Optional<ButtonType> bt = alert.showAndWait();
            if(bt.get() == ButtonType.OK) {
                Platform.exit();
            }else {
                alert.close();
            }
            
        }); 
        root.getChildren().add(btn);
        
        hbox.setSpacing(20); 
        flow.setPadding(new Insets(0, 0, 0, 10));
        flow.setVgap(10);
        flow.setHgap(10); 
        topPane();
        centerPane();
    }
    
    private void topPane() {
        //ObservableList<Genero> lista = FXCollections.observableArrayList(Genero.cargarGeneros()); 
        //generos.setItems(lista);
        generos.getItems().addAll(Genero.cargarGeneros());
        root.getChildren().add(generos);
    }
    
    private void centerPane() {
        root.getChildren().add(hbox);
        
        generos.setOnAction(e -> {
            //Genero g = generos.getValue();
            flow.getChildren().clear();
            v.getChildren().clear();
            Genero g = generos.getSelectionModel().getSelectedItem();
            ArrayList<Pelicula> peliculas = Pelicula.cargarPelicula(g);
            for(Pelicula p: peliculas) {
                PanePelicula pp = new PanePelicula(p);
                flow.getChildren().add(pp.getContendo());
                pp.getContendo().setOnMouseClicked(ev -> {
                    v.getChildren().clear();
                    v.setAlignment(Pos.CENTER); 
                    v.getChildren().add(pp.getImage());
                    v.setSpacing(5);
                    v.getChildren().addAll(new Label(p.getNombre()));
                });     
            }
        }); 
    }
    
    public Pane getRoot() {
        return root;
    }
}
