/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Habitaciones;
import bd.ConnectionDB;

public class HabitacionDAO implements BDOperationsss {
   @Override
    public List<Habitaciones> getAll() {
        List<Habitaciones> lista = new ArrayList<>();
        String sql = "SELECT * FROM habitaciones";
        try (Connection con = ConnectionDB.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Habitaciones habitacion = new Habitaciones(
                        rs.getInt("id_habitacion"),
                        rs.getString("tipo"),
                        rs.getDouble("precio")
                );
                lista.add(habitacion);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar habitaciones: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean insert(Object object) {
        Habitaciones habitacion = (Habitaciones) object;
        String sql = "INSERT INTO habitaciones (tipo, precio) VALUES (?, ?)";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, habitacion.getTipo());
            pst.setDouble(2, habitacion.getPrecio());

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar habitación: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Object object) {
        Habitaciones habitacion = (Habitaciones) object;
        String sql = "UPDATE habitaciones SET tipo=?, precio=? WHERE id_habitacion=?";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, habitacion.getTipo());
            pst.setDouble(2, habitacion.getPrecio());
            pst.setInt(3, habitacion.getIdHabitacion());

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar habitación: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id_habitacion) {
        String sql = "DELETE FROM habitaciones WHERE id_habitacion=?";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id_habitacion);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar habitación: " + e.getMessage());
            return false;
        }
    }

    public Habitaciones getById(int id_habitacion) {
        Habitaciones habitacion = new Habitaciones();
        String sql = "SELECT * FROM habitaciones WHERE id_habitacion=?";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id_habitacion);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                habitacion.setIdHabitacion(rs.getInt("id_habitacion"));
                habitacion.setTipo(rs.getString("tipo"));
                habitacion.setPrecio(rs.getDouble("precio"));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener habitación por ID: " + e.getMessage());
        }
        return habitacion;
    }
}
