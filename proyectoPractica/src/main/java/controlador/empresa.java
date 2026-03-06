/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Mishel
 */
public class empresa {
    //Atributos probados
    int codigoEmpresa; 
    String nombreEmpresa;
    
    //Constructores 
    public empresa(int codigo) {
        this.codigoEmpresa = codigo;
    }
    
    public empresa(int codigo, String nombre) {
        this.codigoEmpresa = codigo;
        this.nombreEmpresa = nombre;
    }

    //Metodo Get o Obtener
    public int getCodigoEmpresa() {
        return codigoEmpresa;
    }
    
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    //Metodos Set o Establecer
    public void setCodigoEmpresa(int codigo) {
        this.codigoEmpresa = codigo;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }  
    
    //
    @Override
    public String toString() {
        return "empresa{" + "codigoEmpresa=" + codigoEmpresa + ", nombreEmpresa=" + nombreEmpresa + '}';
    }
}
