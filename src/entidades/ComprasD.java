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
@Table(name = "compras_d")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprasD.findAll", query = "SELECT c FROM ComprasD c")
    , @NamedQuery(name = "ComprasD.findByNCompra", query = "SELECT c FROM ComprasD c WHERE c.comprasDPK.nCompra = :nCompra")
    , @NamedQuery(name = "ComprasD.findByCodArticulo", query = "SELECT c FROM ComprasD c WHERE c.comprasDPK.codArticulo = :codArticulo")
    , @NamedQuery(name = "ComprasD.findByCantidad", query = "SELECT c FROM ComprasD c WHERE c.cantidad = :cantidad")
    , @NamedQuery(name = "ComprasD.findByPrecioUnidad", query = "SELECT c FROM ComprasD c WHERE c.precioUnidad = :precioUnidad")})
public class ComprasD implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "n_compra")
    private int nCompra;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_articulo")
    private int codArticulo;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "precio_unidad")
    private Short precioUnidad;
    @JoinColumn(name = "cod_articulo", referencedColumnName = "cod_articulo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Articulos articulos;

    public ComprasD() {
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Short getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(Short precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Articulos getArticulos() {
        return articulos;
    }

    public void setArticulos(Articulos articulos) {
        this.articulos = articulos;
    }

    
}
