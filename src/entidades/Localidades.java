/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author gaston
 */
@Entity
@Table(name = "localidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidades.findAll", query = "SELECT l FROM Localidades l")
    , @NamedQuery(name = "Localidades.findByCodLocalidad", query = "SELECT l FROM Localidades l WHERE l.codLocalidad = :codLocalidad")
    , @NamedQuery(name = "Localidades.findByDescripcion", query = "SELECT l FROM Localidades l WHERE l.descripcion = :descripcion")})
public class Localidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_localidad")
    private Integer codLocalidad;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "codLocalidad")
    private Collection<Clientes> clientesCollection;

    public Localidades() {
    }

    public Localidades(Integer codLocalidad) {
        this.codLocalidad = codLocalidad;
    }

    public Localidades(Integer codLocalidad, String descripcion) {
        this.codLocalidad = codLocalidad;
        this.descripcion = descripcion;
    }

    public Integer getCodLocalidad() {
        return codLocalidad;
    }

    public void setCodLocalidad(Integer codLocalidad) {
        this.codLocalidad = codLocalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Clientes> getClientesCollection() {
        return clientesCollection;
    }

    public void setClientesCollection(Collection<Clientes> clientesCollection) {
        this.clientesCollection = clientesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLocalidad != null ? codLocalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidades)) {
            return false;
        }
        Localidades other = (Localidades) object;
        if ((this.codLocalidad == null && other.codLocalidad != null) || (this.codLocalidad != null && !this.codLocalidad.equals(other.codLocalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Localidades[ codLocalidad=" + codLocalidad + " ]";
    }
    
}
