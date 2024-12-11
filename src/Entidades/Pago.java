/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author pieri
 */
public class Pago {
    private String dniSocio;
    private String fechaR;
    private int monto;
    private String mes;
    private String año;
    private String fechaPago;
    
    public Pago(String dniSocio, String fechaR, int monto, String mes, String año, String fechaPago){
        this.dniSocio=dniSocio;
        this.fechaR=fechaR;
        this.monto=monto;
        this.mes=mes;
        this.año=año;
        this.fechaPago=fechaPago;
    }

    /**
     * @return the dniSocio
     */
    public String getDniSocio() {
        return dniSocio;
    }

    /**
     * @param dniSocio the dniSocio to set
     */
    public void setDniSocio(String dniSocio) {
        this.dniSocio = dniSocio;
    }

    /**
     * @return the fechaR
     */
    public String getFechaR() {
        return fechaR;
    }

    /**
     * @param fechaR the fechaR to set
     */
    public void setFechaR(String fechaR) {
        this.fechaR = fechaR;
    }

    /**
     * @return the monto
     */
    public int getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(int monto) {
        this.monto = monto;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * @return the año
     */
    public String getAño() {
        return año;
    }

    /**
     * @param año the año to set
     */
    public void setAño(String año) {
        this.año = año;
    }

    /**
     * @return the fechaPago
     */
    public String getFechaPago() {
        return fechaPago;
    }

    /**
     * @param fechaPago the fechaPago to set
     */
    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }
    
}
