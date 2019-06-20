/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
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
 * @author gaston
 */
@Entity
@Table(name = "compradores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compradores.findAll", query = "SELECT c FROM Compradores c")
    , @NamedQuery(name = "Compradores.findByCodComprador", query = "SELECT c FROM Compradores c WHERE c.codComprador = :codComprador")
    , @NamedQuery(name = "Compradores.findByNombre", query = "SELECT c FROM Compradores c WHERE c.nombre = :nombre")})
public class Compradores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_comprador")
    private Integer codComprador;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codComprador")
    private Collection<ComprasC> comprasCCollection;

    public Compradores() {
    }

    public Compradores(Integer codComprador) {
        this.codComprador = codComprador;
    }

    public Compradores(Integer codComprador, String nombre) {
        this.codComprador = codComprador;
        this.nombre = nombre;
    }

    public Integer getCodComprador() {
        return codComprador;
    }

    public void setCodComprador(Integer codComprador) {
        this.codComprador = codComprador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<ComprasC> getComprasCCollection() {
        return comprasCCollection;
    }

    public void setComprasCCollection(Collection<ComprasC> comprasCCollection) {
        this.comprasCCollection = comprasCCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codComprador != null ? codComprador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compradores)) {
            return false;
        }
        Compradores other = (Compradores) object;
        if ((this.codComprador == null && other.codComprador != null) || (this.codComprador != null && !this.codComprador.equals(other.codComprador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Compradores[ codComprador=" + codComprador + " ]";
    }
    
}
