/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.sql.Date;

public class ReservasDTO {
       
    int id_reserva;
    int id_huesped;
    int id_habitacion;
    Date fecha_entrada;
    Date fecha_salida;

    public ReservasDTO(int id_reserva, int id_huesped, int id_habitacion, Date fecha_entrada, Date fecha_salida) {
        this.id_reserva = id_reserva;
        this.id_huesped = id_huesped;
        this.id_habitacion = id_habitacion;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public int getId_huesped() {
        return id_huesped;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public void setId_huesped(int id_huesped) {
        this.id_huesped = id_huesped;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }
}