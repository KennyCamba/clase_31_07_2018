/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peliculas;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class PanePelicula {
    
   private VBox contenedor;
   private Pelicula pelicula;
   private ImageView iv;
   
   public PanePelicula(Pelicula pelicula) {
       contenedor = new VBox();
       this.pelicula = pelicula;
       contenido();
   } 
   
    private void contenido() {
        Image image = new Image("recursos/" + pelicula.getImagePath(), 70, 100, true, true);
        iv = new ImageView(image);
        contenedor.getChildren().add(iv);
        contenedor.getChildren().addAll(new Label(pelicula.getNombre()), 
                new Label(pelicula.getYear() + ""));
        contenedor.setSpacing(5); 
    }
    
    public ImageView getImageView() {
        return iv;
    }
    
    public ImageView getImage() {
        Image image = new Image("recursos/" + pelicula.getImagePath(), 70, 100, true, true);
        return new ImageView(image);
    }
    
    public Pane getContendo() {
        return contenedor;
    }
}
