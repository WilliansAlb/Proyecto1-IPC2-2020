/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Color;
import java.awt.Component;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yelbetto
 */
public class Utilidad {

    public static String PATRON_FECHA_MYSQL = "YYYY-MM-dd";
    public static String PATRON_FECHA_Y_HORA_MYSQL = "YYYY-MM-dd HH:mm:ss";

    public String aFechaMYSQL(Date date) {
        String fecha;
        SimpleDateFormat sdf = new SimpleDateFormat(PATRON_FECHA_MYSQL);
        fecha = sdf.format(date);

        return fecha;
    }

    public String aFechaYHoraMYSQL(Date date) {
        String fecha;
        SimpleDateFormat sdf = new SimpleDateFormat(PATRON_FECHA_Y_HORA_MYSQL);
        fecha = sdf.format(date);
        return fecha;
    }

    public void informar(Component c, String mensaje, String titulo) {
        JOptionPane.showMessageDialog(c, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void advertir(Component c, String mensaje, String titulo) {
        JOptionPane.showMessageDialog(c, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
    }

    public static String capturar(Component c, String mensaje, String titulo) {
        String datos = JOptionPane.showInputDialog(c, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
        if (datos == null) {
            datos = "";
        }
        return datos;
    }

    public static boolean confirmar(Component c, String mensaje, String titulo) {
        int respuesta = JOptionPane.showConfirmDialog(c, mensaje, titulo, JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }

    private static int hex(String color_hex) {
        return Integer.parseInt(color_hex, 16);
    }

    public void limpiar_tablas(JTable tabla) {
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    public Double dos_decimales(Double decimal) {
        DecimalFormat df = new DecimalFormat("###.##");
        String total = df.format(decimal);
        Double total_n = Double.parseDouble(total);
        return total_n;
    }

    public Date sumarDias(Date fecha, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

    public int dias(java.util.Date fecha, java.util.Date fecha2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(fecha2);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.HOUR, 0);
        calendar2.set(Calendar.HOUR_OF_DAY, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);

        long fechaA = calendar.getTimeInMillis();
        long fechaB = calendar2.getTimeInMillis();

        int dias = (int) ((Math.abs(fechaA - fechaB)) / (1000 * 60 * 60 * 24));

        return dias;
    }

    public boolean generarReporte(JTable jt, String codigo_tienda) {
        boolean todo_bien = false;
        try {
            Random nuevo = new Random(System.currentTimeMillis());
            int aleatorio = nuevo.nextInt(100);
            String ruta = "reportePedido" + aleatorio + ".html";
            FileWriter archivo = new FileWriter(ruta);
            System.out.print(ruta);
            PrintWriter escritura = new PrintWriter(archivo);

//escribimos un archivo de texto con la estructura de html
            escritura.println("<html>");
            escritura.println(" <body>");
            escritura.println(" <h1><center>REPORTE-LISTADO TODOS LOS PEDIDOS A LLEGAR A TIENDA " + codigo_tienda + "</center></h1>");
            escritura.println("<br><br>");
            escritura.println("<div style='text-align: center;' id = 'div1'>");
            escritura.println("<table border='1' style='margin: 0 auto;'>");
            escritura.println("<tr>");
            escritura.println("<td><strong>CODIGO</strong></td>");
            escritura.println("<td><strong>CODIGO PRODUCTO</strong></td>");
            escritura.println("<td><strong>CODIGO TIENDA SOLICITADO</strong></td>");
            escritura.println("<td><strong>PRECIO</strong></td>");
            escritura.println("<td><strong>CANTIDAD</strong></td>");
            escritura.println("<td><strong>TOTAL</strong></td>");
            escritura.println("<td><strong>ANTICIPO</strong></td>");
            escritura.println("<td><strong>FECHA</strong></td>");
            escritura.println("</tr>");
            for (int i = 0; i < jt.getRowCount(); i++) {
                escritura.println("<tr><td>" + jt.getValueAt(i, 0).toString()
                        + "</td><td>" + jt.getValueAt(i, 1).toString() + "</td><td>" + jt.getValueAt(i, 2).toString() + "</td><td>" + jt.getValueAt(i, 3).toString()
                        + "</td><td>" + jt.getValueAt(i, 4).toString() + "</td><td>" + jt.getValueAt(i, 5).toString() + "</td><td>" + jt.getValueAt(i, 6).toString() + "</td><td>" + jt.getValueAt(i, 7).toString() + "</td></tr>");
            }
            escritura.println("</table>");
            escritura.println(" </body>");
            escritura.println("</html>");
//nos aseguramos de cerrar el archivo
            archivo.close();
            todo_bien = true;
        } catch (Exception e) {
            e.printStackTrace();
            todo_bien = false;
        }
        return todo_bien;
    }

    public boolean generarReporte2(JTable jt, String codigo_tienda) {
        boolean todo_bien = false;
        try {
            Random nuevo = new Random(System.currentTimeMillis());
            int aleatorio = nuevo.nextInt(100);
            String ruta = "reportePedidoVerificar" + aleatorio + ".html";
            FileWriter archivo = new FileWriter(ruta);
            System.out.print(ruta);
            PrintWriter escritura = new PrintWriter(archivo);

//escribimos un archivo de texto con la estructura de html
            escritura.println("<html>");
            escritura.println(" <body>");
            escritura.println(" <h1><center>REPORTE-LISTADO PEDIDOS A TIEMPO PARA VERIFICAR SU INGRESO EN TIENDA " + codigo_tienda + "</center></h1>");
            escritura.println("<br><br>");
            escritura.println("<div style='text-align: center;' id = 'div1'>");
            escritura.println("<table border='1' style='margin: 0 auto;'>");
            escritura.println("<tr>");
            escritura.println("<td><strong>CODIGO</strong></td>");
            escritura.println("<td><strong>CODIGO PRODUCTO</strong></td>");
            escritura.println("<td><strong>CODIGO TIENDA SOLICITADO</strong></td>");
            escritura.println("<td><strong>PRECIO</strong></td>");
            escritura.println("<td><strong>CANTIDAD</strong></td>");
            escritura.println("<td><strong>TOTAL</strong></td>");
            escritura.println("<td><strong>ANTICIPO</strong></td>");
            escritura.println("<td><strong>FECHA</strong></td>");
            escritura.println("<td><strong>TIEMPO HABITUAL</strong></td>");
            escritura.println("</tr>");
            for (int i = 0; i < jt.getRowCount(); i++) {
                escritura.println("<tr><td>" + jt.getValueAt(i, 0).toString()
                        + "</td><td>" + jt.getValueAt(i, 1).toString() + "</td><td>" + jt.getValueAt(i, 2).toString() + "</td><td>" + jt.getValueAt(i, 3).toString()
                        + "</td><td>" + jt.getValueAt(i, 4).toString() + "</td><td>" + jt.getValueAt(i, 5).toString() + "</td><td>" + jt.getValueAt(i, 6).toString() + "</td><td>" + jt.getValueAt(i, 7).toString() + "</td><td>" + jt.getValueAt(i, 8).toString() + "</td></tr>");
            }
            escritura.println("</table>");
            escritura.println(" </body>");
            escritura.println("</html>");
//nos aseguramos de cerrar el archivo
            archivo.close();
            todo_bien = true;
        } catch (Exception e) {
            e.printStackTrace();
            todo_bien = false;
        }
        return todo_bien;
    }

    public boolean generarReporte3(JTable jt, String codigo_tienda) {
        boolean todo_bien = false;
        try {
            Random nuevo = new Random(System.currentTimeMillis());
            int aleatorio = nuevo.nextInt(100);
            String ruta = "reportePedidosAtrasados" + aleatorio + ".html";
            FileWriter archivo = new FileWriter(ruta);
            System.out.print(ruta);
            PrintWriter escritura = new PrintWriter(archivo);

//escribimos un archivo de texto con la estructura de html
            escritura.println("<html>");
            escritura.println(" <body>");
            escritura.println(" <h1><center>REPORTE-LISTADO TODOS LOS PEDIDOS ATRASADOS QUE LLEGARÁN A LA TIENDA " + codigo_tienda + "</center></h1>");
            escritura.println("<br><br>");
            escritura.println("<div style='text-align: center;' id = 'div1'>");
            escritura.println("<table border='1' style='margin: 0 auto;'>");
            escritura.println("<tr>");
            escritura.println("<td><strong>CODIGO</strong></td>");
            escritura.println("<td><strong>CODIGO PRODUCTO</strong></td>");
            escritura.println("<td><strong>CODIGO TIENDA SOLICITADO</strong></td>");
            escritura.println("<td><strong>PRECIO</strong></td>");
            escritura.println("<td><strong>CANTIDAD</strong></td>");
            escritura.println("<td><strong>TOTAL</strong></td>");
            escritura.println("<td><strong>ANTICIPO</strong></td>");
            escritura.println("<td><strong>FECHA</strong></td>");
            escritura.println("<td><strong>TIEMPO ATRASADO</strong></td>");
            escritura.println("</tr>");
            for (int i = 0; i < jt.getRowCount(); i++) {
                escritura.println("<tr><td>" + jt.getValueAt(i, 0).toString()
                        + "</td><td>" + jt.getValueAt(i, 1).toString() + "</td><td>" + jt.getValueAt(i, 2).toString() + "</td><td>" + jt.getValueAt(i, 3).toString()
                        + "</td><td>" + jt.getValueAt(i, 4).toString() + "</td><td>" + jt.getValueAt(i, 5).toString() + "</td><td>" + jt.getValueAt(i, 6).toString() + "</td><td>" + jt.getValueAt(i, 7).toString() + "</td><td>" + jt.getValueAt(i, 8).toString() + "</td></tr>");
            }
            escritura.println("</table>");
            escritura.println(" </body>");
            escritura.println("</html>");
//nos aseguramos de cerrar el archivo
            archivo.close();
            todo_bien = true;
        } catch (Exception e) {
            e.printStackTrace();
            todo_bien = false;
        }
        return todo_bien;
    }

    public boolean generarReporte4(JTable jt, String codigo_tienda) {
        boolean todo_bien = false;
        try {
            Random nuevo = new Random(System.currentTimeMillis());
            int aleatorio = nuevo.nextInt(100);
            String ruta = "reportePedidosTransito" + aleatorio + ".html";
            FileWriter archivo = new FileWriter(ruta);
            System.out.print(ruta);
            PrintWriter escritura = new PrintWriter(archivo);

//escribimos un archivo de texto con la estructura de html
            escritura.println("<html>");
            escritura.println(" <body>");
            escritura.println(" <h1><center>REPORTE-LISTADO DE TODOS LOS PEDIDOS QUE SALIERON DE TIENDA " + codigo_tienda + " Y ESTÁN EN TRANSITO</center></h1>");
            escritura.println("<br><br>");
            escritura.println("<div style='text-align: center;' id = 'div1'>");
            escritura.println("<table border='1' style='margin: 0 auto;'>");
            escritura.println("<tr>");
            escritura.println("<td><strong>CODIGO</strong></td>");
            escritura.println("<td><strong>CODIGO PRODUCTO</strong></td>");
            escritura.println("<td><strong>CODIGO TIENDA SOLICITADO</strong></td>");
            escritura.println("<td><strong>PRECIO</strong></td>");
            escritura.println("<td><strong>CANTIDAD</strong></td>");
            escritura.println("<td><strong>TOTAL</strong></td>");
            escritura.println("<td><strong>ANTICIPO</strong></td>");
            escritura.println("<td><strong>FECHA</strong></td>");
            escritura.println("</tr>");
            for (int i = 0; i < jt.getRowCount(); i++) {
                escritura.println("<tr><td>" + jt.getValueAt(i, 0).toString()
                        + "</td><td>" + jt.getValueAt(i, 1).toString() + "</td><td>" + jt.getValueAt(i, 2).toString() + "</td><td>" + jt.getValueAt(i, 3).toString()
                        + "</td><td>" + jt.getValueAt(i, 4).toString() + "</td><td>" + jt.getValueAt(i, 5).toString() + "</td><td>" + jt.getValueAt(i, 6).toString() + "</td><td>" + jt.getValueAt(i, 7).toString() + "</td></tr>");
            }
            escritura.println("</table>");
            escritura.println(" </body>");
            escritura.println("</html>");
//nos aseguramos de cerrar el archivo
            archivo.close();
            todo_bien = true;
        } catch (Exception e) {
            e.printStackTrace();
            todo_bien = false;
        }
        return todo_bien;
    }

    public boolean generarReporte5(JTable jt, String nit) {
        boolean todo_bien = false;
        try {
            Random nuevo = new Random(System.currentTimeMillis());
            int aleatorio = nuevo.nextInt(100);
            String ruta = "reporteComprasCliente" + aleatorio + ".html";
            FileWriter archivo = new FileWriter(ruta);
            System.out.print(ruta);
            PrintWriter escritura = new PrintWriter(archivo);

//escribimos un archivo de texto con la estructura de html
            escritura.println("<html>");
            escritura.println(" <body>");
            escritura.println(" <h1><center>REPORTE-LISTADO DE TODAS LAS COMPRAS REALIZADAS POR " + nit + "</center></h1>");
            escritura.println("<br><br>");
            escritura.println("<div style='text-align: center;' id = 'div1'>");
            escritura.println("<table border='1' style='margin: 0 auto;'>");
            escritura.println("<tr>");
            escritura.println("<td><strong>FACTURA</strong></td>");
            escritura.println("<td><strong>CODIGO PRODUCTO</strong></td>");
            escritura.println("<td><strong>NOMBRE PRODUCTO</strong></td>");
            escritura.println("<td><strong>CODIGO TIENDA</strong></td>");
            escritura.println("<td><strong>PRECIO</strong></td>");
            escritura.println("<td><strong>CANTIDAD</strong></td>");
            escritura.println("<td><strong>TOTAL</strong></td>");
            escritura.println("<td><strong>FECHA</strong></td>");
            escritura.println("</tr>");
            for (int i = 0; i < jt.getRowCount(); i++) {
                escritura.println("<tr><td>" + jt.getValueAt(i, 0).toString()
                        + "</td><td>" + jt.getValueAt(i, 1).toString() + "</td><td>" + jt.getValueAt(i, 2).toString() + "</td><td>" + jt.getValueAt(i, 3).toString()
                        + "</td><td>" + jt.getValueAt(i, 4).toString() + "</td><td>" + jt.getValueAt(i, 5).toString() + "</td><td>" + jt.getValueAt(i, 6).toString() + "</td><td>" + jt.getValueAt(i, 7).toString() + "</td></tr>");
            }
            escritura.println("</table>");
            escritura.println(" </body>");
            escritura.println("</html>");
//nos aseguramos de cerrar el archivo
            archivo.close();
            todo_bien = true;
        } catch (Exception e) {
            e.printStackTrace();
            todo_bien = false;
        }
        return todo_bien;
    }

    public boolean generarReporte6(JTable jt, String nit) {
        boolean todo_bien = false;
        try {
            Random nuevo = new Random(System.currentTimeMillis());
            int aleatorio = nuevo.nextInt(100);
            String ruta = "reportePedidosCliente" + aleatorio + ".html";
            FileWriter archivo = new FileWriter(ruta);
            System.out.print(ruta);
            PrintWriter escritura = new PrintWriter(archivo);

//escribimos un archivo de texto con la estructura de html
            escritura.println("<html>");
            escritura.println(" <body>");
            escritura.println(" <h1><center>REPORTE-LISTADO DE TODOS LOS PEDIDOS DE " + nit + "</center></h1>");
            escritura.println("<br><br>");
            escritura.println("<div style='text-align: center;' id = 'div1'>");
            escritura.println("<table border='1' style='margin: 0 auto;'>");
            escritura.println("<tr>");
            escritura.println("<td><strong>PEDIDO</strong></td>");
            escritura.println("<td><strong>CODIGO PRODUCTO</strong></td>");
            escritura.println("<td><strong>TIENDA SOLICITANTE</strong></td>");
            escritura.println("<td><strong>TIENDA SOLICITADA</strong></td>");
            escritura.println("<td><strong>PRECIO</strong></td>");
            escritura.println("<td><strong>CANTIDAD</strong></td>");
            escritura.println("<td><strong>TOTAL</strong></td>");
            escritura.println("<td><strong>ANTICIPO</strong></td>");
            escritura.println("<td><strong>FECHA</strong></td>");
            escritura.println("</tr>");
            for (int i = 0; i < jt.getRowCount(); i++) {
                escritura.println("<tr><td>" + jt.getValueAt(i, 0).toString()
                        + "</td><td>" + jt.getValueAt(i, 1).toString() + "</td><td>" + jt.getValueAt(i, 2).toString() + "</td><td>" + jt.getValueAt(i, 3).toString()
                        + "</td><td>" + jt.getValueAt(i, 4).toString() + "</td><td>" + jt.getValueAt(i, 5).toString() + "</td><td>" + jt.getValueAt(i, 6).toString() + "</td><td>" + jt.getValueAt(i, 7).toString() + "</td><td>" + jt.getValueAt(i, 8).toString() + "</td></tr>");
            }
            escritura.println("</table>");
            escritura.println(" </body>");
            escritura.println("</html>");
//nos aseguramos de cerrar el archivo
            archivo.close();
            todo_bien = true;
        } catch (Exception e) {
            e.printStackTrace();
            todo_bien = false;
        }
        return todo_bien;
    }

    public boolean generarReporte7(JTable jt, String nombre) {
        boolean todo_bien = false;
        try {
            Random nuevo = new Random(System.currentTimeMillis());
            int aleatorio = nuevo.nextInt(100);
            String ruta = "reporte10MasVendidos" + aleatorio + ".html";
            FileWriter archivo = new FileWriter(ruta);
            System.out.print(ruta);
            PrintWriter escritura = new PrintWriter(archivo);

//escribimos un archivo de texto con la estructura de html
            escritura.println("<html>");
            escritura.println(" <body>");
            escritura.println(" <h1><center>REPORTE " + nombre + "</center></h1>");
            escritura.println("<br><br>");
            escritura.println("<div style='text-align: center;' id = 'div1'>");
            escritura.println("<table border='1' style='margin: 0 auto;'>");
            escritura.println("<tr>");
            escritura.println("<td><strong>POSICION</strong></td>");
            escritura.println("<td><strong>CODIGO PRODUCTO</strong></td>");
            escritura.println("<td><strong>NOMBRE PRODUCTO</strong></td>");
            escritura.println("<td><strong>FABRICANTE</strong></td>");
            escritura.println("<td><strong>PRECIO</strong></td>");
            escritura.println("<td><strong>GARANTIA</strong></td>");
            escritura.println("<td><strong>DESCRIPCION</strong></td>");
            escritura.println("<td><strong># VENTAS</strong></td>");
            escritura.println("</tr>");
            for (int i = 0; i < jt.getRowCount(); i++) {
                String a_colocar = "<tr>";
                for (int o = 0; o < jt.getColumnCount(); o++) {
                    if (jt.getValueAt(i, o) != null) {
                        a_colocar += "<td>" + jt.getValueAt(i, o).toString() + "</td>";
                    } else {
                        a_colocar += "<td>" + "SIN VALOR" + "</td>";
                    }
                }
                a_colocar += "</tr>";
                escritura.print(a_colocar);
            }

            escritura.println("</table>");
            escritura.println(" </body>");
            escritura.println("</html>");
//nos aseguramos de cerrar el archivo
            archivo.close();
            todo_bien = true;
        } catch (Exception e) {
            e.printStackTrace();
            todo_bien = false;
        }
        return todo_bien;
    }
    
    public boolean generarReporte8(JTable jt, String nombre) {
        boolean todo_bien = false;
        try {
            Random nuevo = new Random(System.currentTimeMillis());
            int aleatorio = nuevo.nextInt(100);
            String ruta = "reporteMasVendidosTienda" + aleatorio + ".html";
            FileWriter archivo = new FileWriter(ruta);
            System.out.print(ruta);
            PrintWriter escritura = new PrintWriter(archivo);

//escribimos un archivo de texto con la estructura de html
            escritura.println("<html>");
            escritura.println(" <body>");
            escritura.println(" <h1><center>REPORTE " + nombre + "</center></h1>");
            escritura.println("<br><br>");
            escritura.println("<div style='text-align: center;' id = 'div1'>");
            escritura.println("<table border='1' style='margin: 0 auto;'>");
            escritura.println("<tr>");
            escritura.println("<td><strong>POSICION</strong></td>");
            escritura.println("<td><strong>CODIGO PRODUCTO</strong></td>");
            escritura.println("<td><strong>NOMBRE PRODUCTO</strong></td>");
            escritura.println("<td><strong>FABRICANTE</strong></td>");
            escritura.println("<td><strong>PRECIO</strong></td>");
            escritura.println("<td><strong>GARANTIA</strong></td>");
            escritura.println("<td><strong>DESCRIPCION</strong></td>");
            escritura.println("<td><strong># VENTAS</strong></td>");
            escritura.println("</tr>");
            for (int i = 0; i < jt.getRowCount(); i++) {
                String a_colocar = "<tr>";
                for (int o = 0; o < jt.getColumnCount(); o++) {
                    if (jt.getValueAt(i, o) != null) {
                        a_colocar += "<td>" + jt.getValueAt(i, o).toString() + "</td>";
                    } else {
                        a_colocar += "<td>" + "SIN VALOR" + "</td>";
                    }
                }
                a_colocar += "</tr>";
                escritura.print(a_colocar);
            }

            escritura.println("</table>");
            escritura.println(" </body>");
            escritura.println("</html>");
//nos aseguramos de cerrar el archivo
            archivo.close();
            todo_bien = true;
        } catch (Exception e) {
            e.printStackTrace();
            todo_bien = false;
        }
        return todo_bien;
    }
    
    public boolean generarReporte9(JTable jt, String nombre) {
        boolean todo_bien = false;
        try {
            Random nuevo = new Random(System.currentTimeMillis());
            int aleatorio = nuevo.nextInt(100);
            String ruta = "reporteNuncaVendidoTienda" + aleatorio + ".html";
            FileWriter archivo = new FileWriter(ruta);
            System.out.print(ruta);
            PrintWriter escritura = new PrintWriter(archivo);

//escribimos un archivo de texto con la estructura de html
            escritura.println("<html>");
            escritura.println(" <body>");
            escritura.println(" <h1><center>REPORTE " + nombre + "</center></h1>");
            escritura.println("<br><br>");
            escritura.println("<div style='text-align: center;' id = 'div1'>");
            escritura.println("<table border='1' style='margin: 0 auto;'>");
            escritura.println("<tr>");
            escritura.println("<td><strong>CODIGO PRODUCTO</strong></td>");
            escritura.println("<td><strong>NOMBRE PRODUCTO</strong></td>");
            escritura.println("<td><strong>FABRICANTE</strong></td>");
            escritura.println("<td><strong>PRECIO</strong></td>");
            escritura.println("<td><strong>GARANTIA</strong></td>");
            escritura.println("<td><strong>DESCRIPCION</strong></td>");
            escritura.println("</tr>");
            for (int i = 0; i < jt.getRowCount(); i++) {
                String a_colocar = "<tr>";
                for (int o = 0; o < jt.getColumnCount(); o++) {
                    if (jt.getValueAt(i, o) != null) {
                        a_colocar += "<td>" + jt.getValueAt(i, o).toString() + "</td>";
                    } else {
                        a_colocar += "<td>" + "SIN VALOR" + "</td>";
                    }
                }
                a_colocar += "</tr>";
                escritura.print(a_colocar);
            }

            escritura.println("</table>");
            escritura.println(" </body>");
            escritura.println("</html>");
//nos aseguramos de cerrar el archivo
            archivo.close();
            todo_bien = true;
        } catch (Exception e) {
            e.printStackTrace();
            todo_bien = false;
        }
        return todo_bien;
    }
    
    public static Color COLOR_ENFOQUE = new Color(hex("CCFFCC"));
    public static Color COLOR_SINENFOQUE = Color.WHITE;
}
