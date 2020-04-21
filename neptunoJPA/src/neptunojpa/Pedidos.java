/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neptunojpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexk
 */
@Entity
@Table(name = "pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p")
    , @NamedQuery(name = "Pedidos.findByIdPedido", query = "SELECT p FROM Pedidos p WHERE p.idPedido = :idPedido")
    , @NamedQuery(name = "Pedidos.findByFechaPedido", query = "SELECT p FROM Pedidos p WHERE p.fechaPedido = :fechaPedido")
    , @NamedQuery(name = "Pedidos.findByFechaEntrega", query = "SELECT p FROM Pedidos p WHERE p.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Pedidos.findByFechaEnvio", query = "SELECT p FROM Pedidos p WHERE p.fechaEnvio = :fechaEnvio")
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPedido")
    private Integer idPedido;
    @Column(name = "FechaPedido")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @Column(name = "FechaEntrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Column(name = "FechaEnvio")
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Cargo")
    private BigDecimal cargo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidos")
    private Collection<Detallespedidos> detallespedidosCollection;
    @JoinColumn(name = "IdCliente", referencedColumnName = "IdCliente")
    @ManyToOne(optional = false)
    private Clientes idCliente;
    @JoinColumn(name = "IdEmpleado", referencedColumnName = "IdEmpleado")
    @ManyToOne(optional = false)
    private Empleados idEmpleado;
    @JoinColumn(name = "FormaEnvio", referencedColumnName = "IdCompanyaEnvios")
    @ManyToOne
    private Companyaenvios formaEnvio;

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

    public BigDecimal getCargo() {
        return cargo;
    }

    public void setCargo(BigDecimal cargo) {
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

    @XmlTransient
    public Collection<Detallespedidos> getDetallespedidosCollection() {
        return detallespedidosCollection;
    }

    public void setDetallespedidosCollection(Collection<Detallespedidos> detallespedidosCollection) {
        this.detallespedidosCollection = detallespedidosCollection;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public Empleados getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleados idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Companyaenvios getFormaEnvio() {
        return formaEnvio;
    }

    public void setFormaEnvio(Companyaenvios formaEnvio) {
        this.formaEnvio = formaEnvio;
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
