/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gaston
 */
@Entity
@Table(name = "ventas_d")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentasD.findAll", query = "SELECT v FROM VentasD v")
    , @NamedQuery(name = "VentasD.findByNFactura", query = "SELECT v FROM VentasD v WHERE v.ventasDPK.nFactura = :nFactura")
    , @NamedQuery(name = "VentasD.findByTipoFactura", query = "SELECT v FROM VentasD v WHERE v.ventasDPK.tipoFactura = :tipoFactura")
    , @NamedQuery(name = "VentasD.findByCantidad", query = "SELECT v FROM VentasD v WHERE v.cantidad = :cantidad")
    , @NamedQuery(name = "VentasD.findByPrecioUnidad", query = "SELECT v FROM VentasD v WHERE v.precioUnidad = :precioUnidad")})
public class VentasD implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "n_factura")
    private String nFactura;
    @Id
    @Basic(optional = false)
    @Column(name = "tipo_factura")
    private Character tipoFactura;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "precio_unidad")
    private short precioUnidad;
    @JoinColumn(name = "cod_articulo", referencedColumnName = "cod_articulo")
    @ManyToOne(optional = false)
    private Articulos codArticulo;

    public VentasD() {
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public short getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(short precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Articulos getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(Articulos codArticulo) {
        this.codArticulo = codArticulo;
    }


    
}
