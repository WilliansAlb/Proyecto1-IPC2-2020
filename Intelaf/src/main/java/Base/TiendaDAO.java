/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import POJOS.EmpleadoDTO;
import POJOS.TiendaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author yelbetto
 */
public class TiendaDAO {
    ConectorBD base = new ConectorBD();
    Connection cn;
    ArrayList<TiendaDTO> tiendas = new ArrayList<>();
    
    public TiendaDAO(){
    
    }
    
    public TiendaDAO(ConectorBD base){
        cn = base.getConexion();
    }
    
    public ArrayList<TiendaDTO> obtener_tiendas() {
        boolean estado = false;
        String sql = "";
        if (base.conectar()) {
            sql = "SELECT * FROM Tienda;";
            ResultSet regs = base.seleccionar(sql);
            try {
                while (regs.next()) {
                    TiendaDTO tienda = new TiendaDTO();
                    tienda.setCodigo_tienda(regs.getString("codigo_tienda"));
                    tienda.setNombre(regs.getString("nombre"));
                    tienda.setDireccion(regs.getString("direccion"));
                    tienda.setHorario(regs.getString("horario"));
                    tienda.setTelefono(regs.getString("telefono"));
                    tienda.setTelefono2(regs.getString("telefono2"));
                    tienda.setEmail(regs.getString("email"));
                    tiendas.add(tienda);
                }
            } catch (SQLException sqlex) {
                System.err.println("ERROR: "+sql);
                System.err.print(sqlex.getMessage());
            }
            base.desconectar();
        } else {
            
        }
        return tiendas;
    }
    public ArrayList<String[]> obtener_tiempos(){
        ArrayList<String[]> tiempos = new ArrayList<>();
        
        String sql = "SELECT * FROM Tiempo ORDER BY (dias) ASC";
        
        try(PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                String[] tiempo = new String[4];
                tiempo[0] = rs.getString("codigo_tienda1");
                tiempo[1] = rs.getString("codigo_tienda2");
                tiempo[2] = rs.getInt("dias")+"";
                tiempo[3] = rs.getInt("id_tiempo")+"";
                tiempos.add(tiempo);
            }
        } catch (SQLException ex){
            
        }
        return tiempos;
    }

    public boolean ingreso_tienda(String codigo_tienda, String nombre,String direccion, String telefono, String telefono2, String email, String horario) {
        boolean ingresado = false;
        String sql = "INSERT INTO Tienda VALUES (?,?,?,?,?,?,?)";
        try(PreparedStatement ps = cn.prepareStatement(sql);){
            ps.setString(1, codigo_tienda);
            ps.setString(2, nombre);
            ps.setString(4, telefono);
            ps.setString(5, telefono2);
            ps.setString(3, direccion);
            ps.setString(6, email);
            ps.setString(7, horario);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex){
            
        }
        return ingresado;
    }
    
    public boolean actualizar_tienda(String codigo_tienda, String nombre,String direccion, String telefono, String telefono2, String email, String horario, String codigo_tienda_anterior) {
        boolean ingresado = false;
        String sql = "UPDATE Tienda SET codigo_tienda = ?,nombre = ?,direccion = ?, telefono = ?, telefono2 = ?, email = ?, horario = ? WHERE codigo_tienda = ?";
        try(PreparedStatement ps = cn.prepareStatement(sql);){
            ps.setString(1, codigo_tienda);
            ps.setString(2, nombre);
            ps.setString(4, telefono);
            ps.setString(5, telefono2);
            ps.setString(3, direccion);
            ps.setString(6, email);
            ps.setString(7, horario);
            ps.setString(8, codigo_tienda_anterior);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex){
            
        }
        return ingresado;
    }
    
    public boolean ingresar_tiempo(String codigo_tienda1,String codigo_tienda2,int dias){
        boolean ingresado = false;
        String sql = "INSERT INTO Tiempo(codigo_tienda1,codigo_tienda2,dias) VALUES (?,?,?)";
        try(PreparedStatement ps = cn.prepareStatement(sql);){
            ps.setString(1, codigo_tienda1);
            ps.setString(2, codigo_tienda2);
            ps.setInt(3, dias);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex){
            
        }
        return ingresado;
    }
    public boolean actualizar_tiempo(int id_tiempo,int dias){
        boolean ingresado = false;
        String sql = "UPDATE Tiempo SET dias = ? WHERE id_tiempo = ?";
        try(PreparedStatement ps = cn.prepareStatement(sql);){
            ps.setInt(1, dias);
            ps.setInt(2, id_tiempo);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex){
            
        }
        return ingresado;
    }
    
    public int existe(){
        int ingresado = -1;
        String sql = "SELECT COUNT(*) AS total FROM Tienda";
        try(PreparedStatement ps = cn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ingresado = rs.getInt("total");
            }
        } catch (SQLException ex){
            ingresado = -1;
        }
        return ingresado;
        
    }
}
