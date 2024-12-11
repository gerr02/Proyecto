/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author pieri
 */
public class Socio {
   private String dni; 
    private String nombre;
    private String apellidoPaterno; 
    private String apellidoMaterno;
    private String Fnacimiento; 
    private int edad; 
    private String celular;
    private String Email; 
    private String direccion;
    private int asociados; 
    private int mensualidad; 
    private String Finscripcion;
    
    public Socio (String dni, String nombre,String apellidoPaterno, String apellidoMaterno,
        String Fnacimiento, int edad, String celular, String Email, String direccion,
        int asociados, int mensualidad, String Finscripcion){
        
        this.dni=dni;
        this.nombre=nombre;
        this.apellidoPaterno=apellidoPaterno;
        this.apellidoMaterno=apellidoMaterno;
        this.Fnacimiento=Fnacimiento;
        this.edad=edad;
        this.celular=celular;
        this.Email=Email;
        this.direccion=direccion;
        this.asociados=asociados;
        this.mensualidad=mensualidad;
        this.Finscripcion=Finscripcion;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return the Fnacimiento
     */
    public String getFnacimiento() {
        return Fnacimiento;
    }

    /**
     * @param Fnacimiento the Fnacimiento to set
     */
    public void setFnacimiento(String Fnacimiento) {
        this.Fnacimiento = Fnacimiento;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the asociados
     */
    public int getAsociados() {
        return asociados;
    }

    /**
     * @param asociados the asociados to set
     */
    public void setAsociados(int asociados) {
        this.asociados = asociados;
    }

    /**
     * @return the mensualidad
     */
    public int getMensualidad() {
        return mensualidad;
    }

    /**
     * @param mensualidad the mensualidad to set
     */
    public void setMensualidad(int mensualidad) {
        this.mensualidad = mensualidad;
    }

    /**
     * @return the Finscripcion
     */
    public String getFinscripcion() {
        return Finscripcion;
    }

    /**
     * @param Finscripcion the Finscripcion to set
     */
    public void setFinscripcion(String Finscripcion) {
        this.Finscripcion = Finscripcion;
    } 
}
