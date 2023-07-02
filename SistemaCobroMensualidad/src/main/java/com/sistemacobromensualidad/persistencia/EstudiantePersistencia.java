package com.sistemacobromensualidad.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstudiantePersistencia {
    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fnacimiento;
    private Integer grado;
    private String direccion;
    private Integer genero;
    private char seccion;

    public EstudiantePersistencia(String dni, String nombres, String apellidoPaterno, String apellidoMaterno, String fnacimiento, Integer grado, String direccion, Integer genero, char seccion) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fnacimiento = fnacimiento;
        this.grado = grado;
        this.direccion = direccion;
        this.genero = genero;
        this.seccion = seccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    public String getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(String fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getGenero() {
        return genero;
    }

    public void setGenero(Integer genero) {
        this.genero = genero;
    }

    public char getSeccion() {
        return seccion;
    }

    public void setSeccion(char seccion) {
        this.seccion = seccion;
    }
    
    // Metodos de la base de datos
    
    // Insertar en la base de datos
    public Boolean InsertarEstudiante(){
        String url = "jdbc:mysql://localhost:3306/cobros";
        String usuario = "root";
        String contraseña = "";
        //conexion 
        try (Connection connection = DriverManager.getConnection(url, usuario, contraseña)) {
                String sql = "INSERT INTO personas (dni, nombres, apellidoPaterno, apellidoMaterno ,fnacimiento, grado, direccion, genero, seccion) "
                        + "VALUES (?, ?, ?, ?, ?, ?,?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, dni);
                    statement.setString(2, nombres);
                    statement.setString(3, apellidoPaterno);
                    statement.setString(4, apellidoMaterno);
                    statement.setString(5, fnacimiento);
                    statement.setString(6, String.valueOf(grado));
                    statement.setString(7, direccion);
                    statement.setString(8, String.valueOf(genero));
                    statement.setString(9, apellidoPaterno);

                    int filasAfectadas = statement.executeUpdate();
                    if (filasAfectadas > 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } catch (SQLException e) {
                return false;
        }
    }
}

   
