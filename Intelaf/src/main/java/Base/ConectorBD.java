/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author yelbetto
 */
public class ConectorBD {
    private Connection conexion;
    private Statement sentencia;
    
    //Datos conexion con la Base de Datos
    private final String servidor = "localhost";
    private final String puerto = "3306";
    private final String BD = "Intelaf";
    private final String usuario = "root";
    private final String clave = "Cristeptesico_65";
    private final String URL = "jdbc:mysql://"+servidor+":"+puerto+"/"+BD;
    
    public ConectorBD(){
        this.conexion = null;
        this.sentencia = null;
    }
    
    public boolean conectar(){
        boolean estado = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try{
                //Establecer la conexion con la BD
                conexion = DriverManager.getConnection(URL,usuario,clave);
                estado = true;
            } catch (SQLException ex){
                System.err.print("ERROR: ConectorBD.conectar()");
                System.err.print("Al intentar conectar con la Base de Datos");
                System.err.print(ex.getMessage());
            }
        }catch (ClassNotFoundException cex){
                System.err.print("ERROR: ConectorBD.conectar()");
                System.err.print("No se encontró el Driver de Conexion con MYSQL");
                System.err.print(cex.getMessage());
        }
        return estado;
    }
    
    /**
     * Para ejecutar sentencias SQL: SELECT
     * @param sql texto con el script sql para seleccionar registros
     * @return ResultSet con la información seleccionada o null en caso de no
     */
    public ResultSet seleccionar(String sql){
        ResultSet resultado = null;
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        }catch(SQLException sqlex){
                System.err.print("ERROR: ConectorBD.seleccionar(sql)");
                System.err.print(sqlex.getMessage());
        }
        return resultado;
    }
    /**
     * Para ejecutar sentencias SQL: INSERT, UPDATE, DELETE
     * @param sql texto con el script sql para ejecutar sobre la base de datos
     * @return  true si la sentencia tiene exito y false si no
     */
    public boolean ejecutar(String sql){
        boolean estado = false;
        try {
            sentencia = conexion.createStatement();
            sentencia.execute(sql);
            sentencia.close();
            estado = true;
        } catch (SQLException e){
            System.err.print("ERROR: ConectorBD.ejecutar("+sql+")");
            System.err.print(e.getMessage());
        }
        return estado;
    }
    
    public void desconectar(){
        try{
            if (conexion!= null){
                conexion.close();
                conexion = null;
            }
        }catch(SQLException sqle){
            System.err.print("ERROR: ConectorBD.desconectar()");
            System.err.print(sqle.getMessage());
        }
    }
    public Connection getConexion(){
        return conexion;
    }
}
