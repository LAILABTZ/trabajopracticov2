/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laila.dao;
import com.laila.config.Conexion;
import com.laila.model.Musica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MusicaDAOImpl implements MusicaDAO{
    
    private Conexion objConexion;
private Connection objConnection;

public MusicaDAOImpl() {
    objConexion = new Conexion();
}

@Override
public List<Musica> findAll() {
    String consulta = "SELECT * FROM musicas";
    List<Musica> listado = new LinkedList<>();

    try {
        this.objConexion.conectar();
        this.objConnection = this.objConexion.getJdbcConnection();

        PreparedStatement prest = this.objConnection.prepareStatement(consulta);
        ResultSet rs = prest.executeQuery();

        Musica objMusica;

        while (rs.next()) {
            objMusica = new Musica();
            objMusica.setId(rs.getInt("id"));
            objMusica.setNombre(rs.getString("nombre"));
            objMusica.setOrigen(rs.getString("origen"));
            objMusica.setPrecio(rs.getString("precio"));
            objMusica.setTipo(rs.getString("tipo"));

            listado.add(objMusica);
        }
    } catch (Exception e) {
        System.out.println("Error en la consulta: " + e);
    }

    return listado;
}

@Override
public Musica insert(Musica objMusica) {
    String consulta = "INSERT INTO musicas (nombre, origen, precio, tipo) VALUES (?,?,?,?)";
    try {
        this.objConexion.conectar();
        this.objConnection = this.objConexion.getJdbcConnection();

        PreparedStatement prest = this.objConnection.prepareStatement(consulta);

        prest.setString(1, objMusica.getNombre());
        prest.setString(2, objMusica.getOrigen());
        prest.setString(3, objMusica.getPrecio());
        prest.setString(4, objMusica.getTipo());

        int count = prest.executeUpdate();

        ResultSet rs = null;
        rs = prest.executeQuery("SELECT LAST_INSERT_ID()");

        int autoKey = -1;
        if (rs.next()) {
            autoKey = rs.getInt(1);
            objMusica.setId(autoKey);
            System.out.println("Último ID insertado: " + autoKey);
        } else {
            System.out.println("No existe dato de ID");
        }

    } catch (Exception e) {
        System.out.println("Error al insertar: " + e);
    }

    return objMusica;
}

@Override
public Musica findById(Integer id) {
    throw new UnsupportedOperationException("Not supported yet.");
}

@Override
public Musica updateById(Integer id, Musica objMusica) {
    throw new UnsupportedOperationException("Not supported yet.");
}

@Override
public Boolean deleteById(Integer id) {
    throw new UnsupportedOperationException("Not supported yet.");
}
}


