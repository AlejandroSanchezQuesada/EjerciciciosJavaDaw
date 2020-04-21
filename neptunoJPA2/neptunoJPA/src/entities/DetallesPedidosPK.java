/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author alumno
 */
@Embeddable
public class DetallesPedidosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "IdPedido")
    private int idPedido;
    @Basic(optional = false)
    @Column(name = "IdProducto")
    private short idProducto;

    public DetallesPedidosPK() {
    }

    public DetallesPedidosPK(int idPedido, short idProducto) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public short getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(short idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPedido;
        hash += (int) idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallesPedidosPK)) {
            return false;
        }
        DetallesPedidosPK other = (DetallesPedidosPK) object;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DetallesPedidosPK[ idPedido=" + idPedido + ", idProducto=" + idProducto + " ]";
    }
    
}
