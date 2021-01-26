/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancapp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jaimeacabreraa
 */
@Entity
@Table(name = "adm_cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmCuenta.findAll", query = "SELECT a FROM AdmCuenta a"),
    @NamedQuery(name = "AdmCuenta.findByCodAdm", query = "SELECT a FROM AdmCuenta a WHERE a.codAdm = :codAdm"),
    @NamedQuery(name = "AdmCuenta.findByFechaCreacion", query = "SELECT a FROM AdmCuenta a WHERE a.fechaCreacion = :fechaCreacion")})
public class AdmCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_adm")
    private Integer codAdm;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumn(name = "cliente_cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Cliente clienteCedula;

    public AdmCuenta() {
    }

    public AdmCuenta(Integer codAdm) {
        this.codAdm = codAdm;
    }

    public Integer getCodAdm() {
        return codAdm;
    }

    public void setCodAdm(Integer codAdm) {
        this.codAdm = codAdm;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Cliente getClienteCedula() {
        return clienteCedula;
    }

    public void setClienteCedula(Cliente clienteCedula) {
        this.clienteCedula = clienteCedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAdm != null ? codAdm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmCuenta)) {
            return false;
        }
        AdmCuenta other = (AdmCuenta) object;
        if ((this.codAdm == null && other.codAdm != null) || (this.codAdm != null && !this.codAdm.equals(other.codAdm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bancapp.entity.AdmCuenta[ codAdm=" + codAdm + " ]";
    }
    
}
