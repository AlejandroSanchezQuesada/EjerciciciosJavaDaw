/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neptunojpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alumno
 */
@Entity
@Table(name = "Empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e")
    , @NamedQuery(name = "Empleados.findByIdEmpleado", query = "SELECT e FROM Empleados e WHERE e.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "Empleados.findByApellidos", query = "SELECT e FROM Empleados e WHERE e.apellidos = :apellidos")
    , @NamedQuery(name = "Empleados.findByNombre", query = "SELECT e FROM Empleados e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empleados.findByCargo", query = "SELECT e FROM Empleados e WHERE e.cargo = :cargo")
    , @NamedQuery(name = "Empleados.findByTratamiento", query = "SELECT e FROM Empleados e WHERE e.tratamiento = :tratamiento")
    , @NamedQuery(name = "Empleados.findByFechaNacimiento", query = "SELECT e FROM Empleados e WHERE e.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Empleados.findByFechaContratacion", query = "SELECT e FROM Empleados e WHERE e.fechaContratacion = :fechaContratacion")
    , @NamedQuery(name = "Empleados.findByDireccion", query = "SELECT e FROM Empleados e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Empleados.findByCiudad", query = "SELECT e FROM Empleados e WHERE e.ciudad = :ciudad")
    , @NamedQuery(name = "Empleados.findByRegion", query = "SELECT e FROM Empleados e WHERE e.region = :region")
    , @NamedQuery(name = "Empleados.findByCodPostal", query = "SELECT e FROM Empleados e WHERE e.codPostal = :codPostal")
    , @NamedQuery(name = "Empleados.findByPais", query = "SELECT e FROM Empleados e WHERE e.pais = :pais")
    , @NamedQuery(name = "Empleados.findByTelDomicilio", query = "SELECT e FROM Empleados e WHERE e.telDomicilio = :telDomicilio")
    , @NamedQuery(name = "Empleados.findByExtension", query = "SELECT e FROM Empleados e WHERE e.extension = :extension")
    , @NamedQuery(name = "Empleados.findByFoto", query = "SELECT e FROM Empleados e WHERE e.foto = :foto")
    , @NamedQuery(name = "Empleados.findByNotas", query = "SELECT e FROM Empleados e WHERE e.notas = :notas")
    , @NamedQuery(name = "Empleados.findByJefe", query = "SELECT e FROM Empleados e WHERE e.jefe = :jefe")
    , @NamedQuery(name = "Empleados.findBySalario", query = "SELECT e FROM Empleados e WHERE e.salario = :salario")
    , @NamedQuery(name = "Empleados.findByComision", query = "SELECT e FROM Empleados e WHERE e.comision = :comision")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdEmpleado")
    private Integer idEmpleado;
    @Column(name = "Apellidos")
    private String apellidos;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Cargo")
    private String cargo;
    @Column(name = "Tratamiento")
    private String tratamiento;
    @Column(name = "FechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "FechaContratacion")
    @Temporal(TemporalType.DATE)
    private Date fechaContratacion;
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
    @Column(name = "TelDomicilio")
    private String telDomicilio;
    @Column(name = "Extension")
    private String extension;
    @Column(name = "Foto")
    private String foto;
    @Column(name = "Notas")
    private String notas;
    @Column(name = "Jefe")
    private Integer jefe;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Salario")
    private Float salario;
    @Column(name = "Comision")
    private Integer comision;

    public Empleados() {
    }

    public Empleados(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
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

    public String getTelDomicilio() {
        return telDomicilio;
    }

    public void setTelDomicilio(String telDomicilio) {
        this.telDomicilio = telDomicilio;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Integer getJefe() {
        return jefe;
    }

    public void setJefe(Integer jefe) {
        this.jefe = jefe;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Integer getComision() {
        return comision;
    }

    public void setComision(Integer comision) {
        this.comision = comision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "neptunojpa.Empleados[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
