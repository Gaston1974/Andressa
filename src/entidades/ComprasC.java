/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
 * @author gaston
 */
@Entity
@Table(name = "compras_c")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprasC.findAll", query = "SELECT c FROM ComprasC c")
    , @NamedQuery(name = "ComprasC.findByNCompra", query = "SELECT c FROM ComprasC c WHERE c.nCompra = :nCompra")
    , @NamedQuery(name = "ComprasC.findByNFactura", query = "SELECT c FROM ComprasC c WHERE c.nFactura = :nFactura")
    , @NamedQuery(name = "ComprasC.findByFecha", query = "SELECT c FROM ComprasC c WHERE c.fecha = :fecha")})
public class ComprasC implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "n_compra")
    private Integer nCompra;
    @Basic(optional = false)
    @Column(name = "n_factura")
    private String nFactura;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "cod_comprador", referencedColumnName = "cod_comprador")
    @ManyToOne(optional = false)
    private Compradores codComprador;
    @JoinColumn(name = "cod_dia", referencedColumnName = "cod_dia")
    @ManyToOne
    private Dia codDia;
    @JoinColumn(name = "cod_medio_pago", referencedColumnName = "cod_medio")
    @ManyToOne(optional = false)
    private MediosDePago codMedioPago;
    @JoinColumn(name = "cod_proveedor", referencedColumnName = "cod_proveedor")
    @ManyToOne(optional = false)
    private Proveedores codProveedor;

    public ComprasC() {
    }

    public ComprasC(Integer nCompra) {
        this.nCompra = nCompra;
    }

    public ComprasC(Integer nCompra, String nFactura, Date fecha) {
        this.nCompra = nCompra;
        this.nFactura = nFactura;
        this.fecha = fecha;
    }

    public Integer getNCompra() {
        return nCompra;
    }

    public void setNCompra(Integer nCompra) {
        this.nCompra = nCompra;
    }

    public String getNFactura() {
        return nFactura;
    }

    public void setNFactura(String nFactura) {
        this.nFactura = nFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Compradores getCodComprador() {
        return codComprador;
    }

    public void setCodComprador(Compradores codComprador) {
        this.codComprador = codComprador;
    }

    public Dia getCodDia() {
        return codDia;
    }

    public void setCodDia(Dia codDia) {
        this.codDia = codDia;
    }

    public MediosDePago getCodMedioPago() {
        return codMedioPago;
    }

    public void setCodMedioPago(MediosDePago codMedioPago) {
        this.codMedioPago = codMedioPago;
    }

    public Proveedores getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(Proveedores codProveedor) {
        this.codProveedor = codProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nCompra != null ? nCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprasC)) {
            return false;
        }
        ComprasC other = (ComprasC) object;
        if ((this.nCompra == null && other.nCompra != null) || (this.nCompra != null && !this.nCompra.equals(other.nCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ComprasC[ nCompra=" + nCompra + " ]";
    }
    
}
