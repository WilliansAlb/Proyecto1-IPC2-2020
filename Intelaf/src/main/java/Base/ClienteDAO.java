/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import POJOS.ClienteDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author yelbetto
 */
public class ClienteDAO {

    ConectorBD ba;
    Connection cn;

    public ClienteDAO(ConectorBD ba) {
        cn = ba.getConexion();
    }

    public ArrayList<ClienteDTO> obtener_clientes() {
        ArrayList<ClienteDTO> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente ORDER BY (nit) ASC";

        try (PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ClienteDTO cliente = new ClienteDTO();
                cliente.setNombre(rs.getString("nombre"));
                cliente.setCredito(rs.getDouble("credito"));
                cliente.setNit(rs.getString("nit"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDpi(rs.getString("dpi"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {

        }
        return clientes;
    }

    public boolean ingreso_cliente(String nit, String nombre, String telefono, Double credito, String dpi, String direccion, String email) {
        boolean ingresado = false;
        String sql = "INSERT INTO Cliente VALUES (?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE nombre = ?, telefono = ?, credito = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setString(1, nit);
            ps.setString(2, nombre);
            ps.setString(3, telefono);
            ps.setDouble(4, credito);
            ps.setString(5, dpi);
            ps.setString(6, email);
            ps.setString(7, direccion);
            ps.setString(8, nombre);
            ps.setString(9, telefono);
            ps.setDouble(10, credito);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex) {

        }
        return ingresado;
    }

    /**
     *
     * @param nit
     * @param nombre
     * @param telefono
     * @param credito
     * @param dpi
     * @param direccion
     * @param email
     * @return
     */
    public boolean actualizar_cliente(String nit, String nombre, String telefono, Double credito, String dpi, String direccion, String email) {
        boolean ingresado = false;
        String sql = "UPDATE Cliente SET nombre = ?, telefono = ?, credito = ?, dpi = ?, direccion = ?, email = ? WHERE nit = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setString(1, nombre);
            ps.setString(2, telefono);
            ps.setDouble(3, credito);
            ps.setString(4, dpi);
            ps.setString(5, direccion);
            ps.setString(6, email);
            ps.setString(7, nit);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex) {

        }
        return ingresado;
    }

    public boolean ingreso_cliente_venta(String nit, String nombre, String telefono, Double credito) {
        boolean ingresado = false;
        String sql = "INSERT INTO Cliente VALUES (?,?,?,?)";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setString(1, nit);
            ps.setString(2, nombre);
            ps.setString(3, telefono);
            ps.setDouble(4, credito);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex) {

        }
        return ingresado;
    }

    public int crear_factura(String codigo_tienda, String nit, java.util.Date fecha, Double total, Double credito) {
        int ingresado = -1;
        String sql = "INSERT INTO Factura(codigo_tienda,nit,fecha,total,pago_credito) VALUES (?,?,?,?,?)";
        try (PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, codigo_tienda);
            ps.setString(2, nit);
            ps.setDate(3, new java.sql.Date(fecha.getTime()));
            ps.setDouble(4, total);
            ps.setDouble(5, credito);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                ingresado = generatedKeys.getInt(1);
            }
        } catch (SQLException ex) {

        }
        return ingresado;
    }
    
    public boolean ingresar_venta(int codigo_factura,String codigo_producto,
            int cantidad, Double total){
        boolean ingresado = false;
        String sql = "INSERT INTO Venta(codigo_factura,codigo_producto,cantidad,total) VALUES (?,?,?,?)";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, codigo_factura);
            ps.setString(2, codigo_producto);
            ps.setInt(3, cantidad);
            ps.setDouble(4, total);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex) {
            ingresado = false;
        }   
        return ingresado;
        
    }
    
    public boolean actualizar_cliente2(String nit, Double credito) {
        boolean ingresado = false;
        String sql = "UPDATE Cliente SET credito += ? WHERE nit = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setString(1, nit);
            ps.setDouble(2, credito);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex) {

        }
        return ingresado;
    }
}
