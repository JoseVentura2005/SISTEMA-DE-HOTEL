/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.HabitacionDAO;
import model.Habitaciones;
import javax.swing.JOptionPane;

public class FormularioHabitaciones extends javax.swing.JDialog {

   Habitaciones habitaciones;
    String mode = "";
    int id_habitacion = 0;
    listado_habitaciones parent;
    HabitacionDAO habitacionDAO = new HabitacionDAO();
    
    public FormularioHabitaciones(listado_habitaciones parent, boolean modal, String mode, int id_habitacion) {
       
        super(parent, modal);
        this.parent = parent;
         initComponents();
        this.mode = mode;
        this.id_habitacion = id_habitacion;
        habitaciones = new Habitaciones();
        if (mode.equals("INS")) {
            cargarDatosHabitacion();
           
        }
    }
    
     private void cargarDatosHabitacion() {
        habitaciones = (Habitaciones) habitacionDAO.getById(id_habitacion);
        if (habitaciones != null) {
            txtHabitacion.setText(habitaciones.getTipo());
            txtPrecio.setText(String.valueOf(habitaciones.getPrecio()));
        }
    }

   private boolean validar() {
        if (txtHabitacion.getText().isEmpty() || txtPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Debe llenar todos los campos", "ERROR DE VALIDACIÓN", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Double.parseDouble(txtPrecio.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parent, "El precio debe ser un número válido", "ERROR DE VALIDACIÓN", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
   
   private void insertarHabitacion() {
        if (validar()) {
            habitaciones.setTipo(txtHabitacion.getText());
            habitaciones.setPrecio(Double.parseDouble(txtPrecio.getText()));
            if (habitacionDAO.insert(habitaciones)) {
                parent.refrescarDatos();
                this.dispose();
            }
        }
    }

     private void actualizarHabitacion() {
        if (validar()) {
            habitaciones.setIdHabitacion(id_habitacion); 
            habitaciones.setTipo(txtHabitacion.getText());
            habitaciones.setPrecio(Double.parseDouble(txtPrecio.getText()));
            if (habitacionDAO.update(habitaciones)) {
                parent.refrescarDatos();
                this.dispose();
            }
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtHabitacion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("TIPO DE HABITACION");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, -1));

        jLabel2.setText("PRECIO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 110, -1));
        getContentPane().add(txtHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 210, -1));
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 210, -1));

        btnInsertar.setText("INSERTAR");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 190, -1));

        jPanel1.setBackground(new java.awt.Color(204, 255, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        insertarHabitacion();
    }//GEN-LAST:event_btnInsertarActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                String mode= "INS";
                int id_habitacion= 0;
                listado_habitaciones parent = new listado_habitaciones();
                FormularioHabitaciones dialog = new FormularioHabitaciones(new listado_habitaciones(), true, mode, id_habitacion);
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
    private javax.swing.JButton btnInsertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtHabitacion;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
