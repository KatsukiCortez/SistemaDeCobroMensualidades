package com.sistemacobromensualidad.entidades;

import java.io.Serializable;

/*@Entity
@Table(catalog = "openjpa", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Persona.seleccionaTodos", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.seleccionaPorId", query = "SELECT p FROM Persona p WHERE p.personaId = :personaId"),
    @NamedQuery(name = "Persona.seleccionaPorApellidos", query = "SELECT p FROM Persona p WHERE p.apellidos = :apellidos")})
*/
public class StudentPersistencia implements Serializable{
    
/*    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    //Documento
    @Column(name = "estudiante_id", nullable = false)
    private Integer estudiante_id;
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
    
    // CORREGIR
    /*
    @OneToMany(mappedBy = "persona")
    private List<Mensaje> listaMensaje;*/
}
