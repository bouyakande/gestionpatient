package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-18T20:14:15")
@StaticMetamodel(Consultation.class)
public class Consultation_ { 

    public static volatile SingularAttribute<Consultation, Date> date;
    public static volatile SingularAttribute<Consultation, String> motifConsultation;
    public static volatile SingularAttribute<Consultation, String> taille;
    public static volatile SingularAttribute<Consultation, String> pouls;
    public static volatile SingularAttribute<Consultation, String> observation;
    public static volatile SingularAttribute<Consultation, String> poids;
    public static volatile SingularAttribute<Consultation, String> temperature;
    public static volatile SingularAttribute<Consultation, Integer> dossier;
    public static volatile SingularAttribute<Consultation, Integer> idconsul;

}