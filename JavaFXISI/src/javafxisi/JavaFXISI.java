/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxisi;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import serviceControl.LoadView;
import serviceControl.RemoteObjects;

/**
 *
 * @author Bouya
 */
public class JavaFXISI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       LoadView.showView("Connexion", "Login.fxml", 1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RemoteObjects.init();
        launch(args);

    }
    
}
