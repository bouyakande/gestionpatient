/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Bouya
 */
public class FConsultationController implements Initializable {
    
   @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXTextField txtmotif;

    @FXML
    private JFXTextField txttaille;

    @FXML
    private JFXTextField txtpoids;

    @FXML
    private JFXTextField txttemperature;

    @FXML
    private JFXTextField txtpouls;

    @FXML
    private JFXTextField txtobservation;

    @FXML
    private JFXTextField txtantecedentMedico;

    @FXML
    private JFXTextField txtantecedentChirurgicaux;

    @FXML
    private JFXTextField txtantecedentFamiliaux;

    @FXML
    private JFXTextField txtAllergies;

   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
     @FXML
    void AddConsultation(ActionEvent event) {

    }
    
}
