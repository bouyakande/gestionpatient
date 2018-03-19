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
public class FPatientController implements Initializable {
    
      @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXTextField txtnom;

    @FXML
    private JFXTextField txtprenom;

    @FXML
    private JFXTextField txttel;

    @FXML
    private JFXRadioButton checkMasculin;

    @FXML
    private JFXRadioButton checkfeminin;

    @FXML
    private JFXDatePicker dateNaiss;

    @FXML
    private JFXTextField txtlieuniass;

    @FXML
    private JFXTextField txtadresse;

    @FXML
    void AddPatient(ActionEvent event) {

    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
