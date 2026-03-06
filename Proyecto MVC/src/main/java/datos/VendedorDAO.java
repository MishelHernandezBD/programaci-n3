/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class VendedorDAO {
    //Conatante del STMT
    //El signo de interrogracion es un comodin 
    private static final String SQL_SELECT = "SELECT id_vendedor, nombrevendedor, direvendedor FROM vendedor";
    private static final String SQL_INSERT = "INSERT INTO vendedor(nombrevendedor, direvendedor) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE vendedor SET nombrevendedor=?, direvendedor=? WHERE id_vendedor = ?";
    private static final String SQL_DELETE = "DELETE FROM vendedor WHERE id_vendedor=?";
    private static final String SQL_QUERY = "SELECT id_vendedor, nombrevendedor, direvendedor FROM vendedor WHERE id_vendedor = ?";

    //Trae de la base de datos a java
    public List<Vendedor> select() {
        //Se definen como variables osea se define el objeto aparto memoria ram para la accion
        Connection conn = null; 
        PreparedStatement stmt = null; 
        ResultSet rs = null;
        Vendedor vendedor = null;
        List<Vendedor> vendedores = new ArrayList<Vendedor>(); //Definicion de matriz

        //Manejo de escepcciones
        try {
            conn = Conexion.getConnection(); //Abre la base de datos conexion
            //prepara la instruccion que sera ejecutada en la base de daots tryendo la constante de la accion que se desea realizar
            stmt = conn.prepareStatement(SQL_SELECT); 
            rs = stmt.executeQuery();  //Recot set/ Un set de datos ejecuta el Query
            while (rs.next()) { //Si ahi datos, puede ser verdadero o falso 
                //Se usan variables para resivir la informacion que viene de la base de datos
                int id_vendedor = rs.getInt("id_vendedor"); //Lo que esta en el parentesis es lo que esta en la base de datos
                String nombre = rs.getString("nombrevendedor");
                String direccion = rs.getString("direvendedor");
                
                vendedor = new Vendedor(); //Crea un objeto
                vendedor.setId_vendedor(id_vendedor); //Y le da la informacion al objeto vendedor
                vendedor.setNombreVendedor(nombre);
                vendedor.setDireVendedor(direccion);
                
                vendedores.add(vendedor); //El objeto se agrega a la lista
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out); //Si se desconecta la base de datos administra el error 
        } finally {
            //Se cierran las conecciones con la base de datos 
            //Se cierran en el orden inverso del que se abrieron
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return vendedores; //devuelve una lista
    }

    public int insert(Vendedor vendedor) {
        //Definicion de variables
        Connection conn = null;
        PreparedStatement stmt = null;
        //No ahi rs porque no se sava nada de la base de datos al contrario se insertan
        int rows = 0;
        try {
            conn = Conexion.getConnection(); //Abrio la conneccion
            stmt = conn.prepareStatement(SQL_INSERT); //Se abrio un comando de SQL
            //Asi se asignan los datos a los comodines sustituyendolos
            stmt.setString(1, vendedor.getNombreVendedor());//El nuemero de comodin que se ustituira
            stmt.setString(2, vendedor.getDireVendedor()); //Dirijido al objero que esta en java

            System.out.println("ejecutando query:" + SQL_INSERT);
            //La tabla lleva un control y no es necesario agragarle la llave ya que es aAUTOINCREMENTADO
            rows = stmt.executeUpdate(); //Ejecuta el insert y los coloca en la base de datos en forma de un entero
            System.out.println("Registros afectados:" + rows);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows; //Devuelve el numero de veces que se hace la inserccion de una fila
    }

    public int update(Vendedor vendedor) {
        //Definicion de variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection(); //Coneccion base de datos
            System.out.println("ejecutando query: " + SQL_UPDATE); //Anunciado de la occion que se esta ejecutando
            stmt = conn.prepareStatement(SQL_UPDATE); //Accion que se ejecutara
            stmt.setString(1, vendedor.getNombreVendedor()); //Comodin 1 van en el orden en el que se agregan en la definicion de la cosntante
            stmt.setString(2, vendedor.getDireVendedor());
            stmt.setInt(3, vendedor.getId_vendedor()); //El set depende del tipo de dato que se ingrese

            rows = stmt.executeUpdate(); 
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //Cierre de conecciones base de datos
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Vendedor vendedor) {
        //Definicon de variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        //Inicio del trai catch
        try {
            conn = Conexion.getConnection(); //Coneccion base de datos
            System.out.println("Ejecutando query:" + SQL_DELETE);//Enunciado de la accion que se realizara
            stmt = conn.prepareStatement(SQL_DELETE); //Accion que se realizara
            //Solo se usa el ID para eliminar el registro
            stmt.setInt(1, vendedor.getId_vendedor());
            rows = stmt.executeUpdate();
            
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Vendedor query(Vendedor vendedor) {  
        //Definicion de variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Vendedor> vendedores = new ArrayList<Vendedor>(); //Lista de datos
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            
            stmt.setInt(1, vendedor.getId_vendedor());
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int id_vendedor = rs.getInt("id_vendedor");
                String nombre = rs.getString("nombrevendedor");
                String direccion = rs.getString("direvendedor");
                
                vendedor = new Vendedor();
                vendedor.setId_vendedor(id_vendedor);
                vendedor.setNombreVendedor(nombre);
                vendedor.setDireVendedor(direccion);
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return vendedor;
    }
        
}
