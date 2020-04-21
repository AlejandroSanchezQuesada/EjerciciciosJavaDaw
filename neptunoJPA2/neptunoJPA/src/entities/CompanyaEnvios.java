/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alumno
 */
@Entity
@Table(name = "companyaenvios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompanyaEnvios.findAll", query = "SELECT c FROM CompanyaEnvios c")
    , @NamedQuery(name = "CompanyaEnvios.findByIdCompanyaEnvios", query = "SELECT c FROM CompanyaEnvios c WHERE c.idCompanyaEnvios = :idCompanyaEnvios")
    , @NamedQuery(name = "CompanyaEnvios.findByNombreCompany", query = "SELECT c FROM CompanyaEnvios c WHERE c.nombreCompany = :nombreCompany")
    , @NamedQuery(name = "CompanyaEnvios.findByTelefono", query = "SELECT c FROM CompanyaEnvios c WHERE c.telefono = :telefono")})
public class CompanyaEnvios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdCompanyaEnvios")
    private Short idCompanyaEnvios;
    @Basic(optional = false)
    @Column(name = "NombreCompany")
    private String nombreCompany;
    @Column(name = "Telefono")
    private String telefono;
    @OneToMany(mappedBy = "formaEnvio")
    private Collection<Pedidos> pedidosCollection;

    public CompanyaEnvios() {
    }

    public CompanyaEnvios(Short idCompanyaEnvios) {
        this.idCompanyaEnvios = idCompanyaEnvios;
    }

    public CompanyaEnvios(Short idCompanyaEnvios, String nombreCompany) {
        this.idCompanyaEnvios = idCompanyaEnvios;
        this.nombreCompany = nombreCompany;
    }

    public Short getIdCompanyaEnvios() {
        return idCompanyaEnvios;
    }

    public void setIdCompanyaEnvios(Short idCompanyaEnvios) {
        this.idCompanyaEnvios = idCompanyaEnvios;
    }

    public String getNombreCompany() {
        return nombreCompany;
    }

    public void setNombreCompany(String nombreCompany) {
        this.nombreCompany = nombreCompany;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        hash += (idCompanyaEnvios != null ? idCompanyaEnvios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyaEnvios)) {
            return false;
        }
        CompanyaEnvios other = (CompanyaEnvios) object;
        if ((this.idCompanyaEnvios == null && other.idCompanyaEnvios != null) || (this.idCompanyaEnvios != null && !this.idCompanyaEnvios.equals(other.idCompanyaEnvios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCompany;
    }
    
}
