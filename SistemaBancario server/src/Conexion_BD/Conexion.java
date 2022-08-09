
package Conexion_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.text.BadLocationException;
import sistemabancario.rpc.rmi_MAIN.Main_Principal;

/**
 *
 * @author Ivan Luis Jimenez
 */
public class Conexion {
       Connection con = null;        
    public Connection conex () throws BadLocationException{
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con= DriverManager.getConnection("jdbc:mysql://localhost/banco","root","");
            Main_Principal.Write("[Servidor BD] Conexion establecida");
        }catch(Exception e){
            Main_Principal.Write("[Servidor BD] NO se pudo iniciar la Base de Datos");
        }
        return con;
    }
}
