/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Reservas;
import java.sql.*;
import bd.ConnectionDB;
import java.sql.Date;



public class ReservasDAO implements BDOperationss{
    
    @Override
    public List<Reservas> getAll() {
        List<Reservas> lista = new ArrayList<>();
        String sql = "SELECT * FROM reservas";
        try (Connection con = ConnectionDB.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Reservas reserva = new Reservas(
                        rs.getInt("id_reserva"),
                        rs.getInt("id_huesped"),
                        rs.getInt("id_habitacion"),
                        rs.getDate("fecha_entrada"),
                        rs.getDate("fecha_salida")
                );
                lista.add(reserva);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar reservas: " + e.getMessage());
        }
        return lista;
    }
    
   
      @Override
    public boolean insert(Object object){               
        Reservas reservas = (Reservas) object;
        String sql = "INSERT INTO reservas (id_huesped, id_habitacion, fecha_entrada, fecha_salida) VALUES (?, ?, ?, ?)" ;
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, reservas.getId_huesped());
            pst.setInt(2, reservas.getId_habitacion());
            pst.setDate(3, reservas.getFecha_entrada());
            pst.setDate(4, reservas.getFecha_salida());
            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al insertar huesped: " + e.getMessage());
            return false;
        }     
    }

    @Override
    public boolean update(Object object) {
    Reservas reservas = (Reservas) object;
        
        String sql = "UPDATE reservas SET id_huesped=?, id_habitacion=?, fecha_entrada=?, fecha_salida=? WHERE id_reserva=?" ;
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, reservas.getId_huesped());
            pst.setInt(2, reservas.getId_habitacion());
            pst.setDate(3, reservas.getFecha_entrada());
            pst.setDate(4, reservas.getFecha_salida());
            pst.setInt(5, reservas.getId_reserva());
            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al actualizar huesped: " + e.getMessage());
            return false;
        }     
    }

    @Override
public boolean delete(int id_reserva){               
        String sql = "DELETE FROM reservas WHERE id_reserva=?";
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id_reserva);            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al eliminar huesped: " + e.getMessage());
            return false;
        }     
    }

  public Object getById(int id_reserva) {
        Reservas reservaa = new Reservas();
        String sql = "SELECT * FROM reservas Where id_reserva = ?";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id_reserva);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reservaa.setId_reserva(rs.getInt("id_reserva"));
                reservaa.setId_huesped(rs.getInt("id_huesped"));
                reservaa.setId_habitacion(rs.getInt("id_habitacion"));
                reservaa.setFecha_entrada(rs.getDate("fecha_entrada"));
                reservaa.setFecha_salida(rs.getDate("fecha_salida"));
            }

        } catch (SQLException e) {
            System.err.println("Error al listar reservas: " + e.getMessage());
        }
        return reservaa;
    }
  
    
}


   



