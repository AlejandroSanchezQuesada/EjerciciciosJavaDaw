/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preexamen2;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexk
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByIdCliente", query = "SELECT c FROM Clientes c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Clientes.findByNombreCompany", query = "SELECT c FROM Clientes c WHERE c.nombreCompany = :nombreCompany")
    , @NamedQuery(name = "Clientes.findByNombreContacto", query = "SELECT c FROM Clientes c WHERE c.nombreContacto = :nombreContacto")
    , @NamedQuery(name = "Clientes.findByCargoContacto", query = "SELECT c FROM Clientes c WHERE c.cargoContacto = :cargoContacto")
    , @NamedQuery(name = "Clientes.findByDireccion", query = "SELECT c FROM Clientes c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Clientes.findByCiudad", query = "SELECT c FROM Clientes c WHERE c.ciudad = :ciudad")
    , @NamedQuery(name = "Clientes.findByRegion", query = "SELECT c FROM Clientes c WHERE c.region = :region")
    , @NamedQuery(name = "Clientes.findByCodPostal", query = "SELECT c FROM Clientes c WHERE c.codPostal = :codPostal")
    , @NamedQuery(name = "Clientes.findByPais", query = "SELECT c FROM Clientes c WHERE c.pais = :pais")
    , @NamedQuery(name = "Clientes.findByTelefono", query = "SELECT c FROM Clientes c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Clientes.findByFax", query = "SELECT c FROM Clientes c WHERE c.fax = :fax")
    , @NamedQuery(name = "Clientes.findBySaldo", query = "SELECT c FROM Clientes c WHERE c.saldo = :saldo")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdCliente")
    private String idCliente;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Saldo")
    private BigDecimal saldo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<Pedidos> pedidosCollection;

    public Clientes() {
    }

    public Clientes(String idCliente) {
        this.idCliente = idCliente;
    }

    public Clientes(String idCliente, String nombreCompany) {
        this.idCliente = idCliente;
        this.nombreCompany = nombreCompany;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
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

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @XmlTransient
    public Collection<Pedidos> getPedidosCollection() {
        return pedidosCollection;
    }

    public void setPedidosCollection(Collection<Pedidos> pedidosCollection) {
        this.pedidosCollection = pedidosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "preexamen2.Clientes[ idCliente=" + idCliente + " ]";
    }
    
}
