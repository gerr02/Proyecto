/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author pieri
 */
public class CConexion {
    public Connection conexion;
    String usuario="root";
    String contraseña="123456789";
    String bd="lcdmclub";
    String ip="localhost";
    String puerto="3306";
    
    String cadena="jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public java.sql.Connection Conectar()throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion=DriverManager.getConnection(cadena,usuario,contraseña);
            //JOptionPane.showMessageDialog(null,"Se estableció conexión");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se estableció conexión"+e.toString());
        }
        return conexion;
    }
    
    //Metodo de cerrar la conexion a la base de datos
    public void cerrarConexion() throws SQLException{
        if(conexion!=null){
            if(!conexion.isClosed()){
                conexion.close();   
            }
        }
    }
}
