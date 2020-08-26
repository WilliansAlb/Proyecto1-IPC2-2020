/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import POJOS.EmpleadoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author yelbetto
 */
public class EmpleadoDAO {
    ConectorBD ba;
    Connection cn;
    
    public EmpleadoDAO(ConectorBD ba){
        cn = ba.getConexion();
    }
    
    public ArrayList<EmpleadoDTO> obtener_clientes(){
        ArrayList<EmpleadoDTO> es = new ArrayList<>();
        String sql = "SELECT * FROM Empleado ORDER BY (codigo_empleado) ASC";
        
        try(PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                EmpleadoDTO e = new EmpleadoDTO();
                e.setNombre(rs.getString("nombre"));
                e.setCodigo_empleado(rs.getString("codigo_empleado"));
                e.setTelefono(rs.getString("telefono"));
                e.setDireccion(rs.getString("direccion"));
                e.setDpi(rs.getString("dpi"));
                e.setEmail(rs.getString("email"));
                e.setNit(rs.getString("nit"));
                es.add(e);
            }
        } catch (SQLException ex){
            
        }
        return es;
    }
    
    public boolean ingreso_empleado(String codigo_empleado, String nombre, String telefono, String dpi, String direccion, String email, String nit){
        boolean ingresado = false;
        String sql = "INSERT INTO Empleado VALUES (?,?,?,?,?,?,?)";
        try(PreparedStatement ps = cn.prepareStatement(sql);){
            ps.setString(1, codigo_empleado);
            ps.setString(2, nombre);
            ps.setString(3, telefono);
            ps.setString(4, dpi);
            ps.setString(5, nit);
            ps.setString(6, email);
            ps.setString(7, direccion);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex){
            
        }
        return ingresado;
    }
    
    public boolean actualizar_empleado(String codigo_empleado, String nombre, String telefono, String dpi, String direccion, String email, String nit){
        boolean ingresado = false;
        String sql = "UPDATE Empleado SET nombre = ?, telefono = ?, dpi = ?, nit = ?, email = ?, direccion = ? WHERE codigo_empleado = ?";
        try(PreparedStatement ps = cn.prepareStatement(sql);){
            ps.setString(1, nombre);
            ps.setString(2, telefono);
            ps.setString(3, dpi);
            ps.setString(4, nit);
            ps.setString(5, email);
            ps.setString(6, direccion);
            ps.setString(7, codigo_empleado);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex){
            
        }
        return ingresado;
    }
    public boolean existe_empleado(String codigo_empleado){
        boolean ingresado = false;
        String sql = "SELECT COUNT(*) AS total FROM Empleado WHERE codigo_empleado = ?";
        try(PreparedStatement ps = cn.prepareStatement(sql);){
            ps.setString(1, codigo_empleado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ingresado = rs.getInt("total") > 0;
            }
            ingresado = true;
        } catch (SQLException ex){
            
        }
        return ingresado;
    }
}
