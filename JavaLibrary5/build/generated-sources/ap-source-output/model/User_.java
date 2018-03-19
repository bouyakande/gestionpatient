package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Employe;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-18T20:14:15")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> iduser;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> profil;
    public static volatile SingularAttribute<User, Employe> idemp;
    public static volatile SingularAttribute<User, String> login;
    public static volatile SingularAttribute<User, String> statut;

}