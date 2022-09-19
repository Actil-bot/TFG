package com.company.API;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Api {

    static private int BufferSize = 1024;

    private Api () {}

    public static String downloadFromURL (String link, int opcion) {

        String enlace;

        if (opcion == 1) {
            //enlace = "https://www.googleapis.com/pagespeedonline/v5/runPagespeed?url=";
            enlace = "https://www.googleapis.com/pagespeedonline/v5/runPagespeed?key=AIzaSyB47zNuSEr9c1mH1fpVtO5PkuyqM6JPRNg&url=";

        }
        else {
            //enlace = "https://wave.webaim.org/api/request?key=Xhmu3cYw2923&url=";
            enlace = "https://wave.webaim.org/api/request?key=3NT3H5fx2925&reporttype=2&url=";
        }

        String aux = enlace+link;
        String Url = "";

        try {

            BufferedInputStream input = new BufferedInputStream(new URL(aux).openStream());
            int bytes_leidos = 0;
            byte[] byteContenido = new byte[BufferSize];

            while ((bytes_leidos = input.read(byteContenido)) != -1) {
                Url += new String(byteContenido, 0, bytes_leidos);
            }
            return Url;

        } catch (MalformedURLException exp) {
            exp.printStackTrace();
            System.err.println("Mal formación de la URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Salida";
    }

}


