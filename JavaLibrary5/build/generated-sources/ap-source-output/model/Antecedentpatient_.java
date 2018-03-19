package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Dossierpatients;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-18T20:14:15")
@StaticMetamodel(Antecedentpatient.class)
public class Antecedentpatient_ { 

    public static volatile SingularAttribute<Antecedentpatient, String> alergiesIntolérance;
    public static volatile SingularAttribute<Antecedentpatient, Integer> idA;
    public static volatile SingularAttribute<Antecedentpatient, String> antecedentChirurgicaux;
    public static volatile SingularAttribute<Antecedentpatient, String> antecedentFamiliaux;
    public static volatile SingularAttribute<Antecedentpatient, Dossierpatients> dossier;
    public static volatile SingularAttribute<Antecedentpatient, String> antecedentMedicaux;

}