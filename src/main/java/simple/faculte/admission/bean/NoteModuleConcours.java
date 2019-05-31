/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple.faculte.admission.bean;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Anas
 */
@Entity
public class NoteModuleConcours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private RetenueEcrit retenueEcrit;
    private String refModuleConcours;
    private double note;

    public RetenueEcrit getRetenueEcrit() {
        return retenueEcrit;
    }

    public void setRetenueEcrit(RetenueEcrit retenueEcrit) {
        this.retenueEcrit = retenueEcrit;
    }

    public String getRefModuleConcours() {
        return refModuleConcours;
    }

    public void setRefModuleConcours(String refModuleConcours) {
        this.refModuleConcours = refModuleConcours;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NoteModuleConcours)) {
            return false;
        }
        NoteModuleConcours other = (NoteModuleConcours) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simple.faculte.admission.bean.NoteModuleConcours[ id=" + id + " ]";
    }

}
