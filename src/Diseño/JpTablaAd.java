/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Diseño;

import DAO.PagosDAO;
import DAO.SocioDAO;
import Entidades.Pago;
import Entidades.Socio;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pieri
 */
public class JpTablaAd extends javax.swing.JPanel {
    SocioDAO s1 = new SocioDAO();
    PagosDAO p1 = new PagosDAO();

    /**
     * Creates new form JpTablaAd
     */
    public JpTablaAd() {
        initComponents();
        try {
            llenarTablaSocios();
            llenarTablaPagos();
        } catch (Exception ex) {
            Logger.getLogger(JpTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CentrarDatosSocios(JTable tb){
        DefaultTableCellRenderer cabecera = (DefaultTableCellRenderer) tb.getTableHeader().getDefaultRenderer();
        cabecera.setHorizontalAlignment(SwingConstants.CENTER);
        
        DefaultTableCellRenderer Cuerpo = new DefaultTableCellRenderer();
        Cuerpo.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int i=0; i<tb.getColumnCount(); i++){
            tb.getColumnModel().getColumn(i).setCellRenderer(Cuerpo);
        }
        
        tb.setRowHeight(20);
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
    
    
    private void modeloTablaSocios( ArrayList Socios){
        DefaultTableModel tabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int colum){
                return false;
            }
        };
        
        tabla.setRowCount(Socios.size());
        tabla.addColumn("DNI");
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido Paterno");
        tabla.addColumn("Apellido Materno");
        tabla.addColumn("F.Nacimiento");
        tabla.addColumn("Edad");
        tabla.addColumn("Celular");
        tabla.addColumn("Email");
        tabla.addColumn("Direccion");
        tabla.addColumn("SubAsociados");
        tabla.addColumn("Mensualidad");
        tabla.addColumn("F.Incripcion");
        
        for (int i=0; i<Socios.size(); i++){
            Socio a = (Socio) Socios.get(i);
            tabla.setValueAt(a.getDni(), i,0);
            tabla.setValueAt(a.getNombre(), i, 1);
            tabla.setValueAt(a.getApellidoPaterno(), i, 2);
            tabla.setValueAt(a.getApellidoMaterno(), i, 3);
            tabla.setValueAt(a.getFnacimiento(), i, 4);
            tabla.setValueAt(a.getEdad(), i, 5);
            tabla.setValueAt(a.getCelular(), i, 6);
            tabla.setValueAt(a.getEmail(), i, 7);
            tabla.setValueAt(a.getDireccion(), i, 8);
            tabla.setValueAt(a.getAsociados(), i, 9);
            tabla.setValueAt(a.getMensualidad(), i, 10);
            tabla.setValueAt(a.getFinscripcion(), i, 11);
        }
        
        tblSocios.setModel(tabla);
        CentrarDatosSocios(tblSocios);
    }
    
    
    private void modeloTablaPagos( ArrayList Pagos){
        DefaultTableModel tabla1 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int colum){
                return false;
            }
        };
        
        tabla1.setRowCount(Pagos.size());
        tabla1.addColumn("DNI");
        tabla1.addColumn("F.Inscripción");
        tabla1.addColumn("Monto");
        tabla1.addColumn("Mes");
        tabla1.addColumn("Año");
        tabla1.addColumn("F.Pago");
        
        for (int i=0; i<Pagos.size(); i++){
            Pago b = (Pago) Pagos.get(i);
            tabla1.setValueAt(b.getDniSocio(), i,0);
            tabla1.setValueAt(b.getFechaR(), i, 1);
            tabla1.setValueAt(b.getMonto(), i, 2);
            tabla1.setValueAt(b.getMes(), i, 3);
            tabla1.setValueAt(b.getAño(), i, 4);
            tabla1.setValueAt(b.getFechaPago(), i, 5);
        }
        
        tblPagos.setModel(tabla1);
        CentrarDatosPagos(tblPagos);
    }
    
    
    public void llenarTablaSocios() throws Exception{
        ArrayList<Socio> lista ;
        lista = s1.listaAlumno();
        modeloTablaSocios(lista);
    }
    
    public void llenarTablaPagos() throws Exception{
        ArrayList<Pago> lista1 ;
        lista1 = p1.listaPagos();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSocios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Apellido", "Mensualidad", "Fecha de inscripción", "Celular", "Dirección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPagos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 950, 220));

        jLabel1.setBackground(new java.awt.Color(0, 51, 153));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("LISTA GENERAL DE PAGOS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 51, 153));
        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("LISTA GENERAL DE SOCIOS");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        tblSocios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Apellido", "Mensualidad", "Fecha de inscripción", "Celular", "Dirección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblSocios);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 950, 180));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 50, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            llenarTablaSocios();
            llenarTablaPagos();
            //ValidarTodo();
        } catch (Exception ex) {
            Logger.getLogger(JpTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblPagos;
    private javax.swing.JTable tblSocios;
    // End of variables declaration//GEN-END:variables
}
