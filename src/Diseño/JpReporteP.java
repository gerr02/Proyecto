/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Diseño;

import DAO.PagosDAO;
import Entidades.Anual;
import Entidades.Mensual;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author pieri
 */
public class JpReporteP extends javax.swing.JPanel implements Runnable{
    ButtonGroup btnGr,btnMes;
    String hora, minutos, segundos;
    Thread hilo;
    PagosDAO p1 = new PagosDAO();
    /**
     * Creates new form JpBalance
     */
    public JpReporteP() {
        initComponents();
        panelTabla.setVisible(false);
        
        btnGr = new ButtonGroup();
        btnMes = new ButtonGroup();
        btnGr.add(rbMes);
        btnGr.add(rbAnual);
        
        
        btnMes.add(rbEnero);
        btnMes.add(rbFebrero);
        btnMes.add(rbMarzo);
        btnMes.add(rbAbril);
        btnMes.add(rbMayo);
        btnMes.add(rbJunio);
        btnMes.add(rbJulio);
        btnMes.add(rbAgosto);
        btnMes.add(rbSeptiembre);
        btnMes.add(rbOctubre);
        btnMes.add(rbNoviembre);
        btnMes.add(rbDiciembre);
        
        
        rbEnero.setEnabled(false);
        rbFebrero.setEnabled(false);
        rbMarzo.setEnabled(false);
        rbAbril.setEnabled(false);
        rbMayo.setEnabled(false);
        rbJunio.setEnabled(false);
        rbJulio.setEnabled(false);
        rbAgosto.setEnabled(false);
        rbSeptiembre.setEnabled(false);
        rbOctubre.setEnabled(false);
        rbNoviembre.setEnabled(false);
        rbDiciembre.setEnabled(false);
        
        
        hilo = new Thread(this);
        hilo.start();
        setVisible(true);
        txtFecha.setText("Fecha: "+fecha());
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
                txtHora.setText("Hora: " + hora + ":" + minutos + ":" + segundos);
            }
        }
    }
    
    public static String fecha() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
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
    
    private void modeloTablaPagos( ArrayList Anuales){
        DefaultTableModel tabla1 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int colum){
                return false;
            }
        };
        
        tabla1.setRowCount(Anuales.size());
        tabla1.addColumn("DNI");
        tabla1.addColumn("MES.P");
        tabla1.addColumn("AÑO.P");
        tabla1.addColumn("F.Pago");
        tabla1.addColumn("Monto");
        
        for (int i=0; i<Anuales.size(); i++){
            Anual b = (Anual) Anuales.get(i);
            tabla1.setValueAt(b.getDniSocio(), i,0);
            tabla1.setValueAt(b.getMes(), i, 1);
            tabla1.setValueAt(b.getAño(), i, 2);
            tabla1.setValueAt(b.getFechaPago(), i, 3);
            tabla1.setValueAt(b.getMonto(), i, 4);
        }
        
        tblPagos.setModel(tabla1);
        CentrarDatosPagos(tblPagos);
    }
    
    public void llenarTablaAnual() throws Exception{
        ArrayList<Anual> lista1 ;
        lista1 = p1.listaPagosA(txtAño1.getText());
        modeloTablaPagos(lista1);
    }
    
    
        private void modeloTablaPagoM( ArrayList Mensuales){
        DefaultTableModel tabla1 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int colum){
                return false;
            }
        };
        
        tabla1.setRowCount(Mensuales.size());
        tabla1.addColumn("DNI");
        tabla1.addColumn("MES.P");
        tabla1.addColumn("AÑO.P");
        tabla1.addColumn("F.Pago");
        tabla1.addColumn("Monto");
        
        for (int i=0; i<Mensuales.size(); i++){
            Mensual b = (Mensual) Mensuales.get(i);
            tabla1.setValueAt(b.getDniSocio(), i,0);
            tabla1.setValueAt(b.getMes(), i, 1);
            tabla1.setValueAt(b.getAño(), i, 2);
            tabla1.setValueAt(b.getFechaPago(), i, 3);
            tabla1.setValueAt(b.getMonto(), i, 4);
        }
        
        tblPagos.setModel(tabla1);
        CentrarDatosPagos(tblPagos);
    }
    
    public void llenarTablaMensual() throws Exception{
        int mesC = 0;
        if(rbEnero.isSelected()){
                    mesC=1;
                }
                if(rbFebrero.isSelected()){
                    mesC=2;
                }
                if(rbMarzo.isSelected()){
                    mesC=3;
                }
                if(rbAbril.isSelected()){
                    mesC=4;
                }
                if(rbMayo.isSelected()){
                    mesC=5;
                }
                if(rbJunio.isSelected()){
                    mesC=6;
                }
                if(rbJulio.isSelected()){
                    mesC=7;
                }
                if(rbAgosto.isSelected()){
                    mesC=8;
                }
                if(rbSeptiembre.isSelected()){
                    mesC=9;
                }
                if(rbOctubre.isSelected()){
                    mesC=10;
                }
                if(rbNoviembre.isSelected()){
                    mesC=11;
                }
                if(rbDiciembre.isSelected()){
                    mesC=12;
                } 
        ArrayList<Mensual> lista2;
        lista2 = p1.listaPagosM(txtAño1.getText(),mesC);
        modeloTablaPagoM(lista2);
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
            info.add("\nReporte de pagos\n" + "\n");
            doc.add(info);
            
            PdfPTable tablaInfo = new PdfPTable (3);
            tablaInfo.setWidthPercentage (100);
            tablaInfo.getDefaultCell().setBorder (0);
            float[] ColumnaInfo = new float[] {40f, 40f, 40f};
            tablaInfo.setWidths (ColumnaInfo);
            tablaInfo.setHorizontalAlignment (Element.ALIGN_CENTER);
            
            String tipoR="", mesR="";
            if(rbAnual.isSelected()){
                tipoR="Anual";
                PdfPCell Inf1 = new PdfPCell(new Phrase ("Tipo de reporte: "+tipoR, negrita));
                PdfPCell Inf2 = new PdfPCell (new Phrase ("Año de reporte: "+txtAño1.getText(),negrita));
                PdfPCell Inf3 = new PdfPCell (new Phrase ("Extra: actualizado",negrita));
                Inf1.setBorder(0);
                Inf2.setBorder(0);
                Inf3.setBorder(0);
                tablaInfo.addCell(Inf1);
                tablaInfo.addCell(Inf2);
                tablaInfo.addCell(Inf3);
                
            }else if (rbMes.isSelected()){
                tipoR="Mensual";
                PdfPCell Inf1 = new PdfPCell(new Phrase ("Tipo de reporte: "+tipoR, negrita));
                if(rbEnero.isSelected()){
                    mesR="Enero";
                }
                if(rbFebrero.isSelected()){
                    mesR="Febrero";
                }
                if(rbMarzo.isSelected()){
                    mesR="Marzo";
                }
                if(rbAbril.isSelected()){
                    mesR="Abril";
                }
                if(rbMayo.isSelected()){
                    mesR="Mayo";
                }
                if(rbJunio.isSelected()){
                    mesR="Junio";
                }
                if(rbJulio.isSelected()){
                    mesR="Julio";
                }
                if(rbAgosto.isSelected()){
                    mesR="Agosto";
                }
                if(rbSeptiembre.isSelected()){
                    mesR="Septiembre";
                }
                if(rbOctubre.isSelected()){
                    mesR="Octubreo";
                }
                if(rbNoviembre.isSelected()){
                    mesR="Noviembre";
                }
                if(rbDiciembre.isSelected()){
                    mesR="Diciembre";
                }
                
                PdfPCell Inf2 = new PdfPCell(new Phrase ("Mes de reporte: "+mesR,negrita));
                PdfPCell Inf3 = new PdfPCell (new Phrase ("Año de reporte: "+txtAño1.getText(),negrita));
                Inf1.setBorder(0);
                Inf2.setBorder(0);
                Inf3.setBorder(0);
                tablaInfo.addCell(Inf1);
                tablaInfo.addCell(Inf2);
                tablaInfo.addCell(Inf3);
            }
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

        jLabel2 = new javax.swing.JLabel();
        rbMes = new javax.swing.JRadioButton();
        rbAnual = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        panelMeses = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        rbDiciembre = new javax.swing.JRadioButton();
        rbJulio = new javax.swing.JRadioButton();
        rbNoviembre = new javax.swing.JRadioButton();
        rbFebrero = new javax.swing.JRadioButton();
        rbEnero = new javax.swing.JRadioButton();
        rbAbril = new javax.swing.JRadioButton();
        rbMarzo = new javax.swing.JRadioButton();
        rbMayo = new javax.swing.JRadioButton();
        rbJunio = new javax.swing.JRadioButton();
        rbOctubre = new javax.swing.JRadioButton();
        rbSeptiembre = new javax.swing.JRadioButton();
        rbAgosto = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtAño1 = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        btnImprimir = new javax.swing.JButton();
        panelTabla = new javax.swing.JPanel();
        tbAnual = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        lblAño = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIngresos = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 550));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 51, 153));
        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("REPORTE DE PAGOS - SOCIOS");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        rbMes.setBackground(new java.awt.Color(255, 255, 255));
        rbMes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbMes.setForeground(new java.awt.Color(0, 102, 102));
        rbMes.setText("Mensual");
        rbMes.setFocusPainted(false);
        rbMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbMesMouseClicked(evt);
            }
        });
        rbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMesActionPerformed(evt);
            }
        });
        add(rbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, 30));

        rbAnual.setBackground(new java.awt.Color(255, 255, 255));
        rbAnual.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbAnual.setForeground(new java.awt.Color(0, 102, 102));
        rbAnual.setText("Anual");
        rbAnual.setFocusPainted(false);
        rbAnual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbAnualMouseClicked(evt);
            }
        });
        rbAnual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAnualActionPerformed(evt);
            }
        });
        add(rbAnual, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, 30));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("SOMOS LA CASA DEL MAESTRO");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 180, -1));

        panelMeses.setBackground(new java.awt.Color(205, 228, 205));
        panelMeses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Selecciona mes:");
        panelMeses.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 180, -1));

        rbDiciembre.setBackground(new java.awt.Color(205, 228, 205));
        rbDiciembre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbDiciembre.setForeground(new java.awt.Color(0, 102, 102));
        rbDiciembre.setText("Diciembre");
        rbDiciembre.setFocusPainted(false);
        rbDiciembre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDiciembreActionPerformed(evt);
            }
        });
        panelMeses.add(rbDiciembre, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, 30));

        rbJulio.setBackground(new java.awt.Color(205, 228, 205));
        rbJulio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbJulio.setForeground(new java.awt.Color(0, 102, 102));
        rbJulio.setText("Julio");
        rbJulio.setFocusPainted(false);
        rbJulio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbJulioActionPerformed(evt);
            }
        });
        panelMeses.add(rbJulio, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, 30));

        rbNoviembre.setBackground(new java.awt.Color(205, 228, 205));
        rbNoviembre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbNoviembre.setForeground(new java.awt.Color(0, 102, 102));
        rbNoviembre.setText("Noviembre");
        rbNoviembre.setFocusPainted(false);
        rbNoviembre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNoviembreActionPerformed(evt);
            }
        });
        panelMeses.add(rbNoviembre, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, -1, 30));

        rbFebrero.setBackground(new java.awt.Color(205, 228, 205));
        rbFebrero.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbFebrero.setForeground(new java.awt.Color(0, 102, 102));
        rbFebrero.setText("Febrero");
        rbFebrero.setFocusPainted(false);
        rbFebrero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFebreroActionPerformed(evt);
            }
        });
        panelMeses.add(rbFebrero, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, 30));

        rbEnero.setBackground(new java.awt.Color(205, 228, 205));
        rbEnero.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbEnero.setForeground(new java.awt.Color(0, 102, 102));
        rbEnero.setText("Enero");
        rbEnero.setFocusPainted(false);
        rbEnero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEneroActionPerformed(evt);
            }
        });
        panelMeses.add(rbEnero, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, 30));

        rbAbril.setBackground(new java.awt.Color(205, 228, 205));
        rbAbril.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbAbril.setForeground(new java.awt.Color(0, 102, 102));
        rbAbril.setText("Abril");
        rbAbril.setFocusPainted(false);
        rbAbril.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAbrilActionPerformed(evt);
            }
        });
        panelMeses.add(rbAbril, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, 30));

        rbMarzo.setBackground(new java.awt.Color(205, 228, 205));
        rbMarzo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbMarzo.setForeground(new java.awt.Color(0, 102, 102));
        rbMarzo.setText("Marzo");
        rbMarzo.setFocusPainted(false);
        rbMarzo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMarzoActionPerformed(evt);
            }
        });
        panelMeses.add(rbMarzo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, 30));

        rbMayo.setBackground(new java.awt.Color(205, 228, 205));
        rbMayo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbMayo.setForeground(new java.awt.Color(0, 102, 102));
        rbMayo.setText("Mayo");
        rbMayo.setFocusPainted(false);
        rbMayo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMayoActionPerformed(evt);
            }
        });
        panelMeses.add(rbMayo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, 30));

        rbJunio.setBackground(new java.awt.Color(205, 228, 205));
        rbJunio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbJunio.setForeground(new java.awt.Color(0, 102, 102));
        rbJunio.setText("Junio");
        rbJunio.setFocusPainted(false);
        rbJunio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbJunioActionPerformed(evt);
            }
        });
        panelMeses.add(rbJunio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, 30));

        rbOctubre.setBackground(new java.awt.Color(205, 228, 205));
        rbOctubre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbOctubre.setForeground(new java.awt.Color(0, 102, 102));
        rbOctubre.setText("Octubre");
        rbOctubre.setFocusPainted(false);
        rbOctubre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbOctubreActionPerformed(evt);
            }
        });
        panelMeses.add(rbOctubre, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, -1, 30));

        rbSeptiembre.setBackground(new java.awt.Color(205, 228, 205));
        rbSeptiembre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbSeptiembre.setForeground(new java.awt.Color(0, 102, 102));
        rbSeptiembre.setText("Septiembre");
        rbSeptiembre.setFocusPainted(false);
        rbSeptiembre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSeptiembreActionPerformed(evt);
            }
        });
        panelMeses.add(rbSeptiembre, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, -1, 30));

        rbAgosto.setBackground(new java.awt.Color(205, 228, 205));
        rbAgosto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbAgosto.setForeground(new java.awt.Color(0, 102, 102));
        rbAgosto.setText("Agosto");
        rbAgosto.setFocusPainted(false);
        rbAgosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAgostoActionPerformed(evt);
            }
        });
        panelMeses.add(rbAgosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, 30));

        add(panelMeses, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 690, 140));

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Por favor, Ingrese el año:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 160, -1));
        add(txtAño1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 130, -1));

        txtHora.setEditable(false);
        txtHora.setBackground(new java.awt.Color(255, 255, 255));
        txtHora.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtHora.setForeground(new java.awt.Color(51, 51, 51));
        txtHora.setBorder(null);
        add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 120, 30));

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Seleccionar tipo de balance:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 180, -1));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(51, 51, 51));
        txtFecha.setBorder(null);
        add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 120, 30));

        btnImprimir.setBackground(new java.awt.Color(0, 102, 102));
        btnImprimir.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimir.setText("Mostrar");
        btnImprimir.setFocusPainted(false);
        btnImprimir.setFocusable(false);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 180, 30));

        panelTabla.setBackground(new java.awt.Color(255, 255, 255));
        panelTabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        tbAnual.setViewportView(tblPagos);

        panelTabla.add(tbAnual, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 870, 310));

        lblTitulo.setBackground(new java.awt.Color(0, 51, 153));
        lblTitulo.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 102, 102));
        panelTabla.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 320, 30));
        panelTabla.add(lblAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 510, 20));

        jLabel1.setText("SOMOS ASOCAM");
        panelTabla.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 100, -1));

        jLabel7.setText("Total de ingresos:   S/.");
        panelTabla.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, -1, -1));

        jLabel8.setText("Número de registros:");
        panelTabla.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, -1, -1));

        txtIngresos.setEditable(false);
        panelTabla.add(txtIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 480, 120, -1));

        txtNumero.setEditable(false);
        panelTabla.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 450, 120, -1));

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
        panelTabla.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 50, -1));

        add(panelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void rbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbMesActionPerformed

    private void rbAnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAnualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAnualActionPerformed

    private void rbDiciembreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDiciembreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbDiciembreActionPerformed

    private void rbJulioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbJulioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbJulioActionPerformed

    private void rbNoviembreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoviembreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNoviembreActionPerformed

    private void rbFebreroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFebreroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbFebreroActionPerformed

    private void rbEneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbEneroActionPerformed

    private void rbAbrilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAbrilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAbrilActionPerformed

    private void rbMarzoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMarzoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbMarzoActionPerformed

    private void rbMayoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMayoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbMayoActionPerformed

    private void rbJunioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbJunioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbJunioActionPerformed

    private void rbOctubreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbOctubreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbOctubreActionPerformed

    private void rbSeptiembreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSeptiembreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbSeptiembreActionPerformed

    private void rbAgostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAgostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAgostoActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        if ((rbMes.isSelected()==true || rbAnual.isSelected()==true) && !(txtAño1.getText().isEmpty())){
            String mesS=""; 
            int mesC=0;
            // TODO add your handling code here:
            //pdf()
            
            if(rbAnual.isSelected()){
                jLabel2.setVisible(false);
                rbMes.setVisible(false);
                rbAnual.setVisible(false);
                jLabel4.setVisible(false);
                panelMeses.setVisible(false);
                jLabel5.setVisible(false);
                txtAño1.setVisible(false);
                txtHora.setVisible(false);
                jLabel6.setVisible(false);
                txtFecha.setVisible(false);
                btnImprimir.setVisible(false);
                lblTitulo.setText("REPORTE ANUAL");
                lblAño.setText("Este reporte corresponde al año "+txtAño1.getText());
                panelTabla.setVisible(true);
                try {
                llenarTablaAnual();
                int filas= tblPagos.getRowCount();
                txtNumero.setText("  "+filas);
                txtIngresos.setText("  "+p1.TotalAnual(txtAño1.getText()));
                
                } catch (Exception ex) {
                    Logger.getLogger(JpTabla.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(rbMes.isSelected()){
                if(rbEnero.isSelected()){
                    mesS="Enero";
                    mesC=1;
                }
                if(rbFebrero.isSelected()){
                    mesS="Febrero";
                    mesC=2;
                }
                if(rbMarzo.isSelected()){
                    mesS="Marzo";
                    mesC=3;
                }
                if(rbAbril.isSelected()){
                    mesS="Abril";
                    mesC=4;
                }
                if(rbMayo.isSelected()){
                    mesS="Mayo";
                    mesC=5;
                }
                if(rbJunio.isSelected()){
                    mesS="Junio";
                    mesC=6;
                }
                if(rbJulio.isSelected()){
                    mesS="Julio";
                    mesC=7;
                }
                if(rbAgosto.isSelected()){
                    mesS="Agosto";
                    mesC=8;
                }
                if(rbSeptiembre.isSelected()){
                    mesS="Septiembre";
                    mesC=9;
                }
                if(rbOctubre.isSelected()){
                    mesS="Octubreo";
                    mesC=10;
                }
                if(rbNoviembre.isSelected()){
                    mesS="Noviembre";
                    mesC=11;
                }
                if(rbDiciembre.isSelected()){
                    mesS="Diciembre";
                    mesC=12;
                } 
            if(mesS.equals("")){
                JOptionPane.showMessageDialog(null, "¡Hay campos vacíos!");
            }else{
            jLabel2.setVisible(false);
            rbMes.setVisible(false);
            rbAnual.setVisible(false);
            jLabel4.setVisible(false);
            panelMeses.setVisible(false);
            jLabel5.setVisible(false);
            txtAño1.setVisible(false);
            txtHora.setVisible(false);
            jLabel6.setVisible(false);
            txtFecha.setVisible(false);
            btnImprimir.setVisible(false);
            lblTitulo.setText("REPORTE MENSUAL");
            lblAño.setText("Este reporte corresponde al mes "+mesS+ " Año: "+txtAño1.getText());
            panelTabla.setVisible(true);
                try {
                    llenarTablaMensual();
                    int filas= tblPagos.getRowCount();
                    txtNumero.setText("  "+filas);
                    txtIngresos.setText("  "+p1.TotalMensual(txtAño1.getText(),mesC));
                } catch (Exception e) {
                }
            }
        }
        }else{
            JOptionPane.showMessageDialog(null, "¡Hay campos vacíos!");
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void rbMesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbMesMouseClicked
        // TODO add your handling code here:
        if (rbMes.isSelected()){
            rbEnero.setEnabled(true);
            rbFebrero.setEnabled(true);
            rbMarzo.setEnabled(true);
            rbAbril.setEnabled(true);
            rbMayo.setEnabled(true);
            rbJunio.setEnabled(true);
            rbJulio.setEnabled(true);
            rbAgosto.setEnabled(true);
            rbSeptiembre.setEnabled(true);
            rbOctubre.setEnabled(true);
            rbNoviembre.setEnabled(true);
            rbDiciembre.setEnabled(true);
        }else if(rbAnual.isSelected()){
            rbEnero.setEnabled(false);
            rbEnero.setSelected(false);
            
            rbFebrero.setEnabled(false);
            rbFebrero.setSelected(false);
            
            rbMarzo.setEnabled(false);
            rbMarzo.setSelected(false);
        
            rbAbril.setEnabled(false);
            rbAbril.setSelected(false);
            
            rbMayo.setEnabled(false);
            rbMayo.setSelected(false);
            
            rbJunio.setEnabled(false);
            rbJunio.setSelected(false);
            
            rbJulio.setEnabled(false);
            rbJulio.setSelected(false);
            
            rbAgosto.setEnabled(false);
            rbAgosto.setSelected(false);
            
            rbSeptiembre.setEnabled(false);
            rbSeptiembre.setSelected(false);
            
            rbOctubre.setEnabled(false);
            rbOctubre.setSelected(false);
            
            rbNoviembre.setEnabled(false);
            rbNoviembre.setSelected(false);
            
            rbDiciembre.setEnabled(false);
            rbDiciembre.setSelected(false);
        }
    }//GEN-LAST:event_rbMesMouseClicked

    private void rbAnualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbAnualMouseClicked
        // TODO add your handling code here:
        if (rbMes.isSelected()){
            rbEnero.setEnabled(true);
            rbFebrero.setEnabled(true);
            rbMarzo.setEnabled(true);
            rbAbril.setEnabled(true);
            rbMayo.setEnabled(true);
            rbJunio.setEnabled(true);
            rbJulio.setEnabled(true);
            rbAgosto.setEnabled(true);
            rbSeptiembre.setEnabled(true);
            rbOctubre.setEnabled(true);
            rbNoviembre.setEnabled(true);
            rbDiciembre.setEnabled(true);
            
        }else if(rbAnual.isSelected()){
            
            rbEnero.setEnabled(false);
            rbFebrero.setEnabled(false);
            rbMarzo.setEnabled(false);
            rbAbril.setEnabled(false);
            rbMayo.setEnabled(false);
            rbJunio.setEnabled(false);
            rbJulio.setEnabled(false);
            rbAgosto.setEnabled(false);
            rbSeptiembre.setEnabled(false);
            rbOctubre.setEnabled(false);
            rbNoviembre.setEnabled(false);
            rbDiciembre.setEnabled(false);
        }
    }//GEN-LAST:event_rbAnualMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        String botones [] = {"Salir","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Desea salir?", "La casa del maestro", 0, 0, null, botones, this);
        if(eleccion==JOptionPane.YES_OPTION){
            jLabel2.setVisible(true);
            rbMes.setVisible(true);
            rbAnual.setVisible(true);
            jLabel4.setVisible(true);
            panelMeses.setVisible(true);
            jLabel5.setVisible(true);
            txtAño1.setVisible(true);
            txtHora.setVisible(true);
            jLabel6.setVisible(true);
            txtFecha.setVisible(true);
            btnImprimir.setVisible(true);
            panelTabla.setVisible(false);
        }else{
        }
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblAño;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelMeses;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JRadioButton rbAbril;
    private javax.swing.JRadioButton rbAgosto;
    private javax.swing.JRadioButton rbAnual;
    private javax.swing.JRadioButton rbDiciembre;
    private javax.swing.JRadioButton rbEnero;
    private javax.swing.JRadioButton rbFebrero;
    private javax.swing.JRadioButton rbJulio;
    private javax.swing.JRadioButton rbJunio;
    private javax.swing.JRadioButton rbMarzo;
    private javax.swing.JRadioButton rbMayo;
    private javax.swing.JRadioButton rbMes;
    private javax.swing.JRadioButton rbNoviembre;
    private javax.swing.JRadioButton rbOctubre;
    private javax.swing.JRadioButton rbSeptiembre;
    private javax.swing.JScrollPane tbAnual;
    private javax.swing.JTable tblPagos;
    private javax.swing.JTextField txtAño1;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtIngresos;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
