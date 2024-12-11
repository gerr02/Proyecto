/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Diseño.JpEditar;
import Entidades.Socio;
import Utilidades.CConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author pieri
 */
public class SocioDAO extends CConexion {

    public void registrar(String dni, String nombre,
            String apellidoPaterno, String apellidoMaterno,
            String Fnacimiento, int edad, String celular,
            String Email, String direccion,
            int asociados, int mensualidad, String Finscripcion) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = conexion.prepareStatement("INSERT INTO socios(DniSocio,NombreSocio,ApellidopSocio,ApellidomSocio,FnacimientoSocio,"
                    + "EdadSocio,CelularSocio,EmailSocio,DireccionSocio,Subasociados,Mensualidad,"
                    + "FechaInscripcion) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");

            st.setString(1, dni);
            st.setString(2, nombre);
            st.setString(3, apellidoPaterno);
            st.setString(4, apellidoMaterno);
            st.setString(5, Fnacimiento);
            st.setInt(6, edad);
            st.setString(7, celular);
            st.setString(8, Email);
            st.setString(9, direccion);
            st.setInt(10, asociados);
            st.setInt(11, mensualidad);
            st.setString(12, Finscripcion);
            st.execute();
            
            JOptionPane.showMessageDialog(null, "Registrado con éxito");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        } finally {
            this.cerrarConexion();
        }
    }
    
    public int Busqueda (String DNI) throws Exception{
        int total=0;
        this.Conectar();
        String busSQL="Select * from socios where DniSocio='"+DNI+"'";
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
    
    //BUSCAR DNI EN LA BD
    public String BDni (String DNI) throws Exception{
        String Dni="";
        this.Conectar();
        String busSQL="Select * from socios where DniSocio='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                Dni=(resul.getString(1));
            }
        }catch(Exception e){
        }return Dni;
    }

    //BUSCAR NOMBRES EN LA BD
    public String BDnombres (String DNI) throws Exception{
        String nombres="";
        this.Conectar();
        String busSQL="Select * from socios where DniSocio='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                nombres=(resul.getString(2));
            }
        }catch(Exception e){
        }return nombres;
    }
    
    //BUSCAR A.PATERNO EN LA BD
    public String BDPaterno (String DNI) throws Exception{
        String pater="";
        this.Conectar();
        String busSQL="Select * from socios where DniSocio='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                pater=(resul.getString(3));
            }
        }catch(Exception e){
        }return pater;
    }
    
        //BUSCAR A.MATERNO EN LA BD
    public String BDMaterno (String DNI) throws Exception{
        String Mater="";
        this.Conectar();
        String busSQL="Select * from socios where DniSocio='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                Mater=(resul.getString(4));
            }
        }catch(Exception e){
        }return Mater;
    }
    
    
    //BUSCAR F.NACIMIENTO EN LA BD
    public String BDNacimiento (String DNI) throws Exception{
        String Nacimiento="";
        this.Conectar();
        String busSQL="Select * from socios where DniSocio='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                Nacimiento=(resul.getString(5));
            }
        }catch(Exception e){
        }return Nacimiento;
    }
    
    //BUSCAR EDAD EN LA BD
    public String BDEdad (String DNI) throws Exception{
        String edad="";
        this.Conectar();
        String busSQL="Select * from socios where DniSocio='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                edad=(resul.getString(6));
            }
        }catch(Exception e){
        }return edad;
    }
    
    //BUSCAR CELULAR EN LA BD
    public String BDCel (String DNI) throws Exception{
        String cel="";
        this.Conectar();
        String busSQL="Select * from socios where DniSocio='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                cel=(resul.getString(7));
            }
        }catch(Exception e){
        }return cel;
    }
    
     //BUSCAR  EMAIL EN LA BD
    public String BDEmail (String DNI) throws Exception{
        String email="";
        this.Conectar();
        String busSQL="Select * from socios where DniSocio='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                email=(resul.getString(8));
            }
        }catch(Exception e){
        }return email;
    }
    
     //BUSCAR  DIRECC EN LA BD
    public String BDDirecc (String DNI) throws Exception{
        String direcc="";
        this.Conectar();
        String busSQL="Select * from socios where DniSocio='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                direcc=(resul.getString(9));
            }
        }catch(Exception e){
        }return direcc;
    }
    
     //BUSCAR  SUBASOCIADOS EN LA BD
    public String BDAsoc (String DNI) throws Exception{
        String asoc="";
        this.Conectar();
        String busSQL="Select * from socios where DniSocio='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                asoc=(resul.getString(10));
            }
        }catch(Exception e){
        }return asoc;
    }
    
     //BUSCAR  PAGO EN LA BD
    public String BDPago (String DNI) throws Exception{
        String pago="";
        this.Conectar();
        String busSQL="Select * from socios where DniSocio='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                pago=(resul.getString(11));
            }
        }catch(Exception e){
        }return pago;
    }
    
     //BUSCAR  FECHA INSCRIPCION EN LA BD
    public String BDFecha (String DNI) throws Exception{
        String fecha="";
        this.Conectar();
        String busSQL="Select * from socios where DniSocio='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                fecha=(resul.getString(12));
            }
        }catch(Exception e){
        }return fecha;
    }
    
    
    
    
    
    
    //BUSCANDO DUPLICADOS EN LA BD
    public int Duplicado(String DNI) throws Exception{
        int duplicado = 0;
        this.Conectar();
        String consultaSQL = ("SELECT * FROM socios where DniSocio ='" + DNI+"'");
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
    
    public void modificar(String cod,String dni, String nombre, String apellidoPaterno, String apellidoMaterno,
        String Fnacimiento, int edad, String celular, String Email, String direccion,
        int asociados, int mensualidad, String Finscripcion)throws Exception{
    try{
        this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("UPDATE socios set DniSocio=?, NombreSocio=?,ApellidopSocio=?,ApellidomSocio=?,FnacimientoSocio=?,"
                    + "EdadSocio=?,CelularSocio=?,EmailSocio=?,DireccionSocio=?,Subasociados=?,Mensualidad=?,"
                    + "FechaInscripcion=? WHERE DniSocio='"+cod+"'");
        st.setString(1, dni);
        st.setString(2, nombre);
        st.setString(3, apellidoPaterno);
        st.setString(4, apellidoMaterno);
        st.setString(5, Fnacimiento);
        st.setInt(6, edad);
        st.setString(7, celular);
        st.setString(8, Email);
        st.setString(9, direccion);
        st.setInt(10, asociados);
        st.setInt(11, mensualidad);
        st.setString(12, Finscripcion);
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
     PreparedStatement st = this.conexion.prepareStatement("DELETE FROM socios "
           + " WHERE DniSocio=?");
             st.setString(1, dni);
             st.execute();
    }catch(Exception e){
                throw e;
          }finally{
           this.cerrarConexion();  
          }
    } 
    
    
    
    //LLENAR LA TABLA
    public ArrayList<Socio> listaAlumno() throws Exception{
       ArrayList<Socio> Socios = new ArrayList<>();
       try{
       this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM socios");
        ResultSet rs = st.executeQuery();
        while(rs.next()){
                Socio a = new Socio( rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4),
                                          rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8),
                                          rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getString(12));
                Socios.add(a);
            }
       }catch(Exception e){
       }finally{
           this.cerrarConexion();
       }
       return Socios;
   }  
    
}
