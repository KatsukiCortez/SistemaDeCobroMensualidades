package com.sistemacobromensualidad.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/*import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;*/
/*
@Entity
@Table(catalog = "openjpa", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Estudiante.seleccionaTodos", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.seleccionaPorId", query = "SELECT e FROM Estudiante e WHERE e.estudianteId = :estudianteId"),
    @NamedQuery(name = "Estudiante.seleccionaPorApellidos", query = "SELECT e FROM Estudiante e WHERE e.apellidos = :apellidos")})
*/
public class Estudiante implements Serializable{
    
    /*private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    //Documento
    @Column(name = "estudiante_id", nullable = false)
    private Integer estudianteId;
    //Nombres
    @Column(length = 30)
    private String nombre;
    //Apellido paterno
    @Column(length = 60)
    private String apellidoPaterno;
    //Apellido materno
    @Column(length = 60)
    private String apellidoMaterno;
    // Direccion
    @Column(length = 100)
    private String direccion;
    //Fecha de nacimiento
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    //Telefono
    @Column(length = 15)
    private String telefono;
    
    public Estudiante(Integer estudianteid,String snombre, String apPaterno, String apMaterno){
        this.estudianteId = estudianteid;
        this.nombre = snombre;
        this.apellidoPaterno = apPaterno;
        this.apellidoMaterno = apMaterno;
        this.direccion = "direccion S/N";
        this.fechaNacimiento = new Date(2005, 06, 15);
        this.telefono = "999999999";
    }
    
    /*public Estudiante(Integer estudianteid){
        this.estudianteId = estudianteid;
    }*/
   
    /*public Integer getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public boolean equals(Object object){
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.estudianteId == null && other.estudianteId != null) || (this.estudianteId != null && !this.estudianteId.equals(other.estudianteId))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return "com.sistemacobromensualidad.Estudiante[ estudianteId=]" + estudianteId + " ]";
    }*/
}
