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


/**
 *
 * @author gaston
 */
@Entity
@Table(name = "articulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulos.findAll", query = "SELECT a FROM Articulos a")
    , @NamedQuery(name = "Articulos.findByCodArticulo", query = "SELECT a FROM Articulos a WHERE a.codArticulo = :codArticulo")
    , @NamedQuery(name = "Articulos.findByDescripcion", query = "SELECT a FROM Articulos a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Articulos.findByColor", query = "SELECT a FROM Articulos a WHERE a.color = :color")
    , @NamedQuery(name = "Articulos.findByTalle", query = "SELECT a FROM Articulos a WHERE a.talle = :talle")})
public class Articulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_articulo")
    private Integer codArticulo;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Column(name = "talle")
    private String talle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articulos")
    private Collection<ComprasD> comprasDCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codArticulo")
    private Collection<VentasD> ventasDCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articulos")
    private Collection<Stock> stockCollection;

    public Articulos() {
    }

    public Articulos(Integer codArticulo) {
        this.codArticulo = codArticulo;
    }

    public Articulos(Integer codArticulo, String descripcion, String color) {
        this.codArticulo = codArticulo;
        this.descripcion = descripcion;
        this.color = color;
    }

    public Integer getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(Integer codArticulo) {
        this.codArticulo = codArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }


    
}
