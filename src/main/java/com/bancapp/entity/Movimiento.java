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
@Table(name = "movimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m"),
    @NamedQuery(name = "Movimiento.findById", query = "SELECT m FROM Movimiento m WHERE m.id = :id"),
    @NamedQuery(name = "Movimiento.findByFechaMovimiento", query = "SELECT m FROM Movimiento m WHERE m.fechaMovimiento = :fechaMovimiento"),
    @NamedQuery(name = "Movimiento.findByTipoMovimiento", query = "SELECT m FROM Movimiento m WHERE m.tipoMovimiento = :tipoMovimiento"),
    @NamedQuery(name = "Movimiento.findBySaldo", query = "SELECT m FROM Movimiento m WHERE m.saldo = :saldo")})
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_movimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMovimiento;
    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private Double saldo;
    @JoinColumn(name = "cliente_cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Cliente clienteCedula;
    @JoinColumn(name = "cuenta_codigo_cta", referencedColumnName = "codigo_cta")
    @ManyToOne(optional = false)
    private Cuenta cuentaCodigoCta;

    public Movimiento() {
    }

    public Movimiento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cliente getClienteCedula() {
        return clienteCedula;
    }

    public void setClienteCedula(Cliente clienteCedula) {
        this.clienteCedula = clienteCedula;
    }

    public Cuenta getCuentaCodigoCta() {
        return cuentaCodigoCta;
    }

    public void setCuentaCodigoCta(Cuenta cuentaCodigoCta) {
        this.cuentaCodigoCta = cuentaCodigoCta;
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
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bancapp.entity.Movimiento[ id=" + id + " ]";
    }
    
}
