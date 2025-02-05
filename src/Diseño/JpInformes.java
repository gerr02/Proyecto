/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Diseño;

import DAO.EventoDAO;
import Entidades.Anual;
import Entidades.Evento;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pieri
 */
public class JpInformes extends javax.swing.JPanel {
    EventoDAO e1 = new EventoDAO();
    Calendar fecha = new GregorianCalendar();                                                  
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        
    
    /**
     * Creates new form JpInformes
     */
    public JpInformes() throws Exception {
        initComponents();
        llenarTablaEventos();
    }
    
    public void CentrarDatosPagos(JTable tb){
        DefaultTableCellRenderer cabecera = (DefaultTableCellRenderer) tb.getTableHeader().getDefaultRenderer();
        cabecera.setHorizontalAlignment(SwingConstants.CENTER);
        
        DefaultTableCellRenderer Cuerpo = new DefaultTableCellRenderer();
        Cuerpo.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int i=0; i<tb.getColumnCount(); i++){
            tb.getColumnModel().getColumn(i).setCellRenderer(Cuerpo);
        }
        
        tb.setRowHeight(20);
    }
    
    private void modeloTablaPagos( ArrayList Eventos){
        DefaultTableModel tabla1 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int colum){
                return false;
            }
        };
        
        tabla1.setRowCount(Eventos.size());
        tabla1.addColumn("DNI");
        tabla1.addColumn("Organizador");
        tabla1.addColumn("Evento");
        tabla1.addColumn("F. Evento");
        tabla1.addColumn("F.Reservación");
        tabla1.addColumn("Precio");
        
        for (int i=0; i<Eventos.size(); i++){
            Evento b = (Evento) Eventos.get(i);
            tabla1.setValueAt(b.getDniOrg(), i,0);
            tabla1.setValueAt(b.getNombreOrg(), i, 1);
            tabla1.setValueAt(b.getNombreEvento(), i, 2);
            tabla1.setValueAt(b.getFechaEvento(), i, 3);
            tabla1.setValueAt(b.getFechaIngreso(), i, 4);
            tabla1.setValueAt(b.getPrecioEvento(), i, 5);
        }
        
        tblEventos.setModel(tabla1);
        CentrarDatosPagos(tblEventos);
    }
    
    public void llenarTablaEventos() throws Exception{
        ArrayList<Evento> lista1 ;
        lista1 = e1.listaEventos(mes+1,año);
        modeloTablaPagos(lista1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEventos = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 51, 153));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("EVENTOS REGISTRADOS");

        tblEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblEventos);

        btnActualizar.setBackground(new java.awt.Color(0, 102, 102));
        btnActualizar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.setFocusPainted(false);
        btnActualizar.setFocusable(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(424, 424, 424)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        try {
            llenarTablaEventos();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEventos;
    // End of variables declaration//GEN-END:variables
}
