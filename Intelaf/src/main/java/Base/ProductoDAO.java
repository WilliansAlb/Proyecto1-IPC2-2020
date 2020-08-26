/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import POJOS.ExistenciaDTO;
import POJOS.PedidoDTO;
import POJOS.ProductoDTO;
import POJOS.TiendaDTO;
import POJOS.VentaDTO;
import Util.Utilidad;
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
public class ProductoDAO {

    ConectorBD base = new ConectorBD();
    Connection cn;
    ArrayList<ExistenciaDTO> existencias = new ArrayList<>();
    ArrayList<ProductoDTO> productos = new ArrayList<>();
    Utilidad u = new Utilidad();

    public ProductoDAO() {

    }

    public ProductoDAO(ConectorBD ba) {
        cn = ba.getConexion();
    }

    public void agregar_producto(String codigo_producto, String codigo_tienda, int cantidad, int existencia) {
        boolean estado = false;
        String sql = "";
        if (base.conectar()) {
            sql = "SELECT * FROM Producto WHERE codigo_producto = '" + codigo_producto + "';";
            ResultSet regs = base.seleccionar(sql);
            try {
                while (regs.next()) {
                    ProductoDTO producto = new ProductoDTO();
                    producto.setCodigo_tienda(codigo_tienda);
                    producto.setCodigo_producto(codigo_producto);
                    producto.setCantidad(cantidad);
                    producto.setFabricante(regs.getString("fabricante"));
                    producto.setPrecio(regs.getDouble("precio"));
                    producto.setNombre(regs.getString("nombre"));
                    producto.setDescripcion(regs.getString("descripcion"));
                    producto.setGarantia(regs.getInt("garantia"));
                    producto.setCodigo_existencia(existencia);
                    productos.add(producto);
                }
            } catch (SQLException sqlex) {
                System.err.println("ERROR: " + sql);
                System.err.print(sqlex.getMessage());
            }
            base.desconectar();
        } else {

        }
    }

    public ArrayList<ProductoDTO> obtener_existencias() {
        boolean estado = false;
        String sql = "";
        if (base.conectar()) {
            sql = "SELECT codigo_existencia,codigo_producto,codigo_tienda,cantidad FROM Existencia;";
            ResultSet regs = base.seleccionar(sql);
            try {
                while (regs.next()) {
                    agregar_producto(regs.getString("codigo_producto"), regs.getString("codigo_tienda"), regs.getInt("cantidad"), regs.getInt("codigo_existencia"));
                }
            } catch (SQLException sqlex) {
                System.err.println("ERROR: " + sql);
                System.err.print(sqlex.getMessage());
            }
            base.desconectar();
        } else {

        }
        return productos;
    }

    public String ingreso_producto(String codigo_producto, String nombre,
            String fabricante, Double precio, String descripcion, int garantia,
            String codigo_tienda, int cantidad) {
        String ingresado = "";
        String sql = "INSERT INTO Producto VALUES (?,?,?,?,?,?)";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setString(1, codigo_producto);
            ps.setString(2, nombre);
            ps.setString(3, fabricante);
            ps.setDouble(4, precio);
            ps.setString(5, descripcion);
            ps.setInt(6, garantia);
            ps.executeUpdate();
            ingresado = ingreso_existencia(codigo_producto, codigo_tienda, cantidad);
        } catch (SQLException ex) {
            ingresado = "ERROR AL AGREGAR PRODUCTO ----" + ex.getMessage();
        }
        return ingresado;
    }

    public String ingreso_existencia(String codigo_producto, String codigo_tienda,
            int cantidad) {
        String ingresado = "";
        String sql = "INSERT INTO Existencia(codigo_producto,codigo_tienda,cantidad) VALUES (?,?,?)";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setString(1, codigo_producto);
            ps.setString(2, codigo_tienda);
            ps.setInt(3, cantidad);
            ps.executeUpdate();
            ingresado = "INGRESADO";
        } catch (SQLException ex) {
            ingresado = "ERROR AL AGREGAR EXISTENCIA, INTENTA DE NUEVO ----" + ex.getMessage();
        }
        return ingresado;
    }

    public boolean actualizar_producto(String codigo_producto, String nombre,
            String fabricante, Double precio, String descripcion, int garantia,
            String codigo_producto_antes) {
        boolean ingresado = false;
        String sql = "UPDATE Producto SET codigo_producto = ?, nombre = ?, fabricante = ?,"
                + "precio = ?, descripcion = ?, garantia = ? WHERE codigo_producto = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setString(1, codigo_producto);
            ps.setString(2, nombre);
            ps.setString(3, fabricante);
            ps.setDouble(4, precio);
            ps.setString(5, descripcion);
            ps.setInt(6, garantia);
            ps.setString(7, codigo_producto_antes);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex) {

        }
        return ingresado;
    }

    public boolean actualizacion_existencia(int codigo_existencia,
            int cantidad) {
        boolean ingresado = false;
        String sql = "UPDATE Existencia SET cantidad = ? WHERE codigo_existencia = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setInt(1, cantidad);
            ps.setInt(2, codigo_existencia);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex) {
            ingresado = false;
        }
        return ingresado;
    }

    public boolean quitar_existencias(int id_existencia, int cantidad) {
        boolean ingresado = false;
        String sql = "UPDATE Existencia SET cantidad = cantidad - ? WHERE codigo_existencia = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setInt(1, cantidad);
            ps.setInt(2, id_existencia);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex) {
            ingresado = false;
        }
        return ingresado;
    }

    public boolean ingreso_pedido(int codigo_pedido, String codigo_tienda1, String codigo_tienda2,
            java.util.Date fecha, String nit, Double anticipo) {
        boolean ingresado = false;
        String sql = "INSERT INTO Pedido(codigo_pedido,codigo_tienda1,codigo_tienda2,"
                + "fecha,nit,anticipo,entregado) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setInt(1, codigo_pedido);
            ps.setString(2, codigo_tienda1);
            ps.setString(3, codigo_tienda2);
            ps.setDate(4, new java.sql.Date(fecha.getTime()));
            ps.setString(5, nit);
            ps.setDouble(6, anticipo);
            ps.setBoolean(7, false);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex) {
            ingresado = false;
        }
        return ingresado;
    }

    public boolean ingreso_solicitado(String codigo_producto, int codigo_pedido,
            int cantidad, Double total) {
        boolean ingresado = false;
        String sql = "INSERT INTO Solicitado(codigo_producto,codigo_pedido,"
                + "cantidad,total) VALUES (?,?,?,?)";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setString(1, codigo_producto);
            ps.setInt(2, codigo_pedido);
            ps.setInt(3, cantidad);
            ps.setDouble(4, total);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex) {
            ingresado = false;
        }
        return ingresado;
    }

    public int ultimo_pedido() {
        String sql = "SELECT codigo_pedido FROM Pedido order by(codigo_pedido) desc limit 1";
        int ingresado = -1;
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ingresado = rs.getInt("codigo_pedido");
            }
        } catch (SQLException ex) {
            ingresado = -1;
        }
        return ingresado;
    }

    public PedidoDTO obtener_pedido(int codigo_pedido) {
        String sql = "SELECT codigo_tienda1,codigo_tienda2,fecha,nit,anticipo FROM Pedido WHERE codigo_pedido = ? ORDER BY(codigo_pedido) DESC";
        PedidoDTO ingresado = new PedidoDTO();
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setInt(1, codigo_pedido);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ingresado.setCodigo_pedido(codigo_pedido);
                ingresado.setAnticipo(rs.getDouble("anticipo"));
                ingresado.setFecha2(rs.getDate("fecha"));
                ingresado.setCodigo_tienda1(rs.getString("codigo_tienda1"));
                ingresado.setCodigo_tienda2(rs.getString("codigo_tienda2"));
                ingresado.setNit(rs.getString("nit"));
            }
        } catch (SQLException ex) {
            ingresado = null;
        }
        return ingresado;
    }

    public ArrayList<ProductoDTO> obtener_solicitados(int codigo_pedido) {
        String sql = "SELECT codigo_producto,cantidad,total FROM Solicitado WHERE codigo_pedido = ?;";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setInt(1, codigo_pedido);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                agregar_producto(rs.getString("codigo_producto"), "SIN", rs.getInt("cantidad"), 0);
            }
        } catch (SQLException ex) {

        }
        return productos;
    }

    public void agregar_producto_pedido(String codigo_producto, int cantidad, Double total) {
        boolean estado = false;
        String sql = "";
        if (base.conectar()) {
            sql = "SELECT * FROM Producto WHERE codigo_producto = '" + codigo_producto + "';";
            ResultSet regs = base.seleccionar(sql);
            try {
                while (regs.next()) {
                    ProductoDTO producto = new ProductoDTO();
                    producto.setCodigo_producto(codigo_producto);
                    producto.setCantidad(cantidad);
                    producto.setFabricante(regs.getString("fabricante"));
                    producto.setPrecio(regs.getDouble("precio"));
                    producto.setNombre(regs.getString("nombre"));
                    producto.setDescripcion(regs.getString("descripcion"));
                    producto.setGarantia(regs.getInt("garantia"));
                    producto.setTotal(total);
                    productos.add(producto);
                }
            } catch (SQLException sqlex) {
                System.err.println("ERROR: " + sql);
                System.err.print(sqlex.getMessage());
            }
            base.desconectar();
        } else {

        }
    }

    public ArrayList<ProductoDTO> obtener_p(String sql) {
        ArrayList<ProductoDTO> p = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductoDTO np = new ProductoDTO();
                np.setCodigo_existencia(rs.getInt("i"));
                np.setCantidad(rs.getInt("e"));
                np.setCodigo_tienda(rs.getString("t"));
                np.setNombre(rs.getString("n"));
                np.setFabricante(rs.getString("f"));
                np.setCodigo_producto(rs.getString("cp"));
                np.setPrecio(rs.getDouble("pr"));
                np.setGarantia(rs.getInt("ga"));
                np.setDescripcion(rs.getString("de"));
                p.add(np);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }

    public ArrayList<PedidoDTO> obtener_pedidos(String codigo_tienda1) {
        ArrayList<PedidoDTO> p = new ArrayList<>();
        String sql = "SELECT t.dias,p.codigo_pedido,p.nit,p.codigo_tienda2,p.fecha,s.codigo_producto,q.nombre,s.cantidad,s.total,q.precio,p.anticipo FROM Pedido p,Producto q JOIN Tiempo t,Solicitado s WHERE p.entregado = false AND t.codigo_tienda1 = ? AND t.codigo_tienda2 = p.codigo_tienda2 AND p.codigo_pedido = s.codigo_pedido AND q.codigo_producto = s.codigo_producto;";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setString(1, codigo_tienda1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PedidoDTO np = new PedidoDTO();
                np.setDias(rs.getInt(1));
                np.setCodigo_pedido(rs.getInt(2));
                np.setNit(rs.getString(3));
                np.setCodigo_tienda2(rs.getString(4));
                np.setFecha2(rs.getDate(5));
                np.setCodigo_producto(rs.getString(6));
                np.setNombre_producto(rs.getString(7));
                np.setCantidad(rs.getInt(8));
                np.setTotal(rs.getDouble(9));
                np.setPrecio_producto(rs.getDouble(10));
                np.setAnticipo(rs.getDouble(11));
                p.add(np);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }

    public ArrayList<PedidoDTO> obtener_pedidos_transito(String codigo_tienda1) {
        ArrayList<PedidoDTO> p = new ArrayList<>();
        String sql = "SELECT t.dias,p.codigo_pedido,p.nit,p.codigo_tienda2,p.fecha,s.codigo_producto,q.nombre,s.cantidad,s.total,q.precio,p.anticipo "
                + "FROM Pedido p,Producto q JOIN Tiempo t,Solicitado s "
                + "WHERE p.entregado = false AND p.egresado = true AND p.codigo_tienda1 = ? AND p.codigo_tienda1 = t.codigo_tienda1 AND t.codigo_tienda2 = p.codigo_tienda2 "
                + "AND p.codigo_pedido = s.codigo_pedido AND q.codigo_producto = s.codigo_producto;";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setString(1, codigo_tienda1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PedidoDTO np = new PedidoDTO();
                np.setDias(rs.getInt(1));
                np.setCodigo_pedido(rs.getInt(2));
                np.setNit(rs.getString(3));
                np.setCodigo_tienda2(rs.getString(4));
                np.setFecha2(rs.getDate(5));
                np.setCodigo_producto(rs.getString(6));
                np.setNombre_producto(rs.getString(7));
                np.setCantidad(rs.getInt(8));
                np.setTotal(rs.getDouble(9));
                np.setPrecio_producto(rs.getDouble(10));
                np.setAnticipo(rs.getDouble(11));
                p.add(np);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }

    public ArrayList<PedidoDTO> obtener_pedidos2(String codigo_tienda1) {
        ArrayList<PedidoDTO> p = new ArrayList<>();
        String sql = "SELECT t.dias,p.codigo_pedido,p.nit,p.codigo_tienda2,p.fecha,s.codigo_producto,q.nombre,s.cantidad,s.total,q.precio,p.anticipo FROM Pedido p,Producto q JOIN Tiempo t,Solicitado s WHERE p.entregado = false AND t.codigo_tienda1 = ? AND t.codigo_tienda2 = p.codigo_tienda2 AND p.codigo_pedido = s.codigo_pedido AND q.codigo_producto = s.codigo_producto;";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setString(1, codigo_tienda1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PedidoDTO np = new PedidoDTO();
                np.setDias(rs.getInt(1));
                np.setCodigo_pedido(rs.getInt(2));
                np.setNit(rs.getString(3));
                np.setCodigo_tienda2(rs.getString(4));
                np.setFecha2(rs.getDate(5));
                np.setCodigo_producto(rs.getString(6));
                np.setNombre_producto(rs.getString(7));
                np.setCantidad(rs.getInt(8));
                np.setTotal(rs.getDouble(9));
                np.setPrecio_producto(rs.getDouble(10));
                np.setAnticipo(rs.getDouble(11));
                p.add(np);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }

    public ArrayList<PedidoDTO> obtener_pedidos_cliente(String nit) {
        ArrayList<PedidoDTO> p = new ArrayList<>();
        String sql = "SELECT t.dias,p.codigo_pedido,p.nit,p.codigo_tienda2,p.fecha,s.codigo_producto,q.nombre,s.cantidad,p.anticipo,s.total,q.precio,p.codigo_tienda1 "
                + "FROM Pedido p,Producto q JOIN Tiempo t,Solicitado s "
                + "WHERE p.entregado = false AND t.codigo_tienda1 = p.codigo_tienda1 AND t.codigo_tienda2 = p.codigo_tienda2 "
                + "AND p.codigo_pedido = s.codigo_pedido AND q.codigo_producto = s.codigo_producto AND p.nit = ?;";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setString(1, nit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PedidoDTO np = new PedidoDTO();
                np.setDias(rs.getInt(1));
                np.setCodigo_pedido(rs.getInt(2));
                np.setNit(rs.getString(3));
                np.setCodigo_tienda2(rs.getString(4));
                np.setFecha2(rs.getDate(5));
                np.setCodigo_producto(rs.getString(6));
                np.setNombre_producto(rs.getString(7));
                np.setCantidad(rs.getInt(8));
                np.setAnticipo(rs.getDouble(9));
                np.setTotal(rs.getDouble(10));
                np.setPrecio_producto(rs.getDouble(11));
                np.setCodigo_tienda1(rs.getString(12));
                p.add(np);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }

    public ArrayList<ProductoDTO> diez_mas_vendidos(String sql) {
        ArrayList<ProductoDTO> p = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductoDTO pdto = new ProductoDTO();
                pdto.setCodigo_producto(rs.getString(1));
                pdto.setNombre(rs.getString(2));
                pdto.setFabricante(rs.getString(4));
                pdto.setPrecio(rs.getDouble(3));
                pdto.setGarantia(rs.getInt(5));
                pdto.setDescripcion(rs.getString(6));
                pdto.setConteo(rs.getInt(7));
                p.add(pdto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }

    public ArrayList<ProductoDTO> diez_mas_vendidos_fechas(String sql, java.util.Date fecha1, java.util.Date fecha2) {
        ArrayList<ProductoDTO> p = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setDate(1, new java.sql.Date(fecha1.getTime()));
            ps.setDate(2, new java.sql.Date(fecha2.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductoDTO pdto = new ProductoDTO();
                pdto.setCodigo_producto(rs.getString(1));
                pdto.setNombre(rs.getString(2));
                pdto.setFabricante(rs.getString(4));
                pdto.setPrecio(rs.getDouble(3));
                pdto.setGarantia(rs.getInt(5));
                pdto.setDescripcion(rs.getString(6));
                pdto.setConteo(rs.getInt(7));
                p.add(pdto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }

    public ArrayList<ProductoDTO> mas_vendidos_fechas(String codigo_tienda, java.util.Date fecha1, java.util.Date fecha2) {
        ArrayList<ProductoDTO> p = new ArrayList<>();
        String sql = "SELECT p.codigo_producto, p.nombre, p.precio, p.fabricante, p.garantia, p.descripcion,COUNT(p.codigo_producto) AS total "
                + "FROM Producto p, Factura f JOIN Venta v WHERE p.codigo_producto = v.codigo_producto AND v.codigo_factura = f.codigo_factura "
                + "AND f.codigo_tienda = ? AND (f.fecha BETWEEN ? AND ?) GROUP BY(p.codigo_producto) ORDER BY(total) DESC LIMIT 10;";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setString(1, codigo_tienda);
            ps.setDate(2, new java.sql.Date(fecha1.getTime()));
            ps.setDate(3, new java.sql.Date(fecha2.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductoDTO pdto = new ProductoDTO();
                pdto.setCodigo_producto(rs.getString(1));
                pdto.setNombre(rs.getString(2));
                pdto.setFabricante(rs.getString(4));
                pdto.setPrecio(rs.getDouble(3));
                pdto.setGarantia(rs.getInt(5));
                pdto.setDescripcion(rs.getString(6));
                pdto.setConteo(rs.getInt(7));
                p.add(pdto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }

    public ArrayList<ProductoDTO> mas_vendidos(String codigo_tienda) {
        String sql = "SELECT p.codigo_producto, p.nombre, p.precio, p.fabricante, p.garantia, p.descripcion,COUNT(p.codigo_producto) AS total "
                + "FROM Producto p, Factura f JOIN Venta v WHERE p.codigo_producto = v.codigo_producto AND v.codigo_factura = f.codigo_factura AND "
                + "f.codigo_tienda = ? GROUP BY(p.codigo_producto) ORDER BY(total) DESC LIMIT 10;";
        ArrayList<ProductoDTO> p = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setString(1, codigo_tienda);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductoDTO pdto = new ProductoDTO();
                pdto.setCodigo_producto(rs.getString(1));
                pdto.setNombre(rs.getString(2));
                pdto.setFabricante(rs.getString(4));
                pdto.setPrecio(rs.getDouble(3));
                pdto.setGarantia(rs.getInt(5));
                pdto.setDescripcion(rs.getString(6));
                pdto.setConteo(rs.getInt(7));
                p.add(pdto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }

    public ArrayList<ProductoDTO> nunca_vendidos(String codigo_tienda) {
        String sql = "SELECT * FROM Producto p WHERE (SELECT COUNT(v.codigo_venta) "
                + "FROM Venta v JOIN Factura f WHERE v.codigo_factura = f.codigo_factura "
                + "AND f.codigo_tienda = ? AND v.codigo_producto = p.codigo_producto) = 0;";

        ArrayList<ProductoDTO> p = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setString(1, codigo_tienda);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductoDTO pdto = new ProductoDTO();
                pdto.setCodigo_producto(rs.getString("codigo_producto"));
                pdto.setNombre(rs.getString("nombre"));
                pdto.setFabricante(rs.getString("fabricante"));
                pdto.setPrecio(rs.getDouble("precio"));
                pdto.setGarantia(rs.getInt("garantia"));
                pdto.setDescripcion(rs.getString("descripcion"));
                p.add(pdto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }

    public ArrayList<VentaDTO> compras_cliente(String nit) {
        String sql = "SELECT v.codigo_factura, v.cantidad, v.total, p.nombre, p.precio, p.codigo_producto,f.codigo_tienda,f.fecha "
                + "FROM Venta v, Producto p JOIN Factura f WHERE v.codigo_producto = p.codigo_producto AND f.nit = ? "
                + "AND v.codigo_factura = f.codigo_factura;";

        ArrayList<VentaDTO> p = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setString(1, nit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                VentaDTO v = new VentaDTO();
                v.setCodigo_factura(rs.getInt(1));
                v.setCantidad(rs.getInt(2));
                v.setTotal(rs.getDouble(3));
                v.setNombre_producto(rs.getString(4));
                v.setPrecio(rs.getDouble(5));
                v.setCodigo_producto(rs.getString(6));
                v.setCodigo_tienda(rs.getString(7));
                v.setFecha(rs.getDate(8));
                p.add(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }

    public ArrayList<PedidoDTO> pedidos_egreso() {
        ArrayList<PedidoDTO> p = new ArrayList<>();
        String sql = "SELECT p.codigo_pedido,p.fecha,p.codigo_tienda1,p.codigo_tienda2,p.nit,p.anticipo,SUM(s.total) "
                + "FROM Pedido p JOIN Solicitado s WHERE p.codigo_pedido = s.codigo_pedido AND p.egresado = false "
                + "GROUP BY(p.codigo_pedido);";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PedidoDTO v = new PedidoDTO();
                v.setCodigo_pedido(rs.getInt(1));
                v.setFecha2(rs.getDate(2));
                v.setCodigo_tienda1(rs.getString(3));
                v.setCodigo_tienda2(rs.getString(4));
                v.setNit(rs.getString(5));
                v.setAnticipo(rs.getDouble(6));
                v.setTotal(rs.getDouble(7));
                p.add(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }

    public ArrayList<PedidoDTO> pedidos_ingreso() {
        ArrayList<PedidoDTO> p = new ArrayList<>();
        String sql = "SELECT p.codigo_pedido,p.fecha,p.codigo_tienda1,p.codigo_tienda2,p.nit,p.anticipo,SUM(s.total) "
                + "FROM Pedido p JOIN Solicitado s WHERE p.codigo_pedido = s.codigo_pedido "
                + "AND p.egresado = true AND p.ingresado = false GROUP BY(p.codigo_pedido);";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PedidoDTO v = new PedidoDTO();
                v.setCodigo_pedido(rs.getInt(1));
                v.setFecha2(rs.getDate(2));
                v.setCodigo_tienda1(rs.getString(3));
                v.setCodigo_tienda2(rs.getString(4));
                v.setNit(rs.getString(5));
                v.setAnticipo(rs.getDouble(6));
                v.setTotal(rs.getDouble(7));
                p.add(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }

    public ArrayList<PedidoDTO> pedidos_entrega() {
        ArrayList<PedidoDTO> p = new ArrayList<>();
        String sql = "SELECT p.codigo_pedido,p.fecha,p.codigo_tienda1,p.codigo_tienda2,p.nit,p.anticipo,SUM(s.total) "
                + "FROM Pedido p JOIN Solicitado s WHERE p.codigo_pedido = s.codigo_pedido AND p.ingresado = true "
                + "AND p.entregado = false GROUP BY(p.codigo_pedido);";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PedidoDTO v = new PedidoDTO();
                v.setCodigo_pedido(rs.getInt(1));
                v.setFecha2(rs.getDate(2));
                v.setCodigo_tienda1(rs.getString(3));
                v.setCodigo_tienda2(rs.getString(4));
                v.setNit(rs.getString(5));
                v.setAnticipo(rs.getDouble(6));
                v.setTotal(rs.getDouble(7));
                p.add(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }

    public boolean egresado(int codigo_pedido) {
        boolean ingresado = false;
        String sql = "UPDATE Pedido SET egresado = true WHERE codigo_pedido = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setInt(1, codigo_pedido);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex) {
            System.out.println(ex);
            ingresado = false;
        }
        return ingresado;
    }

    public boolean ingresado(int codigo_pedido, java.util.Date nueva, boolean atrasado) {
        boolean ingresado = false;
        String sql = "UPDATE Pedido SET ingresado = true, fecha_ingreso = ?, atrasado = ? WHERE codigo_pedido = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setDate(1, new java.sql.Date(nueva.getTime()));
            ps.setBoolean(2, atrasado);
            ps.setInt(3, codigo_pedido);
            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException ex) {
            System.out.println(ex);
            ingresado = false;
        }
        return ingresado;
    }

    public String[] productos(int codigo_pedido) {
        String[] datos = new String[3];
        String sql = "SELECT codigo_producto,cantidad,total FROM Solicitado WHERE codigo_pedido = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setInt(1, codigo_pedido);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString("codigo_producto");
                datos[1] = rs.getInt("cantidad") + "";
                datos[2] = rs.getDouble("total") + "";
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            datos[0] = "";
            datos[1] = "";
            datos[2] = "";
        }
        return datos;
    }
}
