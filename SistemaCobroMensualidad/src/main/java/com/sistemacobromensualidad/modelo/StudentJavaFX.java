package com.sistemacobromensualidad.modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentJavaFX {
    private final StringProperty dni;
    private final StringProperty nombre;
    private final StringProperty appat;
    private final StringProperty apmat;
    private final StringProperty fecha;
    private final StringProperty direccion;
    private final IntegerProperty genero;
    private final IntegerProperty grado;
    private final StringProperty seccion;
    
    /**
     * Constructor por defecto
     */
    public StudentJavaFX(){
        this(null, null, null, null, null, null, null, null, null);
    }
    
    /**
     * Constructor con algunos datos iniciales
     * 
     * @param dni
     * @param nombre
     * @param appat
     * @param apmat
     * @param fecha
     * @param direccion
     * @param genero
     * @param grado
     * @param seccion
     */
    //StudentJavaFX estudiante = new StudentJavaFX(dni, nombres, apellidoPaterno, apellidoMaterno, fnacimiento, grado, direccion, genero, String.valueOf(seccion));
    
    public StudentJavaFX(String dni, String nombre, String appat, String apmat, String fecha,
                         String direccion, Integer genero, Integer grado, String seccion){
        this.dni = new SimpleStringProperty(dni);
        this.nombre = new SimpleStringProperty(nombre);
        this.appat = new SimpleStringProperty(appat);
        this.apmat = new SimpleStringProperty(apmat);
        this.fecha = new SimpleStringProperty(fecha);
        this.direccion = new SimpleStringProperty(direccion);
        this.genero = new SimpleIntegerProperty(genero);
        this.grado = new SimpleIntegerProperty(grado);
        this.seccion = new SimpleStringProperty(seccion);
    }

    // Métodos getter y setter para cada propiedad
    
    public String getDni() {
        return dni.get();
    }

    public void setDni(String dni) {
        this.dni.set(dni);
    }

    public StringProperty dniProperty() {
        return dni;
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public String getAppat() {
        return appat.get();
    }

    public void setAppat(String appat) {
        this.appat.set(appat);
    }

    public StringProperty appatProperty() {
        return appat;
    }

    public String getApmat() {
        return apmat.get();
    }

    public void setApmat(String apmat) {
        this.apmat.set(apmat);
    }

    public StringProperty apmatProperty() {
        return apmat;
    }

    public String getFecha() {
        return fecha.get();
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public StringProperty fechaProperty() {
        return fecha;
    }

    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }

    public StringProperty direccionProperty() {
        return direccion;
    }

    public Integer getGenero() {
        return genero.get();
    }

    public void setGenero(Integer genero) {
        this.genero.set(genero);
    }

    public IntegerProperty generoProperty() {
        return genero;
    }

    public Integer getGrado() {
        return grado.get();
    }

    public void setGrado(Integer grado) {
        this.grado.set(grado);
    }

    public IntegerProperty gradoProperty() {
        return grado;
    }

    public String getSeccion() {
        return seccion.get();
    }

    public void setSeccion(String seccion) {
        this.seccion.set(seccion);
    }

    public StringProperty seccionProperty() {
        return seccion;
    }
}


