/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neptunojpa;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexk
 */
@Entity
@Table(name = "categorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c")
    , @NamedQuery(name = "Categorias.findByIdCategoria", query = "SELECT c FROM Categorias c WHERE c.idCategoria = :idCategoria")
    , @NamedQuery(name = "Categorias.findByNombreCategoria", query = "SELECT c FROM Categorias c WHERE c.nombreCategoria = :nombreCategoria")
    , @NamedQuery(name = "Categorias.findByDescripcion", query = "SELECT c FROM Categorias c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Categorias.findByImagen", query = "SELECT c FROM Categorias c WHERE c.imagen = :imagen")})
public class Categorias implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdCategoria")
    private Short idCategoria;
    @Basic(optional = false)
    @Column(name = "NombreCategoria")
    private String nombreCategoria;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Imagen")
    private String imagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria")
    private Collection<Productos> productosCollection;

    public Categorias() {
    }

    public Categorias(Short idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categorias(Short idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public Short getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Short idCategoria) {
        Short oldIdCategoria = this.idCategoria;
        this.idCategoria = idCategoria;
        changeSupport.firePropertyChange("idCategoria", oldIdCategoria, idCategoria);
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        String oldNombreCategoria = this.nombreCategoria;
        this.nombreCategoria = nombreCategoria;
        changeSupport.firePropertyChange("nombreCategoria", oldNombreCategoria, nombreCategoria);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String oldDescripcion = this.descripcion;
        this.descripcion = descripcion;
        changeSupport.firePropertyChange("descripcion", oldDescripcion, descripcion);
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        String oldImagen = this.imagen;
        this.imagen = imagen;
        changeSupport.firePropertyChange("imagen", oldImagen, imagen);
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorias)) {
            return false;
        }
        Categorias other = (Categorias) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "neptunojpa.Categorias[ idCategoria=" + idCategoria + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
