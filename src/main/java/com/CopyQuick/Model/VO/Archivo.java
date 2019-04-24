/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CopyQuick.Model.VO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC02
 */
@Entity
@Table(name = "archivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Archivo.findAll", query = "SELECT a FROM Archivo a"),
    @NamedQuery(name = "Archivo.findByIdArchivo", query = "SELECT a FROM Archivo a WHERE a.idArchivo = :idArchivo"),
    @NamedQuery(name = "Archivo.findByNombre", query = "SELECT a FROM Archivo a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Archivo.findBySemestre", query = "SELECT a FROM Archivo a WHERE a.semestre = :semestre"),
    @NamedQuery(name = "Archivo.findByEscuela", query = "SELECT a FROM Archivo a WHERE a.escuela = :escuela"),
    @NamedQuery(name = "Archivo.findByPublico", query = "SELECT a FROM Archivo a WHERE a.publico = :publico"),
    @NamedQuery(name = "Archivo.findByNumHojas", query = "SELECT a FROM Archivo a WHERE a.numHojas = :numHojas")})
public class Archivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idArchivo")
    private Integer idArchivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semestre")
    private int semestre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "escuela")
    private String escuela;
    @Basic(optional = false)
    @NotNull
    @Column(name = "publico")
    private boolean publico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numHojas")
    private int numHojas;
    @JoinColumn(name = "nomUsuario", referencedColumnName = "nomUsuario")
    @ManyToOne(optional = false)
    private Usuario nomUsuario;

    public Archivo() {
    }

    public Archivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public Archivo(Integer idArchivo, String nombre, int semestre, String escuela, boolean publico, int numHojas) {
        this.idArchivo = idArchivo;
        this.nombre = nombre;
        this.semestre = semestre;
        this.escuela = escuela;
        this.publico = publico;
        this.numHojas = numHojas;
    }

    public Integer getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public boolean getPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }

    public int getNumHojas() {
        return numHojas;
    }

    public void setNumHojas(int numHojas) {
        this.numHojas = numHojas;
    }

    public Usuario getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(Usuario nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArchivo != null ? idArchivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivo)) {
            return false;
        }
        Archivo other = (Archivo) object;
        if ((this.idArchivo == null && other.idArchivo != null) || (this.idArchivo != null && !this.idArchivo.equals(other.idArchivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CopyQuick.Model.VO.Archivo[ idArchivo=" + idArchivo + " ]";
    }
    
}
