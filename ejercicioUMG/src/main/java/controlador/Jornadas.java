/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Mishel
 */
public class Jornadas {
    private int codigoJornada;
    private String nombreJor;

    public Jornadas() {
    }

    public Jornadas(int codigoJornada) {
        this.codigoJornada = codigoJornada;
    }

    public Jornadas(int codigoJornada, String nombreJor) {
        this.codigoJornada = codigoJornada;
        this.nombreJor = nombreJor;
    }

    public int getCodigoJornada() {
        return codigoJornada;
    }

    public void setCodigoJornada(int codigoJornada) {
        this.codigoJornada = codigoJornada;
    }

    public String getNombreJor() {
        return nombreJor;
    }

    public void setNombreJor(String nombreJor) {
        this.nombreJor = nombreJor;
    }

    @Override
    public String toString() {
        return "Jornadas{" + "codigoJornada=" + codigoJornada + ", nombreJor=" + nombreJor + '}';
    }
        
}
