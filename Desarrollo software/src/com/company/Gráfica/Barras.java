package com.company.Gráfica;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class Barras extends GraphicG {

    JPanel panel;
    int[] ponderaciones;

    public Barras(int[] ponderaciones) {

        super();
        this.ponderaciones = ponderaciones;
        Setting();
    }

    @Override
    public void init() {

        panel = new JPanel();
        getContentPane().add(panel);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        //Ponderaciones resultadas
        dataset.addValue(ponderaciones[0], "Ponderación", "LCP");
        dataset.addValue(ponderaciones[1], "Ponderación", "FCP");
        dataset.addValue(ponderaciones[2], "Ponderación", "SI");
        dataset.addValue(ponderaciones[3], "Ponderación", "TI");
        dataset.addValue(ponderaciones[4], "Ponderación", "TBT");
        dataset.addValue(ponderaciones[5], "Ponderación", "CLS");

        //Pesos finales
        dataset.addValue(25, "Peso", "LCP");
        dataset.addValue(10, "Peso", "FCP");
        dataset.addValue(10, "Peso", "SI");
        dataset.addValue(10, "Peso", "TI");
        dataset.addValue(30, "Peso", "TBT");
        dataset.addValue(15, "Peso", "CLS");

        // Creando gráfico
        JFreeChart chart = ChartFactory.createBarChart("Métricas esenciales", "Nombre de Métricas", "Peso", dataset, PlotOrientation.VERTICAL, true, true,false);

        // Crear el panel
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);

    }

    @Override
    public JPanel getPanel() {

        return panel;
    }

}
