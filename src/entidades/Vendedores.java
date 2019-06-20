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
@Table(name = "vendedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedores.findAll", query = "SELECT v FROM Vendedores v")
    , @NamedQuery(name = "Vendedores.findByCodVendedor", query = "SELECT v FROM Vendedores v WHERE v.codVendedor = :codVendedor")
    , @NamedQuery(name = "Vendedores.findByNombre", query = "SELECT v FROM Vendedores v WHERE v.nombre = :nombre")})
public class Vendedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_vendedor")
    private Integer codVendedor;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codVendedor")
    private Collection<VentasC> ventasCCollection;

    public Vendedores() {
    }

    public Vendedores(Integer codVendedor) {
        this.codVendedor = codVendedor;
    }

    public Vendedores(Integer codVendedor, String nombre) {
        this.codVendedor = codVendedor;
        this.nombre = nombre;
    }

    public Integer getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(Integer codVendedor) {
        this.codVendedor = codVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (codVendedor != null ? codVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedores)) {
            return false;
        }
        Vendedores other = (Vendedores) object;
        if ((this.codVendedor == null && other.codVendedor != null) || (this.codVendedor != null && !this.codVendedor.equals(other.codVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Vendedores[ codVendedor=" + codVendedor + " ]";
    }
    
}
