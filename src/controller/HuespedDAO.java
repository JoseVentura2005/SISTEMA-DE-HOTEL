/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.util.ArrayList;
import java.util.List;
import model.Huespedes;
import java.sql.*;
import bd.ConnectionDB;

public class HuespedDAO implements BDOperations {
    
    
    @Override
    public List<Object> getAll(){
        List<Object> lista = new ArrayList<>();
        String sql = "SELECT * FROM huespedes";
        try (Connection con = ConnectionDB.getConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                lista.add(new Huespedes(
                        rs.getInt("id_huesped"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono")
                       
                ));
            }           
            
        }catch(SQLException e){
            System.err.println("Error al listar huespedes: " + e.getMessage());
        }     
        return lista;
    }
    
     @Override
    public boolean insert(Object object){               
        Huespedes huespedd = (Huespedes) object;
        String sql = "INSERT INTO huespedes (nombre, email, telefono) VALUES (?, ?, ?)" ;
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, huespedd.getNombre());
            pst.setString(2, huespedd.getEmail());
            pst.setString(3, huespedd.getTelefono());
            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al insertar huesped: " + e.getMessage());
            return false;
        }     
    }
    
     @Override
    public boolean update(Object object){ 
        Huespedes huesped = (Huespedes) object;
        
        String sql = "UPDATE huespedes SET nombre=?, email=?, telefono=? WHERE id_huesped=?" ;
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, huesped.getNombre());
            pst.setString(2, huesped.getEmail());
            pst.setString(3, huesped.getTelefono());
            pst.setInt(4, huesped.getIdHuesped());
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al actualizar huesped: " + e.getMessage());
            return false;
        }     
    }
    
     public boolean delete(int id_huesped){               
        String sql = "DELETE FROM huespedes WHERE id_huesped=?";
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id_huesped);            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al eliminar huesped: " + e.getMessage());
            return false;
        }     
    }
     
     public Object getById(int id_huesped) {
        Huespedes huesped = new Huespedes();
        String sql = "SELECT * FROM huespedes Where id_huesped = ?";
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_huesped);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){                
                huesped.setIdHuesped(rs.getInt("id_huesped"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setEmail(rs.getString("email"));
                huesped.setTelefono(rs.getString("telefono")); 
                
            }           
            
        }catch(SQLException e){
            System.err.println("Error al listar huespedes: " + e.getMessage());
        }     
        return huesped;
  
    
}
}

