/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Diseño.FrmSesion;
import Diseño.frmSelect;
import Utilidades.CConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author pieri
 */
public class SesionDAO extends CConexion{

    
    public int validarUsuario(String usuario, String contraseña) throws Exception{
        int resul=0;
        this.Conectar();
        String consulSQL=("SELECT * FROM admin where CodAdmin ='"+usuario+"' "
                                   + "and Contraseña ='"+contraseña+"'");
        try{           
           PreparedStatement st=conexion.prepareStatement(consulSQL);            
           ResultSet rs = st.executeQuery(consulSQL);
           
           if(rs.next()){
               resul=1;
           }
       }
        catch(Exception e){
           JOptionPane.showMessageDialog(null, "ERROR: "+e);
       }
        finally{
           this.cerrarConexion();
       } 
        return resul;
    }
}
