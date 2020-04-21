/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preexamen2;

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
 * @author alexk
 */
@Entity
@Table(name = "companyaenvios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companyaenvios.findAll", query = "SELECT c FROM Companyaenvios c")
    , @NamedQuery(name = "Companyaenvios.findByIdCompanyaEnvios", query = "SELECT c FROM Companyaenvios c WHERE c.idCompanyaEnvios = :idCompanyaEnvios")
    , @NamedQuery(name = "Companyaenvios.findByNombreCompany", query = "SELECT c FROM Companyaenvios c WHERE c.nombreCompany = :nombreCompany")
    , @NamedQuery(name = "Companyaenvios.findByTelefono", query = "SELECT c FROM Companyaenvios c WHERE c.telefono = :telefono")})
public class Companyaenvios implements Serializable {

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

    public Companyaenvios() {
    }

    public Companyaenvios(Short idCompanyaEnvios) {
        this.idCompanyaEnvios = idCompanyaEnvios;
    }

    public Companyaenvios(Short idCompanyaEnvios, String nombreCompany) {
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
        if (!(object instanceof Companyaenvios)) {
            return false;
        }
        Companyaenvios other = (Companyaenvios) object;
        if ((this.idCompanyaEnvios == null && other.idCompanyaEnvios != null) || (this.idCompanyaEnvios != null && !this.idCompanyaEnvios.equals(other.idCompanyaEnvios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "preexamen2.Companyaenvios[ idCompanyaEnvios=" + idCompanyaEnvios + " ]";
    }
    
}
