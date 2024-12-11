/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utilidades.CConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author pieri
 */
public class AdmiDAO extends CConexion{
    public void registrar(String cod, String DNI, String nombre,
            String apellidos,String contraseña,String Email, String celular,
            String direccion) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = conexion.prepareStatement("INSERT INTO admin(CodAdmin,DniAd,NombreAd,ApellidosAd,Contraseña,EmailAd,"
                    + "CelularAd, DireccionAd) VALUES(?,?,?,?,?,?,?,?)");

            st.setString(1, cod);
            st.setString(2, DNI);
            st.setString(3, nombre);
            st.setString(4, apellidos);
            st.setString(5, contraseña);
            st.setString(6, Email);
            st.setString(7, celular);
            st.setString(8, direccion);
            st.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar tabla admi" + e);
        } finally {
            this.cerrarConexion();
        }
    }
    
    public int Busqueda (String DNI) throws Exception{
        int total=0;
        this.Conectar();
        String busSQL="Select * from admin where DniAd='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                total=1;
            }else{
                total=0;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se realizó busqueda"+e.getMessage());
        }return total;
    }
    
    //BUSCAR USUARIO EN LA BD
    public String Busuario (String DNI) throws Exception{
        String usuario="";
        this.Conectar();
        String busSQL="Select * from admin where DniAd='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                usuario=(resul.getString(1));
            }
        }catch(Exception e){
        }return usuario;
    }
    
    //BUSCAR DNI EN LA BD
    public String BDni (String DNI) throws Exception{
        String Dni="";
        this.Conectar();
        String busSQL="Select * from admin where DniAd='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                Dni=(resul.getString(2));
            }
        }catch(Exception e){
        }return Dni;
    }
    
    //BUSCAR NOMBRES EN LA BD
    public String BDnombres (String DNI) throws Exception{
        String nombres="";
        this.Conectar();
        String busSQL="Select * from admin where DniAd='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                nombres=(resul.getString(3));
            }
        }catch(Exception e){
        }return nombres;
    }
    
     //BUSCAR NOMBRES EN LA BD
        public String BDApellidos (String DNI) throws Exception{
        String apellidos="";
        this.Conectar();
        String busSQL="Select * from admin where DniAd='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                apellidos=(resul.getString(4));
            }
        }catch(Exception e){
        }return apellidos;
    }
        
    //BUSCAR NOMBRES EN LA BD
        public String BDContra (String DNI) throws Exception{
        String contra="";
        this.Conectar();
        String busSQL="Select * from admin where DniAd='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                contra=(resul.getString(5));
            }
        }catch(Exception e){
        }return contra;
    }
        
    //BUSCAR  EMAIL EN LA BD
    public String BDEmail (String DNI) throws Exception{
        String email="";
        this.Conectar();
        String busSQL="Select * from admin where DniAd='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                email=(resul.getString(6));
            }
        }catch(Exception e){
        }return email;
    }
    
    //BUSCAR CELULAR EN LA BD
    public String BDCel (String DNI) throws Exception{
        String cel="";
        this.Conectar();
        String busSQL="Select * from admin where DniAd='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                cel=(resul.getString(7));
            }
        }catch(Exception e){
        }return cel;
    }
    
    //BUSCAR  DIRECC EN LA BD
    public String BDDirecc (String DNI) throws Exception{
        String direcc="";
        this.Conectar();
        String busSQL="Select * from admin where DniAd='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                direcc=(resul.getString(8));
            }
        }catch(Exception e){
        }return direcc;
    }
    
    public void modificar(String busqueda,String user, String DNI,String nombre,String apellidos,String contra,String correo,String celular,String Direcc)throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("UPDATE admin set CodAdmin=?, DniAd=?,NombreAd=?,ApellidosAd=?,contraseña=?,"
                    + "EmailAd=?,CelularAd=?, DireccionAd=? WHERE DniAd='"+busqueda+"'");
        st.setString(1, user);
        st.setString(2, DNI);
        st.setString(3, nombre);
        st.setString(4, apellidos);
        st.setString(5, contra);
        st.setString(6, correo);
        st.setString(7, celular);
        st.setString(8, Direcc);
        st.execute();
        
        JOptionPane.showMessageDialog(null, "Modificacion exitosa");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al modificar DAO "+e);
        }finally{
            this.cerrarConexion();
        }
    }
    
    public void eliminar(String dni)throws Exception{
    try{
    this.Conectar();
     PreparedStatement st = this.conexion.prepareStatement("DELETE FROM admin "
           + " WHERE DniAd='"+dni+"'");
        st.execute();
             
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se eliminó el registro"+e);
        }finally{
           this.cerrarConexion();  
        }
    } 
      
    
    //BUSCANDO DUPLICADOS EN LA BD
    public int Duplicado(String DNI) throws Exception{
        int duplicado = 0;
        this.Conectar();
        String consultaSQL = ("SELECT * FROM admin where DniAd ='" + DNI+"'");
        try {
            PreparedStatement ste = conexion.prepareStatement(consultaSQL);
            ResultSet rst = ste.executeQuery(consultaSQL);

            if (rst.next()) {
                duplicado = 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONSULTA: " + e);
        } finally {
            this.cerrarConexion();
        }
        return duplicado;
    }
}
