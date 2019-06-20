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
@Table(name = "proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p")
    , @NamedQuery(name = "Proveedores.findByCodProveedor", query = "SELECT p FROM Proveedores p WHERE p.codProveedor = :codProveedor")
    , @NamedQuery(name = "Proveedores.findByNombre", query = "SELECT p FROM Proveedores p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proveedores.findByApellido", query = "SELECT p FROM Proveedores p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Proveedores.findByDni", query = "SELECT p FROM Proveedores p WHERE p.dni = :dni")
    , @NamedQuery(name = "Proveedores.findByCodLocalidad", query = "SELECT p FROM Proveedores p WHERE p.codLocalidad = :codLocalidad")
    , @NamedQuery(name = "Proveedores.findByTelefono", query = "SELECT p FROM Proveedores p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Proveedores.findByMail", query = "SELECT p FROM Proveedores p WHERE p.mail = :mail")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_proveedor")
    private Integer codProveedor;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @Column(name = "cod_localidad")
    private int codLocalidad;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "mail")
    private String mail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProveedor")
    private Collection<ComprasC> comprasCCollection;

    public Proveedores() {
    }

    public Proveedores(Integer codProveedor) {
        this.codProveedor = codProveedor;
    }

    public Proveedores(Integer codProveedor, String nombre, String apellido, int codLocalidad) {
        this.codProveedor = codProveedor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.codLocalidad = codLocalidad;
    }

    public Integer getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(Integer codProveedor) {
        this.codProveedor = codProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getCodLocalidad() {
        return codLocalidad;
    }

    public void setCodLocalidad(int codLocalidad) {
        this.codLocalidad = codLocalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
        hash += (codProveedor != null ? codProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.codProveedor == null && other.codProveedor != null) || (this.codProveedor != null && !this.codProveedor.equals(other.codProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Proveedores[ codProveedor=" + codProveedor + " ]";
    }
    
}
