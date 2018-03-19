/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author M Ceessay
 */
@Entity
@Table(name = "dossierpatients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dossierpatients.findAll", query = "SELECT d FROM Dossierpatients d"),
    @NamedQuery(name = "Dossierpatients.findByIddossier", query = "SELECT d FROM Dossierpatients d WHERE d.iddossier = :iddossier"),
    @NamedQuery(name = "Dossierpatients.findByMatricul", query = "SELECT d FROM Dossierpatients d WHERE d.matricul = :matricul"),
    @NamedQuery(name = "Dossierpatients.findByDatecCeationS", query = "SELECT d FROM Dossierpatients d WHERE d.datecCeationS = :datecCeationS")})
public class Dossierpatients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddossier")
    private Integer iddossier;
    @Basic(optional = false)
    @Column(name = "matricul")
    private String matricul;
    @Basic(optional = false)
    @Column(name = "DatecCeationS")
    @Temporal(TemporalType.DATE)
    private Date datecCeationS;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dossier")
    private List<Antecedentpatient> antecedentpatientList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dossierper")
    private List<Dossierpatients> dossierpatientsList;
    @JoinColumn(name = "Dossierper", referencedColumnName = "iddossier")
    @ManyToOne(optional = false)
    private Dossierpatients dossierper;
    @JoinColumn(name = "idPatient", referencedColumnName = "idPatient")
    @ManyToOne(optional = false)
    private Patients idPatient;

    public Dossierpatients() {
    }

    public Dossierpatients(Integer iddossier) {
        this.iddossier = iddossier;
    }

    public Dossierpatients(Integer iddossier, String matricul, Date datecCeationS) {
        this.iddossier = iddossier;
        this.matricul = matricul;
        this.datecCeationS = datecCeationS;
    }

    public Integer getIddossier() {
        return iddossier;
    }

    public void setIddossier(Integer iddossier) {
        this.iddossier = iddossier;
    }

    public String getMatricul() {
        return matricul;
    }

    public void setMatricul(String matricul) {
        this.matricul = matricul;
    }

    public Date getDatecCeationS() {
        return datecCeationS;
    }

    public void setDatecCeationS(Date datecCeationS) {
        this.datecCeationS = datecCeationS;
    }

    @XmlTransient
    public List<Antecedentpatient> getAntecedentpatientList() {
        return antecedentpatientList;
    }

    public void setAntecedentpatientList(List<Antecedentpatient> antecedentpatientList) {
        this.antecedentpatientList = antecedentpatientList;
    }

    @XmlTransient
    public List<Dossierpatients> getDossierpatientsList() {
        return dossierpatientsList;
    }

    public void setDossierpatientsList(List<Dossierpatients> dossierpatientsList) {
        this.dossierpatientsList = dossierpatientsList;
    }

    public Dossierpatients getDossierper() {
        return dossierper;
    }

    public void setDossierper(Dossierpatients dossierper) {
        this.dossierper = dossierper;
    }

    public Patients getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Patients idPatient) {
        this.idPatient = idPatient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddossier != null ? iddossier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dossierpatients)) {
            return false;
        }
        Dossierpatients other = (Dossierpatients) object;
        if ((this.iddossier == null && other.iddossier != null) || (this.iddossier != null && !this.iddossier.equals(other.iddossier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Dossierpatients[ iddossier=" + iddossier + " ]";
    }
    
}
