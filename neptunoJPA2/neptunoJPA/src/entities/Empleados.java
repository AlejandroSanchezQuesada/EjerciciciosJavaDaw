/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alumno
 */
@Entity
@Table(name = "empleados")
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
    , @NamedQuery(name = "Empleados.findBySalario", query = "SELECT e FROM Empleados e WHERE e.salario = :salario")
    , @NamedQuery(name = "Empleados.findByComision", query = "SELECT e FROM Empleados e WHERE e.comision = :comision")})
public class Empleados implements Serializable {

    @Lob
    @Column(name = "Foto")
    private byte[] foto;

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdEmpleado")
    private Short idEmpleado;
    @Basic(optional = false)
    @Column(name = "Apellidos")
    private String apellidos;
    @Basic(optional = false)
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
    @Lob
    @Column(name = "Notas")
    private String notas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Salario")
    private BigDecimal salario;
    @Column(name = "Comision")
    private Short comision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private Collection<Pedidos> pedidosCollection;
    @OneToMany(mappedBy = "jefe")
    private Collection<Empleados> empleadosCollection;
    @JoinColumn(name = "Jefe", referencedColumnName = "IdEmpleado")
    @ManyToOne
    private Empleados jefe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "IdEmpleado")
    private Collection<entities.Pedidos> pedidosCollection2;

    public Empleados() {
    }

    public Empleados(Short idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleados(Short idEmpleado, String apellidos, String nombre) {
        this.idEmpleado = idEmpleado;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    public Short getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Short idEmpleado) {
        Short oldIdEmpleado = this.idEmpleado;
        this.idEmpleado = idEmpleado;
        changeSupport.firePropertyChange("idEmpleado", oldIdEmpleado, idEmpleado);
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        String oldApellidos = this.apellidos;
        this.apellidos = apellidos;
        changeSupport.firePropertyChange("apellidos", oldApellidos, apellidos);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        String oldCargo = this.cargo;
        this.cargo = cargo;
        changeSupport.firePropertyChange("cargo", oldCargo, cargo);
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        String oldTratamiento = this.tratamiento;
        this.tratamiento = tratamiento;
        changeSupport.firePropertyChange("tratamiento", oldTratamiento, tratamiento);
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        Date oldFechaNacimiento = this.fechaNacimiento;
        this.fechaNacimiento = fechaNacimiento;
        changeSupport.firePropertyChange("fechaNacimiento", oldFechaNacimiento, fechaNacimiento);
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        Date oldFechaContratacion = this.fechaContratacion;
        this.fechaContratacion = fechaContratacion;
        changeSupport.firePropertyChange("fechaContratacion", oldFechaContratacion, fechaContratacion);
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

    public String getTelDomicilio() {
        return telDomicilio;
    }

    public void setTelDomicilio(String telDomicilio) {
        String oldTelDomicilio = this.telDomicilio;
        this.telDomicilio = telDomicilio;
        changeSupport.firePropertyChange("telDomicilio", oldTelDomicilio, telDomicilio);
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        String oldExtension = this.extension;
        this.extension = extension;
        changeSupport.firePropertyChange("extension", oldExtension, extension);
    }


    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        String oldNotas = this.notas;
        this.notas = notas;
        changeSupport.firePropertyChange("notas", oldNotas, notas);
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        BigDecimal oldSalario = this.salario;
        this.salario = salario;
        changeSupport.firePropertyChange("salario", oldSalario, salario);
    }

    public Short getComision() {
        return comision;
    }

    public void setComision(Short comision) {
        Short oldComision = this.comision;
        this.comision = comision;
        changeSupport.firePropertyChange("comision", oldComision, comision);
    }

    @XmlTransient
    public Collection<Pedidos> getPedidosCollection() {
        return pedidosCollection;
    }

    public void setPedidosCollection(Collection<Pedidos> pedidosCollection) {
        this.pedidosCollection = pedidosCollection;
    }

    @XmlTransient
    public Collection<Empleados> getEmpleadosCollection() {
        return empleadosCollection;
    }

    public void setEmpleadosCollection(Collection<Empleados> empleadosCollection) {
        this.empleadosCollection = empleadosCollection;
    }

    public Empleados getJefe() {
        return jefe;
    }

    public void setJefe(Empleados jefe) {
        Empleados oldJefe = this.jefe;
        this.jefe = jefe;
        changeSupport.firePropertyChange("jefe", oldJefe, jefe);
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
        return nombre + " " + apellidos;
    }

    public Collection<entities.Pedidos> getPedidosCollection2() {
        return pedidosCollection2;
    }

    public void setPedidosCollection2(Collection<entities.Pedidos> pedidosCollection2) {
        this.pedidosCollection2 = pedidosCollection2;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
}
