/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacion;

import Base.TiendaDAO;
import POJOS.TiendaDTO;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author yelbetto
 */
public class ClienteInterfaz extends javax.swing.JFrame {

    Insertar ingreso = new Insertar();
    private Resultado resultado = new Resultado();
    Reportes reporte = new Reportes();
    CatalogoProductos catalogo = new CatalogoProductos();
    RastreoPedido rastreo = new RastreoPedido();
    Boolean seleccionado = false;
    JLabel[] conjunto;
    JLabel[] avisos;
    int pintado = 0;
    ClienteInterfaz frame;
    ArrayList<TiendaDTO> tiendas = new ArrayList<>();
    String codigo_tienda = "";
    Date fecha_actual;

    /**
     * Creates new form Ventana
     */
    public ClienteInterfaz() {
        initComponents();
        setLocationRelativeTo(null);
        agregar_hover();
        frame = this;
        TiendaDAO tienda = new TiendaDAO();
        tiendas = tienda.obtener_tiendas();
        jl_ingresar_aviso.setVisible(false);
        jl_buscar_aviso.setVisible(false);
        jl_boton_ingresar.setVisible(false);
        jl_boton_buscar.setVisible(false);
        Date fecha = new Date();
        jdc_fecha_actual.setDate(fecha);
    }

    public void agregar_hover() {
        JLabel[] conjunto1 = {jl_boton_cargar, jl_boton_buscar, jl_boton_ingresar, jl_boton_modificar};
        conjunto = conjunto1;
        JLabel[] conjunto2 = {jl_cargar_aviso, jl_buscar_aviso, jl_ingresar_aviso, jl_modificar_aviso};
        avisos = conjunto2;
        for (int i = 0; i < conjunto.length; i++) {
            al_iniciar(conjunto[i]);
        }
        catalogo.setVisible(true);
        jp_escritorio.add(catalogo);
        jl_cargar_aviso.setBackground(Color.yellow);
        jl_cargar_aviso.setOpaque(true);
        jl_boton_cargar.setBackground(new Color(0, 102, 102));
        jl_boton_cargar.setOpaque(true);
        jl_boton_cargar.setForeground(Color.yellow);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Fondo = new javax.swing.JPanel();
        btn_exit = new javax.swing.JButton();
        jp_menu = new javax.swing.JPanel();
        jl_boton_cargar = new javax.swing.JLabel();
        jl_boton_buscar = new javax.swing.JLabel();
        jl_nombre = new javax.swing.JLabel();
        jl_boton_ingresar = new javax.swing.JLabel();
        jl_boton_modificar = new javax.swing.JLabel();
        jl_cargar_aviso = new javax.swing.JLabel();
        jl_ingresar_aviso = new javax.swing.JLabel();
        jl_modificar_aviso = new javax.swing.JLabel();
        jl_buscar_aviso = new javax.swing.JLabel();
        btn_exit1 = new javax.swing.JButton();
        jp_escritorio = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jdc_fecha_actual = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Fondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                FondoMouseDragged(evt);
            }
        });
        Fondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FondoMousePressed(evt);
            }
        });

        btn_exit.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btn_exit.setText("X");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        jp_menu.setBackground(new java.awt.Color(129, 191, 253));
        jp_menu.setLayout(new java.awt.GridBagLayout());

        jl_boton_cargar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_boton_cargar.setText("CATALOGO");
        jl_boton_cargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_boton_cargarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jl_boton_cargarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jl_boton_cargarMouseEntered(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 52;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jp_menu.add(jl_boton_cargar, gridBagConstraints);

        jl_boton_buscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_boton_buscar.setText("BUSCAR");
        jl_boton_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_boton_buscarMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 52;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 385, 0);
        jp_menu.add(jl_boton_buscar, gridBagConstraints);

        jl_nombre.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jl_nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_nombre.setText("INTELAF");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 13, 0);
        jp_menu.add(jl_nombre, gridBagConstraints);

        jl_boton_ingresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_boton_ingresar.setText("INGRESAR");
        jl_boton_ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_boton_ingresarMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 52;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jp_menu.add(jl_boton_ingresar, gridBagConstraints);

        jl_boton_modificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_boton_modificar.setText("RASTREO PEDIDO");
        jl_boton_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_boton_modificarMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 52;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 2.3;
        jp_menu.add(jl_boton_modificar, gridBagConstraints);

        jl_cargar_aviso.setBackground(new java.awt.Color(0, 102, 102));
        jl_cargar_aviso.setForeground(new java.awt.Color(0, 102, 102));
        jl_cargar_aviso.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 35;
        jp_menu.add(jl_cargar_aviso, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 33;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        jp_menu.add(jl_ingresar_aviso, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 34;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        jp_menu.add(jl_modificar_aviso, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 37;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        jp_menu.add(jl_buscar_aviso, gridBagConstraints);

        btn_exit1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btn_exit1.setText("—");
        btn_exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exit1ActionPerformed(evt);
            }
        });

        jp_escritorio.setLayout(new java.awt.BorderLayout());

        jButton1.setText("MAX");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jdc_fecha_actual.setDateFormatString("yyyy/MM/dd");
        jdc_fecha_actual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jdc_fecha_actualMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jdc_fecha_actualMouseEntered(evt);
            }
        });
        jdc_fecha_actual.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdc_fecha_actualPropertyChange(evt);
            }
        });

        jLabel2.setText("Fecha actual:");

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addComponent(jp_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdc_fecha_actual, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(jp_escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_exit)
                        .addComponent(btn_exit1)
                        .addComponent(jButton1)
                        .addComponent(jLabel2))
                    .addComponent(jdc_fecha_actual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jp_escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exit1ActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btn_exit1ActionPerformed

    private void jl_boton_cargarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_boton_cargarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jl_boton_cargarMouseEntered

    private void jl_boton_cargarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_boton_cargarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jl_boton_cargarMouseExited
    int pos_x, pos_y;

    /**
    private void FondoMouseDragged(java.awt.event.MouseEvent evt) {                                       private void FondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FondoMouseDragged
        int x =
     * evt.getXOnScreen(); int y = evt.getYOnScreen();
     *
     * this.setLocation(x - pos_x, y - pos_y);
    }//GEN-LAST:event_FondoMouseDragged
*
     */
    private void FondoMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - pos_x, y - pos_y);
    }

    private void FondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FondoMousePressed
        pos_x = evt.getX();
        pos_y = evt.getY();
    }//GEN-LAST:event_FondoMousePressed

    private void jl_boton_cargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_boton_cargarMouseClicked
        cerrando();
        catalogo.setVisible(true);
        jp_escritorio.add(catalogo);
        jp_escritorio.validate();
        despintando_aviso();
        jl_cargar_aviso.setOpaque(true);
        jl_cargar_aviso.setBackground(Color.yellow);
    }//GEN-LAST:event_jl_boton_cargarMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jl_boton_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_boton_modificarMouseClicked
        cerrando();
        rastreo.setVisible(true);
        rastreo.setFecha_actual(fecha_actual);
        jp_escritorio.add(rastreo);

        jp_escritorio.validate();
        despintando_aviso();
        jl_modificar_aviso.setOpaque(true);
        jl_modificar_aviso.setBackground(Color.yellow);
    }//GEN-LAST:event_jl_boton_modificarMouseClicked

    private void jdc_fecha_actualMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdc_fecha_actualMouseEntered

    }//GEN-LAST:event_jdc_fecha_actualMouseEntered

    private void jdc_fecha_actualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdc_fecha_actualMouseClicked

    }//GEN-LAST:event_jdc_fecha_actualMouseClicked

    private void jdc_fecha_actualPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdc_fecha_actualPropertyChange
        fecha_actual = jdc_fecha_actual.getDate();
        if (rastreo.isVisible()) {
            rastreo.setFecha_actual(fecha_actual);
        }
    }//GEN-LAST:event_jdc_fecha_actualPropertyChange

    private void jl_boton_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_boton_buscarMouseClicked
        cerrando();
        reporte.setVisible(true);
        jp_escritorio.add(reporte);
        jp_escritorio.validate();
        despintando_aviso();
        jl_buscar_aviso.setOpaque(true);
        jl_buscar_aviso.setBackground(Color.yellow);
    }//GEN-LAST:event_jl_boton_buscarMouseClicked

    private void jl_boton_ingresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_boton_ingresarMouseClicked
        cerrando();
        ingreso = new Insertar();
        ingreso.setVisible(true);
        ingreso.rellenar_tabla_tiempos(ingreso.getCodigo_tienda_actual());
        jp_escritorio.add(ingreso);
        jp_escritorio.validate();
        despintando_aviso();
        jl_ingresar_aviso.setOpaque(true);
        jl_ingresar_aviso.setBackground(Color.yellow);
    }//GEN-LAST:event_jl_boton_ingresarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteInterfaz().setVisible(true);
            }
        });
    }
    boolean click_todos = false;

    public void al_iniciar(JLabel boton) {
        boton.addMouseListener(new MouseListener() {
            boolean click = false;

            @Override
            public void mouseClicked(MouseEvent me) {
                despintando_jl_v2(boton);
                despintando_aviso_v2(boton);
                for (int i = 0; i < conjunto.length; i++) {
                    if (conjunto[i].getText().equalsIgnoreCase(boton.getText())) {
                        pintado = i;
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
                
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                boton.setOpaque(true);
                boton.setBackground(new Color(0, 102, 102));
                boton.setForeground(Color.yellow);
                for (int i = 0; i < conjunto.length; i++) {
                    if (conjunto[i].getText().equalsIgnoreCase(boton.getText()) && pintado != i) {
                        avisos[i].setOpaque(true);
                        avisos[i].setBackground(new Color(0, 102, 102));
                    }
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {
                boolean dejar_pintado = false;
                switch (boton.getText()) {
                    case "CATALOGO":
                        dejar_pintado = jl_cargar_aviso.getBackground() == Color.yellow;
                        break;
                    case "INGRESAR":
                        dejar_pintado = jl_ingresar_aviso.getBackground() == Color.yellow;
                        break;
                    case "BUSCAR":
                        dejar_pintado = jl_buscar_aviso.getBackground() == Color.yellow;
                        break;
                    case "RASTREO PEDIDO":
                        dejar_pintado = jl_modificar_aviso.getBackground() == Color.yellow;
                        break;
                    default:
                }
                if (!dejar_pintado) {
                    despintar(boton);
                }
                comprobar();
            }

        });
    }

    public JPanel getJp_escritorio() {
        return jp_escritorio;
    }

    public void despintar_jl() {
        despintar(jl_boton_cargar);
        despintar(jl_boton_buscar);
        despintar(jl_boton_ingresar);
    }

    public void despintar(JLabel boton) {
        boton.setOpaque(false);
        boton.setBackground(new Color(0, 204, 204));
        boton.setForeground(Color.black);
    }

    public void cerrando() {
        resultado.setVisible(false);
        ingreso.setVisible(false);
        rastreo.setVisible(false);
        reporte.setVisible(false);
        catalogo.setVisible(false);
    }

    public void despintando_aviso() {
        for (int i = 0; i < avisos.length; i++) {
            despintar(avisos[i]);
        }
    }

    public void despintando_aviso_v2(JLabel no_despintar) {
        for (int i = 0; i < conjunto.length; i++) {
            if (!no_despintar.getText().equals(conjunto[i].getText())) {
                despintar(avisos[i]);
            }
        }
    }

    public void comprobar() {
        for (int i = 0; i < avisos.length; i++) {
            if (i != pintado) {
                despintar(avisos[i]);
            } else {
                avisos[i].setOpaque(true);
                avisos[i].setBackground(Color.yellow);
            }
        }
    }

    public void despintando_jl_v2(JLabel no_despintar) {
        for (int i = 0; i < conjunto.length; i++) {
            if (conjunto[i].getText() != no_despintar.getText() && avisos[i].getBackground() != Color.yellow) {
                conjunto[i].setOpaque(false);
                conjunto[i].setBackground(new Color(0, 204, 204));
                conjunto[i].setForeground(Color.black);
            }
        }
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public void mostrar_ingresados() {
        cerrando();
        resultado.setVisible(true);
        jp_escritorio.add(resultado);
        jp_escritorio.validate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_exit1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private com.toedter.calendar.JDateChooser jdc_fecha_actual;
    private javax.swing.JLabel jl_boton_buscar;
    private javax.swing.JLabel jl_boton_cargar;
    private javax.swing.JLabel jl_boton_ingresar;
    private javax.swing.JLabel jl_boton_modificar;
    private javax.swing.JLabel jl_buscar_aviso;
    private javax.swing.JLabel jl_cargar_aviso;
    private javax.swing.JLabel jl_ingresar_aviso;
    private javax.swing.JLabel jl_modificar_aviso;
    private javax.swing.JLabel jl_nombre;
    private javax.swing.JPanel jp_escritorio;
    private javax.swing.JPanel jp_menu;
    // End of variables declaration//GEN-END:variables
}