/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Mishel
 */
public class Cursos {
    private int codigoCurso;
    private String nombreCur;
    private String estatusCur;

    public Cursos() {
    }
    
    public Cursos(int codigoCurso, String nombreCur) {
        this.codigoCurso = codigoCurso;
    }

    public Cursos(String nombreCur, String estatusCur) {
        this.nombreCur = nombreCur;
        this.estatusCur = estatusCur;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombreCur() {
        return nombreCur;
    }

    public void setNombreCur(String nombreCur) {
        this.nombreCur = nombreCur;
    }

    public String getEstatusCur() {
        return estatusCur;
    }

    public void setEstatusCur(String estatusCur) {
        this.estatusCur = estatusCur;
    }

    @Override
    public String toString() {
        return "cursos{" + "codigoCurso=" + codigoCurso + ", nombreCur=" + nombreCur + ", estatusCur=" + estatusCur + '}';
    }
}
