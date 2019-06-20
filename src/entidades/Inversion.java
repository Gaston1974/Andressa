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
@Table(name = "inversion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inversion.findAll", query = "SELECT i FROM Inversion i")
    , @NamedQuery(name = "Inversion.findByCodBanco", query = "SELECT i FROM Inversion i WHERE i.inversionPK.codBanco = :codBanco")
    , @NamedQuery(name = "Inversion.findByFechaInicio", query = "SELECT i FROM Inversion i WHERE i.inversionPK.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Inversion.findByMonto", query = "SELECT i FROM Inversion i WHERE i.monto = :monto")
    , @NamedQuery(name = "Inversion.findByPlazoDias", query = "SELECT i FROM Inversion i WHERE i.plazoDias = :plazoDias")
    , @NamedQuery(name = "Inversion.findByNCuenta", query = "SELECT i FROM Inversion i WHERE i.nCuenta = :nCuenta")})
public class Inversion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_banco")
    private int codBanco;
    @Id
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "monto")
    private short monto;
    @Basic(optional = false)
    @Column(name = "plazo_dias")
    private int plazoDias;
    @Column(name = "n_cuenta")
    private String nCuenta;
    @JoinColumn(name = "cod_banco", referencedColumnName = "cod_banco", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Banco banco;

    public Inversion() {
    }

    public short getMonto() {
        return monto;
    }

    public void setMonto(short monto) {
        this.monto = monto;
    }

    public int getPlazoDias() {
        return plazoDias;
    }

    public void setPlazoDias(int plazoDias) {
        this.plazoDias = plazoDias;
    }

    public String getNCuenta() {
        return nCuenta;
    }

    public void setNCuenta(String nCuenta) {
        this.nCuenta = nCuenta;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

 
}
