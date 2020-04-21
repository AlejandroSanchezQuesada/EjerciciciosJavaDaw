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
@Table(name = "CompanyEnvios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompanyEnvios.findAll", query = "SELECT c FROM CompanyEnvios c")
    , @NamedQuery(name = "CompanyEnvios.findByIdCompanyEnvios", query = "SELECT c FROM CompanyEnvios c WHERE c.idCompanyEnvios = :idCompanyEnvios")
    , @NamedQuery(name = "CompanyEnvios.findByNombreCompany", query = "SELECT c FROM CompanyEnvios c WHERE c.nombreCompany = :nombreCompany")
    , @NamedQuery(name = "CompanyEnvios.findByTelefono", query = "SELECT c FROM CompanyEnvios c WHERE c.telefono = :telefono")})
public class CompanyEnvios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdCompanyEnvios")
    private Integer idCompanyEnvios;
    @Column(name = "NombreCompany")
    private String nombreCompany;
    @Column(name = "Telefono")
    private String telefono;

    public CompanyEnvios() {
    }

    public CompanyEnvios(Integer idCompanyEnvios) {
        this.idCompanyEnvios = idCompanyEnvios;
    }

    public Integer getIdCompanyEnvios() {
        return idCompanyEnvios;
    }

    public void setIdCompanyEnvios(Integer idCompanyEnvios) {
        this.idCompanyEnvios = idCompanyEnvios;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompanyEnvios != null ? idCompanyEnvios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyEnvios)) {
            return false;
        }
        CompanyEnvios other = (CompanyEnvios) object;
        if ((this.idCompanyEnvios == null && other.idCompanyEnvios != null) || (this.idCompanyEnvios != null && !this.idCompanyEnvios.equals(other.idCompanyEnvios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "neptunojpa.CompanyEnvios[ idCompanyEnvios=" + idCompanyEnvios + " ]";
    }
    
}
