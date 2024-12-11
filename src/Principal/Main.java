/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Diseño.FrmSesion;
import Utilidades.CConexion;

/**
 *
 * @author pieri
 */
public class Main {
    public static void main(String[] args) throws Exception {
        CConexion conex = new CConexion();
        conex.Conectar();
        FrmSesion frm1 = new FrmSesion();
        frm1.setVisible(true);
    }
}
