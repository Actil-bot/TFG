package com.company.Gráfica;

import javax.swing.*;

public abstract class GraphicG extends JFrame implements IGraph {

    protected String nombre;

    public GraphicG () {}

    public GraphicG (String nombre) {
        this.nombre = nombre;
        Setting ();
    }

    public void Setting () {
        setTitle("Gráfica");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        init();
    }
    public abstract void init ();
    public abstract JPanel getPanel();
}
