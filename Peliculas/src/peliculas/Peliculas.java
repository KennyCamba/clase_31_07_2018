/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peliculas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Municipio de Gye
 */
public class Peliculas extends Application {
    
    @Override
    public void start(Stage stage) {
        PaneOrganizer pane = new PaneOrganizer();
        stage.setScene(new Scene(pane.getRoot(), 600, 600));
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
