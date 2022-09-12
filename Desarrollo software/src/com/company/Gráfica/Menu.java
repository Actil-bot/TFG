package com.company.Gráfica;

import com.company.API.Api;
import com.company.Rendimiento.Rendimiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    JButton rendi, graficas, others;
    JLabel label;
    String url;
    int[] ponderaciones;
    String contenido;
    int rendimiento;

    public Menu (String url) {

        this.url = url;
        this.contenido = Api.downloadFromURL(url);
        Rendimiento performance = new Rendimiento(contenido);
        this.ponderaciones = new int[6];

        // Trabajo con la sección del rendimiento
        this.rendimiento = performance.porcentaje(performance.calculoRendimiento());

        // Trabajo con las métricas que conforman el rendimiento
        int lcp = performance.porcentaje(performance.Lcp());
        int fcp = performance.porcentaje(performance.Fcp());
        int si = performance.porcentaje(performance.SI());
        int ti = performance.porcentaje(performance.TI());
        int tbt = performance.porcentaje(performance.TBT());
        int cls = performance.porcentaje(performance.CLS());
        this.ponderaciones = performance.ponderacion(lcp, fcp, si, ti, tbt, cls);
        panel();
    }

    public void panel () {

        componentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void componentes () {

        label  = new JLabel();
        label.setBounds(220, 25, 180, 20);
        label.setText("Seleccione una opción");
        add(label);

        rendi = new JButton("Rendimiento");
        rendi.setBounds(220, 75, 150 , 20);
        add(rendi);
        rendi.addActionListener(this);

        graficas = new JButton("Gráficas");
        graficas.setBounds(220, 240, 150,  20);
        add(graficas);
        graficas.addActionListener(this);

        others = new JButton("Tiempos de métricas no esenciales");
        others.setBounds(145, 400, 300,  20);
        add(others);
        others.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == rendi) {
            JOptionPane.showMessageDialog(null, "El rendimiento de la página es: " + rendimiento);
        }

        else if (e.getSource() == graficas) {

            GraphicG grafico = new Barras(ponderaciones);
            GraphicG grapg = new Seccion3d(ponderaciones);
            JPanel panel1 = grafico.getPanel();
            JPanel panel2 = grapg.getPanel();

            JFrame frame = new JFrame();
            JScrollPane scroll = new JScrollPane();
            JPanel panelPadre = new JPanel();

            frame.setSize(1000,600);
            scroll.setBounds(5,5, 8, 5);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            scroll.setViewportView(panelPadre);
            frame.add(scroll);
            panelPadre.add(panel1);
            panelPadre.add(panel2);

            panel1.setVisible(true);
            panel2.setVisible(true);
            panelPadre.setPreferredSize(new Dimension(950, 900));

            panelPadre.setVisible(true);
            frame.add(scroll);
            frame.setVisible(true);

        }
        else if (e.getSource() == others) {

            BarrasSegundos seg = new BarrasSegundos(contenido);
        }
        else {
            JOptionPane.showMessageDialog(null, "Opción no válida");

        }
    }
}


