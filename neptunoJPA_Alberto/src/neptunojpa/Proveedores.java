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
@Table(name = "Proveedores")
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

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdProveedor")
    private Integer idProveedor;
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

    public Proveedores() {
    }

    public Proveedores(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreCompany() {
        return nombreCompany;
    }

    public void setNombreCompany(String nombreCompany) {
        this.nombreCompany = nombreCompany;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getCargoContacto() {
        return cargoContacto;
    }

    public void setCargoContacto(String cargoContacto) {
        this.cargoContacto = cargoContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPaginaPrincipal() {
        return paginaPrincipal;
    }

    public void setPaginaPrincipal(String paginaPrincipal) {
        this.paginaPrincipal = paginaPrincipal;
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
    
}
