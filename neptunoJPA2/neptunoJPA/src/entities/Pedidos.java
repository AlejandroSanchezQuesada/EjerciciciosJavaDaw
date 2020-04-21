/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alumno
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

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

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
    @JoinColumn(name = "IdCliente", referencedColumnName = "IdCliente")
    @ManyToOne(optional = false)
    private Clientes idCliente;
    @JoinColumn(name = "IdEmpleado", referencedColumnName = "IdEmpleado")
    @ManyToOne(optional = false)
    private Empleados idEmpleado;
    @JoinColumn(name = "FormaEnvio", referencedColumnName = "IdCompanyaEnvios")
    @ManyToOne
    private CompanyaEnvios formaEnvio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidos")
    private Collection<DetallesPedidos> detallesPedidosCollection;

    public Pedidos() {
    }

    public Pedidos(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        Integer oldIdPedido = this.idPedido;
        this.idPedido = idPedido;
        changeSupport.firePropertyChange("idPedido", oldIdPedido, idPedido);
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        Date oldFechaPedido = this.fechaPedido;
        this.fechaPedido = fechaPedido;
        changeSupport.firePropertyChange("fechaPedido", oldFechaPedido, fechaPedido);
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        Date oldFechaEntrega = this.fechaEntrega;
        this.fechaEntrega = fechaEntrega;
        changeSupport.firePropertyChange("fechaEntrega", oldFechaEntrega, fechaEntrega);
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        Date oldFechaEnvio = this.fechaEnvio;
        this.fechaEnvio = fechaEnvio;
        changeSupport.firePropertyChange("fechaEnvio", oldFechaEnvio, fechaEnvio);
    }

    public BigDecimal getCargo() {
        return cargo;
    }

    public void setCargo(BigDecimal cargo) {
        BigDecimal oldCargo = this.cargo;
        this.cargo = cargo;
        changeSupport.firePropertyChange("cargo", oldCargo, cargo);
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        String oldDestinatario = this.destinatario;
        this.destinatario = destinatario;
        changeSupport.firePropertyChange("destinatario", oldDestinatario, destinatario);
    }

    public String getDireccionDestinatario() {
        return direccionDestinatario;
    }

    public void setDireccionDestinatario(String direccionDestinatario) {
        String oldDireccionDestinatario = this.direccionDestinatario;
        this.direccionDestinatario = direccionDestinatario;
        changeSupport.firePropertyChange("direccionDestinatario", oldDireccionDestinatario, direccionDestinatario);
    }

    public String getCiudadDestinatario() {
        return ciudadDestinatario;
    }

    public void setCiudadDestinatario(String ciudadDestinatario) {
        String oldCiudadDestinatario = this.ciudadDestinatario;
        this.ciudadDestinatario = ciudadDestinatario;
        changeSupport.firePropertyChange("ciudadDestinatario", oldCiudadDestinatario, ciudadDestinatario);
    }

    public String getRegionDestinatario() {
        return regionDestinatario;
    }

    public void setRegionDestinatario(String regionDestinatario) {
        String oldRegionDestinatario = this.regionDestinatario;
        this.regionDestinatario = regionDestinatario;
        changeSupport.firePropertyChange("regionDestinatario", oldRegionDestinatario, regionDestinatario);
    }

    public String getCodPostalDestinatario() {
        return codPostalDestinatario;
    }

    public void setCodPostalDestinatario(String codPostalDestinatario) {
        String oldCodPostalDestinatario = this.codPostalDestinatario;
        this.codPostalDestinatario = codPostalDestinatario;
        changeSupport.firePropertyChange("codPostalDestinatario", oldCodPostalDestinatario, codPostalDestinatario);
    }

    public String getPaisDestinatario() {
        return paisDestinatario;
    }

    public void setPaisDestinatario(String paisDestinatario) {
        String oldPaisDestinatario = this.paisDestinatario;
        this.paisDestinatario = paisDestinatario;
        changeSupport.firePropertyChange("paisDestinatario", oldPaisDestinatario, paisDestinatario);
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        Clientes oldIdCliente = this.idCliente;
        this.idCliente = idCliente;
        changeSupport.firePropertyChange("idCliente", oldIdCliente, idCliente);
    }

    public Empleados getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleados idEmpleado) {
        Empleados oldIdEmpleado = this.idEmpleado;
        this.idEmpleado = idEmpleado;
        changeSupport.firePropertyChange("idEmpleado", oldIdEmpleado, idEmpleado);
    }

    public CompanyaEnvios getFormaEnvio() {
        return formaEnvio;
    }

    public void setFormaEnvio(CompanyaEnvios formaEnvio) {
        CompanyaEnvios oldFormaEnvio = this.formaEnvio;
        this.formaEnvio = formaEnvio;
        changeSupport.firePropertyChange("formaEnvio", oldFormaEnvio, formaEnvio);
    }

    @XmlTransient
    public Collection<DetallesPedidos> getDetallesPedidosCollection() {
        return detallesPedidosCollection;
    }

    public void setDetallesPedidosCollection(Collection<DetallesPedidos> detallesPedidosCollection) {
        this.detallesPedidosCollection = detallesPedidosCollection;
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
        return idPedido.toString();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
