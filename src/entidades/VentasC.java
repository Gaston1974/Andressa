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
import javax.persistence.EmbeddedId;
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
@Table(name = "ventas_c")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentasC.findAll", query = "SELECT v FROM VentasC v")
    , @NamedQuery(name = "VentasC.findByNFactura", query = "SELECT v FROM VentasC v WHERE v.ventasCPK.nFactura = :nFactura")
    , @NamedQuery(name = "VentasC.findByTipoFactura", query = "SELECT v FROM VentasC v WHERE v.ventasCPK.tipoFactura = :tipoFactura")
    , @NamedQuery(name = "VentasC.findByFecha", query = "SELECT v FROM VentasC v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "VentasC.findByTurno", query = "SELECT v FROM VentasC v WHERE v.turno = :turno")})
public class VentasC implements Serializable {

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
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "turno")
    private String turno;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne
    private Clientes codCliente;
    @JoinColumn(name = "cod_dia", referencedColumnName = "cod_dia")
    @ManyToOne
    private Dia codDia;
    @JoinColumn(name = "cod_medio_pago", referencedColumnName = "cod_medio")
    @ManyToOne(optional = false)
    private MediosDePago codMedioPago;
    @JoinColumn(name = "cod_vendedor", referencedColumnName = "cod_vendedor")
    @ManyToOne(optional = false)
    private Vendedores codVendedor;

    public VentasC() {
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Clientes getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Clientes codCliente) {
        this.codCliente = codCliente;
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

    public Vendedores getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(Vendedores codVendedor) {
        this.codVendedor = codVendedor;
    }

    
}
