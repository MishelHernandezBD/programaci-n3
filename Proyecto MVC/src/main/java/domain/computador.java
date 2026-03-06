/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Mishel
 */
public class computador {
    //Atributos
    String color;
    String marca;
    String procesador;
    
    //Constructores

    public computador() {
    }

    public computador(String color) {
        this.color = color;
    }

    public computador(String marca, String procesador) {
        this.marca = marca;
        this.procesador = procesador;
    }
    
    
    //Metodos Get y Set
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }
    
    //Texto en cadena

    @Override//Significa que es un metodo polimorgico 
    public String toString() {
        return "computador{" + "color=" + color + ", marca=" + marca + ", procesador=" + procesador + '}';
    }
    
    
}
