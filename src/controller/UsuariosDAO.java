/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import org.mindrot.jbcrypt.BCrypt;
import java.util.ArrayList;
import java.util.List;
import model.Usuarios;
import java.sql.*;
import bd.ConnectionDB;

public class UsuariosDAO  {
    public Usuarios getUsuario(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE username = ?";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next() && BCrypt.checkpw(password, rs.getString("password_hash"))) {
                    return new Usuarios(rs.getInt("id"), rs.getString("username"), rs.getString("password_hash"), rs.getString("rol"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // O maneja la excepción de otra manera (por ejemplo, lanzando una excepción personalizada)
        }
        return null; // Retorna null si no encuentra el usuario, la contraseña es incorrecta o ocurre un error
    }

    public boolean registrarUsuario(Usuarios usuario) {
        String sql = "INSERT INTO usuarios (username, password_hash, rol) VALUES (?, ?, ?)";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, usuario.getUsername());
            pst.setString(2, BCrypt.hashpw(usuario.getPasswordHash(), BCrypt.gensalt()));
            pst.setString(3, usuario.getRol());

            return pst.executeUpdate() > 0; // Retorna true si se insertó correctamente
        } catch (SQLException e) {
            e.printStackTrace(); // O maneja la excepción de otra manera (por ejemplo, lanzando una excepción personalizada)
            return false; // Retorna false si ocurre un error
        }
    }

  
}
