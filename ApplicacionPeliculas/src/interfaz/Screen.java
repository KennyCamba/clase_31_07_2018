/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Estudiante
 */
public class Screen extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        PaneOrganizer p = new PaneOrganizer();
        Scene scene = new Scene(p.getRoot(), 600, 600);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
