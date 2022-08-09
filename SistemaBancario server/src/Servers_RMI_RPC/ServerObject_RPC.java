package Servers_RMI_RPC;

import Conexion_BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Ivan Luis Jimenez
 */
public class ServerObject_RPC{

    Conexion C = new Conexion();
    Connection CC;
    PreparedStatement us;
    int acceso = 0;
    public String cliente = "";
    int saldo = 0;

    Vector<Integer> datos = new Vector<Integer>();
    Vector<Vector<String>> estado = new Vector<Vector<String>>();
    
    Vector<String> saldoA = new Vector<String>();
    Vector<String> retiro = new Vector<String>();
    Vector<String> fecha = new Vector<String>();
    Vector<String> claveC = new Vector<String>();
    
    public ServerObject_RPC() throws BadLocationException {
        this.CC = C.conex();
    }

    public int acceso(int usuario, int clave) {
        acceso = 0;
        try {
            Statement st = CC.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuario;");
            while (rs.next()) {
                if (rs.getInt(4) == usuario && rs.getInt(2) == clave) {
                    acceso = 1;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            acceso = 0;
        }
        return acceso;
    }

    public String cliente(int usuario) {
        try {
            Statement st = CC.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cliente;");
            while (rs.next()) {

                if (rs.getInt(1) == usuario) {
                    cliente = rs.getString("numeroCuentaCliente");
                }
            }
            rs.close();
        } catch (SQLException ex) {
            acceso = 0;
        }
        return cliente;
    }

    public int saldo(int usuario) {
        try {
            Statement st = CC.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM saldo;");
            while (rs.next()) {
                if (rs.getInt(4) == usuario) {
                    saldo = rs.getInt("saldo");
                }
            }
            rs.close();
        } catch (SQLException ex) {
            acceso = 0;
        }
        return saldo;
    }

    public int insertar_estado(String Sa,String r,String f,String idca,String idcl) {
        acceso = 0;
        int s = Integer.parseInt(Sa);
        int ret = Integer.parseInt(r);
        try {
            us = CC.prepareStatement("INSERT INTO estado(saldoAnterior"
                    + ",retiro,fecha,claveCajero, cliente_idCliente) VALUES('"
                    + s + "'," + ret + ",'"+f+"','" + idca + "',"+idcl+")");
            us.executeUpdate();
            acceso = 1;
        } catch (SQLException ex) {
             System.out.println(""+ex.getMessage());
        }
        return acceso;
    }
    
    public int insertar_nSaldo(String saldo,String fecha,String usuario){
        acceso = 0;
        int s = Integer.parseInt(saldo);
        int u = Integer.parseInt(usuario);
        try {
            us = CC.prepareStatement("INSERT INTO saldo(saldo"
                    + ",fecha,usuario_idUsuario) VALUES("
                    + s + ",'" + fecha +"',"+u+")");
            us.executeUpdate();
            acceso = 1;
        } catch (SQLException ex) {
             System.out.println(""+ex.getMessage());
        }
        return acceso;
    }
    
    public Vector<Vector<String>> estado(int cliente){
        try {
            String consulta = "SELECT saldoAnterior,retiro,fecha,claveCajero FROM estado WHERE cliente_idCliente="+cliente;
            Statement st = CC.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                saldoA.addElement(rs.getString("saldoAnterior"));
                retiro.addElement(rs.getString("retiro"));
                fecha.addElement(rs.getString("fecha"));
                claveC.addElement(rs.getString("claveCajero"));
            }
            estado.addElement(saldoA);
            estado.addElement(retiro);
            estado.addElement(fecha);
            estado.addElement(claveC);

            
        } catch (Exception e) {

        }
        return estado;
    }       
    
}
