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
@Table(name = "dia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dia.findAll", query = "SELECT d FROM Dia d")
    , @NamedQuery(name = "Dia.findByCodDia", query = "SELECT d FROM Dia d WHERE d.codDia = :codDia")
    , @NamedQuery(name = "Dia.findByDescripcion", query = "SELECT d FROM Dia d WHERE d.descripcion = :descripcion")})
public class Dia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_dia")
    private Integer codDia;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "codDia")
    private Collection<ComprasC> comprasCCollection;
    @OneToMany(mappedBy = "codDia")
    private Collection<VentasC> ventasCCollection;

    public Dia() {
    }

    public Dia(Integer codDia) {
        this.codDia = codDia;
    }

    public Dia(Integer codDia, String descripcion) {
        this.codDia = codDia;
        this.descripcion = descripcion;
    }

    public Integer getCodDia() {
        return codDia;
    }

    public void setCodDia(Integer codDia) {
        this.codDia = codDia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<ComprasC> getComprasCCollection() {
        return comprasCCollection;
    }

    public void setComprasCCollection(Collection<ComprasC> comprasCCollection) {
        this.comprasCCollection = comprasCCollection;
    }

    @XmlTransient
    public Collection<VentasC> getVentasCCollection() {
        return ventasCCollection;
    }

    public void setVentasCCollection(Collection<VentasC> ventasCCollection) {
        this.ventasCCollection = ventasCCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDia != null ? codDia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dia)) {
            return false;
        }
        Dia other = (Dia) object;
        if ((this.codDia == null && other.codDia != null) || (this.codDia != null && !this.codDia.equals(other.codDia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Dia[ codDia=" + codDia + " ]";
    }
    
}
