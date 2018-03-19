/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author M Ceessay
 */
@Entity
@Table(name = "consultation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultation.findAll", query = "SELECT c FROM Consultation c"),
    @NamedQuery(name = "Consultation.findByIdconsul", query = "SELECT c FROM Consultation c WHERE c.idconsul = :idconsul"),
    @NamedQuery(name = "Consultation.findByMotifConsultation", query = "SELECT c FROM Consultation c WHERE c.motifConsultation = :motifConsultation"),
    @NamedQuery(name = "Consultation.findByTaille", query = "SELECT c FROM Consultation c WHERE c.taille = :taille"),
    @NamedQuery(name = "Consultation.findByPoids", query = "SELECT c FROM Consultation c WHERE c.poids = :poids"),
    @NamedQuery(name = "Consultation.findByTemperature", query = "SELECT c FROM Consultation c WHERE c.temperature = :temperature"),
    @NamedQuery(name = "Consultation.findByPouls", query = "SELECT c FROM Consultation c WHERE c.pouls = :pouls"),
    @NamedQuery(name = "Consultation.findByDate", query = "SELECT c FROM Consultation c WHERE c.date = :date"),
    @NamedQuery(name = "Consultation.findByDossier", query = "SELECT c FROM Consultation c WHERE c.dossier = :dossier")})
public class Consultation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconsul")
    private Integer idconsul;
    @Basic(optional = false)
    @Column(name = "MotifConsultation")
    private String motifConsultation;
    @Basic(optional = false)
    @Column(name = "Taille")
    private String taille;
    @Basic(optional = false)
    @Column(name = "Poids")
    private String poids;
    @Basic(optional = false)
    @Column(name = "Temperature")
    private String temperature;
    @Basic(optional = false)
    @Column(name = "Pouls")
    private String pouls;
    @Basic(optional = false)
    @Lob
    @Column(name = "Observation")
    private String observation;
    @Basic(optional = false)
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "Dossier")
    private int dossier;

    public Consultation() {
    }

    public Consultation(Integer idconsul) {
        this.idconsul = idconsul;
    }

    public Consultation(Integer idconsul, String motifConsultation, String taille, String poids, String temperature, String pouls, String observation, Date date, int dossier) {
        this.idconsul = idconsul;
        this.motifConsultation = motifConsultation;
        this.taille = taille;
        this.poids = poids;
        this.temperature = temperature;
        this.pouls = pouls;
        this.observation = observation;
        this.date = date;
        this.dossier = dossier;
    }

    public Integer getIdconsul() {
        return idconsul;
    }

    public void setIdconsul(Integer idconsul) {
        this.idconsul = idconsul;
    }

    public String getMotifConsultation() {
        return motifConsultation;
    }

    public void setMotifConsultation(String motifConsultation) {
        this.motifConsultation = motifConsultation;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPouls() {
        return pouls;
    }

    public void setPouls(String pouls) {
        this.pouls = pouls;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDossier() {
        return dossier;
    }

    public void setDossier(int dossier) {
        this.dossier = dossier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconsul != null ? idconsul.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultation)) {
            return false;
        }
        Consultation other = (Consultation) object;
        if ((this.idconsul == null && other.idconsul != null) || (this.idconsul != null && !this.idconsul.equals(other.idconsul))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Consultation[ idconsul=" + idconsul + " ]";
    }
    
}
