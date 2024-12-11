/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Anual;
import Entidades.Mensual;
import Entidades.Pago;
import Utilidades.CConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author pieri
 */
public class PagosDAO extends CConexion{
    public void registro(int monto, String mes, String año, String fechaC, String fechaP, String DNI){
        try{
           this.Conectar();
            PreparedStatement st = conexion.prepareStatement("INSERT INTO pagos(Monto,Mes,Año,pagoscol,FechaPago,DniSocio)VALUES(?,?,?,?,?,?)"); 
            st.setInt(1, monto);
            st.setString(2, mes);
            st.setString(3, año);
            st.setString(4, fechaC);
            st.setString(5, fechaP);
            st.setString(6, DNI);
            st.execute();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar BD PAGO" + e);
        }
    }
    
    //LLENAR LA TABLA
    public ArrayList<Pago> listaPagos() throws Exception{
       ArrayList<Pago> Pagos = new ArrayList<>();
       try{
       this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT DniSocio,pagoscol,Monto,Mes,Año,FechaPago FROM pagos");
        ResultSet rs = st.executeQuery();
        while(rs.next()){
                Pago b = new Pago( rs.getString(1),rs.getString(2), rs.getInt(3), rs.getString(4),
                                          rs.getString(5), rs.getString(6));
                Pagos.add(b);
            }
       }catch(Exception e){
       }finally{
           this.cerrarConexion();
       }
       return Pagos;
    }
    
    //Buscar Año
    public ArrayList<Anual> listaPagosA(String Año) throws Exception{
       ArrayList<Anual> Anuales = new ArrayList<>();
       try{
       this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT DniSocio,Mes,Año,FechaPago,Monto FROM pagos WHERE YEAR(FechaPago)='"+Año+"'");
        ResultSet rs = st.executeQuery();
        while(rs.next()){
                Anual b = new Anual( rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));
                Anuales.add(b);
            }
       }catch(Exception e){
       }finally{
           this.cerrarConexion();
       }
       return Anuales;
   }
    
    //Buscar MES
    public ArrayList<Mensual> listaPagosM(String Año, int mes) throws Exception{
       ArrayList<Mensual> Mensuales = new ArrayList<>();
       try{
       this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT DniSocio,Mes,Año,FechaPago,Monto FROM pagos WHERE MONTH(FechaPago)='"+mes+"' AND YEAR(FechaPago)='"+Año+"'");
        ResultSet rs = st.executeQuery();
        while(rs.next()){
                Mensual b = new Mensual( rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));
                Mensuales.add(b);
            }
       }catch(Exception e){
       }finally{
           this.cerrarConexion();
       }
       return Mensuales;
   }
    
    //Buscar DNI
    public ArrayList<Anual> listaControl(String DNI) throws Exception{
       ArrayList<Anual> control= new ArrayList<>();
       try{
       this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT DniSocio,Mes,Año,FechaPago,Monto FROM pagos WHERE DniSocio='"+DNI+"'");
        ResultSet rs = st.executeQuery();
        while(rs.next()){
                Anual b = new Anual( rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));
                control.add(b);
            }
       }catch(Exception e){
       }finally{
           this.cerrarConexion();
       }
       return control;
   }
    
    public int TotalAnual(String Año) throws Exception{
        int totalA=0;
        this.Conectar();
        String busSQL="Select * FROM pagos WHERE YEAR(FechaPago)='"+Año+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            while(resul.next()==true){
                totalA=Integer.parseInt(resul.getString(2))+totalA;
            }
        }catch(Exception e){
        }
        return totalA;
    }
    
    public int TotalMensual(String Año, int mes) throws Exception{
        int totalM=0;
        this.Conectar();
        String busSQL="Select * FROM pagos WHERE MONTH(FechaPago)='"+mes+"' AND YEAR(FechaPago)='"+Año+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            while(resul.next()==true){
                totalM=Integer.parseInt(resul.getString(2))+totalM;
            }
        }catch(Exception e){
        }
        return totalM;
    }
}
