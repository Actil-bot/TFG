package com.company.Wave;

public class DatosWave {

    String data;
    public DatosWave(String contenido2) {

        this.data = contenido2;
    }

    public int StringToInt (String dato) {

        return Integer.parseInt(dato);
    }

    public int numErrors () {

        String aux = data.split("description\":\"Errors\",\"count\":")[1].split(",")[0];
        return StringToInt(aux);
    }

    public int contrastErrors () {

        String aux = data.split("\"Contrast Errors\",\"count\":")[1].split(",")[0];
        return StringToInt(aux);
    }

    public int numAlerts () {

        String aux = data.split("\"Alerts\",\"count\":")[1].split(",")[0];
        return StringToInt(aux);
    }

    public int numFeatures () {

        String aux = data.split("\"Features\",\"count\":")[1].split(",")[0];
        return StringToInt(aux);
    }

    public int numStructural () {

        String aux = data.split("\"Structural Elements\",\"count\":")[1].split(",")[0];
        return StringToInt(aux);
    }

    public int numAria () {

        String aux = data.split("\"ARIA\",\"count\":")[1].split(",")[0];
        return StringToInt(aux);
    }

    public String [] getAlerts () {

        String [] alert = data.split("\"description\":\"Alerts\"")[1].split("\"items\":*")[1]. split("\"feature\":")[0].split("\"description\":\"");
        int numAlerts = alert.length-1;

        String [] alertas = new String[numAlerts];

        for (int i = 0; i < numAlerts; i++) {

            alertas[i] = alert[i+1].split("\",")[0];
        }
        return alertas;
    }

    public String arrayStringToString (String [] param) {

        String result = "";
        for (int i = 0; i < param.length; i++) {
            result += param[i] + "\n";
        }
        return result;

    }

    public String[] getErrors() {

        String [] errors = data.split("\"description\":\"Errors\"")[1].split("\"items\":*")[1]. split("\"contrast\":")[0].split("\"description\":\"");
        int numErrors = errors.length-1;

        String [] errores = new String[numErrors];

        for (int i = 0; i < numErrors; i++) {

            errores[i] = errors[i+1].split("\",")[0];
        }
        return errores;
    }

    public String[] getEstructural() {

        String [] struct = data.split("\"description\":\"Structural Elements\"")[1].split("\"items\":*")[1]. split("\"aria\":")[0].split("\"description\":\"");
        int numStruct = struct.length-1;

        String [] estructura = new String[numStruct];

        for (int i = 0; i < numStruct; i++) {

            estructura[i] = struct[i+1].split("\",")[0];
        }
        return estructura;
    }
}
