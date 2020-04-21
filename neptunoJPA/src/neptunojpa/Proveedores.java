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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p")
    , @NamedQuery(name = "Proveedores.findByIdProveedor", query = "SELECT p FROM Proveedores p WHERE p.idProveedor = :idProveedor")
    , @NamedQuery(name = "Proveedores.findByNombreCompany", query = "SELECT p FROM Proveedores p WHERE p.nombreCompany = :nombreCompany")
    , @NamedQuery(name = "Proveedores.findByNombreContacto", query = "SELECT p FROM Proveedores p WHERE p.nombreContacto = :nombreContacto")
    , @NamedQuery(name = "Proveedores.findByCargoContacto", query = "SELECT p FROM Proveedores p WHERE p.cargoContacto = :cargoContacto")
    , @NamedQuery(name = "Proveedores.findByDireccion", query = "SELECT p FROM Proveedores p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Proveedores.findByCiudad", query = "SELECT p FROM Proveedores p WHERE p.ciudad = :ciudad")
    , @NamedQuery(name = "Proveedores.findByRegion", query = "SELECT p FROM Proveedores p WHERE p.region = :region")
    , @NamedQuery(name = "Proveedores.findByCodPostal", query = "SELECT p FROM Proveedores p WHERE p.codPostal = :codPostal")
    , @NamedQuery(name = "Proveedores.findByPais", query = "SELECT p FROM Proveedores p WHERE p.pais = :pais")
    , @NamedQuery(name = "Proveedores.findByTelefono", query = "SELECT p FROM Proveedores p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Proveedores.findByFax", query = "SELECT p FROM Proveedores p WHERE p.fax = :fax")
    , @NamedQuery(name = "Proveedores.findByPaginaPrincipal", query = "SELECT p FROM Proveedores p WHERE p.paginaPrincipal = :paginaPrincipal")})
public class Proveedores implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdProveedor")
    private Short idProveedor;
    @Basic(optional = false)
    @Column(name = "NombreCompany")
    private String nombreCompany;
    @Column(name = "NombreContacto")
    private String nombreContacto;
    @Column(name = "CargoContacto")
    private String cargoContacto;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "Ciudad")
    private String ciudad;
    @Column(name = "Region")
    private String region;
    @Column(name = "CodPostal")
    private String codPostal;
    @Column(name = "Pais")
    private String pais;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "Fax")
    private String fax;
    @Column(name = "PaginaPrincipal")
    private String paginaPrincipal;
    @OneToMany(mappedBy = "idProveedor")
    private Collection<Productos> productosCollection;

    public Proveedores() {
    }

    public Proveedores(Short idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedores(Short idProveedor, String nombreCompany) {
        this.idProveedor = idProveedor;
        this.nombreCompany = nombreCompany;
    }

    public Short getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Short idProveedor) {
        Short oldIdProveedor = this.idProveedor;
        this.idProveedor = idProveedor;
        changeSupport.firePropertyChange("idProveedor", oldIdProveedor, idProveedor);
    }

    public String getNombreCompany() {
        return nombreCompany;
    }

    public void setNombreCompany(String nombreCompany) {
        String oldNombreCompany = this.nombreCompany;
        this.nombreCompany = nombreCompany;
        changeSupport.firePropertyChange("nombreCompany", oldNombreCompany, nombreCompany);
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        String oldNombreContacto = this.nombreContacto;
        this.nombreContacto = nombreContacto;
        changeSupport.firePropertyChange("nombreContacto", oldNombreContacto, nombreContacto);
    }

    public String getCargoContacto() {
        return cargoContacto;
    }

    public void setCargoContacto(String cargoContacto) {
        String oldCargoContacto = this.cargoContacto;
        this.cargoContacto = cargoContacto;
        changeSupport.firePropertyChange("cargoContacto", oldCargoContacto, cargoContacto);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        String oldDireccion = this.direccion;
        this.direccion = direccion;
        changeSupport.firePropertyChange("direccion", oldDireccion, direccion);
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        String oldCiudad = this.ciudad;
        this.ciudad = ciudad;
        changeSupport.firePropertyChange("ciudad", oldCiudad, ciudad);
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        String oldRegion = this.region;
        this.region = region;
        changeSupport.firePropertyChange("region", oldRegion, region);
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        String oldCodPostal = this.codPostal;
        this.codPostal = codPostal;
        changeSupport.firePropertyChange("codPostal", oldCodPostal, codPostal);
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        String oldPais = this.pais;
        this.pais = pais;
        changeSupport.firePropertyChange("pais", oldPais, pais);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        String oldTelefono = this.telefono;
        this.telefono = telefono;
        changeSupport.firePropertyChange("telefono", oldTelefono, telefono);
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        String oldFax = this.fax;
        this.fax = fax;
        changeSupport.firePropertyChange("fax", oldFax, fax);
    }

    public String getPaginaPrincipal() {
        return paginaPrincipal;
    }

    public void setPaginaPrincipal(String paginaPrincipal) {
        String oldPaginaPrincipal = this.paginaPrincipal;
        this.paginaPrincipal = paginaPrincipal;
        changeSupport.firePropertyChange("paginaPrincipal", oldPaginaPrincipal, paginaPrincipal);
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
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "neptunojpa.Proveedores[ idProveedor=" + idProveedor + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
