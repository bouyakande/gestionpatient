package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import interfaces.IGlobalInterfaces;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import static service.MySingleton.*;
import model.Employe;
import model.User;
import serviceControl.ContolleCode;

import serviceControl.RemoteObjects;

/**
 * FXML Controller class
 *
 * @author Bouya
 * @since 26/02/2018
 * @version 1.0
 */
public class FEmployeController implements Initializable {

    @FXML
    private StackPane rootPane;

    @FXML
    private ImageView imgBack;

    @FXML
    private ImageView imgBus;

    @FXML
    private JFXTextField txtnom;

    @FXML
    private JFXTextField txtprenom;

    @FXML
    private JFXTextField txtfonction;

    @FXML
    private JFXTextField txttel;

    @FXML
    private JFXTextField txtemail;

    @FXML
    private JFXTextField txtadr;

    @FXML
    private JFXComboBox<String> comboprofil;

    @FXML
    private JFXButton btnEdit;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXTextField txtmatEmplouyer;

    @FXML
    private JFXButton bntsearch;

    @FXML
    private TableView<Employe> tableMovements;

    @FXML
    private TableColumn<Employe, Integer> colId;

    @FXML
    private TableColumn<Employe, String> colnom;

    @FXML
    private TableColumn<Employe, String> colprenom;

    @FXML
    private TableColumn<Employe, String> colfonction;

    @FXML
    private TableColumn<Employe, String> coltelephone;

    @FXML
    private TableColumn<Employe, String> colemail;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private ObservableList<Employe> oblist;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {

            //Anmate bus movement
            animateBus();
            //POpulate booking comboboxes
            populateCombooxes();

            IGlobalInterfaces connect = RemoteObjects.getGlobalRemote();
            List<Employe> l = connect.listeEmploye();

            chargerTable(l);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    void goBack(MouseEvent event) {

    }

    /**
     *
     * @param event
     * @throws RemoteException void saveemploye permet d ajouter un employe
     */
    @FXML
    void saveemploye(ActionEvent event) throws RemoteException {
        boolean r = valeurSaisit();
        if (r == true) {
            alert.setContentText("Veuillez renseigner touts les champs svp !!!!");
            alert.showAndWait();
        } else {
            IGlobalInterfaces connect = RemoteObjects.getGlobalRemote();
            Employe em = getInstanceEmploye();
            em.setAdresse(txtadr.getText());
            em.setEmail(txtemail.getText());
            em.setFonction(txtfonction.getText());
            int i = 0;
            for (Employe employe : connect.listeEmploye()) {
                i = employe.getIdemp() + 1;

            }
            String sg = txtfonction.getText().substring(0, 3);
            em.setMatricule(sg + "" + i);
            em.setNom(txtnom.getText());
            em.setPrenom(txtprenom.getText());
            em.setTelephone(txttel.getText());
            int a = connect.addEmploye(em);
            if (a != 0) {
                int j = 0;

                for (Employe employe : connect.listeEmploye()) {
                    j = employe.getIdemp();
                }
                User u = getInstanceUser();
                u.setPassword(em.getEmail());
                u.setLogin(em.getPrenom());
                Employe ep = getInstanceEmploye();
                ep.setIdemp(j);
                u.setIdemp(ep);
                u.setProfil(comboprofil.getValue());
                u.setStatut("debloquer");
                int v = connect.addUser(u);
                if (v != 0) {
                    clearFields();
                    alert.setContentText("employe ajouté !!!!");
                    alert.showAndWait();
                } else {
                    alert.setContentText("erreur d'ajout !!!!");
                    alert.showAndWait();
                }

            } else {
                alert.setContentText("Echec employe non ajouté");
                alert.showAndWait();
            }

        }
    }

    /**
     *
     * @param event void searchEmploye cette fonction permet la recherche d un
     * employe
     */
    @FXML
    void searchEmploye(ActionEvent event) {
        try {
            IGlobalInterfaces connect = RemoteObjects.getGlobalRemote();
            List< Employe> lu = new ArrayList<>();

            Employe le = connect.searchEmploye(txtmatEmplouyer.getText());

            lu.add(le);
            oblist = FXCollections.observableArrayList(lu);
            tableMovements.setItems(oblist);

        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @return un boolean boolean valeurSaisit() pour verifier que l utilisateur
     * a bien renseigner touts les champsS
     */
    private boolean valeurSaisit() {
        if (txtnom.getText().equals("") || txtprenom.getText().equals("") || txtemail.getText().equals("") || txttel.getText().equals("") || txtfonction.getText().equals("") || txtadr.getText().equals("")) {
            return true;

        } else {
            return false;
        }

    }

    /**
     * void animatedBus() une fonction qui permet l animation de notre objet
     */
    private void animateBus() {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        KeyValue kv = new KeyValue(imgBus.xProperty(), 700);
        KeyFrame kf = new KeyFrame(Duration.seconds(10), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    @FXML
    private void editDriver(ActionEvent event) {
        JFXSnackbar fXSnackbar = new JFXSnackbar(rootPane);
        fXSnackbar.show("This functionality will not be implemented here. I am tired", 5000);
    }

    /**
     * void clearFields() permet de d effacer le contenu des champs
     */
    private void clearFields() {
        txtnom.setText("");
        txtprenom.setText("");
        txtemail.setText("");
        txttel.setText("");
        txtfonction.setText("");
        txtadr.setText("");

        comboprofil.setValue("");

    }

    @FXML
    private void resetFields(ActionEvent event) {
        clearFields();
    }

    /**
     * void populateCombooxes() cette fonction permet le chargement des donnees
     * dans un combobox
     */
    private void populateCombooxes() {

        comboprofil.getItems().addAll("medecin", "infirmier", "generaliste", "secretere");

    }

    /**
     *
     * @param lu
     * @throws RemoteException void chargerTable permet de charger les donnees
     * de la base de donnee sur un table view
     */

    public void chargerTable(List<Employe> lu) throws RemoteException {
        try {

            oblist = FXCollections.observableArrayList(lu);
            tableMovements.setItems(oblist);

            colId.setCellValueFactory(new PropertyValueFactory<>("idemp"));
            colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colfonction.setCellValueFactory(new PropertyValueFactory<>("fonction"));

            colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            coltelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));

            tableMovements.getSelectionModel().setCellSelectionEnabled(true);
            tableMovements.setEditable(true);
            handleEdit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * void handlEdit pour effectuer la modification a partir du tableview
     */
    public void handleEdit() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        IGlobalInterfaces connect = RemoteObjects.getGlobalRemote();
        colemail.setCellFactory(TextFieldTableCell.forTableColumn());
        colemail.setOnEditCommit(event -> {
            Employe emp = event.getRowValue();

            int ctr = ContolleCode.controlString(event.getNewValue());
            if (ctr == 0) {
                emp.setEmail(event.getNewValue());
                try {
                    int r = connect.udpdateEmployer(emp);
                    if (r != 0) {
                        alert.setContentText("Modifié!!!!!");
                        alert.showAndWait();
                    } else {
                        alert.setContentText("non modifié!!!!!");
                        alert.showAndWait();
                    }
                    //chargerTableProfil(connect.listProfil());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                alert.setContentText("Caractères spéciaux non Autorisé!!!!!");
                alert.showAndWait();
            }

        }
        );
        colfonction.setCellFactory(TextFieldTableCell.forTableColumn());
        colfonction.setOnEditCommit(event -> {
            Employe emp = event.getRowValue();

            int ctr = ContolleCode.controlString(event.getNewValue());
            if (ctr == 0) {
                emp.setFonction(event.getNewValue());
                try {
                    int r = connect.udpdateEmployer(emp);
                    if (r != 0) {
                        alert.setContentText("Modifié!!!!!");
                        alert.showAndWait();
                    } else {
                        alert.setContentText("non modifié!!!!!");
                        alert.showAndWait();
                    }
                    //chargerTableProfil(connect.listProfil());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                alert.setContentText("Caractères spéciaux non Autorisé!!!!!");
                alert.showAndWait();
            }

        }
        );
        colprenom.setCellFactory(TextFieldTableCell.forTableColumn());
        colprenom.setOnEditCommit(event -> {
            Employe emp = event.getRowValue();

            int ctr = ContolleCode.controlString(event.getNewValue());
            if (ctr == 0) {
                emp.setPrenom(event.getNewValue());
                try {
                    int r = connect.udpdateEmployer(emp);
                    if (r != 0) {
                        alert.setContentText("Modifié!!!!!");
                        alert.showAndWait();
                    } else {
                        alert.setContentText("non modifié!!!!!");
                        alert.showAndWait();
                    }
                    //chargerTableProfil(connect.listProfil());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                alert.setContentText("Caractères spéciaux non Autorisé!!!!!");
                alert.showAndWait();
            }

        }
        );
        colnom.setCellFactory(TextFieldTableCell.forTableColumn());
        colnom.setOnEditCommit(event -> {
            Employe emp = event.getRowValue();

            int ctr = ContolleCode.controlString(event.getNewValue());
            if (ctr == 0) {
                emp.setNom(event.getNewValue());
                try {
                    int r = connect.udpdateEmployer(emp);
                    if (r != 0) {
                        alert.setContentText("Modifié!!!!!");
                        alert.showAndWait();
                    } else {
                        alert.setContentText("non modifié!!!!!");
                        alert.showAndWait();
                    }
                    //chargerTableProfil(connect.listProfil());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                alert.setContentText("Caractères spéciaux non Autorisé!!!!!");
                alert.showAndWait();
            }

        }
        );
        coltelephone.setCellFactory(TextFieldTableCell.forTableColumn());
        coltelephone.setOnEditCommit(event -> {
            Employe emp = event.getRowValue();

            int ctr = ContolleCode.controlString(event.getNewValue());
            if (ctr == 0) {
                emp.setTelephone(event.getNewValue());
                try {
                    int r = connect.udpdateEmployer(emp);
                    if (r != 0) {
                        alert.setContentText("Modifié!!!!!");
                        alert.showAndWait();
                    } else {
                        alert.setContentText("non modifié!!!!!");
                        alert.showAndWait();
                    }
                    //chargerTableProfil(connect.listProfil());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                alert.setContentText("Caractères spéciaux non Autorisé!!!!!");
                alert.showAndWait();
            }

        }
        );

    }

    /**
     *
     * @param event void debloquer cette fonction permet de bloquer un
     * utlisateur
     */
    @FXML
    void bloquer(ActionEvent event) {
        try {
            IGlobalInterfaces connect = RemoteObjects.getGlobalRemote();
            int a = connect.blocUser(txtmatEmplouyer.getText());
            if (a != 0) {
                alert.setContentText("utilisateur bloquer !!!!");
                alert.showAndWait();
            } else {
                alert.setContentText("utilisateur non bloquer !!!!");
                alert.showAndWait();
            }
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

    }

    /**
     *
     * @param event void debloquer cette fonction permet de debloquer un
     * utlisateur
     */
    @FXML
    void debloquer(ActionEvent event) {
        try {
            IGlobalInterfaces connect = RemoteObjects.getGlobalRemote();
            int a = connect.deblocUser(txtmatEmplouyer.getText());
            if (a != 0) {
                alert.setContentText("utilisateur bloquer !!!!");
                alert.showAndWait();
            } else {
                alert.setContentText("utilisateur non bloquer !!!!");
                alert.showAndWait();
            }
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

}
