/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Diseño;

import javax.swing.JOptionPane;

/**
 *
 * @author pieri
 */
public class frmBannerPago extends javax.swing.JFrame {
    
    JpTablaControl tabla = new JpTablaControl();
    JpPagos agregar =  new JpPagos();
    EditarAd editar = new EditarAd();
    JpEliminarAd eliminar= new JpEliminarAd();
    JpReporteP pagosM = new JpReporteP();
    

    /**
     * Creates new form frmBannerAdmi
     */
    public frmBannerPago() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("LA CASA DEL MAESTRO");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Main.add(tabla);
        Main.add(agregar);
        Main.add(editar);
        Main.add(eliminar);
        Main.add(pagosM);
        
        tabla.setVisible(false);
        agregar.setVisible(false);
        editar.setVisible(false);
        eliminar.setVisible(false);
        pagosM.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnLista = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnPagos = new javax.swing.JButton();
        Main = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setName(""); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 60));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar.setBackground(new java.awt.Color(0, 51, 102));
        btnAgregar.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pago.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorderPainted(false);
        btnAgregar.setFocusPainted(false);
        btnAgregar.setFocusable(false);
        btnAgregar.setMaximumSize(new java.awt.Dimension(106, 39));
        btnAgregar.setMinimumSize(new java.awt.Dimension(106, 39));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        btnLista.setBackground(new java.awt.Color(0, 51, 102));
        btnLista.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        btnLista.setForeground(new java.awt.Color(255, 255, 255));
        btnLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clientes.png"))); // NOI18N
        btnLista.setText("Control");
        btnLista.setBorderPainted(false);
        btnLista.setFocusPainted(false);
        btnLista.setFocusable(false);
        btnLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaActionPerformed(evt);
            }
        });
        jPanel2.add(btnLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        btnSalir.setBackground(new java.awt.Color(0, 51, 102));
        btnSalir.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/exit.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorderPainted(false);
        btnSalir.setFocusPainted(false);
        btnSalir.setFocusable(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, -1, -1));

        btnBorrar.setBackground(new java.awt.Color(0, 51, 102));
        btnBorrar.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.setBorderPainted(false);
        btnBorrar.setFocusPainted(false);
        btnBorrar.setFocusable(false);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        btnPagos.setBackground(new java.awt.Color(0, 51, 102));
        btnPagos.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        btnPagos.setForeground(new java.awt.Color(255, 255, 255));
        btnPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Balance.png"))); // NOI18N
        btnPagos.setText("Reporte");
        btnPagos.setBorderPainted(false);
        btnPagos.setFocusPainted(false);
        btnPagos.setFocusable(false);
        btnPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagosActionPerformed(evt);
            }
        });
        jPanel2.add(btnPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 60));

        Main.setBackground(new java.awt.Color(255, 255, 255));
        Main.setLayout(new java.awt.CardLayout());
        getContentPane().add(Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1000, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        tabla.setVisible(false);
        agregar.setVisible(true);
        editar.setVisible(false);
        eliminar.setVisible(false);
        pagosM.setVisible(false);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaActionPerformed
        // TODO add your handling code here:
        tabla.setVisible(true);
        agregar.setVisible(false);
        editar.setVisible(false);
        eliminar.setVisible(false);
        pagosM.setVisible(false);
    }//GEN-LAST:event_btnListaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        String botones [] = {"Salir","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Desea salir?", "La casa del maestro", 0, 0, null, botones, this);
        if(eleccion==JOptionPane.YES_OPTION){
            frmSelect fSel = new frmSelect();
            fSel.setVisible(true);
            this.dispose();
        }else{
            JpNuevo JpN = new JpNuevo();
            JpN.setVisible(true);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
        // TODO add your handling code here:
        tabla.setVisible(false);
        agregar.setVisible(false);
        editar.setVisible(false);
        eliminar.setVisible(false);
        pagosM.setVisible(true);
    }//GEN-LAST:event_btnPagosActionPerformed

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
            java.util.logging.Logger.getLogger(frmBannerPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBannerPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBannerPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBannerPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBannerPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Main;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnLista;
    private javax.swing.JButton btnPagos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
