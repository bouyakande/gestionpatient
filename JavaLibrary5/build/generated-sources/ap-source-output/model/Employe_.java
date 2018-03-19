package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-18T20:14:15")
@StaticMetamodel(Employe.class)
public class Employe_ { 

    public static volatile ListAttribute<Employe, User> userList;
    public static volatile SingularAttribute<Employe, String> matricule;
    public static volatile SingularAttribute<Employe, String> fonction;
    public static volatile SingularAttribute<Employe, String> adresse;
    public static volatile SingularAttribute<Employe, String> telephone;
    public static volatile SingularAttribute<Employe, Integer> idemp;
    public static volatile SingularAttribute<Employe, String> nom;
    public static volatile SingularAttribute<Employe, String> prenom;
    public static volatile SingularAttribute<Employe, String> email;

}