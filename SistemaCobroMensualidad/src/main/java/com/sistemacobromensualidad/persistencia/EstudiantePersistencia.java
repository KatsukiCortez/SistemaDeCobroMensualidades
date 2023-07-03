package com.sistemacobromensualidad.persistencia;

import com.sistemacobromensualidad.modelo.StudentJavaFX;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    private static final String url = "jdbc:mysql://localhost:3307/cobros";
    private static final String usuario = "root";
    private static final String contraseña = "";
    
    public EstudiantePersistencia(){
    }
    
    public EstudiantePersistencia(String dni) {
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
    public boolean InsertarEstudiante() {
    try (Connection connection = DriverManager.getConnection(url, usuario, contraseña)) {
        String sql = "INSERT INTO estudiante (dni, nombres, apellidoPaterno, apellidoMaterno, fnacimiento, grado, direccion, genero, seccion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, dni);
            statement.setString(2, nombres);
            statement.setString(3, apellidoPaterno);
            statement.setString(4, apellidoMaterno);
            statement.setString(5, fnacimiento);
            statement.setInt(6, grado);
            statement.setString(7, direccion);
            statement.setInt(8, genero);
            statement.setString(9, String.valueOf(seccion));
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
    
    public List<StudentJavaFX> obtenerEstudiantes() {
    List<StudentJavaFX> estudiantes = new ArrayList<>();

    try (Connection connection = DriverManager.getConnection(url, usuario, contraseña)) {
        String query = "SELECT dni, nombres, apellidoPaterno, apellidoMaterno, fnacimiento, grado, direccion, genero, seccion FROM estudiante";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String dni = resultSet.getString("dni");
            String nombres = resultSet.getString("nombres");
            String apellidoPaterno = resultSet.getString("apellidoPaterno");
            String apellidoMaterno = resultSet.getString("apellidoMaterno");
            String fnacimiento = resultSet.getString("fnacimiento");
            int grado = resultSet.getInt("grado");
            String direccion = resultSet.getString("direccion");
            int genero = resultSet.getInt("genero");
            String seccion = resultSet.getString("seccion");

            StudentJavaFX estudiante = new StudentJavaFX(dni, nombres, apellidoPaterno, apellidoMaterno, fnacimiento, direccion, grado, genero, String.valueOf(seccion));
            estudiantes.add(estudiante);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return estudiantes;
}

    
}


   
