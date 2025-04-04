/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;
import controller.HabitacionDAO;
import controller.HuespedDAO;
import controller.ReservasDAO;
import model.Habitaciones;
import model.Huespedes;
import model.Reservas;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.sql.Date;
import java.util.List;

public class FormularioReservas extends javax.swing.JDialog {

    Reservas reserva;
    String mode = "";
    int id_reserva = 0;
    listado_reservas parent;
    ReservasDAO reservaDAO = new ReservasDAO();
    HuespedDAO huespedDAO = new HuespedDAO();
    HabitacionDAO habitacionDAO = new HabitacionDAO();
   
    public FormularioReservas(listado_reservas parent, boolean modal, String mode, int id_reserva) {
        
        super(parent, modal);
        this.parent = parent;
        initComponents();
        this.mode = mode;
        this.id_reserva = id_reserva;
        reserva = new Reservas();
        cargarComboBoxes();
        if (mode.equals("UPD") || mode.equals("DLT")) {
            cargarDatosReserva();
        }
        configurarBotonOperacion();
      
    }
    
    
    private void cargarComboBoxHuespedes() {
    List<Object> huespedesObj = huespedDAO.getAll();
    for (Object obj : huespedesObj) {
        if (obj instanceof Huespedes) {
            Huespedes huesped = (Huespedes) obj;
            cbxHuesped.addItem(String.valueOf(huesped.getIdHuesped()));
        } else {
            System.err.println("Objeto no es de tipo Huespedes: " + obj);
        }
    }
}
     private void cargarComboBoxes() {
        cargarComboBoxHuespedes();
        cargarComboBoxHabitaciones();
    }
 

  private void cargarComboBoxHabitaciones() {
    List<Habitaciones> habitaciones = habitacionDAO.getAll();
    for (Habitaciones habitacion : habitaciones) {
        cbxHabitacion.addItem(String.valueOf(habitacion.getIdHabitacion())); 
    }
}

    private void cargarDatosReserva() {
        reserva = (Reservas) reservaDAO.getById(id_reserva);
        if (reserva != null) {
            txtReserva.setText(String.valueOf(reserva.getId_reserva()));
            cbxHuesped.setSelectedItem(reserva.getId_huesped());
            cbxHabitacion.setSelectedItem(reserva.getId_habitacion());
            dateFechaEntrada.setDate(reserva.getFecha_entrada());
            dateFechaSalida.setDate(reserva.getFecha_salida());
        }
    }
    
    private void configurarBotonOperacion() {
        if (mode.equals("INS")) {
            btnGuardar.setText("insertar");
        } else if (mode.equals("UPD")) {
            btnGuardar.setText("Modificar");
        } else if (mode.equals("DLT")) {
            btnGuardar.setText("Borrar");
        }
    }
    
      private boolean validar() {
        if (dateFechaEntrada.getDate() == null || dateFechaSalida.getDate() == null) {
            JOptionPane.showMessageDialog(parent, "Debe ingresar fechas de entrada y salida", "ERROR DE VALIDACIÓN", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
      
        private void insertarReserva() {
        if (validar()) {
            reserva.setId_huesped(Integer.parseInt((String) cbxHuesped.getSelectedItem()));
            reserva.setId_habitacion(Integer.parseInt((String) cbxHabitacion.getSelectedItem()));
            reserva.setFecha_entrada(new Date(dateFechaEntrada.getDate().getTime()));
            reserva.setFecha_salida(new Date(dateFechaSalida.getDate().getTime()));
            if (reservaDAO.insert(reserva)) {
                parent.refrescarDatos();
                this.dispose();
            }
        }
    }
        
    private void actualizarReserva() {
        if (validar()) {
            reserva.setId_huesped(Integer.parseInt((String) cbxHuesped.getSelectedItem()));
            reserva.setId_habitacion(Integer.parseInt((String) cbxHabitacion.getSelectedItem()));
            reserva.setFecha_entrada(new Date(dateFechaEntrada.getDate().getTime()));
            reserva.setFecha_salida(new Date(dateFechaSalida.getDate().getTime()));
            reserva.setId_reserva(id_reserva);
            if (reservaDAO.update(reserva)) {
                parent.refrescarDatos();
                this.dispose();
            }
        }
    }

    private void eliminarReserva() {
        if (reservaDAO.delete(id_reserva)) {
            parent.refrescarDatos();
            this.dispose();
        }
    }
      
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbxHuesped = new javax.swing.JComboBox<>();
        cbxHabitacion = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        txtReserva = new javax.swing.JTextField();
        dateFechaSalida = new com.toedter.calendar.JDateChooser();
        dateFechaEntrada = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxHuesped.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HUESPED_ID" }));
        jPanel1.add(cbxHuesped, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        cbxHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HABITACION_ID", " " }));
        jPanel1.add(cbxHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 120, -1));

        btnGuardar.setText("GUARDAR CAMBIOS");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 180, -1));
        jPanel1.add(txtReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 260, 30));
        jPanel1.add(dateFechaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 210, 100));
        jPanel1.add(dateFechaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 210, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       if (mode.equals("INS")) {
            insertarReserva();
        } else if (mode.equals("UPD")) {
            actualizarReserva();
        } else if (mode.equals("DLT")) {
            eliminarReserva();
        }
       
       
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String mode= "INS";
                int id_reserva= 0;
                listado_reservas parent = new listado_reservas();
                
                FormularioReservas dialog = new FormularioReservas(new listado_reservas(), true, mode, id_reserva);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxHabitacion;
    private javax.swing.JComboBox<String> cbxHuesped;
    private com.toedter.calendar.JDateChooser dateFechaEntrada;
    private com.toedter.calendar.JDateChooser dateFechaSalida;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtReserva;
    // End of variables declaration//GEN-END:variables
}
