/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacion;

import Base.ConectorBD;
import Base.ProductoDAO;
import POJOS.PedidoDTO;
import POJOS.ProductoDTO;
import POJOS.VentaDTO;
import Util.Utilidad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yelbetto
 */
public class Reportes extends javax.swing.JPanel {

    private String codigo_tienda;
    private Date fecha_actual;
    ArrayList<PedidoDTO> pedidos = new ArrayList<>();
    ConectorBD base = new ConectorBD();

    /**
     * Creates new form Reportes
     */
    public Reportes() {
        initComponents();
        jp_filtros.setVisible(false);
        if (base.conectar()) {
            System.out.println("nitido");
        }
        jtf_temporal.setVisible(false);
        jl_temporal.setVisible(false);
        jdc1.setVisible(false);
        jdc2.setVisible(false);
        btn_ver.setVisible(false);
        jl_de.setVisible(false);
        jl_a.setVisible(false);
        btn_ver2.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcb_listados = new javax.swing.JComboBox<>();
        jp_filtros = new javax.swing.JPanel();
        jl_de = new javax.swing.JLabel();
        jdc1 = new com.toedter.calendar.JDateChooser();
        jl_a = new javax.swing.JLabel();
        jdc2 = new com.toedter.calendar.JDateChooser();
        btn_ver = new javax.swing.JButton();
        jl_temporal = new javax.swing.JLabel();
        jtf_temporal = new javax.swing.JTextField();
        btn_ver2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_pedidos = new javax.swing.JTable();
        btn_exportar = new javax.swing.JButton();
        jl_listado = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REPORTES");

        jLabel2.setText("LISTADO DE:");

        jcb_listados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PEDIDOS A LLEGAR", "PEDIDOS A VERIFICAR", "PEDIDOS ATRASADOS", "PEDIDOS EN TRANSITO", "COMPRAS REALIZADAS POR CLIENTE", "PEDIDOS EN CURSO DE CLIENTE", "10 PRODUCTOS MAS VENDIDOS", "PRODUCTOS MAS VENDIDOS", "PRODUCTOS NUNCA VENDIDOS" }));
        jcb_listados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcb_listadosItemStateChanged(evt);
            }
        });

        jl_de.setText("DE: ");

        jl_a.setText("A:");

        btn_ver.setText("VER");
        btn_ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verActionPerformed(evt);
            }
        });

        jl_temporal.setText("NIT:");

        jtf_temporal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_temporalKeyReleased(evt);
            }
        });

        btn_ver2.setText("VER");
        btn_ver2.setEnabled(false);
        btn_ver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ver2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_filtrosLayout = new javax.swing.GroupLayout(jp_filtros);
        jp_filtros.setLayout(jp_filtrosLayout);
        jp_filtrosLayout.setHorizontalGroup(
            jp_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_filtrosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jp_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jl_temporal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_de, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_filtrosLayout.createSequentialGroup()
                        .addComponent(jdc1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jl_a)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdc2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtf_temporal, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ver2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ver, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addContainerGap())
        );
        jp_filtrosLayout.setVerticalGroup(
            jp_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_filtrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_ver)
                    .addGroup(jp_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jdc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jl_a)
                        .addComponent(jdc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jl_de)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_temporal)
                    .addComponent(jtf_temporal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ver2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jt_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUCTO", "TIENDA", "PRECIO", "CANTIDAD", "TOTAL", "ANTICIPO", "FECHA SOLICITADO"
            }
        ));
        jScrollPane1.setViewportView(jt_pedidos);

        btn_exportar.setText("EXPORTAR A HTML");
        btn_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportarActionPerformed(evt);
            }
        });

        jl_listado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jl_listado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_listado.setText("LISTADO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcb_listados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jp_filtros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_exportar))
                    .addComponent(jl_listado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcb_listados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_filtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_listado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_exportar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcb_listadosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcb_listadosItemStateChanged

        String s = jcb_listados.getSelectedItem().toString();
        DefaultTableModel modelo = new DefaultTableModel();
        jt_pedidos.setModel(modelo);
        jl_listado.setText("LISTADOS");
        if (s.equalsIgnoreCase("PEDIDOS A LLEGAR")) {
            //check
            String codigo_tienda1 = codigo_tienda;
            ProductoDAO p = new ProductoDAO(base);
            pedidos = p.obtener_pedidos(getCodigo_tienda());
            if (pedidos != null) {
                agregar_columnas1();
                for (PedidoDTO pe : pedidos) {
                    rellenar_pedidos(pe);
                }
            }
            jl_listado.setText("Listados todos los productos a llegar a tienda actual " + getCodigo_tienda());
            jp_filtros.setVisible(false);
        } else if (s.equalsIgnoreCase("PEDIDOS A VERIFICAR")) {
            ProductoDAO p = new ProductoDAO(base);
            pedidos = p.obtener_pedidos(getCodigo_tienda());
            if (pedidos != null) {
                agregar_columnas6();
                for (PedidoDTO pe : pedidos) {
                    a_verificar(pe);
                }
                if (no_hay) {
                    Utilidad utili = new Utilidad();
                    utili.informar(null, "NO HAY PEDIDOS A TIEMPO (LES FALTA O LES SOBRA DIAS)", "SIN RESULTADOS");
                }
            }
            jl_listado.setText("LISTADO DE PEDIDOS QUE ESTAN A TIEMPO EN TIENDA " + getCodigo_tienda());
            jp_filtros.setVisible(false);
        } else if (s.equalsIgnoreCase("PEDIDOS ATRASADOS")) {
            ProductoDAO p = new ProductoDAO(base);
            pedidos = p.obtener_pedidos(getCodigo_tienda());
            if (pedidos != null) {
                agregar_columnas7();
                for (PedidoDTO pe : pedidos) {
                    a_verificar_atrasados(pe);
                }
                if (no_hay) {
                    Utilidad utili = new Utilidad();
                    utili.informar(null, "NO HAY PEDIDOS A TIEMPO (LES FALTA O LES SOBRA DIAS)", "SIN RESULTADOS");
                }
            }

            jp_filtros.setVisible(false);
        } else if (s.equalsIgnoreCase("PEDIDOS EN TRANSITO")) {
            ProductoDAO p = new ProductoDAO(base);
            pedidos = p.obtener_pedidos_transito(getCodigo_tienda());
            if (pedidos != null) {
                agregar_columnas1();
                for (PedidoDTO pe : pedidos) {
                    rellenar_pedidos(pe);
                }
            }
            jl_listado.setText("LISTADO PEDIDOS QUE SALIERON Y ESTAN EN TRANSITO A LLEGAR A " + getCodigo_tienda());
            jp_filtros.setVisible(false);
        } else if (s.equalsIgnoreCase("COMPRAS REALIZADAS POR CLIENTE")) {
            //check
            jdc1.setVisible(false);
            jdc2.setVisible(false);
            btn_ver.setVisible(false);
            jl_de.setVisible(false);
            jl_a.setVisible(false);
            btn_ver2.setVisible(true);
            jl_temporal.setVisible(true);
            jtf_temporal.setVisible(true);
            jp_filtros.setVisible(true);
        } else if (s.equalsIgnoreCase("PEDIDOS EN CURSO DE CLIENTE")) {
            //check
            jdc1.setVisible(false);
            jdc2.setVisible(false);
            btn_ver.setVisible(false);
            jl_de.setVisible(false);
            jl_a.setVisible(false);
            btn_ver2.setVisible(true);
            jp_filtros.setVisible(true);
            jl_temporal.setVisible(true);
            jtf_temporal.setVisible(true);
        } else if (s.equalsIgnoreCase("10 PRODUCTOS MAS VENDIDOS")) {
            //check
            jp_filtros.setVisible(true);
            jdc1.setVisible(true);
            jdc2.setVisible(true);
            btn_ver.setVisible(true);
            jl_de.setVisible(true);
            jl_a.setVisible(true);

            jl_temporal.setVisible(false);
            jtf_temporal.setVisible(false);
            btn_ver2.setVisible(false);
        } else if (s.equalsIgnoreCase("PRODUCTOS MAS VENDIDOS")) {
            //check
            jdc1.setVisible(true);
            jdc2.setVisible(true);
            btn_ver.setVisible(true);
            jl_de.setVisible(true);
            jl_a.setVisible(true);
            jp_filtros.setVisible(true);
            jl_temporal.setVisible(false);
            jtf_temporal.setVisible(false);
            btn_ver2.setVisible(false);
        } else if (s.equalsIgnoreCase("PRODUCTOS NUNCA VENDIDOS")) {
            //check
            ProductoDAO p = new ProductoDAO(base);
            ArrayList<ProductoDTO> pro = p.nunca_vendidos(getCodigo_tienda());
            if (pro != null) {
                agregar_columnas3();
                for (ProductoDTO pe : pro) {
                    rellenar_mas(pe);
                }
            }
            jp_filtros.setVisible(false);
            jl_listado.setText("LISTADO PRODUCTOS NUNCA VENDIDOS EN TIENDA ACTUAL " + getCodigo_tienda());
        }
    }//GEN-LAST:event_jcb_listadosItemStateChanged

    private void btn_verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verActionPerformed
        String s = jcb_listados.getSelectedItem().toString();
        ProductoDAO d = new ProductoDAO(base);
        if (jdc1.getDate() != null && jdc2.getDate() != null) {
            if (s.equalsIgnoreCase("10 PRODUCTOS MAS VENDIDOS")) {
                Date d1 = jdc1.getDate();
                Date d2 = jdc2.getDate();
                String sql = "SELECT p.codigo_producto, p.nombre, p.precio, p.fabricante, p.garantia, p.descripcion,"
                        + "COUNT(p.codigo_producto) AS total FROM Producto p, Factura f JOIN Venta v "
                        + "WHERE p.codigo_producto = v.codigo_producto AND v.codigo_factura = f.codigo_factura AND "
                        + "(f.fecha BETWEEN ? AND ?) GROUP BY(p.codigo_producto) ORDER BY(total) DESC LIMIT 10";
                ArrayList<ProductoDTO> prod = d.diez_mas_vendidos_fechas(sql, d1, d2);
                int pos = 1;
                agregar_columnas2();
                for (ProductoDTO p : prod) {
                    rellenar_mas(pos, p.getCodigo_producto(), p.getNombre(), p.getFabricante(), p.getPrecio(), p.getGarantia(), p.getDescripcion(), p.getConteo());
                    pos++;
                }
                int anio = d1.getYear() + 1900;
                int anio2 = d2.getYear() + 1900;
                int mes = d1.getMonth() + 1;
                int mes2 = d2.getMonth() + 1;
                jl_listado.setText("LISTADO 10 PRODUCTOS MAS VENDIDOS ENTRE " + d1.getDate() + "-" + mes + "-" + anio + " y " + d2.getDate() + "-" + mes2 + "-" + anio2);
            } else if (s.equalsIgnoreCase("PRODUCTOS MAS VENDIDOS")) {
                Date d1 = jdc1.getDate();
                Date d2 = jdc2.getDate();
                ArrayList<ProductoDTO> prod = d.mas_vendidos_fechas(getCodigo_tienda(), d1, d2);
                int pos = 1;
                agregar_columnas2();
                for (ProductoDTO p : prod) {
                    rellenar_mas(pos, p.getCodigo_producto(), p.getNombre(), p.getFabricante(), p.getPrecio(), p.getGarantia(), p.getDescripcion(), p.getConteo());
                    pos++;
                }
                int anio = d1.getYear() + 1900;
                int anio2 = d2.getYear() + 1900;
                int mes = d1.getMonth() + 1;
                int mes2 = d2.getMonth() + 1;
                jl_listado.setText("LISTADO MAS VENDIDOS ENTRE " + d1.getDate() + "-" + mes + "-" + anio + " y " + d2.getDate() + "-" + mes2 + "-" + anio2 + " DE TIENDA ACTUAL " + getCodigo_tienda());
            }
        } else {
            if (s.equalsIgnoreCase("10 PRODUCTOS MAS VENDIDOS")) {
                String sql = "SELECT p.codigo_producto, p.nombre, p.precio, p.fabricante, p.garantia, p.descripcion,COUNT(p.codigo_producto) AS total "
                        + "FROM Producto p JOIN Venta v WHERE p.codigo_producto = v.codigo_producto GROUP BY(p.codigo_producto) ORDER BY(total) DESC LIMIT 10;";
                ArrayList<ProductoDTO> prod = d.diez_mas_vendidos(sql);
                int pos = 1;
                agregar_columnas2();
                for (ProductoDTO p : prod) {
                    rellenar_mas(pos, p.getCodigo_producto(), p.getNombre(), p.getFabricante(), p.getPrecio(), p.getGarantia(), p.getDescripcion(), p.getConteo());
                    pos++;
                }
                jl_listado.setText("LISTADO 10 PRODUCTOS MAS VENDIDOS POR TODAS LAS TIENDAS");
            } else if (s.equalsIgnoreCase("PRODUCTOS MAS VENDIDOS")) {
                ArrayList<ProductoDTO> prod = d.mas_vendidos(getCodigo_tienda());
                int pos = 1;
                agregar_columnas2();
                for (ProductoDTO p : prod) {
                    rellenar_mas(pos, p.getCodigo_producto(), p.getNombre(), p.getFabricante(), p.getPrecio(), p.getGarantia(), p.getDescripcion(), p.getConteo());
                    pos++;
                }
                jl_listado.setText("LISTADO PRODUCTOS MAS VENDIDOS DE TIENDA ACTUAL " + getCodigo_tienda());
            }
        }
    }//GEN-LAST:event_btn_verActionPerformed

    private void btn_ver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ver2ActionPerformed
        String s = jcb_listados.getSelectedItem().toString();
        Utilidad utili = new Utilidad();
        if (!jtf_temporal.getText().isEmpty()) {
            String nit = jtf_temporal.getText();
            ProductoDAO pro = new ProductoDAO(base);
            if (s.equalsIgnoreCase("COMPRAS REALIZADAS POR CLIENTE")) {
                ProductoDAO p = new ProductoDAO(base);
                ArrayList<VentaDTO> v = p.compras_cliente(nit.toUpperCase());
                if (v != null) {
                    agregar_columnas5();
                    for (VentaDTO ve : v) {
                        rellenar_ventas(ve);
                    }
                } else {
                    utili.informar(null, "No existe el cliente", "NIT NO EXISTENTE");
                }
                jl_listado.setText("LISTADO PEDIDOS EN CURSO DE CLIENTE " + nit.toUpperCase());
            } else {
                ProductoDAO p = new ProductoDAO(base);
                pedidos = p.obtener_pedidos_cliente(nit.toUpperCase());
                if (pedidos != null) {
                    agregar_columnas4();
                    for (PedidoDTO pe : pedidos) {
                        rellenar_pedidos2(pe);
                    }
                } else {
                    utili.informar(null, "No existe el cliente", "NIT NO EXISTENTE");
                }
                jl_listado.setText("LISTADO PEDIDOS EN CURSO DE CLIENTE " + nit.toUpperCase());
            }
        } else {
            utili.informar(null, "Ingresa el nit primero", "FALTA NIT");
        }
    }//GEN-LAST:event_btn_ver2ActionPerformed

    private void jtf_temporalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_temporalKeyReleased
        if (jtf_temporal.getText().isEmpty()) {
            btn_ver2.setEnabled(false);
        } else {
            btn_ver2.setEnabled(true);
        }
    }//GEN-LAST:event_jtf_temporalKeyReleased

    private void btn_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportarActionPerformed
        Utilidad u = new Utilidad();
        if (jt_pedidos.getRowCount() > 0) {
            String s = jcb_listados.getSelectedItem().toString();
            if (s.equalsIgnoreCase("PEDIDOS A LLEGAR")) {
                if (u.generarReporte(jt_pedidos, getCodigo_tienda())) {
                    u.informar(null, "REPORTE GENERADO EXITOSAMENTE", "EXPORTAR HTML");
                } else {
                    u.informar(null, "FALLO EL GENERAR EL HTML", "EXPORTAR HTML");
                }
            } else if (s.equalsIgnoreCase("PEDIDOS A VERIFICAR")) {
                if (u.generarReporte2(jt_pedidos, getCodigo_tienda())) {
                    u.informar(null, "REPORTE GENERADO EXITOSAMENTE", "EXPORTAR HTML");
                } else {
                    u.informar(null, "FALLO EL GENERAR EL HTML", "EXPORTAR HTML");
                }
            } else if (s.equalsIgnoreCase("PEDIDOS ATRASADOS")) {
                if (u.generarReporte3(jt_pedidos, getCodigo_tienda())) {
                    u.informar(null, "REPORTE GENERADO EXITOSAMENTE", "EXPORTAR HTML");
                } else {
                    u.informar(null, "FALLO EL GENERAR EL HTML", "EXPORTAR HTML");
                }
            } else if (s.equalsIgnoreCase("PEDIDOS EN TRANSITO")) {
                if (u.generarReporte4(jt_pedidos, getCodigo_tienda())) {
                    u.informar(null, "REPORTE GENERADO EXITOSAMENTE", "EXPORTAR HTML");
                } else {
                    u.informar(null, "FALLO EL GENERAR EL HTML", "EXPORTAR HTML");
                }
            } else if (s.equalsIgnoreCase("COMPRAS REALIZADAS POR CLIENTE")) {
                if (u.generarReporte5(jt_pedidos, jtf_temporal.getText().toUpperCase()) ){
                    u.informar(null, "REPORTE GENERADO EXITOSAMENTE", "EXPORTAR HTML");
                } else {
                    u.informar(null, "FALLO EL GENERAR EL HTML", "EXPORTAR HTML");
                }
            } else if (s.equalsIgnoreCase("PEDIDOS EN CURSO DE CLIENTE")) {
                if (u.generarReporte6(jt_pedidos, jtf_temporal.getText().toUpperCase()) ){
                    u.informar(null, "REPORTE GENERADO EXITOSAMENTE", "EXPORTAR HTML");
                } else {
                    u.informar(null, "FALLO EL GENERAR EL HTML", "EXPORTAR HTML");
                }
            } else if (s.equalsIgnoreCase("10 PRODUCTOS MAS VENDIDOS")) {
                if (u.generarReporte7(jt_pedidos, jl_listado.getText()) ){
                    u.informar(null, "REPORTE GENERADO EXITOSAMENTE", "EXPORTAR HTML");
                } else {
                    u.informar(null, "FALLO EL GENERAR EL HTML", "EXPORTAR HTML");
                }
            } else if (s.equalsIgnoreCase("PRODUCTOS MAS VENDIDOS")) {
                if (u.generarReporte8(jt_pedidos, jl_listado.getText()) ){
                    u.informar(null, "REPORTE GENERADO EXITOSAMENTE", "EXPORTAR HTML");
                } else {
                    u.informar(null, "FALLO EL GENERAR EL HTML", "EXPORTAR HTML");
                }
            } else if (s.equalsIgnoreCase("PRODUCTOS NUNCA VENDIDOS")) {
                if (u.generarReporte9(jt_pedidos, jl_listado.getText()) ){
                    u.informar(null, "REPORTE GENERADO EXITOSAMENTE", "EXPORTAR HTML");
                } else {
                    u.informar(null, "FALLO EL GENERAR EL HTML", "EXPORTAR HTML");
                }
            }
        } else {
            u.informar(null, "SELECCIONA UN TIPO DE REPORTE PRIMERO", "EXPORTAR");
        }
    }//GEN-LAST:event_btn_exportarActionPerformed

    public String getCodigo_tienda() {
        return codigo_tienda;
    }

    public void setCodigo_tienda(String codigo_tienda) {
        this.codigo_tienda = codigo_tienda;
    }

    public Date getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(Date fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

    public void rellenar_pedidos(PedidoDTO p) {
        Object[] fila = new Object[8];
        DefaultTableModel model = (DefaultTableModel) jt_pedidos.getModel();
        fila[0] = p.getCodigo_pedido();
        fila[1] = p.getCodigo_producto();
        fila[2] = p.getCodigo_tienda2();
        fila[3] = p.getPrecio_producto();
        fila[4] = p.getCantidad();
        fila[5] = p.getTotal();
        fila[6] = p.getAnticipo();
        fila[7] = p.getFecha2();
        model.addRow(fila);
    }

    public void rellenar_pedidos_verificar(PedidoDTO p) {
        Object[] fila = new Object[9];
        DefaultTableModel model = (DefaultTableModel) jt_pedidos.getModel();
        fila[0] = p.getCodigo_pedido();
        fila[1] = p.getCodigo_producto();
        fila[2] = p.getCodigo_tienda2();
        fila[3] = p.getPrecio_producto();
        fila[4] = p.getCantidad();
        fila[5] = p.getTotal();
        fila[6] = p.getAnticipo();
        fila[7] = p.getFecha2();
        fila[8] = p.getDias();
        model.addRow(fila);
    }

    public void rellenar_pedidos2(PedidoDTO p) {
        Object[] fila = new Object[9];
        DefaultTableModel model = (DefaultTableModel) jt_pedidos.getModel();
        fila[0] = p.getCodigo_pedido();
        fila[1] = p.getCodigo_producto();
        fila[2] = p.getCodigo_tienda1();
        fila[3] = p.getCodigo_tienda2();
        fila[4] = p.getPrecio_producto();
        fila[5] = p.getCantidad();
        fila[6] = p.getTotal();
        fila[7] = p.getAnticipo();
        fila[8] = p.getFecha2();
        model.addRow(fila);
    }

    public void rellenar_ventas(VentaDTO p) {
        Object[] fila = new Object[8];
        DefaultTableModel model = (DefaultTableModel) jt_pedidos.getModel();
        fila[0] = p.getCodigo_factura();
        fila[1] = p.getCodigo_producto();
        fila[2] = p.getNombre_producto();
        fila[3] = p.getCodigo_tienda();
        fila[4] = p.getPrecio();
        fila[5] = p.getCantidad();
        fila[6] = p.getTotal();
        fila[7] = p.getFecha();
        model.addRow(fila);
    }

    public void rellenar_mas(int numero, String codigo, String nombre, String fabricante, Double precio, int garantia, String descripcion, int no_ventas) {
        Object[] fila = new Object[8];
        DefaultTableModel model = (DefaultTableModel) jt_pedidos.getModel();
        fila[0] = numero;
        fila[1] = codigo;
        fila[2] = nombre;
        fila[3] = fabricante;
        fila[4] = precio;
        fila[5] = garantia;
        fila[6] = descripcion;
        fila[7] = no_ventas;
        model.addRow(fila);
    }

    public void rellenar_mas(ProductoDTO p) {
        Object[] fila = new Object[6];
        DefaultTableModel model = (DefaultTableModel) jt_pedidos.getModel();
        fila[0] = p.getCodigo_producto();
        fila[1] = p.getNombre();
        fila[2] = p.getFabricante();
        fila[3] = p.getPrecio();
        fila[4] = p.getGarantia();
        fila[5] = p.getDescripcion();
        model.addRow(fila);
    }

    public void agregar_columnas1() {
        DefaultTableModel modelo = new DefaultTableModel();
        jt_pedidos.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("TIENDA");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("TOTAL");
        modelo.addColumn("ANTICIPO");
        modelo.addColumn("FECHA");
        jt_pedidos.setModel(modelo);
    }

    public void agregar_columnas6() {
        DefaultTableModel modelo = new DefaultTableModel();
        jt_pedidos.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("TIENDA");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("TOTAL");
        modelo.addColumn("ANTICIPO");
        modelo.addColumn("FECHA");
        modelo.addColumn("TIEMPO");
        jt_pedidos.setModel(modelo);
    }

    public void agregar_columnas7() {
        DefaultTableModel modelo = new DefaultTableModel();
        jt_pedidos.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("TIENDA");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("TOTAL");
        modelo.addColumn("ANTICIPO");
        modelo.addColumn("FECHA");
        modelo.addColumn("DIAS ATRASO");
        jt_pedidos.setModel(modelo);
    }

    public void agregar_columnas4() {
        DefaultTableModel modelo = new DefaultTableModel();
        jt_pedidos.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("TIENDA SOLICITANTE");
        modelo.addColumn("TIENDA SOLICITADA");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("TOTAL");
        modelo.addColumn("ANTICIPO");
        modelo.addColumn("FECHA");
        jt_pedidos.setModel(modelo);
    }

    public void agregar_columnas5() {
        DefaultTableModel modelo = new DefaultTableModel();
        jt_pedidos.setModel(modelo);
        modelo.addColumn("FACTURA");
        modelo.addColumn("CODIGO PRODUCTO");
        modelo.addColumn("NOMBRE PRODUCTO");
        modelo.addColumn("TIENDA");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("TOTAL");
        modelo.addColumn("FECHA");
        jt_pedidos.setModel(modelo);
    }

    public void agregar_columnas2() {
        DefaultTableModel modelo = new DefaultTableModel();
        jt_pedidos.setModel(modelo);
        modelo.addColumn("#");
        modelo.addColumn("CODIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("FABRICANTE");
        modelo.addColumn("PRECIO");
        modelo.addColumn("GARANTIA");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("# VENTAS");
        jt_pedidos.setModel(modelo);
    }

    public void agregar_columnas3() {
        DefaultTableModel modelo = new DefaultTableModel();
        jt_pedidos.setModel(modelo);
        modelo.addColumn("CODIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("FABRICANTE");
        modelo.addColumn("PRECIO");
        modelo.addColumn("GARANTIA");
        modelo.addColumn("DESCRIPCION");
        jt_pedidos.setModel(modelo);
    }
    boolean no_hay = false;

    public void a_verificar(PedidoDTO pe) {
        Date fecha_solicitado = pe.getFecha2();
        Date actual = fecha_actual;
        int tiempo = pe.getDias();
        Utilidad u = new Utilidad();
        int dias_entre = u.dias(fecha_solicitado, actual);

        int resta = tiempo - dias_entre;
        if (resta == 0) {
            rellenar_pedidos_verificar(pe);
            no_hay = false;
        }
        no_hay = jt_pedidos.getRowCount() == 0;
    }

    public void a_verificar_atrasados(PedidoDTO pe) {
        Date fecha_solicitado = pe.getFecha2();
        Date actual = fecha_actual;
        int tiempo = pe.getDias();
        Utilidad u = new Utilidad();
        int dias_entre = u.dias(fecha_solicitado, actual);

        int resta = tiempo - dias_entre;
        if (resta < 0) {
            pe.setDias(Math.abs(resta));
            rellenar_pedidos_verificar(pe);
            no_hay = false;
        }
        no_hay = jt_pedidos.getRowCount() == 0;
    }

    public void iniciar() {
        ProductoDAO p = new ProductoDAO(base);
        pedidos = p.obtener_pedidos(getCodigo_tienda());
        if (pedidos != null) {
            agregar_columnas1();
            for (PedidoDTO pe : pedidos) {
                rellenar_pedidos(pe);
            }
        }
        jl_listado.setText("Listados todos los productos a llegar a tienda actual " + getCodigo_tienda());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exportar;
    private javax.swing.JButton btn_ver;
    private javax.swing.JButton btn_ver2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcb_listados;
    private com.toedter.calendar.JDateChooser jdc1;
    private com.toedter.calendar.JDateChooser jdc2;
    private javax.swing.JLabel jl_a;
    private javax.swing.JLabel jl_de;
    private javax.swing.JLabel jl_listado;
    private javax.swing.JLabel jl_temporal;
    private javax.swing.JPanel jp_filtros;
    private javax.swing.JTable jt_pedidos;
    private javax.swing.JTextField jtf_temporal;
    // End of variables declaration//GEN-END:variables
}
