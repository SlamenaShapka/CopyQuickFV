/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CopyQuick.Model.VO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC02
 */
@Entity
@Table(name = "registro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r"),
    @NamedQuery(name = "Registro.findByIdRegistro", query = "SELECT r FROM Registro r WHERE r.idRegistro = :idRegistro"),
    @NamedQuery(name = "Registro.findByPrecio", query = "SELECT r FROM Registro r WHERE r.precio = :precio"),
    @NamedQuery(name = "Registro.findByVigencia", query = "SELECT r FROM Registro r WHERE r.vigencia = :vigencia"),
    @NamedQuery(name = "Registro.findByFecha", query = "SELECT r FROM Registro r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Registro.findByUsuarioFinal", query = "SELECT r FROM Registro r WHERE r.usuarioFinal = :usuarioFinal"),
    @NamedQuery(name = "Registro.findByPaginaIni", query = "SELECT r FROM Registro r WHERE r.paginaIni = :paginaIni"),
    @NamedQuery(name = "Registro.findByPaginaFin", query = "SELECT r FROM Registro r WHERE r.paginaFin = :paginaFin")})
public class Registro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRegistro")
    private Integer idRegistro;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "vigencia")
    private Boolean vigencia;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 15)
    @Column(name = "usuarioFinal")
    private String usuarioFinal;
    @Column(name = "paginaIni")
    private Integer paginaIni;
    @Column(name = "paginaFin")
    private Integer paginaFin;

    public Registro() {
    }

    public Registro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Boolean getVigencia() {
        return vigencia;
    }

    public void setVigencia(Boolean vigencia) {
        this.vigencia = vigencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuarioFinal() {
        return usuarioFinal;
    }

    public void setUsuarioFinal(String usuarioFinal) {
        this.usuarioFinal = usuarioFinal;
    }

    public Integer getPaginaIni() {
        return paginaIni;
    }

    public void setPaginaIni(Integer paginaIni) {
        this.paginaIni = paginaIni;
    }

    public Integer getPaginaFin() {
        return paginaFin;
    }

    public void setPaginaFin(Integer paginaFin) {
        this.paginaFin = paginaFin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistro != null ? idRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.idRegistro == null && other.idRegistro != null) || (this.idRegistro != null && !this.idRegistro.equals(other.idRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CopyQuick.Model.VO.Registro[ idRegistro=" + idRegistro + " ]";
    }
    
}
