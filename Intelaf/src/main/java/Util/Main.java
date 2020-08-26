/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Base.ConectorBD;
import Base.EmpleadoDAO;
import Visualizacion.ClienteInterfaz;
import Visualizacion.Ventana;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author yelbetto
 */
public class Main {

    public static void main(String args[]) {
        JPanel jp2 = new JPanel();
        JComboBox jcb = new JComboBox();
        jcb.addItem("CLIENTE");
        jcb.addItem("EMPLEADO");

        JTextField jt = new JTextField();
        jt.setVisible(false);
        jt.setHorizontalAlignment(SwingConstants.CENTER);
        TextPrompt tx12 = new TextPrompt("CODIGO EMPLEADO", jt);
        JButton cancelar = new JButton("Cancelar");
        JButton continuar = new JButton("Continuar");
        continuar.setEnabled(true);
        tx12.changeStyle(2);
        jp2.setLayout(new GridLayout(3, 2));
        jp2.add(new JLabel("TIPO USUARIO: ", SwingConstants.CENTER));
        jp2.add(jcb);
        JLabel nuevo = new JLabel("CODIGO: EMPLEADO");
        nuevo.setVisible(false);
        jp2.add(nuevo);
        jp2.add(jt);
        jp2.add(cancelar);
        jp2.add(continuar);
        JFrame jf = new JFrame();
        jf.setUndecorated(true);
        jf.setLocationRelativeTo(null);
        jf.setSize(400, 150);
        jf.add(jp2);
        jf.setVisible(true);
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jf.setVisible(false);
            }
        });

        jcb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                String s = jcb.getSelectedItem().toString();
                if (s.equalsIgnoreCase("EMPLEADO")) {
                    continuar.setEnabled(false);
                    nuevo.setVisible(true);
                    jt.setVisible(true);
                } else {
                    continuar.setEnabled(true);
                    nuevo.setVisible(false);
                    jt.setVisible(false);
                }
            }
        });
        jt.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                String s = jt.getText();
                ConectorBD nu = new ConectorBD();
                if (nu.conectar()) {
                    EmpleadoDAO em = new EmpleadoDAO(nu);
                    if (em.existe_empleado(s)){
                        continuar.setEnabled(true);
                    } else {
                        continuar.setEnabled(false);
                    }
                }
            }
        });
        continuar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String s = jcb.getSelectedItem().toString();
                if (s.equalsIgnoreCase("EMPLEADO")) {
                    Ventana v = new Ventana();
                    v.setVisible(true);
                } else {
                    ClienteInterfaz cli = new ClienteInterfaz();
                    cli.setVisible(true);
                }
                jf.setVisible(false);
            }
        });
        
    }
}
