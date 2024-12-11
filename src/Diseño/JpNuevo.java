/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Diseño;

import DAO.SocioDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author pieri
 */
public class JpNuevo extends javax.swing.JPanel {
    SocioDAO s1 = new SocioDAO();
    

    /**
     * Creates new form JpNuevo
     */
    public JpNuevo() {
        initComponents();
        Limpiar();
        btnRegistrar.setEnabled(false);
        btnValidar.setEnabled(false);
    }
    
    public static String fecha() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
    }
    
    public String nacimiento(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        return sdf.format(jDateChooser1.getDate());
    }
    
    private void Limpiar() {
       
        txtDNI.setText("");
        txtNombres.setText("");
        txtPaterno.setText("");
        txtMaterno.setText("");
        txtEdad.setText("");
        txtCel.setText("");
        txtEmail.setText("");
        txtDirecc.setText("");
        txtAsoc.setText("");
        txtPago.setText("");
        txtFecha.setText(fecha());
        txtAsoc.setEnabled(true);
    }
    
    
    public static boolean Letras(String dato){
        return dato.matches("[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?(( |\\-)[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?)*");
    }
    
    public static boolean DNI(String dato){
        return dato.matches("[0-9]{8}");
    }
    
    public static boolean ncel(String dato){
        return dato.matches("(9)[0-9]{8}");
    }
    
    public static boolean Numeros(String dato){
        return dato.matches("[0-9]{1,2}");
    }
    
    public static boolean correo(String dato){
        return dato.matches("[A-Za-z0-9+_.-]+@(.+)$");
    }
    
    public static boolean FechaN(String dato){
        return dato.matches("^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$");
    }
    
    public void ValidarVacios(){
        
        //Validando DNI
        if(txtDNI.getText().isEmpty()){
            lblDni.setText("*");
        }else{
            lblDni.setText("");
        }
        
        //Validando A.Paterno
        if(txtPaterno.getText().isEmpty()){
            lblPaterno.setText("*");
        }else{
            lblPaterno.setText("");
        }
        
        //Validando A.Materno
        if(txtMaterno.getText().isEmpty()){
            lblMaterno.setText("*");
        }else{
            lblMaterno.setText("");
        }
        
        //Validando Nombres
        if(txtNombres.getText().isEmpty()){
            lblNombres.setText("*");
        }else{
            lblNombres.setText("");
        }
        
        //Validando Edad
        if(txtEdad.getText().isEmpty()){
            lblEdad.setText("*");
        }else{
            lblEdad.setText("");
        }
        
        //Validando Celular
        if(txtCel.getText().isEmpty()){
            lblCel.setText("*");
        }else{
            lblCel.setText("");
        }
        
        //Validando Email
        if(txtEmail.getText().isEmpty()){
            lblEmail.setText("*");
        }else{
            lblEmail.setText("");
        }
        
        //Validando Direccion
        if(txtDirecc.getText().isEmpty()){
            lblDirecc.setText("*");
        }else{
            lblDirecc.setText("");
        }
        
        //Validando Subasociados
        if(txtAsoc.getText().isEmpty()){
            lblAsoc.setText("*");
        }else{
            lblAsoc.setText("");
        }
        
        //Validando Inscripción
        if(txtFecha.getText().isEmpty()){
            lblFecha.setText("*");
        }else{
            lblFecha.setText("");
        }
        
        
        if(txtDNI.getText().isEmpty() || txtPaterno.getText().isEmpty() || txtMaterno.getText().isEmpty()
        || txtNombres.getText().isEmpty() || txtEdad.getText().isEmpty()
        || txtCel.getText().isEmpty() || txtEmail.getText().isEmpty() || txtDirecc.getText().isEmpty()
        || txtAsoc.getText().isEmpty() || txtPago.getText().isEmpty() || txtFecha.getText().isEmpty()
        ){
            
            btnValidar.setEnabled(false);
        }else{
            btnValidar.setEnabled(true);
        }
    }
    
    public void ValidarTodo(){
        
        //Validando DNI
        if (!DNI(txtDNI.getText())) {
            lblDni.setText("*");
            } else {
            lblDni.setText("");
            }
        
        //Validando Nombres
        if (!Letras(txtNombres.getText())) {
            lblNombres.setText("*");
        } else {
            lblNombres.setText("");
        }
        
        //Validando Apellido Paterno
        if (!Letras(txtPaterno.getText())) {
            lblPaterno.setText("*");
        } else {
            lblPaterno.setText("");
        }
        
        //Validando Apellido Materno
        if (!Letras(txtMaterno.getText())) {
            lblMaterno.setText("*");
        } else {
            lblMaterno.setText("");
        }
        
        //Validando fecha de nacimiento
        if (!FechaN(nacimiento())) {
            lblNacimiento.setText("*");
        } else {
            lblNacimiento.setText("");
        }
        
        //Validando edad
        if (!Numeros(txtEdad.getText()) && Integer.parseInt(txtEdad.getText())<18) {
            lblEdad.setText("*");
        } else {
            lblEdad.setText("");
        }
        
        //Validando edad
        if (Integer.parseInt(txtEdad.getText())<18) {
            lblEdad.setText("*");
        } else {
            lblEdad.setText("");
        }
        
        //Validando celular
        if (!ncel(txtCel.getText())){
           lblCel.setText("*");
        } else {
            lblCel.setText(""); 
        }
        
        //Validando correo
        if (!correo(txtEmail.getText())) {
            lblEmail.setText("*");
        } else {
            lblEmail.setText("");
        }
        
        
        //Validando n asoc
        if (!Numeros(txtAsoc.getText())&& Integer.parseInt(txtAsoc.getText())>9) {
            lblAsoc.setText("*");
        }else {
            lblAsoc.setText("");
        }
       
        
        //Prender el botón
        if (!DNI(txtDNI.getText().trim()) || !Letras(txtNombres.getText().trim()) || !Letras(txtPaterno.getText().trim()) 
            || !Letras(txtMaterno.getText().trim())
            || !Numeros(txtEdad.getText().trim()) || Integer.parseInt(txtEdad.getText())<18 || !ncel(txtCel.getText().trim())
            || !correo(txtEmail.getText().trim()) || txtDirecc.getText().isEmpty() || txtAsoc.getText().isEmpty() || txtPago.getText().isEmpty() || txtFecha.getText().isEmpty()
            || lblError.getText().equals("EL DNI ya está registrado")){
            
            btnRegistrar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Datos inválidos, por favor revisar y corregir");
            
        } else {
            //se apaga todo
            txtDNI.setEditable(false);
            txtNombres.setEditable(false);
            txtPaterno.setEditable(false);
            txtMaterno.setEditable(false);
            txtEdad.setEditable(false);
            txtCel.setEditable(false);
            txtEmail.setEditable(false);
            txtDirecc.setEditable(false);
            txtAsoc.setEditable(false);
            txtPago.setEditable(false);
            txtFecha.setEditable(false);
            btnRegistrar.setEnabled(true);
            btnQuitar.setEnabled(false);
            btnValidar.setEnabled(false);
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
        lblError = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDirecc = new javax.swing.JTextField();
        txtPaterno = new javax.swing.JTextField();
        txtCel = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtMaterno = new javax.swing.JTextField();
        btnVaciar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        btnValidar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtAsoc = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblPaterno = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        lblAsoc = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        lblDirecc = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblMaterno = new javax.swing.JLabel();
        lblNacimiento = new javax.swing.JLabel();
        lblCel = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("DNI:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 33, -1));

        lblError.setBackground(new java.awt.Color(51, 51, 51));
        lblError.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, 220, 20));

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 0, 0));
        add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Edad:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));

        txtDirecc.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtDirecc.setForeground(new java.awt.Color(51, 51, 51));
        txtDirecc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtDirecc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccActionPerformed(evt);
            }
        });
        txtDirecc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccKeyReleased(evt);
            }
        });
        add(txtDirecc, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 220, 20));

        txtPaterno.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtPaterno.setForeground(new java.awt.Color(51, 51, 51));
        txtPaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtPaterno.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                txtPaternoComponentMoved(evt);
            }
        });
        txtPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaternoActionPerformed(evt);
            }
        });
        txtPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaternoKeyReleased(evt);
            }
        });
        add(txtPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 120, -1));

        txtCel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtCel.setForeground(new java.awt.Color(51, 51, 51));
        txtCel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCelKeyReleased(evt);
            }
        });
        add(txtCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 120, -1));

        jLabel15.setBackground(new java.awt.Color(51, 51, 51));
        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Email:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        txtPago.setEditable(false);
        txtPago.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtPago.setForeground(new java.awt.Color(51, 51, 51));
        txtPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagoActionPerformed(evt);
            }
        });
        txtPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPagoKeyReleased(evt);
            }
        });
        add(txtPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 50, -1));

        jLabel16.setBackground(new java.awt.Color(0, 51, 153));
        jLabel16.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("FICHA DE INSCRIPCIÓN");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, -1));

        jLabel17.setBackground(new java.awt.Color(51, 51, 51));
        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("Nombres:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(51, 51, 51));
        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaKeyReleased(evt);
            }
        });
        add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 100, -1));

        jLabel18.setBackground(new java.awt.Color(51, 51, 51));
        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setText("Celular:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, -1, -1));

        txtMaterno.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtMaterno.setForeground(new java.awt.Color(51, 51, 51));
        txtMaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaternoKeyReleased(evt);
            }
        });
        add(txtMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 130, -1));

        btnVaciar.setBackground(new java.awt.Color(0, 102, 102));
        btnVaciar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnVaciar.setForeground(new java.awt.Color(255, 255, 255));
        btnVaciar.setText("Vaciar");
        btnVaciar.setFocusPainted(false);
        btnVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarActionPerformed(evt);
            }
        });
        add(btnVaciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, 150, 30));

        jLabel19.setBackground(new java.awt.Color(51, 51, 51));
        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 102));
        jLabel19.setText("N° asociados:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        jLabel20.setBackground(new java.awt.Color(51, 51, 51));
        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setText("Mensualidad:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, -1, -1));

        txtEdad.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtEdad.setForeground(new java.awt.Color(51, 51, 51));
        txtEdad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEdadKeyReleased(evt);
            }
        });
        add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 60, -1));

        txtDNI.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtDNI.setForeground(new java.awt.Color(51, 51, 51));
        txtDNI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDNIKeyReleased(evt);
            }
        });
        add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 140, -1));

        jLabel21.setBackground(new java.awt.Color(51, 51, 51));
        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setText("DNI:");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 33, -1));

        btnRegistrar.setBackground(new java.awt.Color(0, 102, 102));
        btnRegistrar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 150, 30));

        txtEmail.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(51, 51, 51));
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtEmail.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                txtEmailComponentMoved(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 130, -1));

        btnValidar.setBackground(new java.awt.Color(0, 102, 102));
        btnValidar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnValidar.setForeground(new java.awt.Color(255, 255, 255));
        btnValidar.setText("Validar");
        btnValidar.setFocusPainted(false);
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });
        add(btnValidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 150, 30));

        btnQuitar.setBackground(new java.awt.Color(255, 0, 0));
        btnQuitar.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setText("X");
        btnQuitar.setFocusPainted(false);
        btnQuitar.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnQuitar.setMinimumSize(new java.awt.Dimension(10, 10));
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, -1, 20));

        jLabel22.setBackground(new java.awt.Color(51, 51, 51));
        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setText("Fecha:");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, -1, -1));

        jLabel23.setBackground(new java.awt.Color(51, 51, 51));
        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 102));
        jLabel23.setText("Apellido Materno:");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, -1, 20));

        jLabel24.setBackground(new java.awt.Color(51, 51, 51));
        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 102, 102));
        jLabel24.setText("Domicilio:");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, -1, -1));

        jLabel25.setBackground(new java.awt.Color(51, 51, 51));
        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 102));
        jLabel25.setText("Apellido Paterno:");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));

        txtAsoc.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtAsoc.setForeground(new java.awt.Color(51, 51, 51));
        txtAsoc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtAsoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAsocKeyReleased(evt);
            }
        });
        add(txtAsoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 30, -1));

        jLabel26.setBackground(new java.awt.Color(51, 51, 51));
        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 102));
        jLabel26.setText("Fecha nacimiento:");
        add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, -1, -1));

        txtNombres.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtNombres.setForeground(new java.awt.Color(51, 51, 51));
        txtNombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombresKeyReleased(evt);
            }
        });
        add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 160, -1));

        lblEmail.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 0, 0));
        add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, -1));

        lblPaterno.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblPaterno.setForeground(new java.awt.Color(255, 0, 0));
        add(lblPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        lblNombres.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblNombres.setForeground(new java.awt.Color(255, 0, 0));
        add(lblNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));

        lblAsoc.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblAsoc.setForeground(new java.awt.Color(255, 0, 0));
        add(lblAsoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        lblDni.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblDni.setForeground(new java.awt.Color(255, 0, 0));
        add(lblDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        lblDirecc.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblDirecc.setForeground(new java.awt.Color(255, 0, 0));
        add(lblDirecc, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, -1, -1));

        lblEdad.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblEdad.setForeground(new java.awt.Color(255, 0, 0));
        add(lblEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, -1, -1));

        lblMaterno.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblMaterno.setForeground(new java.awt.Color(255, 0, 0));
        add(lblMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, -1, -1));

        lblNacimiento.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblNacimiento.setForeground(new java.awt.Color(255, 0, 0));
        add(lblNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, -1, -1));

        lblCel.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblCel.setForeground(new java.awt.Color(255, 0, 0));
        add(lblCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, -1, -1));

        jDateChooser1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jDateChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseClicked(evt);
            }
        });
        add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, 120, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void txtDireccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccActionPerformed

    private void txtDireccKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtDireccKeyReleased

    private void txtPaternoComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_txtPaternoComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaternoComponentMoved

    private void txtPaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaternoKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtPaternoKeyReleased

    private void txtCelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtCelKeyReleased

    private void txtPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagoActionPerformed

    private void txtPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtPagoKeyReleased

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtFechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
        
    }//GEN-LAST:event_txtFechaKeyReleased

    private void txtMaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaternoKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtMaternoKeyReleased

    private void txtEdadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtEdadKeyReleased

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIActionPerformed

    private void txtDNIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyReleased
        // TODO add your handling code here
        ValidarVacios();
        try {
            if(s1.Busqueda(txtDNI.getText())==1){
                lblError.setText("El DNI ya está registrado");
            }else{
                lblError.setText("");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtDNIKeyReleased

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        String DNI = txtDNI.getText();
        String nombre = txtNombres.getText();
        String apellidoP= txtPaterno.getText();
        String apellidoM= txtMaterno.getText();
        String Fnacimiento=nacimiento();
        int edad= Integer.parseInt(txtEdad.getText());
        String celular= txtCel.getText();
        String correo =txtEmail.getText();
        String Direcc=txtDirecc.getText();
        int Asoc = Integer.parseInt(txtAsoc.getText());
        int pago=Integer.parseInt(txtPago.getText());
        String fecha=txtFecha.getText();

        //Se intenta enviar los datos a traves del metodo registrar creado en DAO
        try{
            s1.registrar(DNI,nombre,apellidoP,apellidoM,Fnacimiento,edad,celular,correo,Direcc,Asoc,pago,fecha);
            Limpiar();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Hubo un error al registrar este registro "
                + ", verifique los datos e intentelo de nuevo: "+ e);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtEmailComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_txtEmailComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailComponentMoved

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtEmailKeyReleased

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
        txtAsoc.setText("");
        txtPago.setText("");
        txtAsoc.setEnabled(true);
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void txtNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtNombresKeyReleased

    private void txtAsocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAsocKeyReleased
        // TODO add your handling code here:
        ValidarVacios();

        if(Integer.parseInt(txtAsoc.getText())>=0){
            txtAsoc.setEnabled(false);
            String cadena;
            int men;
            int x=Integer.parseInt(txtAsoc.getText());
            men=x*10;
            cadena= String.valueOf(men);
            txtPago.setText(cadena);
        }
    }//GEN-LAST:event_txtAsocKeyReleased

    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed
        // TODO add your handling code here:
        ValidarTodo();
    }//GEN-LAST:event_btnValidarActionPerformed

    private void btnVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarActionPerformed
        // TODO add your handling code here:}
       Limpiar();
       btnRegistrar.setEnabled(false);
    }//GEN-LAST:event_btnVaciarActionPerformed

    private void txtPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaternoActionPerformed

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVaciar;
    private javax.swing.JButton btnValidar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblAsoc;
    private javax.swing.JLabel lblCel;
    private javax.swing.JLabel lblDirecc;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMaterno;
    private javax.swing.JLabel lblNacimiento;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblPaterno;
    private javax.swing.JTextField txtAsoc;
    private javax.swing.JTextField txtCel;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDirecc;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtPaterno;
    // End of variables declaration//GEN-END:variables
}
