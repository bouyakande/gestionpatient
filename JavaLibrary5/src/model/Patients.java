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
@Table(name = "patients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patients.findAll", query = "SELECT p FROM Patients p"),
    @NamedQuery(name = "Patients.findByNom", query = "SELECT p FROM Patients p WHERE p.nom = :nom"),
    @NamedQuery(name = "Patients.findByPrenom", query = "SELECT p FROM Patients p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Patients.findByAdresses", query = "SELECT p FROM Patients p WHERE p.adresses = :adresses"),
    @NamedQuery(name = "Patients.findByLieunaissance", query = "SELECT p FROM Patients p WHERE p.lieunaissance = :lieunaissance"),
    @NamedQuery(name = "Patients.findByTelephone", query = "SELECT p FROM Patients p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "Patients.findByGenre", query = "SELECT p FROM Patients p WHERE p.genre = :genre"),
    @NamedQuery(name = "Patients.findByDateNaissance", query = "SELECT p FROM Patients p WHERE p.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Patients.findByIdPatient", query = "SELECT p FROM Patients p WHERE p.idPatient = :idPatient")})
public class Patients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "adresses")
    private String adresses;
    @Basic(optional = false)
    @Column(name = "lieunaissance")
    private String lieunaissance;
    @Basic(optional = false)
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @Column(name = "genre")
    private String genre;
    @Basic(optional = false)
    @Column(name = "dateNaissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPatient")
    private Integer idPatient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPatient")
    private List<Dossierpatients> dossierpatientsList;

    public Patients() {
    }

    public Patients(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Patients(Integer idPatient, String nom, String prenom, String adresses, String lieunaissance, String telephone, String genre, Date dateNaissance) {
        this.idPatient = idPatient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresses = adresses;
        this.lieunaissance = lieunaissance;
        this.telephone = telephone;
        this.genre = genre;
        this.dateNaissance = dateNaissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresses() {
        return adresses;
    }

    public void setAdresses(String adresses) {
        this.adresses = adresses;
    }

    public String getLieunaissance() {
        return lieunaissance;
    }

    public void setLieunaissance(String lieunaissance) {
        this.lieunaissance = lieunaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    @XmlTransient
    public List<Dossierpatients> getDossierpatientsList() {
        return dossierpatientsList;
    }

    public void setDossierpatientsList(List<Dossierpatients> dossierpatientsList) {
        this.dossierpatientsList = dossierpatientsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPatient != null ? idPatient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patients)) {
            return false;
        }
        Patients other = (Patients) object;
        if ((this.idPatient == null && other.idPatient != null) || (this.idPatient != null && !this.idPatient.equals(other.idPatient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Patients[ idPatient=" + idPatient + " ]";
    }
    
}
