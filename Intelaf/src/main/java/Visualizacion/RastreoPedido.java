/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacion;

import Base.ConectorBD;
import Base.ProductoDAO;
import Base.TiendaDAO;
import POJOS.PedidoDTO;
import POJOS.ProductoDTO;
import Util.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yelbetto
 */
public class RastreoPedido extends javax.swing.JPanel {

    private Date fecha_actual;
    Utilidad utilidad = new Utilidad();
    ArrayList<String[]> tiempos;

    /**
     * Creates new form RastreoPedido
     */
    public RastreoPedido() {
        initComponents();
        ConectorBD conector = new ConectorBD();
        if (conector.conectar()) {
            TiendaDAO tienda = new TiendaDAO(conector);
            tiempos = tienda.obtener_tiempos();
        }
        TextPrompt tx = new TextPrompt("INGRESA CODIGO PEDIDO", codigo_pedido);
        tx.changeStyle(2);
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
        codigo_pedido = new javax.swing.JTextField();
        btn_rastrear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_productos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jl_dias = new javax.swing.JLabel();
        dias = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pago = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tienda_recoger = new javax.swing.JTextField();
        tienda_origen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        anticipo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RASTREO DE PEDIDO");

        jLabel2.setText("CODIGO PEDIDO:");

        codigo_pedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codigo_pedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigo_pedidoKeyReleased(evt);
            }
        });

        btn_rastrear.setText("RASTREAR");
        btn_rastrear.setEnabled(false);
        btn_rastrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rastrearActionPerformed(evt);
            }
        });

        jt_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PEDIDO", "PRODUCTO", "TIENDA ORIGEN", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(jt_productos);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(255, 51, 51));

        jl_dias.setText("DIAS RESTANTES:");

        dias.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dias.setEnabled(false);

        jLabel4.setText("TIENDA ORIGEN:");

        pago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pago.setEnabled(false);

        jLabel6.setText("TIENDA A RECOGER:");

        tienda_recoger.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tienda_recoger.setEnabled(false);

        tienda_origen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tienda_origen.setEnabled(false);
        tienda_origen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tienda_origenActionPerformed(evt);
            }
        });

        jLabel5.setText("PAGO PARA RECOGER:");

        jLabel7.setText("TOTAL:");

        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total.setEnabled(false);

        jLabel8.setText("ANTICIPO REALIZADO:");

        anticipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        anticipo.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(anticipo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(tienda_origen))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jl_dias))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dias, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pago, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tienda_recoger))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_dias)
                    .addComponent(dias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tienda_recoger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tienda_origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(anticipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PRODUCTOS EN EL PEDIDO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigo_pedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_rastrear))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(codigo_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_rastrear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tienda_origenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tienda_origenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tienda_origenActionPerformed

    private void btn_rastrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rastrearActionPerformed
        String pedido = codigo_pedido.getText();
        int codigo = Integer.parseInt(pedido);
        Date actual = new Date();
        ConectorBD conector = new ConectorBD();
        if (conector.conectar()) {
            ProductoDAO producto = new ProductoDAO(conector);
            PedidoDTO product = producto.obtener_pedido(codigo);
            if (product.getFecha2()!=null) {
                int d = dias(product.getCodigo_tienda1(), product.getCodigo_tienda2());
                int dias_entre = utilidad.dias(getFecha_actual(), product.getFecha2());
                System.out.println(d + "");
                if (d >= dias_entre) {
                    int tem = d - dias_entre;
                    dias.setText(tem + "");
                    dias.setForeground(Color.black);
                } else {
                    int tem = dias_entre - d;
                    dias.setText(tem + "");
                    dias.setText("0");
                    dias.setForeground(Color.red);
                }
                dias.setToolTipText("FECHA SOLICITADO: " + product.getFecha2());
                ArrayList<ProductoDTO> prod = producto.obtener_solicitados(codigo);
                Double total1 = 0.0;

                for (ProductoDTO p : prod) {
                    total1 += p.getCantidad() * p.getPrecio();
                    System.out.println(total1);
                }
                Double pago1 = total1 - product.getAnticipo();
                total.setText(total1 + "");
                pago.setText(pago1 + "");
                System.out.println(product.getFecha2() + "");
                System.out.println(getFecha_actual());
                tienda_recoger.setText(product.getCodigo_tienda1());
                tienda_origen.setText(product.getCodigo_tienda2());
                anticipo.setText(product.getAnticipo() + "");
                utilidad.limpiar_tablas(jt_productos);
                for (ProductoDTO p : prod) {
                    rellenar_tabla(p, codigo, tienda_origen.getText());
                }
            } else {
                utilidad.informar(null, "No existe un pedido con ese codigo, ingresa uno correcto", "Pedido no encontrado");
                codigo_pedido.setText("");
                btn_rastrear.setEnabled(false);
            }

        }
    }//GEN-LAST:event_btn_rastrearActionPerformed

    private void codigo_pedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigo_pedidoKeyReleased
        String s = codigo_pedido.getText();
        btn_rastrear.setEnabled(!s.isEmpty());
    }//GEN-LAST:event_codigo_pedidoKeyReleased

    public Date getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(Date fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

    public int dias(String c1, String c2) {
        int dias1 = -1;
        for (String[] dia : tiempos) {
            if ((dia[0].equalsIgnoreCase(c1) || dia[1].equalsIgnoreCase(c1)) && (dia[0].equalsIgnoreCase(c2) || dia[1].equalsIgnoreCase(c2))) {
                dias1 = Integer.parseInt(dia[2]);
                break;
            }
        }
        return dias1;
    }

    public void rellenar_tabla(ProductoDTO t, int id_pedido, String tienda_origen) {
        Object[] fila = new Object[6];
        DefaultTableModel model = (DefaultTableModel) jt_productos.getModel();
        fila[0] = id_pedido;
        fila[1] = t.getCodigo_producto() + " | " + t.getNombre();
        fila[2] = tienda_origen;
        fila[3] = t.getCantidad();
        fila[4] = t.getPrecio();
        fila[5] = t.getCantidad() * t.getPrecio();
        model.addRow(fila);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anticipo;
    private javax.swing.JButton btn_rastrear;
    private javax.swing.JTextField codigo_pedido;
    private javax.swing.JTextField dias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_dias;
    private javax.swing.JTable jt_productos;
    private javax.swing.JTextField pago;
    private javax.swing.JTextField tienda_origen;
    private javax.swing.JTextField tienda_recoger;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}