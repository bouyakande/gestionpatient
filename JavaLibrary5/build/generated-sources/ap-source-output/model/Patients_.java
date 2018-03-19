package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Dossierpatients;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-18T20:14:15")
@StaticMetamodel(Patients.class)
public class Patients_ { 

    public static volatile ListAttribute<Patients, Dossierpatients> dossierpatientsList;
    public static volatile SingularAttribute<Patients, Date> dateNaissance;
    public static volatile SingularAttribute<Patients, String> genre;
    public static volatile SingularAttribute<Patients, Integer> idPatient;
    public static volatile SingularAttribute<Patients, String> adresses;
    public static volatile SingularAttribute<Patients, String> telephone;
    public static volatile SingularAttribute<Patients, String> nom;
    public static volatile SingularAttribute<Patients, String> prenom;
    public static volatile SingularAttribute<Patients, String> lieunaissance;

}