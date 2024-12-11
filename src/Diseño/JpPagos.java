/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Diseño;

import DAO.PagosDAO;
import DAO.SocioDAO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pieri
 */
public class JpPagos extends javax.swing.JPanel implements Runnable{
    String hora, minutos, segundos;
    Thread hilo;
    SocioDAO s1 = new SocioDAO();
    PagosDAO p1 = new PagosDAO();

    /**
     * Creates new form JpPagos
     */
    public JpPagos() {
        initComponents();
        hilo = new Thread(this);
        hilo.start();
        setVisible(true);
        setVisible(true);
    }
    
    public void hora() {
        Calendar calendario = new GregorianCalendar();
        Date horaactual = new Date();
        calendario.setTime(horaactual);
        hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }
    
    public void run() {
        Thread current = Thread.currentThread();
        for (int i = 1; i > 0; i++) {
            if (i > 0) {
                hora();
            }
        }
    }
    
    public static String fecha() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("  YYYY/MM/dd");
        return formatofecha.format(fecha);
    }
    
    public void Borrar(){
        txtBuscar.setText("");
        txtNombreC.setText("");
        txtDni.setText("");
        txtMonto.setText("");
        txtAño.setText("");
    }
    
    public void limpiar(){
        checkTodo.setSelected(false);
        checkEnero.setSelected(false);
        checkFebrero.setSelected(false);
        checkMarzo.setSelected(false);
        checkAbril.setSelected(false);
        checkMayo.setSelected(false);
        checkJunio.setSelected(false);
        checkJulio.setSelected(false);
        checkAgosto.setSelected(false);
        checkSeptiembre.setSelected(false);
        checkOctubre.setSelected(false);
        checkNoviembre.setSelected(false);
        checkDiciembre.setSelected(false);
    }
    
    
    private void pdf() throws FileNotFoundException{
        try{
            hora();
            FileOutputStream archivo;
            File file = new File("src/pdf/"+"R-Pagos"+hora+minutos+segundos+".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/Imagenes/LogoP.png");
            
            Paragraph fecha = new Paragraph();
            
            Font negrita = new Font (Font.FontFamily.UNDEFINED, 10, Font.NORMAL, BaseColor.BLACK);
            Font ReporteT = new Font (Font.FontFamily.UNDEFINED, 14, Font.BOLD, BaseColor.BLACK);
            
            fecha.add(Chunk. NEWLINE);
            fecha.setFont(negrita);
            
            Date date= new Date();
            fecha.add("Fecha: "+ new SimpleDateFormat("dd-MM-yyyy").format(date)+"\n\n");
            
            PdfPTable Encabezado = new PdfPTable (4);
            
            Encabezado.setWidthPercentage (100);
            Encabezado.getDefaultCell().setBorder (0) ;
            float[] ColumnaEncabezado = new float[] {20, 10, 90, 40f};
            Encabezado.setWidths (ColumnaEncabezado);
            Encabezado.setHorizontalAlignment (Element. ALIGN_LEFT);
            Encabezado.addCell (img);
            
            
            
            String ruc = "20398495421";
            String nom = "Asociación Casa del Maestro";
            String tel="(073) 502533";
            String dir = "San Antonio, Sullana";
            String emal= "somosASOCAM@gmail.com";
            
            Encabezado.addCell("");
            Encabezado.addCell("RUC: "+ruc+ "\nNombre: "+nom+"\nTeléfono: "+tel+"\nDirección: "+dir+"\nEmail: "+emal);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);
            
            Paragraph info = new Paragraph();
            info.setAlignment(Element.ALIGN_CENTER);
            info.setFont(ReporteT);
            info.add(Chunk.NEWLINE);
            info.add("\nComprobante de pago\n" + "\n");
            doc.add(info);
            
            PdfPTable tablaInfo = new PdfPTable (3);
            tablaInfo.setWidthPercentage (100);
            tablaInfo.getDefaultCell().setBorder (0);
            float[] ColumnaInfo = new float[] {40f, 40f, 40f};
            tablaInfo.setWidths (ColumnaInfo);
            tablaInfo.setHorizontalAlignment (Element.ALIGN_CENTER);
            
            
            
            
            doc.add(tablaInfo);
            doc.close();
        }catch (Exception e){
            
        }
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
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtDni = new javax.swing.JTextField();
        txtNombreC = new javax.swing.JTextField();
        checkJunio = new javax.swing.JCheckBox();
        checkEnero = new javax.swing.JCheckBox();
        checkFebrero = new javax.swing.JCheckBox();
        checkMarzo = new javax.swing.JCheckBox();
        checkAbril = new javax.swing.JCheckBox();
        checkMayo = new javax.swing.JCheckBox();
        checkTodo = new javax.swing.JCheckBox();
        checkJulio = new javax.swing.JCheckBox();
        checkAgosto = new javax.swing.JCheckBox();
        checkSeptiembre = new javax.swing.JCheckBox();
        checkOctubre = new javax.swing.JCheckBox();
        checkNoviembre = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAño = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtMonto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        checkDiciembre = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 51, 153));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("REGISTRO DE PAGOS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        txtBuscar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(51, 51, 51));
        txtBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 250, 30));

        btnBuscar.setBackground(new java.awt.Color(0, 102, 102));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnBuscar.setFocusable(false);
        btnBuscar.setPreferredSize(new java.awt.Dimension(40, 40));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 50, 30));

        txtDni.setEditable(false);
        txtDni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 90, 20));

        txtNombreC.setEditable(false);
        txtNombreC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtNombreC.setMaximumSize(new java.awt.Dimension(64, 18));
        add(txtNombreC, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 220, 20));

        checkJunio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        checkJunio.setForeground(new java.awt.Color(0, 102, 102));
        checkJunio.setText("Junio");
        checkJunio.setContentAreaFilled(false);
        add(checkJunio, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, -1, -1));

        checkEnero.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        checkEnero.setForeground(new java.awt.Color(0, 102, 102));
        checkEnero.setText("Enero");
        checkEnero.setContentAreaFilled(false);
        checkEnero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkEneroActionPerformed(evt);
            }
        });
        add(checkEnero, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, -1));

        checkFebrero.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        checkFebrero.setForeground(new java.awt.Color(0, 102, 102));
        checkFebrero.setText("Febrero");
        checkFebrero.setContentAreaFilled(false);
        add(checkFebrero, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        checkMarzo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        checkMarzo.setForeground(new java.awt.Color(0, 102, 102));
        checkMarzo.setText("Marzo");
        checkMarzo.setContentAreaFilled(false);
        add(checkMarzo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, -1));

        checkAbril.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        checkAbril.setForeground(new java.awt.Color(0, 102, 102));
        checkAbril.setText("Abril");
        checkAbril.setContentAreaFilled(false);
        add(checkAbril, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, -1, -1));

        checkMayo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        checkMayo.setForeground(new java.awt.Color(0, 102, 102));
        checkMayo.setText("Mayo");
        checkMayo.setContentAreaFilled(false);
        add(checkMayo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, -1, -1));

        checkTodo.setBackground(new java.awt.Color(255, 255, 255));
        checkTodo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        checkTodo.setForeground(new java.awt.Color(0, 102, 102));
        checkTodo.setText("Seleccionar todo");
        checkTodo.setContentAreaFilled(false);
        checkTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkTodoMouseClicked(evt);
            }
        });
        checkTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTodoActionPerformed(evt);
            }
        });
        add(checkTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        checkJulio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        checkJulio.setForeground(new java.awt.Color(0, 102, 102));
        checkJulio.setText("Julio");
        checkJulio.setContentAreaFilled(false);
        add(checkJulio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, -1, -1));

        checkAgosto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        checkAgosto.setForeground(new java.awt.Color(0, 102, 102));
        checkAgosto.setText("Agosto");
        checkAgosto.setContentAreaFilled(false);
        add(checkAgosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, -1, -1));

        checkSeptiembre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        checkSeptiembre.setForeground(new java.awt.Color(0, 102, 102));
        checkSeptiembre.setText("Septiembre");
        checkSeptiembre.setContentAreaFilled(false);
        add(checkSeptiembre, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, -1, -1));

        checkOctubre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        checkOctubre.setForeground(new java.awt.Color(0, 102, 102));
        checkOctubre.setText("Octubre");
        checkOctubre.setContentAreaFilled(false);
        add(checkOctubre, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, -1, -1));

        checkNoviembre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        checkNoviembre.setForeground(new java.awt.Color(0, 102, 102));
        checkNoviembre.setText("Noviembre");
        checkNoviembre.setContentAreaFilled(false);
        add(checkNoviembre, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("DNI:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Mensualidad:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, -1, -1));

        txtAño.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        add(txtAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, 110, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Año:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Seleccione mes:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 130, 30));

        txtMonto.setEditable(false);
        txtMonto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtMonto.setMaximumSize(new java.awt.Dimension(64, 18));
        add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 100, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Nombre:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        checkDiciembre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        checkDiciembre.setForeground(new java.awt.Color(0, 102, 102));
        checkDiciembre.setText("Diciembre");
        checkDiciembre.setContentAreaFilled(false);
        add(checkDiciembre, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, -1, -1));

        jPanel1.setBackground(new java.awt.Color(223, 253, 223));
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 470, 100));

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("X");
        btnCancelar.setFocusable(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 50, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        btnBuscar.setEnabled(true);
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String Buscar = txtBuscar.getText();
        try{
            if(s1.Busqueda(Buscar)==1){
                txtDni.setText(s1.BDni(Buscar));
                txtNombreC.setText(s1.BDnombres(Buscar)+" "+s1.BDPaterno(Buscar)+" "+s1.BDMaterno(Buscar));
                txtMonto.setText(s1.BDPago(Buscar));
            }else{
                txtBuscar.setText("");
                txtDni.setText("");
                txtNombreC.setText("");
                txtMonto.setText("");
                JOptionPane.showMessageDialog(null, "DNI no registrado en la BD");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla"+e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void checkEneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkEneroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here
        String botones [] = {"Continuar","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Los datos son correctos?", "La casa del maestro", 0, 0, null, botones, this);
        if(eleccion==JOptionPane.YES_OPTION){
            
            String DNI = txtDni.getText();
            int monto= Integer.parseInt(txtMonto.getText());
            String año = txtAño.getText();
            String fechaP=fecha();
            try {
                String fechaC = s1.BDFecha(txtDni.getText());
                
                if(checkEnero.isSelected()){
                    try{
                        p1.registro(monto,"Enero",año,fechaC,fechaP,DNI);
                        JOptionPane.showMessageDialog(null, "Registro: Enero del "+año);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Hubo un error al registrar este registro "
                        + ", verifique los datos e intentelo de nuevo: "+ e);
                    }
                }
                
                if(checkFebrero.isSelected()){
                    try{
                        p1.registro(monto,"Febrero",año,fechaC,fechaP,DNI);
                        JOptionPane.showMessageDialog(null, "Registro: Febrero del "+año);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Hubo un error al registrar este registro "
                        + ", verifique los datos e intentelo de nuevo: "+ e);
                    }
                }
                
                if(checkMarzo.isSelected()){
                    try{
                        p1.registro(monto,"Marzo",año,fechaC,fechaP,DNI);
                        JOptionPane.showMessageDialog(null, "Registro: Marzo del "+año);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Hubo un error al registrar este registro "
                        + ", verifique los datos e intentelo de nuevo: "+ e);
                    }
                }
                
                if(checkAbril.isSelected()){
                    try{
                        p1.registro(monto,"Abril",año,fechaC,fechaP,DNI);
                        JOptionPane.showMessageDialog(null, "Registro: Abril del "+año);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Hubo un error al registrar este registro "
                        + ", verifique los datos e intentelo de nuevo: "+ e);
                    }
                }
                
                if(checkMayo.isSelected()){
                    try{
                        p1.registro(monto,"Mayo",año,fechaC,fechaP,DNI);
                        JOptionPane.showMessageDialog(null, "Registro: Mayo del "+año);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Hubo un error al registrar este registro "
                        + ", verifique los datos e intentelo de nuevo: "+ e);
                    }
                }
                
                if(checkJunio.isSelected()){
                    try{
                        p1.registro(monto,"Junio",año,fechaC,fechaP,DNI);
                        JOptionPane.showMessageDialog(null, "Registro: Junio del "+año);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Hubo un error al registrar este registro "
                        + ", verifique los datos e intentelo de nuevo: "+ e);
                    }
                }
                
                if(checkJulio.isSelected()){
                    try{
                        p1.registro(monto,"Julio",año,fechaC,fechaP,DNI);
                        JOptionPane.showMessageDialog(null, "Registro: Julio del "+año);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Hubo un error al registrar este registro "
                        + ", verifique los datos e intentelo de nuevo: "+ e);
                    }
                }
                
                if(checkAgosto.isSelected()){
                    try{
                        p1.registro(monto,"Agosto",año,fechaC,fechaP,DNI);
                        JOptionPane.showMessageDialog(null, "Registro: Agosto del "+año);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Hubo un error al registrar este registro "
                        + ", verifique los datos e intentelo de nuevo: "+ e);
                    }
                }
                
                if(checkSeptiembre.isSelected()){
                    try{
                        p1.registro(monto,"Septiembre",año,fechaC,fechaP,DNI);
                        JOptionPane.showMessageDialog(null, "Registro: Septiembre del "+año);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Hubo un error al registrar este registro "
                        + ", verifique los datos e intentelo de nuevo: "+ e);
                    }
                }
                
                if(checkOctubre.isSelected()){
                    try{
                        p1.registro(monto,"Octubre",año,fechaC,fechaP,DNI);
                        JOptionPane.showMessageDialog(null, "Registro: Octubre del "+año);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Hubo un error al registrar este registro "
                        + ", verifique los datos e intentelo de nuevo: "+ e);
                    }
                }
                
                if(checkNoviembre.isSelected()){
                    try{
                        p1.registro(monto,"Noviembre",año,fechaC,fechaP,DNI);
                        JOptionPane.showMessageDialog(null, "Registro: Noviembre del "+año);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Hubo un error al registrar este registro "
                        + ", verifique los datos e intentelo de nuevo: "+ e);
                    }
                }
                
                if(checkDiciembre.isSelected()){
                    try{
                        p1.registro(monto,"Diciembre",año,fechaC,fechaP,DNI);
                        JOptionPane.showMessageDialog(null, "Registro: Diciembre del "+año);
                    }catch(HeadlessException e){
                        JOptionPane.showMessageDialog(null,"Hubo un error al registrar este registro "
                        + ", verifique los datos e intentelo de nuevo: "+ e);
                    }
                }
                
            } catch (Exception ex) {
                Logger.getLogger(JpPagos.class.getName()).log(Level.SEVERE, null, ex);
            }
            Borrar();
            limpiar();
        }else{
            JpPagos pagos = new JpPagos();
            pagos.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void checkTodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkTodoMouseClicked
        // TODO add your handling code he
        checkEnero.setSelected(true);
        checkFebrero.setSelected(true);
        checkMarzo.setSelected(true);
        checkAbril.setSelected(true);
        checkMayo.setSelected(true);
        checkJunio.setSelected(true);
        checkJulio.setSelected(true);
        checkAgosto.setSelected(true);
        checkSeptiembre.setSelected(true);
        checkOctubre.setSelected(true);
        checkNoviembre.setSelected(true);
        checkDiciembre.setSelected(true);
        
        if (checkTodo.isSelected()==false){
            limpiar();
        }
    }//GEN-LAST:event_checkTodoMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        String botones [] = {"Salir","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "No se guardarán los datos, ¿Desea salir?", "La casa del maestro", 0, 0, null, botones, this);
        if(eleccion==JOptionPane.YES_OPTION){
            limpiar();
            Borrar();
            txtBuscar.setEditable(true);
        }else{
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void checkTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkTodoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JCheckBox checkAbril;
    private javax.swing.JCheckBox checkAgosto;
    private javax.swing.JCheckBox checkDiciembre;
    private javax.swing.JCheckBox checkEnero;
    private javax.swing.JCheckBox checkFebrero;
    private javax.swing.JCheckBox checkJulio;
    private javax.swing.JCheckBox checkJunio;
    private javax.swing.JCheckBox checkMarzo;
    private javax.swing.JCheckBox checkMayo;
    private javax.swing.JCheckBox checkNoviembre;
    private javax.swing.JCheckBox checkOctubre;
    private javax.swing.JCheckBox checkSeptiembre;
    private javax.swing.JCheckBox checkTodo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNombreC;
    // End of variables declaration//GEN-END:variables
}
