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
@Table(name = "medios_de_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MediosDePago.findAll", query = "SELECT m FROM MediosDePago m")
    , @NamedQuery(name = "MediosDePago.findByCodMedio", query = "SELECT m FROM MediosDePago m WHERE m.codMedio = :codMedio")
    , @NamedQuery(name = "MediosDePago.findByDescripcion", query = "SELECT m FROM MediosDePago m WHERE m.descripcion = :descripcion")})
public class MediosDePago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_medio")
    private Integer codMedio;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMedioPago")
    private Collection<ComprasC> comprasCCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMedioPago")
    private Collection<VentasC> ventasCCollection;

    public MediosDePago() {
    }

    public MediosDePago(Integer codMedio) {
        this.codMedio = codMedio;
    }

    public MediosDePago(Integer codMedio, String descripcion) {
        this.codMedio = codMedio;
        this.descripcion = descripcion;
    }

    public Integer getCodMedio() {
        return codMedio;
    }

    public void setCodMedio(Integer codMedio) {
        this.codMedio = codMedio;
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
        hash += (codMedio != null ? codMedio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediosDePago)) {
            return false;
        }
        MediosDePago other = (MediosDePago) object;
        if ((this.codMedio == null && other.codMedio != null) || (this.codMedio != null && !this.codMedio.equals(other.codMedio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MediosDePago[ codMedio=" + codMedio + " ]";
    }
    
}
