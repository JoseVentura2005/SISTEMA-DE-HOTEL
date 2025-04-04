/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Ventu
 */
public class Reservas {
    
 
    int id_reserva;
    int id_huesped;
    int id_habitacion;
    Date fecha_entrada;
    Date fecha_salida;

    public Reservas() {
    }

    public Reservas(int id_reserva, int id_huesped, int id_habitacion, Date fecha_entrada, Date fecha_salida) {
        this.id_reserva = id_reserva;
        this.id_huesped = id_huesped;
        this.id_habitacion = id_habitacion;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
    }

    public int getId_huesped() {
        return id_huesped;
    }

    public void setId_huesped(int id_huesped) {
        this.id_huesped = id_huesped;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
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

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id_reserva;
        hash = 59 * hash + this.id_huesped;
        hash = 59 * hash + this.id_habitacion;
        hash = 59 * hash + Objects.hashCode(this.fecha_entrada);
        hash = 59 * hash + Objects.hashCode(this.fecha_salida);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reservas other = (Reservas) obj;
        if (this.id_reserva != other.id_reserva) {
            return false;
        }
        if (this.id_huesped != other.id_huesped) {
            return false;
        }
        if (this.id_habitacion != other.id_habitacion) {
            return false;
        }
        if (!Objects.equals(this.fecha_entrada, other.fecha_entrada)) {
            return false;
        }
        return Objects.equals(this.fecha_salida, other.fecha_salida);
    }
}

