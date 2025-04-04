/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bd.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HuespeddDAO {
    
    public List<Integer> getAllHuespedIds() {
        List<Integer> ids = new ArrayList<>();
        String sql = "SELECT id_huesped FROM huespedes";
        try (Connection con = ConnectionDB.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ids.add(rs.getInt("id_huesped"));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener IDs de huéspedes: " + e.getMessage());
        }
        return ids;
    }
}
