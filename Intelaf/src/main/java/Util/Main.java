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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author yelbetto
 */
public class Main {

    public static void main(String args[]) {
        int opcion = JOptionPane.showConfirmDialog(null, new JLabel("INTELAF te pregunta, ¿eres un empleado?"), "INTELAF",JOptionPane.YES_NO_OPTION);
        if (opcion==JOptionPane.YES_OPTION){
            Ventana v = new Ventana();
            System.out.println("iniciar");
            v.agregar_hover();
            v.setVisible(true);
            System.out.println("iniciar");
        } else {
            ClienteInterfaz nuevo = new ClienteInterfaz();
            System.out.println("iniciar2");
            nuevo.setVisible(true);
        }
    }
}
