/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;


import controller.HuespedDAO;
import javax.swing.JOptionPane;
import model.Huespedes;


public class FormularioHuespedess extends javax.swing.JDialog {

    /**
     * Creates new form FormularioHuespedess
     */
     private Huespedes huesped;
    private String mode = "";
    private int id_huesped = 0;
    private listado_huespedes parent;
    HuespedDAO dao = new HuespedDAO();
    
  

     public FormularioHuespedess(listado_huespedes parent, boolean modal, String mode, int id_huesped) {
       super(parent, modal);    
        this.parent = parent;
        initComponents();
        
  
        
        this.mode = mode;
        this.id_huesped = id_huesped;
       huesped = new Huespedes();        
        if(mode.equals("UPD") || mode.equals("DLT")){
            huesped = (Huespedes) dao.getById(id_huesped);
            txtNombre.setText(huesped.getNombre());
        }      
        if(mode.equals("INS")){
            btnOperacion.setText("INSERTAR");
        }else if(mode.equals("UPD")){
            btnOperacion.setText("MODIFICAR");
        }else if(mode.equals("DLT")){
            btnOperacion.setText("BORRAR");
        }
        
    }
    
    private boolean validar(){
        if(txtNombre.getText().equals("") || txtNombre.getText().equals(null)){
            JOptionPane.showMessageDialog(parent, "Debe ingresar un nombre", "ERROR DE VALIDACIÓN", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        
        
        
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnOperacion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 270, -1));
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 270, -1));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 270, -1));

        btnOperacion.setText("INSERTAR");
        btnOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperacionActionPerformed(evt);
            }
        });
        getContentPane().add(btnOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        jLabel1.setText("NOMBRE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel2.setText("EMAIL");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel3.setText("TELEFONO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperacionActionPerformed
        if(mode.equals("INS")){
            boolean validacion = validar();
            if(validacion){
                Huespedes huespedd = new Huespedes();
                huespedd.setNombre(txtNombre.getText());
                huespedd.setEmail(txtCorreo.getText());
                huespedd.setTelefono(txtTelefono.getText());
                boolean operacion = dao.insert(huespedd);
                if(operacion){
                    parent.refrescarDatos();
                    this.dispose();
                }
            }
        }
        if(mode.equals("UPD")){
            boolean validacion = validar();
            if(validacion){
                huesped.setNombre(txtNombre.getText());
                huesped.setEmail(txtCorreo.getText());
                huesped.setTelefono(txtTelefono.getText());
                boolean operacion = dao.update(huesped);
                if(operacion){
                    parent.refrescarDatos();
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_btnOperacionActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioHuespedess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioHuespedess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioHuespedess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioHuespedess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 String mode = "INS"; 
            int id_huesped = 0;  
            listado_huespedes parent = new listado_huespedes(); 

                 FormularioHuespedess dialog = new FormularioHuespedess(new listado_huespedes(), true, mode, id_huesped);
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
    private javax.swing.JButton btnOperacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
