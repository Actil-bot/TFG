package com.company.Gráfica;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

import javax.swing.*;

public class Seccion3d extends GraphicG {

    JPanel panel;
    int[] ponderacion;

    public Seccion3d(int[] ponderaciones) {

        super();
        this.ponderacion = ponderaciones;
        Setting();
    }

    @Override
    public void init() {
        panel = new JPanel();
        getContentPane().add(panel);

        // Fuente de datos
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("LCP", ponderacion[0]);
        data.setValue("FCP", ponderacion[1]);
        data.setValue("SI",ponderacion[2]);
        data.setValue("TI",ponderacion[3]);
        data.setValue("TBT", ponderacion[4]);
        data.setValue("CLS",ponderacion[5]);

        // Creando gráfico
        JFreeChart chart = ChartFactory.createPieChart3D("Rendimiento", data, true, true, false);
        PiePlot3D pieplot3d = (PiePlot3D)chart.getPlot();
        pieplot3d.setDepthFactor(0.5);
        pieplot3d.setStartAngle(290D);
        pieplot3d.setDirection(Rotation.CLOCKWISE);
        pieplot3d.setForegroundAlpha(0.5F);

        // Crear el panel
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
}
