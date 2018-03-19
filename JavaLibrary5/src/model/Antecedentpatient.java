/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author M Ceessay
 */
@Entity
@Table(name = "antecedentpatient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antecedentpatient.findAll", query = "SELECT a FROM Antecedentpatient a"),
    @NamedQuery(name = "Antecedentpatient.findByIdA", query = "SELECT a FROM Antecedentpatient a WHERE a.idA = :idA")})
public class Antecedentpatient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idA")
    private Integer idA;
    @Basic(optional = false)
    @Lob
    @Column(name = "AntecedentMedicaux")
    private String antecedentMedicaux;
    @Basic(optional = false)
    @Lob
    @Column(name = "AntecedentChirurgicaux")
    private String antecedentChirurgicaux;
    @Basic(optional = false)
    @Lob
    @Column(name = "AntecedentFamiliaux")
    private String antecedentFamiliaux;
    @Basic(optional = false)
    @Lob
    @Column(name = "AlergiesIntol\u00e9rance")
    private String alergiesIntolérance;
    @JoinColumn(name = "Dossier", referencedColumnName = "iddossier")
    @ManyToOne(optional = false)
    private Dossierpatients dossier;

    public Antecedentpatient() {
    }

    public Antecedentpatient(Integer idA) {
        this.idA = idA;
    }

    public Antecedentpatient(Integer idA, String antecedentMedicaux, String antecedentChirurgicaux, String antecedentFamiliaux, String alergiesIntolérance) {
        this.idA = idA;
        this.antecedentMedicaux = antecedentMedicaux;
        this.antecedentChirurgicaux = antecedentChirurgicaux;
        this.antecedentFamiliaux = antecedentFamiliaux;
        this.alergiesIntolérance = alergiesIntolérance;
    }

    public Integer getIdA() {
        return idA;
    }

    public void setIdA(Integer idA) {
        this.idA = idA;
    }

    public String getAntecedentMedicaux() {
        return antecedentMedicaux;
    }

    public void setAntecedentMedicaux(String antecedentMedicaux) {
        this.antecedentMedicaux = antecedentMedicaux;
    }

    public String getAntecedentChirurgicaux() {
        return antecedentChirurgicaux;
    }

    public void setAntecedentChirurgicaux(String antecedentChirurgicaux) {
        this.antecedentChirurgicaux = antecedentChirurgicaux;
    }

    public String getAntecedentFamiliaux() {
        return antecedentFamiliaux;
    }

    public void setAntecedentFamiliaux(String antecedentFamiliaux) {
        this.antecedentFamiliaux = antecedentFamiliaux;
    }

    public String getAlergiesIntolérance() {
        return alergiesIntolérance;
    }

    public void setAlergiesIntolérance(String alergiesIntolérance) {
        this.alergiesIntolérance = alergiesIntolérance;
    }

    public Dossierpatients getDossier() {
        return dossier;
    }

    public void setDossier(Dossierpatients dossier) {
        this.dossier = dossier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idA != null ? idA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antecedentpatient)) {
            return false;
        }
        Antecedentpatient other = (Antecedentpatient) object;
        if ((this.idA == null && other.idA != null) || (this.idA != null && !this.idA.equals(other.idA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Antecedentpatient[ idA=" + idA + " ]";
    }
    
}
