package com.company.Gráfica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class VentanaPrincipal extends JFrame implements ActionListener {

    JButton send, reset;
    JLabel label;
    JTextField tf;
    JPanel panel;
    JFrame frame;
    JTextArea ta;

    public VentanaPrincipal() {

        frame = new JFrame("Validador de accesibilidad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,500);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        label = new JLabel("Introduzca una URL:");
        tf = new JTextField(50);
        send = new JButton("Validar");
        reset = new JButton("Restablecer");
        send.addActionListener(this);
        reset.addActionListener(this);
        panel.add(label);
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

        ta = new JTextArea();

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == send) {
            if (tf.getText().equals("")) {
                label.setText("Por favor, introduzca una URL válida");
            }
            else {

            }
            // URL a validar
            String url = tf.getText();
            Menu menu = new Menu(url);
        }

        else if (e.getSource() == reset) {
            tf.setText(null);

        }
        else  {
            label.setText("Por favor, introduzca una URL válida");
        }
    }
}
