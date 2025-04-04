
package dto;


public class HabitacionesDTO {
    
      private int idHabitacion;
    private String tipo;
    private double precio;
    
   

    public HabitacionesDTO(int idHabitacion, String tipo, double precio) {
        this.idHabitacion = idHabitacion;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    
}
