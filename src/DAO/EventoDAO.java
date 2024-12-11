/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Evento;
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
public class EventoDAO extends CConexion{
    public void registrar(String dniO, String nombreO, String nombreE, String FechaE, String fechaIns, double precio) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = conexion.prepareStatement("INSERT INTO eventos(DniOrg,NombreOrg,NombreEvento,FechaEvento,FechaIngreso,PrecioEvento) VALUES(?,?,?,?,?,?)");

            st.setString(1, dniO);
            st.setString(2, nombreO);
            st.setString(3, nombreE);
            st.setString(4, FechaE);
            st.setString(5, fechaIns);
            st.setDouble(6, precio);
            st.execute();
            JOptionPane.showMessageDialog(null, "Registrado con éxito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
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
    
    public String BDnombres (String DNI) throws Exception{
        String nombres="", apellidos="", apellidos2="";
        this.Conectar();
        String busSQL="Select * from socios where DniSocio='"+DNI+"'";
        try {
            java.sql.Statement st=Conectar().createStatement();
            java.sql.ResultSet resul = st.executeQuery(busSQL);
            
            if(resul.next()){
                nombres=(resul.getString(2));
                apellidos=(resul.getString(3));
                apellidos2=(resul.getString(4));
            }
        }catch(Exception e){
        }return nombres+" "+apellidos+" "+apellidos2;
    }
    
    
    public int FechaR (String fecha) throws Exception{
        int total=0;
        this.Conectar();
        String busSQL="Select * from eventos where FechaEvento='"+fecha+"'";
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
    
    //LLENAR EVENTOS
    public ArrayList<Evento> listaEventos(int mes, int año) throws Exception{
       ArrayList<Evento> Eventos = new ArrayList<>();
       try{
       this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM eventos WHERE MONTH(FechaEvento)='"+mes+"' AND YEAR(FechaEvento)='"+año+"'");
        ResultSet rs = st.executeQuery();
        while(rs.next()){
                Evento b = new Evento( rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4),
                                          rs.getString(5), rs.getDouble(6));
                Eventos.add(b);
            }
       }catch(Exception e){
       }finally{
           this.cerrarConexion();
       }
       return Eventos;
    }
    
    public ArrayList<Evento> listaEventosB(String Año, int mes) throws Exception{
       ArrayList<Evento> Eventos = new ArrayList<>();
       try{
       this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM eventos WHERE MONTH(FechaEvento)='"+mes+"' AND YEAR(FechaEvento)='"+Año+"'");
        ResultSet rs = st.executeQuery();
        while(rs.next()){
                Evento b = new Evento( rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4),
                                          rs.getString(5), rs.getDouble(6));
                Eventos.add(b);
            }
       }catch(Exception e){
       }finally{
           this.cerrarConexion();
       }
       return Eventos;
    }
}
