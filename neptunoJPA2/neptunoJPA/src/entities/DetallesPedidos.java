/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alumno
 */
@Entity
@Table(name = "detallespedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallesPedidos.findAll", query = "SELECT d FROM DetallesPedidos d")
    , @NamedQuery(name = "DetallesPedidos.findByIdPedido", query = "SELECT d FROM DetallesPedidos d WHERE d.detallesPedidosPK.idPedido = :idPedido")
    , @NamedQuery(name = "DetallesPedidos.findByIdProducto", query = "SELECT d FROM DetallesPedidos d WHERE d.detallesPedidosPK.idProducto = :idProducto")
    , @NamedQuery(name = "DetallesPedidos.findByPrecioUnidad", query = "SELECT d FROM DetallesPedidos d WHERE d.precioUnidad = :precioUnidad")
    , @NamedQuery(name = "DetallesPedidos.findByCantidad", query = "SELECT d FROM DetallesPedidos d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetallesPedidos.findByDescuento", query = "SELECT d FROM DetallesPedidos d WHERE d.descuento = :descuento")})
public class DetallesPedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallesPedidosPK detallesPedidosPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PrecioUnidad")
    private BigDecimal precioUnidad;
    @Basic(optional = false)
    @Column(name = "Cantidad")
    private short cantidad;
    @Column(name = "Descuento")
    private Float descuento;
    @JoinColumn(name = "IdPedido", referencedColumnName = "IdPedido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedidos pedidos;
    @JoinColumn(name = "IdProducto", referencedColumnName = "IdProducto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;

    public DetallesPedidos() {
    }

    public DetallesPedidos(DetallesPedidosPK detallesPedidosPK) {
        this.detallesPedidosPK = detallesPedidosPK;
    }

    public DetallesPedidos(DetallesPedidosPK detallesPedidosPK, BigDecimal precioUnidad, short cantidad) {
        this.detallesPedidosPK = detallesPedidosPK;
        this.precioUnidad = precioUnidad;
        this.cantidad = cantidad;
    }

    public DetallesPedidos(int idPedido, short idProducto) {
        this.detallesPedidosPK = new DetallesPedidosPK(idPedido, idProducto);
    }

    public DetallesPedidosPK getDetallesPedidosPK() {
        return detallesPedidosPK;
    }

    public void setDetallesPedidosPK(DetallesPedidosPK detallesPedidosPK) {
        this.detallesPedidosPK = detallesPedidosPK;
    }

    public BigDecimal getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(BigDecimal precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallesPedidosPK != null ? detallesPedidosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallesPedidos)) {
            return false;
        }
        DetallesPedidos other = (DetallesPedidos) object;
        if ((this.detallesPedidosPK == null && other.detallesPedidosPK != null) || (this.detallesPedidosPK != null && !this.detallesPedidosPK.equals(other.detallesPedidosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DetallesPedidos[ detallesPedidosPK=" + detallesPedidosPK + " ]";
    }
    
}
