package com.company.Rendimiento;

public class Rendimiento {

    private int[] aux;
    String data;

    // Obtención del rendimiento de la página web
    public Rendimiento (String datos) {
        this.data = datos;
        aux = new int[6];
    }

    // Cálculo de los datos de rendimiento con sus ponderaciones
    public int[] ponderacion(int lcp, int fcp, int si, int ti, int tbt, int cls) {

        aux[0] = (int) (lcp * 0.25);
        aux[1] = (int) (fcp * 0.1);
        aux[2] = (int) (si * 0.1);
        aux[3] = (int) (ti * 0.1);
        aux[4] = (int) (tbt * 0.3);
        aux[5] = (int) (cls * 0.15);

        return aux;
    }

    // Búsqueda de los datos del rendimiento
    public double calculoRendimiento() {

        String performance = data.split("\"title\": \"Performance\",\n" + "        \"score\": ")[1].split(",")[0];
        double rendimiento = Double.parseDouble(performance);
        return rendimiento;
    }

    public double Lcp () {

        // Obtención del score de "largest-contentful-paint"
        String Lcp = data.split("\"largest-contentful-paint\": *")[1].split("\"score\": ")[1].split(",")[0];
        double Dlcp = Double.parseDouble(Lcp);
        return Dlcp;
    }

    public double Fcp () {

        // Obtención del score de  First Contentful Paint
        String FCP = data.split("\"first-contentful-paint\": *")[1].split("\"score\": ")[1].split(",")[0];
        double Dfcp = Double.parseDouble(FCP);
        return Dfcp;
    }

    public double SI () {

        // Obtención del score de  Speed Index
        String SI = data.split("\"speed-index\": *")[1].split("\"score\": ")[1].split(",")[0];
        double Dsi = Double.parseDouble(SI);
        return Dsi;
    }

    public double TI () {

        // Obtención del score de  Time to Interactive
        String TI = data.split("\"title\": \"Time to Interactive\",")[1].split("\"score\": ")[1].split(",")[0];
        double Dti = Double.parseDouble(TI);
        return Dti;
    }

    public double TBT () {
        // Obtención del score de  Total Blocking Time
        String Tbt = data.split("\"total-blocking-time\": *")[1].split("\"score\": ")[1].split(",")[0];
        double Dtbt = Double.parseDouble(Tbt);
        return Dtbt;
    }

    public double CLS () {
        // Obtención del score de  Cumulative Layout Shift
        String Cls = data.split("\"cumulative-layout-shift\": *")[1].split("\"score\": ")[1].split(",")[0];
        double Dcls = Double.parseDouble(Cls);
        return Dcls;
    }

    // Transformación de los números en porcentajes
    public int porcentaje(double rendimiento) {
        int resultado = (int) (rendimiento * 100);
        return resultado;
    }
}
