/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Ventu
 */
public class HuespedesDTO {
    
    
   private int idHuesped;
    private String nombre;
    private String email;
    private String telefono;

    public HuespedesDTO (int idHuesped, String nombre, String email, String telefono) {
        this.idHuesped = idHuesped;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    
}
   public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdHuesped() {
        return idHuesped;
    }
}