/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.ArrayList;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Genero;
import modelo.Pelicula;

/**
 *
 * @author Estudiante
 */
public class PaneOrganizer {
    private ComboBox<Genero> comboGeneros;
    private VBox root;
    private FlowPane fp;
    private HBox hbox;
    VBox v;
    
    public PaneOrganizer(){
        root = new VBox();
        comboGeneros = new ComboBox<>();
        topPane();
        centerPane();
        acciones();
    }
    
    private void topPane(){
        HBox v = new HBox();
        v.setPadding(new Insets(10, 10, 10, 10)); 
        ObservableList<Genero> lista = FXCollections.observableArrayList(Genero.cargarGeneros());
        comboGeneros.setItems(lista);
        v.getChildren().add( comboGeneros);
        root.getChildren().add(v);
        
    }
    
    private void centerPane() {
        hbox = new HBox();
        v = new VBox();
        hbox.setSpacing(40); 
        fp = new FlowPane();
        fp.setPadding(new Insets(0, 0, 0, 10));
        hbox.getChildren().add(fp);
        root.getChildren().add(hbox);
        fp.setHgap(10);
        fp.setVgap(10); 
        hbox.getChildren().add(v);
    }
    
    private void acciones() {
        comboGeneros.setOnAction(e -> {
                    fp.getChildren().clear();
                    v.getChildren().clear();
                    Genero g = comboGeneros.getSelectionModel().getSelectedItem();
                    ArrayList<Pelicula> peliculas = Pelicula.cargarPelicula(g);
                    for(Pelicula p : peliculas){ 
                        PaneImagenes pi = new PaneImagenes(p);
                        fp.getChildren().add(pi.getContenido());
                        
                        pi.getContenido().setOnMouseClicked(ev -> {
                            Pelicula pe = pi.getPelicula();
                            v.getChildren().clear();
                            v.setSpacing(5);
                            v.setAlignment(Pos.CENTER); 
                            v.getChildren().add(new ImageView(new Image("recursos/"+(pe.getImagePath().trim()))));
                            HBox h = new HBox();
                            h.setSpacing(3); 
                            h.setAlignment(Pos.CENTER); 
                            for(int i=0; i<pi.getPelicula().getRating(); i++){
                                h.getChildren().add(new ImageView(new Image("recursos/star.png", 30, 30, true, true)));
                            }
                            VBox vb = new VBox();
                            vb.setSpacing(3); 
                            vb.getChildren().addAll(new Label("Nombre: "+pe.getNombre()),new Label("Director: "+pe.getDirector()),
                                    new Label("Year: "+pe.getYear()));
                            v.getChildren().addAll(h, vb);
                        }); 
                    }
                    
                });     
    }
    
    public VBox getRoot(){
        return root;
    }

}
