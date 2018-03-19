/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Employe;
import model.User;

/**
 *
 * @author Bouya
 */
public class MySingleton {

    //------ création d'un singleton pour ma table employe
    public static Employe singleEmp = new Employe();
    public static Employe getInstanceEmploye() {
        return singleEmp;
    }

    //------ création d'un singleton pour ma table user
    public static User singleUser = new User();
    public static User getInstanceUser() {
        return singleUser;
    }

}
