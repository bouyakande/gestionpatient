/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.*;
import interfaces.IGlobalInterfaces;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.User;
import serviceControl.LoadView;
import serviceControl.RemoteObjects;

/**
 * FXML Controller class
 *
 * @author danml
 */
public class LoginController implements Initializable {

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXTextField logtxt;

    @FXML
    private JFXPasswordField pwdtxt;

    @FXML
    private ImageView imgLogin;

    @FXML
    private Label lab;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Animate imageview
        ScaleTransition transition = new ScaleTransition(Duration.seconds(4), imgLogin);
        transition.setToX(2);
        transition.setToY(2);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true);
        transition.play();
        lab.setVisible(false);

    }

    @FXML
    private void doLogin(ActionEvent event) {
        try {
            IGlobalInterfaces connect = RemoteObjects.getGlobalRemote();
            List<User> lp = connect.oblistUser();
            for (User u : lp) {
                if (u.getLogin().equals(logtxt.getText()) && u.getPassword().equals(pwdtxt.getText())) {
                    System.out.println(u.getStatut());
                    if (u.getStatut().compareTo("debloquer")!=0) {
                        lab.setVisible(true);
                        lab.setText("Votre compte est Bloque avise l administrateur");
                        LoadView.showView("Connexion", "Login.fxml", 1);
                        alert.setContentText("compte bloque!!!!");
                        alert.showAndWait();
                    } else {
                        
                        if (u.getProfil().equals("infirmier")) {
                            LoadView.showView("Menu Infirmier", "MenuInfirmier.fxml", 1);
                        } else if (u.getProfil().equals("medecin")) {
                            LoadView.showView("Menu Medecin", "FDocumentsPatient.fxml", 1);
                        } else if (u.getProfil().equals("secretaire")) {

                        }else if (u.getProfil().equals("admin")) {
                            LoadView.showView("Menu Employe", "FEmploye.fxml", 1);
                        }
                        

                    }
                }else {

                lab.setVisible(true);
                lab.setText("login ou mot de passe incorrecte");
                LoadView.showView("Connexion", "Login.fxml", 1);

//                alert.setContentText("objet null");
//                alert.showAndWait();
            }

            }
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    private void codeConnexion() {
        try {
            IGlobalInterfaces connect = RemoteObjects.getGlobalRemote();
            User u = connect.connexion(logtxt.getText(), pwdtxt.getText());
            if (u == null) {

                lab.setVisible(true);
                lab.setText("login ou mot de passe incorrecte");
                LoadView.showView("Connexion", "Login.fxml", 1);

                alert.setContentText("objet null");
                alert.showAndWait();
            } else if (u.getStatut().equals("debloquer")) {
                if (u.getProfil().equals("infirmier")) {
                    LoadView.showView("Menu Infirmier", "MenuInfirmier.fxml", 1);
                } else if (u.getProfil().equals("medecin")) {
                    LoadView.showView("Menu Medecin", "FDocumentsPatient.fxml", 1);
                } else if (u.getProfil().equals("secretaire")) {

                }
            } else {
                lab.setVisible(true);
                lab.setText("Votre compte est Bloque avise l administrateur");
                LoadView.showView("Connexion", "Login.fxml", 1);
                alert.setContentText("compte bloque!!!!");
                alert.showAndWait();

            }

        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
