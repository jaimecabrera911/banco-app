/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancapp.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jaimeacabreraa
 */
@Entity
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByCodigoCta", query = "SELECT c FROM Cuenta c WHERE c.codigoCta = :codigoCta"),
    @NamedQuery(name = "Cuenta.findByNombreCta", query = "SELECT c FROM Cuenta c WHERE c.nombreCta = :nombreCta"),
    @NamedQuery(name = "Cuenta.findByEstado", query = "SELECT c FROM Cuenta c WHERE c.estado = :estado")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo_cta")
    private Integer codigoCta;
    @Column(name = "nombre_cta")
    private String nombreCta;
    @Column(name = "estado")
    private Boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaCodigoCta")
    private List<Movimiento> movimientoList;

    public Cuenta() {
    }

    public Cuenta(Integer codigoCta) {
        this.codigoCta = codigoCta;
    }

    public Integer getCodigoCta() {
        return codigoCta;
    }

    public void setCodigoCta(Integer codigoCta) {
        this.codigoCta = codigoCta;
    }

    public String getNombreCta() {
        return nombreCta;
    }

    public void setNombreCta(String nombreCta) {
        this.nombreCta = nombreCta;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCta != null ? codigoCta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.codigoCta == null && other.codigoCta != null) || (this.codigoCta != null && !this.codigoCta.equals(other.codigoCta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bancapp.entity.Cuenta[ codigoCta=" + codigoCta + " ]";
    }
    
}
