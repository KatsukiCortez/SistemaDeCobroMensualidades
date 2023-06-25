package com.sistemacobromensualidad.entidades;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(catalog = "openjpa", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Estudiante.seleccionaTodos", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.seleccionaPorId", query = "SELECT e FROM Estudiante e WHERE e.estudianteId = :estudianteId"),
    @NamedQuery(name = "Estudiante.seleccionaPorApellidos", query = "SELECT e FROM Estudiante e WHERE e.apellidos = :apellidos")})

public class Estudiante implements Serializable{
    
    private static long serialVersionUID = 1L;
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
    
    public Estudiante(String snombre, String apPaterno, String apMaterno){
        this.nombre = snombre;
        this.apellidoPaterno = apPaterno;
        this.apellidoMaterno = apMaterno;
        this.direccion = "direccion S/N";
        this.fechaNacimiento = new Date(2005, 06, 15);
        this.telefono = "999999999";
    }
    
    public Estudiante(Integer estudianteid){
        this.estudianteId = estudianteid;
    }
    
    /**
     * @return the estudianteId
     */
    public Integer getEstudianteId() {
        return estudianteId;
    }

    /**
     * @param estudianteId the estudianteId to set
     */
    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
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
    }
}
