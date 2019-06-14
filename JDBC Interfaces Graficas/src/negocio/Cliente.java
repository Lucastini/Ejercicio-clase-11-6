/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Mosqueteros
 */
public class Cliente {
    
    private String nombre, apellido;
    private int tipo;
    private Date fechaNacimiento;
    private DateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
    
    public Cliente(String nom, String ape, int t, String strFecha){
        nombre=nom;
        apellido=ape;
        tipo=t;
        fechaNacimiento=stringToDate(strFecha);
    }
    
    public Date stringToDate(String strFecha){
        Date res=null;
        try{
            return formatoFecha.parse(strFecha);
        }catch(ParseException e){
            JOptionPane.showMessageDialog(null, "Error al convertir fecha. El formato ingresado no es valido, debe ser dd/MM/yyyy");
        }
        return res;
    }
    
    public int edad(){
        Date actual=new Date();
        long tiempo=actual.getTime()-fechaNacimiento.getTime();
        return (int)((tiempo/(long)(1000*60*60*24))/365l);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public DateFormat getFormatoFecha() {
        return formatoFecha;
    }

    public void setFormatoFecha(DateFormat formatoFecha) {
        this.formatoFecha = formatoFecha;
    }
    
    
    
}
