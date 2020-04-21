/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicandojdbcjpafinal;

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
 * @author alexk
 */
@Entity
@Table(name = "detallespedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallespedidos.findAll", query = "SELECT d FROM Detallespedidos d")
    , @NamedQuery(name = "Detallespedidos.findByIdPedido", query = "SELECT d FROM Detallespedidos d WHERE d.detallespedidosPK.idPedido = :idPedido")
    , @NamedQuery(name = "Detallespedidos.findByIdProducto", query = "SELECT d FROM Detallespedidos d WHERE d.detallespedidosPK.idProducto = :idProducto")
    , @NamedQuery(name = "Detallespedidos.findByPrecioUnidad", query = "SELECT d FROM Detallespedidos d WHERE d.precioUnidad = :precioUnidad")
    , @NamedQuery(name = "Detallespedidos.findByCantidad", query = "SELECT d FROM Detallespedidos d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detallespedidos.findByDescuento", query = "SELECT d FROM Detallespedidos d WHERE d.descuento = :descuento")})
public class Detallespedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallespedidosPK detallespedidosPK;
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

    public Detallespedidos() {
    }

    public Detallespedidos(DetallespedidosPK detallespedidosPK) {
        this.detallespedidosPK = detallespedidosPK;
    }

    public Detallespedidos(DetallespedidosPK detallespedidosPK, BigDecimal precioUnidad, short cantidad) {
        this.detallespedidosPK = detallespedidosPK;
        this.precioUnidad = precioUnidad;
        this.cantidad = cantidad;
    }

    public Detallespedidos(int idPedido, short idProducto) {
        this.detallespedidosPK = new DetallespedidosPK(idPedido, idProducto);
    }

    public DetallespedidosPK getDetallespedidosPK() {
        return detallespedidosPK;
    }

    public void setDetallespedidosPK(DetallespedidosPK detallespedidosPK) {
        this.detallespedidosPK = detallespedidosPK;
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
        hash += (detallespedidosPK != null ? detallespedidosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallespedidos)) {
            return false;
        }
        Detallespedidos other = (Detallespedidos) object;
        if ((this.detallespedidosPK == null && other.detallespedidosPK != null) || (this.detallespedidosPK != null && !this.detallespedidosPK.equals(other.detallespedidosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "practicandojdbcjpafinal.Detallespedidos[ detallespedidosPK=" + detallespedidosPK + " ]";
    }
    
}
