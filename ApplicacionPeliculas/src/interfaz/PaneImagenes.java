/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Pelicula;

/**
 *
 * @author Estudiante
 */
public class PaneImagenes {
    
    private VBox contenedor;
    private String imagePatch;
    private final String PATCH = "recursos/";
    private ImageView peliculaImg;
    Pelicula pelicula;
    Label nombre;
    Label anio;
    
    public PaneImagenes(Pelicula pelicula){
        this.pelicula = pelicula;
        this.imagePatch = PATCH+pelicula.getImagePath();
        contenedor = new VBox();
        contenedor.setSpacing(5);
        contenedor.setAlignment(Pos.CENTER); 
        contenido();
    }
    
    private void contenido(){
        peliculaImg = new ImageView(new Image("recursos/"+(pelicula.getImagePath().trim())));
        nombre = new Label(pelicula.getNombre());
        anio = new Label(String.valueOf(pelicula.getYear()));
        contenedor.getChildren().addAll(peliculaImg, nombre, anio);
    }
    
    public VBox getContenido(){
        return contenedor;
    }
    
    public Pelicula getPelicula(){
        return pelicula;
    }
    
    public ImageView getImage(){
        return peliculaImg;
    }
    
//    public VBox getInfo(){
//        contenedor.getChildren().removeAll(anio, nombre);
//        
//        contenedor.getChildren().addAll(h, new Label("Nombre: "+pelicula.getNombre()),
//                                            new Label("Director: "+pelicula.getDirector()),
//                                            new Label("Year: "+pelicula.getYear()));
//        return contenedor;
//    }
}
