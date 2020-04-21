/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neptunojpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alumno
 */
@Entity
@Table(name = "Pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p")
    , @NamedQuery(name = "Pedidos.findByIdPedido", query = "SELECT p FROM Pedidos p WHERE p.idPedido = :idPedido")
    , @NamedQuery(name = "Pedidos.findByIdCliente", query = "SELECT p FROM Pedidos p WHERE p.idCliente = :idCliente")
    , @NamedQuery(name = "Pedidos.findByIdEmpleado", query = "SELECT p FROM Pedidos p WHERE p.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "Pedidos.findByFechaPedido", query = "SELECT p FROM Pedidos p WHERE p.fechaPedido = :fechaPedido")
    , @NamedQuery(name = "Pedidos.findByFechaEntrega", query = "SELECT p FROM Pedidos p WHERE p.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Pedidos.findByFechaEnvio", query = "SELECT p FROM Pedidos p WHERE p.fechaEnvio = :fechaEnvio")
    , @NamedQuery(name = "Pedidos.findByFormaEnvio", query = "SELECT p FROM Pedidos p WHERE p.formaEnvio = :formaEnvio")
    , @NamedQuery(name = "Pedidos.findByCargo", query = "SELECT p FROM Pedidos p WHERE p.cargo = :cargo")
    , @NamedQuery(name = "Pedidos.findByDestinatario", query = "SELECT p FROM Pedidos p WHERE p.destinatario = :destinatario")
    , @NamedQuery(name = "Pedidos.findByDireccionDestinatario", query = "SELECT p FROM Pedidos p WHERE p.direccionDestinatario = :direccionDestinatario")
    , @NamedQuery(name = "Pedidos.findByCiudadDestinatario", query = "SELECT p FROM Pedidos p WHERE p.ciudadDestinatario = :ciudadDestinatario")
    , @NamedQuery(name = "Pedidos.findByRegionDestinatario", query = "SELECT p FROM Pedidos p WHERE p.regionDestinatario = :regionDestinatario")
    , @NamedQuery(name = "Pedidos.findByCodPostalDestinatario", query = "SELECT p FROM Pedidos p WHERE p.codPostalDestinatario = :codPostalDestinatario")
    , @NamedQuery(name = "Pedidos.findByPaisDestinatario", query = "SELECT p FROM Pedidos p WHERE p.paisDestinatario = :paisDestinatario")})
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdPedido")
    private Integer idPedido;
    @Column(name = "IdCliente")
    private String idCliente;
    @Column(name = "IdEmpleado")
    private Integer idEmpleado;
    @Column(name = "FechaPedido")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @Column(name = "FechaEntrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Column(name = "FechaEnvio")
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    @Column(name = "FormaEnvio")
    private Integer formaEnvio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Cargo")
    private Float cargo;
    @Column(name = "Destinatario")
    private String destinatario;
    @Column(name = "DireccionDestinatario")
    private String direccionDestinatario;
    @Column(name = "CiudadDestinatario")
    private String ciudadDestinatario;
    @Column(name = "RegionDestinatario")
    private String regionDestinatario;
    @Column(name = "CodPostalDestinatario")
    private String codPostalDestinatario;
    @Column(name = "PaisDestinatario")
    private String paisDestinatario;

    public Pedidos() {
    }

    public Pedidos(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Integer getFormaEnvio() {
        return formaEnvio;
    }

    public void setFormaEnvio(Integer formaEnvio) {
        this.formaEnvio = formaEnvio;
    }

    public Float getCargo() {
        return cargo;
    }

    public void setCargo(Float cargo) {
        this.cargo = cargo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDireccionDestinatario() {
        return direccionDestinatario;
    }

    public void setDireccionDestinatario(String direccionDestinatario) {
        this.direccionDestinatario = direccionDestinatario;
    }

    public String getCiudadDestinatario() {
        return ciudadDestinatario;
    }

    public void setCiudadDestinatario(String ciudadDestinatario) {
        this.ciudadDestinatario = ciudadDestinatario;
    }

    public String getRegionDestinatario() {
        return regionDestinatario;
    }

    public void setRegionDestinatario(String regionDestinatario) {
        this.regionDestinatario = regionDestinatario;
    }

    public String getCodPostalDestinatario() {
        return codPostalDestinatario;
    }

    public void setCodPostalDestinatario(String codPostalDestinatario) {
        this.codPostalDestinatario = codPostalDestinatario;
    }

    public String getPaisDestinatario() {
        return paisDestinatario;
    }

    public void setPaisDestinatario(String paisDestinatario) {
        this.paisDestinatario = paisDestinatario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "neptunojpa.Pedidos[ idPedido=" + idPedido + " ]";
    }
    
}
