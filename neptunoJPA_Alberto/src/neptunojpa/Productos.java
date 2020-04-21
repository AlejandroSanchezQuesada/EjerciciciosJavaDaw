/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neptunojpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alumno
 */
@Entity
@Table(name = "Productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByIdProducto", query = "SELECT p FROM Productos p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Productos.findByNombreProducto", query = "SELECT p FROM Productos p WHERE p.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Productos.findByIdProveedor", query = "SELECT p FROM Productos p WHERE p.idProveedor = :idProveedor")
    , @NamedQuery(name = "Productos.findByIdCategoria", query = "SELECT p FROM Productos p WHERE p.idCategoria = :idCategoria")
    , @NamedQuery(name = "Productos.findByCantidadPorUnidad", query = "SELECT p FROM Productos p WHERE p.cantidadPorUnidad = :cantidadPorUnidad")
    , @NamedQuery(name = "Productos.findByPrecioUnidad", query = "SELECT p FROM Productos p WHERE p.precioUnidad = :precioUnidad")
    , @NamedQuery(name = "Productos.findByUnidadesEnExistencia", query = "SELECT p FROM Productos p WHERE p.unidadesEnExistencia = :unidadesEnExistencia")
    , @NamedQuery(name = "Productos.findByUnidadesEnPedido", query = "SELECT p FROM Productos p WHERE p.unidadesEnPedido = :unidadesEnPedido")
    , @NamedQuery(name = "Productos.findByNivelNuevoPedido", query = "SELECT p FROM Productos p WHERE p.nivelNuevoPedido = :nivelNuevoPedido")
    , @NamedQuery(name = "Productos.findBySuspendido", query = "SELECT p FROM Productos p WHERE p.suspendido = :suspendido")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdProducto")
    private Integer idProducto;
    @Column(name = "NombreProducto")
    private String nombreProducto;
    @Column(name = "IdProveedor")
    private Integer idProveedor;
    @Column(name = "IdCategoria")
    private Integer idCategoria;
    @Column(name = "CantidadPorUnidad")
    private String cantidadPorUnidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PrecioUnidad")
    private Float precioUnidad;
    @Column(name = "UnidadesEnExistencia")
    private Integer unidadesEnExistencia;
    @Column(name = "UnidadesEnPedido")
    private Integer unidadesEnPedido;
    @Column(name = "NivelNuevoPedido")
    private Integer nivelNuevoPedido;
    @Column(name = "Suspendido")
    private Character suspendido;

    public Productos() {
    }

    public Productos(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCantidadPorUnidad() {
        return cantidadPorUnidad;
    }

    public void setCantidadPorUnidad(String cantidadPorUnidad) {
        this.cantidadPorUnidad = cantidadPorUnidad;
    }

    public Float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(Float precioUnidad) {
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

    public Character getSuspendido() {
        return suspendido;
    }

    public void setSuspendido(Character suspendido) {
        this.suspendido = suspendido;
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
        return "neptunojpa.Productos[ idProducto=" + idProducto + " ]";
    }
    
}
