/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neptunojpa;

import java.io.Serializable;
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
@Table(name = "DetallesPedidos")
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
    @Column(name = "PrecioUnidad")
    private Float precioUnidad;
    @Column(name = "Cantidad")
    private Integer cantidad;
    @Column(name = "Descuento")
    private Float descuento;
    @JoinColumn(name = "IdPedido", referencedColumnName = "IdPedido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedidos pedidos;

    public DetallesPedidos() {
    }

    public DetallesPedidos(DetallesPedidosPK detallesPedidosPK) {
        this.detallesPedidosPK = detallesPedidosPK;
    }

    public DetallesPedidos(int idPedido, int idProducto) {
        this.detallesPedidosPK = new DetallesPedidosPK(idPedido, idProducto);
    }

    public DetallesPedidosPK getDetallesPedidosPK() {
        return detallesPedidosPK;
    }

    public void setDetallesPedidosPK(DetallesPedidosPK detallesPedidosPK) {
        this.detallesPedidosPK = detallesPedidosPK;
    }

    public Float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(Float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
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
        return "neptunojpa.DetallesPedidos[ detallesPedidosPK=" + detallesPedidosPK + " ]";
    }
    
}
