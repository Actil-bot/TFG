package com.company.Gráfica;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class BarrasSegundos extends GraphicG {

    String contenido;
    JPanel panel;
    String data;
    int [] valores = new int[4];

    public BarrasSegundos(String contenido) {

        super();
        this.contenido = contenido;
        this.data = contenido.split("\"id\": \"metrics\",\n" + "        \"title\": \"Metrics\",")[1].split("},")[0];
        FVC();
        LVC();
        Ol();
        ODC();
        Setting();
    }

    public void FVC() {
        // Observed First Visual Change
        String fvc = data.split("\"observedFirstVisualChange\": ")[1].split(",")[0];
        valores[0] = StringToInt(fvc);
    }

    public void LVC() {
        // Observed Last Visual Change
        String lvc = data.split("\"observedLastVisualChange\": ")[1].split(",")[0];
        valores[1] = StringToInt(lvc);
    }

    public void Ol() {
        // Observed Load
        String ol = data.split("\"observedLoad\": ")[1].split(",")[0];
        valores[2] = StringToInt(ol);
    }

    public void ODC() {
        // Observed DOM Contact Loaded
        String odc = data.split("\"observedDomContentLoaded\": ")[1].split(",")[0];
        valores[3] =  StringToInt(odc);
    }
    public int StringToInt (String dato) {

        return Integer.parseInt(dato);
    }

    @Override
    public void init() {

        panel = new JPanel();
        getContentPane().add(panel);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(valores[0], "Milisegundos", "Observed First Visual Change");
        dataset.setValue(valores[1], "Milisegundos", "Observed Last Visual Change");
        dataset.setValue(valores[2], "Milisegundos", "Observed Load");
        dataset.setValue(valores[3], "Milisegundos", "Observed DOM Contact Loaded");

        JFreeChart chart = ChartFactory.createBarChart("Tiempos de métricas no esenciales", "Nombre métricas", "Tiempo", dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);

    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
}
