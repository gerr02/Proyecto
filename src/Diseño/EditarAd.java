/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Diseño;

import DAO.AdmiDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author pieri
 */
public class EditarAd extends javax.swing.JPanel {
    AdmiDAO A1 = new AdmiDAO();
    
    /**
     * Creates new form EditarAd
     */
    public EditarAd() {
        initComponents();
        
        //Cajas de texto
        txtUsuario.setEditable(false);
        txtDNI.setEditable(false);
        txtNombres.setEditable(false);
        txtApellidos.setEditable(false);
        txtEmail.setEditable(false);
        txtDirecc.setEditable(false);
        txtCelular.setEditable(false);
        txtContra.setEditable(false);
        
        //botones apagados
        btnBuscar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnValidar.setEnabled(false);
        btnGrabar.setEnabled(false);
        
        //LOS LBL EMPIEZAN APAGADOS
        lblDni.setVisible(false);
        lblApellidos.setVisible(false);
        lblNombres.setVisible(false);
        lblEmail.setVisible(false);
        lblDirecc.setVisible(false);
        lblCel.setVisible(false);
        lblUsuario.setVisible(false);
        lblContraseña.setVisible(false); 
    }
    
    public void Limpiar() {
        txtBuscar.setText("");
        txtDNI.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtEmail.setText("");
        txtDirecc.setText("");
        txtCelular.setText("");
        txtUsuario.setText("");
        txtContra.setText("");
    }
    
    public static boolean Letras(String dato){
        return dato.matches("[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?(( |\\-)[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?)*");
    }
    
    public static boolean DNI(String dato){
        return dato.matches("[0-9]{8}");
    }
    
    public static boolean Contra(String dato){
        return dato.matches("^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$");
    }
    
    public static boolean ncel(String dato){
        return dato.matches("(9)[0-9]{8}");
    }
    public static boolean correo(String dato){
        return dato.matches("[A-Za-z0-9+_.-]+@(.+)$");
    }
    
    
    
    public void ValidarVacios(){
        
        //Validando DNI
        if(txtDNI.getText().isEmpty()){
            lblDni.setText("*");
        }else{
            lblDni.setText("");
        }
        
        //Validando Apellidos
        if(txtApellidos.getText().isEmpty()){
            lblNombres.setText("*");
        }else{
            lblNombres.setText("");
        }
        
        //Validando Nombres
        if(txtNombres.getText().isEmpty()){
            lblApellidos.setText("*");
        }else{
            lblApellidos.setText("");
        }
        
        //Validando Celular
        if(txtCelular.getText().isEmpty()){
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
        
        //Validando el usuario
        if(txtUsuario.getText().isEmpty()){
            lblUsuario.setText("*");
        }else{
            lblUsuario.setText("");
        }
        
        //Validando contraseña
        if(txtContra.getText().isEmpty()){
            lblContraseña.setText("*");
        }else{
            lblContraseña.setText("");
        }
        
        
        
        if(txtDNI.getText().isEmpty() || txtApellidos.getText().isEmpty()
        || txtNombres.getText().isEmpty() || txtCelular.getText().isEmpty() || txtDirecc.getText().isEmpty()
        || txtEmail.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtContra.getText().isEmpty()){
            btnValidar.setEnabled(false);
        }else{
            btnValidar.setEnabled(true);
        }
    }
    
    public void ValidarTodo(){
        //Prender el botón
        if (!DNI(txtDNI.getText().trim()) || !Letras(txtNombres.getText().trim()) || !Letras(txtApellidos.getText().trim()) 
            || !Contra(txtContra.getText()) || txtUsuario.getText().isEmpty() || !ncel(txtCelular.getText().trim())
            || !correo(txtEmail.getText().trim()) || txtDirecc.getText().isEmpty()
            || lblError.getText().equals("EL DNI ya está registrado")){
            JOptionPane.showMessageDialog(null, "Datos inválidos, por favor revisar y corregir");
            btnGrabar.setEnabled(false);
        } else {
            btnGrabar.setEnabled(true);
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
        btnCancelar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JLabel();
        txtDirecc = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lblCel = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        lblNombres = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        lblDirecc = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        txtContra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnGrabar = new javax.swing.JButton();
        btnValidar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        txtBuscar1 = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 51, 153));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("EDITAR FICHA DE ADMINISTRADOR");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, -1));

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

        txtUsuario.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(51, 51, 51));
        txtUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });
        add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 160, -1));

        jLabel17.setBackground(new java.awt.Color(51, 51, 51));
        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("Nombres:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, -1, -1));

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("DNI:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 33, -1));

        txtNombres.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtNombres.setForeground(new java.awt.Color(51, 51, 51));
        txtNombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombresKeyReleased(evt);
            }
        });
        add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 170, -1));

        txtContraseña.setBackground(new java.awt.Color(51, 51, 51));
        txtContraseña.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(0, 102, 102));
        txtContraseña.setText("Contraseña:");
        add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, -1, -1));

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
        add(txtDirecc, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 160, 20));

        jLabel15.setBackground(new java.awt.Color(51, 51, 51));
        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Celular:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, -1, -1));

        lblCel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblCel.setForeground(new java.awt.Color(255, 0, 0));
        add(lblCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 290, 20, 20));

        txtCelular.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtCelular.setForeground(new java.awt.Color(51, 51, 51));
        txtCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtCelular.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                txtCelularComponentMoved(evt);
            }
        });
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCelularKeyReleased(evt);
            }
        });
        add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 180, -1));

        lblNombres.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblNombres.setForeground(new java.awt.Color(255, 0, 0));
        add(lblNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 20, 20));

        lblUsuario.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 0, 0));
        add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 30, 20));

        lblDni.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblDni.setForeground(new java.awt.Color(255, 0, 0));
        add(lblDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 20, -1));

        lblDirecc.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblDirecc.setForeground(new java.awt.Color(255, 0, 0));
        add(lblDirecc, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 20, 20));

        lblApellidos.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblApellidos.setForeground(new java.awt.Color(255, 0, 0));
        add(lblApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 20, 20));

        lblContraseña.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblContraseña.setForeground(new java.awt.Color(255, 0, 0));
        add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, 20, 20));

        lblEmail.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 0, 0));
        add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 250, 20, 20));

        jLabel24.setBackground(new java.awt.Color(51, 51, 51));
        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 102, 102));
        jLabel24.setText("Domicilio:");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        jLabel23.setBackground(new java.awt.Color(51, 51, 51));
        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 102));
        jLabel23.setText("Apellidos:");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, 20));

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
        add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 190, -1));

        txtContra.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtContra.setForeground(new java.awt.Color(51, 51, 51));
        txtContra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContraKeyReleased(evt);
            }
        });
        add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 160, -1));

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Usuario:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));

        txtApellidos.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtApellidos.setForeground(new java.awt.Color(51, 51, 51));
        txtApellidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidosKeyReleased(evt);
            }
        });
        add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 160, -1));

        jLabel16.setBackground(new java.awt.Color(51, 51, 51));
        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("Email:");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, -1, -1));

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
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 190, -1));

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
        add(btnGrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 130, 30));

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
        add(btnValidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 130, 30));

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
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 130, 30));

        lblError.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 210, 20));

        txtBuscar1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtBuscar1.setForeground(new java.awt.Color(51, 51, 51));
        txtBuscar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar1ActionPerformed(evt);
            }
        });
        txtBuscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscar1KeyReleased(evt);
            }
        });
        add(txtBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 250, 30));

        btnBuscar1.setBackground(new java.awt.Color(0, 102, 102));
        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnBuscar1.setFocusable(false);
        btnBuscar1.setPreferredSize(new java.awt.Dimension(40, 40));
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 50, 30));

        btnCancelar1.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnCancelar1.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar1.setText("X");
        btnCancelar1.setFocusable(false);
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });
        add(btnCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 50, -1));
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
            if(A1.Busqueda(Buscar)==1){
                txtUsuario.setText(A1.Busuario(Buscar));
                txtDNI.setText(A1.BDni(Buscar));
                txtNombres.setText(A1.BDnombres(Buscar));
                txtApellidos.setText(A1.BDApellidos(Buscar));
                txtContra.setText(A1.BDContra(Buscar));
                txtEmail.setText(A1.BDEmail(Buscar));
                txtDirecc.setText(A1.BDDirecc(Buscar));
                txtCelular.setText(A1.BDCel(Buscar));

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

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtUsuarioKeyReleased

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

    private void txtCelularComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_txtCelularComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularComponentMoved

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtCelularKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtCelularKeyReleased

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIActionPerformed

    private void txtDNIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtDNIKeyReleased

    private void txtContraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtContraKeyReleased

    private void txtApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyReleased
        // TODO add your handling code here:
        ValidarVacios();
    }//GEN-LAST:event_txtApellidosKeyReleased

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
        String busqueda= txtBuscar.getText();
        String user = txtUsuario.getText();
        String DNI = txtDNI.getText();
        String nombre = txtNombres.getText();
        String apellidos= txtApellidos.getText();
        String contra = txtContra.getText();
        String correo =txtEmail.getText();
        String celular= txtCelular.getText();
        String Direcc=txtDirecc.getText();
        

        //Se intenta enviar los datos a traves del metodo registrar creado en DAO
        try{
            A1.modificar(busqueda,user, DNI,nombre,apellidos,contra,correo,celular,Direcc);
            JOptionPane.showMessageDialog(null, "Modificado con éxito");
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
        txtUsuario.setEditable(true);
        txtDNI.setEditable(true);
        txtNombres.setEditable(true);
        txtApellidos.setEditable(true);
        txtEmail.setEditable(true);
        txtDirecc.setEditable(true);
        txtCelular.setEditable(true);
        txtContra.setEditable(true);

        btnValidar.setEnabled(true);
        btnEditar.setEnabled(false);

        //LOS LBL SE ENCIENDEN
        lblDni.setVisible(true);
        lblApellidos.setVisible(true);
        lblNombres.setVisible(true);
        lblEmail.setVisible(true);
        lblDirecc.setVisible(true);
        lblCel.setVisible(true);
        lblUsuario.setVisible(true);
        lblContraseña.setVisible(true); 
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar1ActionPerformed

    private void txtBuscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar1KeyReleased

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnValidar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCel;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblDirecc;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscar1;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtContra;
    private javax.swing.JLabel txtContraseña;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDirecc;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
