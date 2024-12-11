/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author pieri
 */
public class Evento {
    private String DniOrg;
    private String NombreOrg;
    private String NombreEvento;
    private String FechaEvento;
    private String FechaIngreso;
    private double PrecioEvento;
    
    public Evento(String DniOrg,String NombreOrg,String NombreEvento,String FechaEvento,String FechaIngreso,double PrecioEvento){
        this.DniOrg=DniOrg;
        this.NombreOrg=NombreOrg;
        this.NombreEvento=NombreEvento;
        this.FechaEvento=FechaEvento;
        this.FechaIngreso=FechaIngreso;
        this.PrecioEvento=PrecioEvento;
    }

    /**
     * @return the DniOrg
     */
    public String getDniOrg() {
        return DniOrg;
    }

    /**
     * @param DniOrg the DniOrg to set
     */
    public void setDniOrg(String DniOrg) {
        this.DniOrg = DniOrg;
    }

    /**
     * @return the NombreOrg
     */
    public String getNombreOrg() {
        return NombreOrg;
    }

    /**
     * @param NombreOrg the NombreOrg to set
     */
    public void setNombreOrg(String NombreOrg) {
        this.NombreOrg = NombreOrg;
    }

    /**
     * @return the NombreEvento
     */
    public String getNombreEvento() {
        return NombreEvento;
    }

    /**
     * @param NombreEvento the NombreEvento to set
     */
    public void setNombreEvento(String NombreEvento) {
        this.NombreEvento = NombreEvento;
    }

    /**
     * @return the FechaEvento
     */
    public String getFechaEvento() {
        return FechaEvento;
    }

    /**
     * @param FechaEvento the FechaEvento to set
     */
    public void setFechaEvento(String FechaEvento) {
        this.FechaEvento = FechaEvento;
    }

    /**
     * @return the FechaIngreso
     */
    public String getFechaIngreso() {
        return FechaIngreso;
    }

    /**
     * @param FechaIngreso the FechaIngreso to set
     */
    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    /**
     * @return the PrecioEvento
     */
    public double getPrecioEvento() {
        return PrecioEvento;
    }

    /**
     * @param PrecioEvento the PrecioEvento to set
     */
    public void setPrecioEvento(double PrecioEvento) {
        this.PrecioEvento = PrecioEvento;
    }
    
    
}
