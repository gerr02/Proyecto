/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Diseño;

import DAO.SocioDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author pieri
 */
public class JpEditar extends javax.swing.JPanel {
    SocioDAO s1 = new SocioDAO();

    /**
     * Creates new form JpEditar
     */
    public JpEditar() {
        initComponents();
        btnBuscar.setEnabled(false);
        
        //LAS CAJAS DE TEXTO EMPIEZAN APAGADAS
        txtDNI.setEditable(false);
        txtNombres.setEditable(false);
        txtPaterno.setEditable(false);
        txtMaterno.setEditable(false);
        txtNacimiento.setEditable(false);
        txtEdad.setEditable(false);
        txtCel.setEditable(false);
        txtEmail.setEditable(false);
        txtDirecc.setEditable(false);
        txtAsoc.setEditable(false);
        txtPago.setEditable(false);
        txtFecha.setEditable(false);
        
        //EL BOTÓN EMPIEZA APAGADO
        btnEditar.setEnabled(false);
        btnValidar.setEnabled(false);
        btnGrabar.setEnabled(false);
        btnQuitar1.setEnabled(false);
        
        //LOS LBL EMPIEZAN APAGADOS
        lblDNI.setVisible(false);
        lblNombres.setVisible(false);
        lblPaterno.setVisible(false);
        lblMaterno.setVisible(false);
        lblNacimiento.setVisible(false);
        lblEdad.setVisible(false);
        lblCel.setVisible(false);
        lblEmail.setVisible(false);
        lblDirecc.setVisible(false);
        lblAsoc.setVisible(false);
        lblFecha.setVisible(false);
    }
    
    public void Limpiar() {
        txtBuscar.setText("");
        txtDNI.setText("");
        txtNombres.setText("");
        txtPaterno.setText("");
        txtMaterno.setText("");
        txtNacimiento.setText("");
        txtEdad.setText("");
        txtCel.setText("");
        txtEmail.setText("");
        txtDirecc.setText("");
        txtAsoc.setText("");
        txtPago.setText("");
        txtFecha.setText("");
    }
    
    //EXPRESIONES REGULARES 
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
    
    
    public void ValidarTodo(){
        //Prender el botón
        if (!DNI(txtDNI.getText().trim()) || !Letras(txtNombres.getText().trim()) || !Letras(txtPaterno.getText().trim()) 
            || !Letras(txtMaterno.getText().trim()) || !FechaN(txtNacimiento.getText().trim())
            || !Numeros(txtEdad.getText().trim()) || Integer.parseInt(txtEdad.getText())<18 || !ncel(txtCel.getText().trim())
            || !correo(txtEmail.getText().trim()) || txtDirecc.getText().isEmpty() || txtAsoc.getText().isEmpty() || txtPago.getText().isEmpty() || txtFecha.getText().isEmpty()
            || lblError.getText().equals("EL DNI ya está registrado")){
            JOptionPane.showMessageDialog(null, "Datos inválidos, por favor revisar y corregir");
            btnGrabar.setEnabled(false);
            btnBuscar.setEnabled(false);
            
        } else {
            txtDNI.setEditable(false);
            txtNombres.setEditable(false);
            txtPaterno.setEditable(false);
            txtMaterno.setEditable(false);
            txtNacimiento.setEditable(false);
            txtEdad.setEditable(false);
            txtCel.setEditable(false);
            txtEmail.setEditable(false);
            txtDirecc.setEditable(false);
            txtAsoc.setEditable(false);
            txtPago.setEditable(false);
            txtFecha.setEditable(false);
            
            btnQuitar1.setEnabled(false);
            btnGrabar.setEnabled(true);
            btnValidar.setEnabled(false);
            txtBuscar.setEditable(false);
            btnBuscar.setEnabled(false);
            btnEditar.setEnabled(false);
        }

    }
    
    public void ValidarVacios(){
        
        //Validando DNI
        if(txtDNI.getText().isEmpty()){
            lblDNI.setText("*");
        }else{
            lblDNI.setText("");
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
        
        //Validando FNacimiento
        if(txtNacimiento.getText().isEmpty()){
            lblNacimiento.setText("*");
        }else{
            lblNacimiento.setText("");
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
        || txtNombres.getText().isEmpty() || txtNacimiento.getText().isEmpty() || txtEdad.getText().isEmpty()
        || txtCel.getText().isEmpty() || txtEmail.getText().isEmpty() || txtDirecc.getText().isEmpty()
        || txtAsoc.getText().isEmpty() || txtPago.getText().isEmpty() || txtFecha.getText().isEmpty()
        || lblError.getText().equals("EL DNI ya está registrado")){
            btnValidar.setEnabled(false);
        }else{
            btnValidar.setEnabled(true);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtNacimiento = new javax.swing.JTextField();
        txtMaterno = new javax.swing.JTextField();
        txtPaterno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDirecc = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtAsoc = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnGrabar = new javax.swing.JButton();
        btnValidar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnQuitar1 = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        lblCel = new javax.swing.JLabel();
        lblDNI = new javax.swing.JLabel();
        lblPaterno = new javax.swing.JLabel();
        lblMaterno = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblNacimiento = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        lblAsoc = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblDirecc = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 51, 153));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("EDITAR FICHA DE SOCIO");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

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
        add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 250, 30));

        btnBuscar.setBackground(new java.awt.Color(0, 102, 102));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnBuscar.setFocusable(false);
        btnBuscar.setPreferredSize(new java.awt.Dimension(40, 40));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 50, 30));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Nombres:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Apellido Paterno:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Apellido Materno:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, -1, 20));

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Edad:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, -1));

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("DNI:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 33, -1));

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
        add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 140, -1));

        txtEdad.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtEdad.setForeground(new java.awt.Color(51, 51, 51));
        txtEdad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEdadKeyReleased(evt);
            }
        });
        add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 60, -1));

        txtNacimiento.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtNacimiento.setForeground(new java.awt.Color(51, 51, 51));
        txtNacimiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNacimientoActionPerformed(evt);
            }
        });
        txtNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNacimientoKeyReleased(evt);
            }
        });
        add(txtNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 120, -1));

        txtMaterno.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtMaterno.setForeground(new java.awt.Color(51, 51, 51));
        txtMaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaternoKeyReleased(evt);
            }
        });
        add(txtMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 130, -1));

        txtPaterno.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtPaterno.setForeground(new java.awt.Color(51, 51, 51));
        txtPaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtPaterno.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                txtPaternoComponentMoved(evt);
            }
        });
        txtPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaternoKeyReleased(evt);
            }
        });
        add(txtPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 120, -1));

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Fecha:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, -1, -1));

        txtCel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtCel.setForeground(new java.awt.Color(51, 51, 51));
        txtCel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCelKeyReleased(evt);
            }
        });
        add(txtCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, 120, -1));

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Fecha nacimiento:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, -1, -1));

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
        add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 100, -1));

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Celular:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, -1, -1));

        txtNombres.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtNombres.setForeground(new java.awt.Color(51, 51, 51));
        txtNombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombresKeyReleased(evt);
            }
        });
        add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 160, -1));

        jLabel11.setBackground(new java.awt.Color(51, 51, 51));
        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Domicilio:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, -1, -1));

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
        add(txtDirecc, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 220, 20));

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("N° asociados:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        txtAsoc.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtAsoc.setForeground(new java.awt.Color(51, 51, 51));
        txtAsoc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtAsoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAsocActionPerformed(evt);
            }
        });
        txtAsoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAsocKeyReleased(evt);
            }
        });
        add(txtAsoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 30, -1));

        jLabel13.setBackground(new java.awt.Color(51, 51, 51));
        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Mensualidad:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

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
        add(txtPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 50, -1));

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
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 130, -1));

        jLabel14.setBackground(new java.awt.Color(51, 51, 51));
        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Email:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, -1, -1));

        btnGrabar.setBackground(new java.awt.Color(0, 102, 102));
        btnGrabar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnGrabar.setForeground(new java.awt.Color(255, 255, 255));
        btnGrabar.setText("Grabar");
        btnGrabar.setFocusPainted(false);
        btnGrabar.setFocusable(false);
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });
        add(btnGrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, 130, 30));

        btnValidar.setBackground(new java.awt.Color(0, 102, 102));
        btnValidar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnValidar.setForeground(new java.awt.Color(255, 255, 255));
        btnValidar.setText("Validar");
        btnValidar.setFocusPainted(false);
        btnValidar.setFocusable(false);
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });
        add(btnValidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 130, 30));

        btnEditar.setBackground(new java.awt.Color(0, 102, 102));
        btnEditar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setFocusPainted(false);
        btnEditar.setFocusable(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 130, 30));

        btnQuitar1.setBackground(new java.awt.Color(255, 0, 0));
        btnQuitar1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnQuitar1.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar1.setText("X");
        btnQuitar1.setFocusPainted(false);
        btnQuitar1.setFocusable(false);
        btnQuitar1.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnQuitar1.setMinimumSize(new java.awt.Dimension(10, 10));
        btnQuitar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitar1ActionPerformed(evt);
            }
        });
        add(btnQuitar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, -1, 20));

        lblError.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 210, 20));

        lblCel.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblCel.setForeground(new java.awt.Color(255, 0, 0));
        add(lblCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, -1, -1));

        lblDNI.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblDNI.setForeground(new java.awt.Color(255, 0, 0));
        add(lblDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        lblPaterno.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblPaterno.setForeground(new java.awt.Color(255, 0, 0));
        add(lblPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        lblMaterno.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblMaterno.setForeground(new java.awt.Color(255, 0, 0));
        add(lblMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, -1, -1));

        lblEdad.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblEdad.setForeground(new java.awt.Color(255, 0, 0));
        add(lblEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, -1, -1));

        lblFecha.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 0, 0));
        add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, -1, -1));

        lblNacimiento.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblNacimiento.setForeground(new java.awt.Color(255, 0, 0));
        add(lblNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, -1, -1));

        lblNombres.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblNombres.setForeground(new java.awt.Color(255, 0, 0));
        add(lblNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        lblAsoc.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblAsoc.setForeground(new java.awt.Color(255, 0, 0));
        add(lblAsoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, -1, -1));

        lblEmail.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 0, 0));
        add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, -1, -1));

        lblDirecc.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblDirecc.setForeground(new java.awt.Color(255, 0, 0));
        add(lblDirecc, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, -1, -1));

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
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 50, -1));
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
                txtDNI.setText(s1.BDni(Buscar));
                txtNombres.setText(s1.BDnombres(Buscar));
                txtPaterno.setText(s1.BDPaterno(Buscar));
                txtMaterno.setText(s1.BDMaterno(Buscar));
                txtNacimiento.setText(s1.BDNacimiento(Buscar));
                txtEdad.setText(s1.BDEdad(Buscar));
                txtCel.setText(s1.BDCel(Buscar));
                txtEmail.setText(s1.BDEmail(Buscar));
                txtDirecc.setText(s1.BDDirecc(Buscar));
                txtAsoc.setText(s1.BDAsoc(Buscar));
                txtPago.setText(s1.BDPago(Buscar));
                txtFecha.setText(s1.BDFecha(Buscar));
                
                btnEditar.setEnabled(true);
                btnGrabar.setEnabled(false);
                txtBuscar.setEditable(false);
                btnCancelar.setEnabled(true);
                
            }else{
                Limpiar();
                JOptionPane.showMessageDialog(null, "DNI no registrado en la BD");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al enviar DNI"+e.getMessage());
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIActionPerformed

    private void txtDNIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
        
        String DNI=txtDNI.getText(); 
        
        try {
            s1.Duplicado(DNI);
            if(s1.Duplicado(DNI)==1){
                lblError.setText("EL DNI ya está registrado");
            }else{
                lblError.setText("");
            }
        } catch (Exception ex) {
            lblError.setText("Errores "+ex);
        }
    }//GEN-LAST:event_txtDNIKeyReleased

    private void txtEdadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtEdadKeyReleased

    private void txtNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNacimientoActionPerformed

    private void txtNacimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNacimientoKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtNacimientoKeyReleased

    private void txtMaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaternoKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtMaternoKeyReleased

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

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtFechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtFechaKeyReleased

    private void txtNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtNombresKeyReleased

    private void txtDireccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccActionPerformed

    private void txtDireccKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtDireccKeyReleased

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

    private void txtPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagoActionPerformed

    private void txtPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtPagoKeyReleased

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

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        // TODO add your handling code here:
        String COD= txtBuscar.getText();
        String DNI = txtDNI.getText();
        String nombre = txtNombres.getText();
        String apellidoP= txtPaterno.getText();
        String apellidoM= txtMaterno.getText();
        String Fnacimiento=txtNacimiento.getText();
        int edad= Integer.parseInt(txtEdad.getText());
        String celular= txtCel.getText();
        String correo =txtEmail.getText();
        String Direcc=txtDirecc.getText();
        int Asoc = Integer.parseInt(txtAsoc.getText());
        int pago=Integer.parseInt(txtPago.getText());
        String fecha=txtFecha.getText();

        //Se intenta enviar los datos a traves del metodo registrar creado en DAO
        try{
            s1.modificar(COD,DNI,nombre,apellidoP,apellidoM,Fnacimiento,edad,celular,correo,Direcc,Asoc,pago,fecha);
            txtBuscar.setEditable(true);
            Limpiar();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Hubo un error al modificar este registro "
                + ", verifique los datos e intentelo de nuevo: "+ e);
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed
        // TODO add your handling code here:
        ValidarTodo();
    }//GEN-LAST:event_btnValidarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        txtNombres.setEditable(true);
        txtPaterno.setEditable(true);
        txtMaterno.setEditable(true);
        txtNacimiento.setEditable(true);
        txtEdad.setEditable(true);
        txtCel.setEditable(true);
        txtEmail.setEditable(true);
        txtDirecc.setEditable(true);
        txtAsoc.setEditable(false);
        
        btnQuitar1.setEnabled(true);
        btnValidar.setEnabled(true);
        btnEditar.setEnabled(false);
        
        lblDNI.setVisible(true);
        lblNombres.setVisible(true);
        lblPaterno.setVisible(true);
        lblMaterno.setVisible(true);
        lblNacimiento.setVisible(true);
        lblEdad.setVisible(true);
        lblCel.setVisible(true);
        lblEmail.setVisible(true);
        lblDirecc.setVisible(true);
        lblFecha.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnQuitar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitar1ActionPerformed
        // TODO add your handling code here:
        txtAsoc.setText("");
        txtPago.setText("");
        txtAsoc.setEditable(true);
    }//GEN-LAST:event_btnQuitar1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        String botones [] = {"Salir","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "No se guardarán los datos, ¿Desea salir?", "La casa del maestro", 0, 0, null, botones, this);
        if(eleccion==JOptionPane.YES_OPTION){
           Limpiar();
           txtBuscar.setEditable(true);
        }else{
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtAsocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAsocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAsocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnQuitar1;
    private javax.swing.JButton btnValidar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblAsoc;
    private javax.swing.JLabel lblCel;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblDirecc;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMaterno;
    private javax.swing.JLabel lblNacimiento;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblPaterno;
    private javax.swing.JTextField txtAsoc;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCel;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDirecc;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNacimiento;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtPaterno;
    // End of variables declaration//GEN-END:variables
}
