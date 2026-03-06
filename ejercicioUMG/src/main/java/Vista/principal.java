/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.util.List;
//Importacion de Objetos y sus DAO
//Cursos
import Controlador.Cursos;
import Modelo.CursosDAO;
//Jornada
import controlador.Jornadas;
import modelo.JornadasDAO;
//asignacion_cursos_alumnos

/**
 *
 * @author Mishel
 */
public class principal {
   public static void main(String[] args) {
//---------------CURSOS-------------------------
       /*CursosDAO cursosDAO = new CursosDAO();
        
        //------------INSERT------------
        Cursos cursoInsert = new Cursos("Estadistica ", "Activo");
        cursosDAO.insert(cursoInsert);
        System.out.println("Curso insertado: " + cursoInsert.toString());
        /*
        //------------UPDATE------------
        Cursos cursoUpdate = new Cursos();
        cursoUpdate.setCodigoCurso(4);
        cursoUpdate.setNombreCur("Calculo");
        cursoUpdate.setEstatusCur("Activo");
        
        cursosDAO.update(cursoUpdate);
        System.out.println("Registro actualizado: " + cursoUpdate.toString());
        
        //------------Select------------
        System.out.println("\n--- Lista de todos los cursos ---");
        List<Cursos> listaCursos = cursosDAO.select();
        for (Cursos cursos : listaCursos) {
            System.out.println(cursos.toString()); // Imprime cada curso encontrado
        }
       
       //------------Delete------------
        Cursos cursoDelete = new Cursos();
        cursoDelete.setCodigoCurso(5);
        
        //System.out.println("Registro " + cursoDelete + " eliminado" );
        cursosDAO.delete(cursoDelete);
        
           
        //------------Query------------
        Cursos cursoQuery = new Cursos();
        cursoQuery.setCodigoCurso(1);
        
        cursoQuery=cursosDAO.query(cursoQuery);
        System.out.println(cursoQuery.toString());
       */

        
        
   //---------------JORNADAS-------------------------
       JornadasDAO jornadasDAO = new JornadasDAO();
        
        //------------INSERT------------
        Jornadas jornadaInsert = new Jornadas(1,"Diurna");
        jornadasDAO.insert(jornadaInsert);
        System.out.println("Curso insertado: " + jornadaInsert.toString());
        /*
        //------------UPDATE------------
        Jornadas jornadaUpdate = new Jornadas();
        jornadaUpdate.setCodigoJornada(1);
        jornadaUpdate.setNombreJor("Matutina");
        
        jornadasDAO.update(jornadaUpdate);
        System.out.println("Registro actualizado: " + jornadaUpdate.toString());
        */
        //------------Select------------
        System.out.println("\n--- Lista de todos los cursos ---");
        List<Jornadas> listaJornada = jornadasDAO.select();
        for (Jornadas jornada : listaJornada) {
            System.out.println(jornada.toString());
        }
       /*
        //------------Query------------
        Jornadas jornadaQuery = new Jornadas();
        jornadaQuery.setCodigoJornada(1);
        
        jornadaQuery=jornadasDAO.query(jornadaQuery);
        System.out.println(jornadaQuery.toString());
       
       //------------Delete------------
        Jornadas jornadaDelete = new Jornadas();
        jornadaDelete.setCodigoJornada(1);
        
        jornadasDAO.delete(jornadaDelete);
        
       */    
        
    }
}
