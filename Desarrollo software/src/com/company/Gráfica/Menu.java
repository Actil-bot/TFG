package com.company.Gráfica;

import com.company.API.Api;
import com.company.Rendimiento.Rendimiento;
import com.company.Wave.DatosWave;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    JButton rendi, graficas, others, resultApiWave, AlertsApiWave, errorsApiWave, structuralE;
    JLabel label, label1, label2;
    String url;
    int[] ponderaciones;
    String contenido;
    String contenido2;
    DatosWave wave;
    int rendimiento;

    public Menu (String url) {

        this.url = url;
        // Contenidos de las dos APIs
        this.contenido = Api.downloadFromURL(url,1);
        this.contenido2 = Api.downloadFromURL(url,2);

        Rendimiento performance = new Rendimiento(contenido);
        this.wave = new DatosWave(contenido2);
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
        setSize(1000,400);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void componentes () {

        label  = new JLabel();
        label.setBounds(415, 35, 180, 20);
        label.setText("Seleccione una opción:");
        add(label);

        label1  = new JLabel();
        label1.setBounds(430, 60, 180, 20);
        label1.setText("API PageSpeed");
        add(label1);

        label2  = new JLabel();
        label2.setBounds(450, 200, 180, 20);
        label2.setText("API Wave");
        add(label2);

        rendi = new JButton("Rendimiento");
        rendi.setBounds(50, 110, 200 , 40);
        add(rendi);
        rendi.addActionListener(this);

        graficas = new JButton("Métricas esenciales");
        graficas.setBounds(375, 110, 200,  40);
        add(graficas);
        graficas.addActionListener(this);

        others = new JButton("Métricas no esenciales");
        others.setBounds(690, 110, 200,  40);
        add(others);
        others.addActionListener(this);

        resultApiWave = new JButton("Resultados obtenidos");
        resultApiWave.setBounds(30, 250, 200,  40);
        add(resultApiWave);
        resultApiWave.addActionListener(this);

        errorsApiWave = new JButton("Errores surgidos");
        errorsApiWave.setBounds(250, 250, 200,  40);
        add(errorsApiWave);
        errorsApiWave.addActionListener(this);

        AlertsApiWave = new JButton("Alertas surgidas");
        AlertsApiWave.setBounds(470, 250, 200,  40);
        add(AlertsApiWave);
        AlertsApiWave.addActionListener(this);

        structuralE = new JButton("Problemas estructurales");
        structuralE.setBounds(700, 250, 200,  40);
        add(structuralE);
        structuralE.addActionListener(this);
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
        else if (e.getSource() == resultApiWave) {

            // Trabajo con la segunda API
            JOptionPane.showMessageDialog(null, "Los resultados obtenidos son: \n\n" + "- Número de errores: " + wave.numErrors() + "\n" + "- Errores contrastados: " +  wave.contrastErrors() + "\n" + "- Número de alertas: " +  wave.numAlerts() + "\n" + "- Número de características: " +  wave.numFeatures() + "\n" + "- Número de elementos estructurales: " +  wave.numStructural() + "\n" + "- Número de ARIA: " +  wave.numAria() + "\n");
        }

        else if (e.getSource() == AlertsApiWave) {

            JOptionPane.showMessageDialog(null, "Las alertas detectadas son: \n\n" + wave.arrayStringToString(wave.getAlerts()));

        }
        else if (e.getSource() == others) {

            BarrasSegundos seg = new BarrasSegundos(contenido);
        }

        else if (e.getSource() == errorsApiWave) {

            JOptionPane.showMessageDialog(null, "Los errores detectados son: \n\n" + wave.arrayStringToString(wave.getErrors()));
        }

        else if (e.getSource() == structuralE) {

            JOptionPane.showMessageDialog(null, "Los elementos estructurales detectados son: \n\n" + wave.arrayStringToString(wave.getEstructural()) + "\n");

        }
        else {
            JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }
}


