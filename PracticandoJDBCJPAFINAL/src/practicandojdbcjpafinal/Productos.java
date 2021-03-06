/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicandojdbcjpafinal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexk
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByIdProducto", query = "SELECT p FROM Productos p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Productos.findByNombreProducto", query = "SELECT p FROM Productos p WHERE p.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Productos.findByCantidadPorUnidad", query = "SELECT p FROM Productos p WHERE p.cantidadPorUnidad = :cantidadPorUnidad")
    , @NamedQuery(name = "Productos.findByPrecioUnidad", query = "SELECT p FROM Productos p WHERE p.precioUnidad = :precioUnidad")
    , @NamedQuery(name = "Productos.findByUnidadesEnExistencia", query = "SELECT p FROM Productos p WHERE p.unidadesEnExistencia = :unidadesEnExistencia")
    , @NamedQuery(name = "Productos.findByUnidadesEnPedido", query = "SELECT p FROM Productos p WHERE p.unidadesEnPedido = :unidadesEnPedido")
    , @NamedQuery(name = "Productos.findByNivelNuevoPedido", query = "SELECT p FROM Productos p WHERE p.nivelNuevoPedido = :nivelNuevoPedido")
    , @NamedQuery(name = "Productos.findBySuspendido", query = "SELECT p FROM Productos p WHERE p.suspendido = :suspendido")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdProducto")
    private Short idProducto;
    @Basic(optional = false)
    @Column(name = "NombreProducto")
    private String nombreProducto;
    @Column(name = "CantidadPorUnidad")
    private String cantidadPorUnidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PrecioUnidad")
    private BigDecimal precioUnidad;
    @Column(name = "UnidadesEnExistencia")
    private Integer unidadesEnExistencia;
    @Column(name = "UnidadesEnPedido")
    private Integer unidadesEnPedido;
    @Column(name = "NivelNuevoPedido")
    private Integer nivelNuevoPedido;
    @Column(name = "Suspendido")
    private Boolean suspendido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private Collection<Detallespedidos> detallespedidosCollection;
    @JoinColumn(name = "IdCategoria", referencedColumnName = "IdCategoria")
    @ManyToOne(optional = false)
    private Categorias idCategoria;
    @JoinColumn(name = "IdProveedor", referencedColumnName = "IdProveedor")
    @ManyToOne
    private Proveedores idProveedor;

    public Productos() {
    }

    public Productos(Short idProducto) {
        this.idProducto = idProducto;
    }

    public Productos(Short idProducto, String nombreProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
    }

    public Short getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Short idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCantidadPorUnidad() {
        return cantidadPorUnidad;
    }

    public void setCantidadPorUnidad(String cantidadPorUnidad) {
        this.cantidadPorUnidad = cantidadPorUnidad;
    }

    public BigDecimal getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(BigDecimal precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Integer getUnidadesEnExistencia() {
        return unidadesEnExistencia;
    }

    public void setUnidadesEnExistencia(Integer unidadesEnExistencia) {
        this.unidadesEnExistencia = unidadesEnExistencia;
    }

    public Integer getUnidadesEnPedido() {
        return unidadesEnPedido;
    }

    public void setUnidadesEnPedido(Integer unidadesEnPedido) {
        this.unidadesEnPedido = unidadesEnPedido;
    }

    public Integer getNivelNuevoPedido() {
        return nivelNuevoPedido;
    }

    public void setNivelNuevoPedido(Integer nivelNuevoPedido) {
        this.nivelNuevoPedido = nivelNuevoPedido;
    }

    public Boolean getSuspendido() {
        return suspendido;
    }

    public void setSuspendido(Boolean suspendido) {
        this.suspendido = suspendido;
    }

    @XmlTransient
    public Collection<Detallespedidos> getDetallespedidosCollection() {
        return detallespedidosCollection;
    }

    public void setDetallespedidosCollection(Collection<Detallespedidos> detallespedidosCollection) {
        this.detallespedidosCollection = detallespedidosCollection;
    }

    public Categorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categorias idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Proveedores getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedores idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "practicandojdbcjpafinal.Productos[ idProducto=" + idProducto + " ]";
    }
    
}
