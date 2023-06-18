package com.sistemacobromensualidad.modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final IntegerProperty documento; 
    private final StringProperty nombre;
    private final StringProperty appat;
    private final StringProperty apmat;
    private final StringProperty fecha;
    private final StringProperty direccion;
    private final IntegerProperty telefono;
    
    /**
     * Constructor por defecto
     */
    public Student(){
        this(null,null,null);
    }
    
    /**
     * Constructor con algunos datos inciales
     * 
     * @param nombre
     * @param appat
     * @param apmat
     */
    public Student(String nombre, String appat, String apmat){
        this.nombre = new SimpleStringProperty(nombre);
        this.appat = new SimpleStringProperty(appat);
        this.apmat = new SimpleStringProperty(apmat);
        
        //Algunos datos inciales por conveniencia
        this.direccion = new SimpleStringProperty("Alguna direccion");
        this.telefono = new SimpleIntegerProperty(1564651);
        this.documento = new SimpleIntegerProperty(777777);
        this.fecha = new SimpleStringProperty("05/12/2011");
    }

    public IntegerProperty DocumentoProperty() {
        return documento;
    }
    public void setDocumento (int documento){
        this.documento.set(documento);
    }
    public int getDocumento(){
        return documento.get();
    }
    

    public StringProperty NombreProperty() {
        return nombre;
    }
    public void setNombre (String nombre){
        this.nombre.set(nombre);
    }
    public String getNombre(){
        return nombre.get();
    }
    

    public StringProperty AppatProperty() {
        return appat;
    }
    public void setAppat (String appat){
        this.appat.set(appat);
    }
    public String getAppat(){
        return appat.get();
    }
    

    public StringProperty ApmatProperty() {
        return apmat;
    }
    public void setApmat (String apmat){
        this.apmat.set(apmat);
    }
    public String getApmat(){
        return apmat.get();
    }
    

    public StringProperty FechaProperty() {
        return fecha;
    }
    public void setFecha (String fecha){
        this.fecha.set(fecha);
    }
    public String getFecha(){
        return fecha.get();
    }
    

    public StringProperty DireccionProperty() {
        return direccion;
    }
    public void setDireccion (String direccion){
        this.direccion.set(direccion);
    }
    public String getDireccion(){
        return direccion.get();
    }
    

    public IntegerProperty TelefonoProperty() {
        return telefono;
    }
    public void setTelefono (int telefono){
        this.telefono.set(telefono);
    }
    public int getTelefono(){
        return telefono.get();
    }
}
