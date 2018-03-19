package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Antecedentpatient;
import model.Dossierpatients;
import model.Patients;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-18T20:14:15")
@StaticMetamodel(Dossierpatients.class)
public class Dossierpatients_ { 

    public static volatile ListAttribute<Dossierpatients, Dossierpatients> dossierpatientsList;
    public static volatile SingularAttribute<Dossierpatients, Dossierpatients> dossierper;
    public static volatile SingularAttribute<Dossierpatients, String> matricul;
    public static volatile SingularAttribute<Dossierpatients, Patients> idPatient;
    public static volatile SingularAttribute<Dossierpatients, Integer> iddossier;
    public static volatile SingularAttribute<Dossierpatients, Date> datecCeationS;
    public static volatile ListAttribute<Dossierpatients, Antecedentpatient> antecedentpatientList;

}