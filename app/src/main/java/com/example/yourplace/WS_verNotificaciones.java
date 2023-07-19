package com.example.yourplace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WS_verNotificaciones {
    public String buscar() {
        String aux = "";
        try {
            //Establecer URL a consultar en servidor
            URL url = new URL("http://192.168.0.14:80/usu/vercatalogo.php");
            //Establecer conexiÃ³n con el webservice
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            //Habilitar envÃ­o de datos mediante POST
            conexion.setRequestMethod("POST");
            //Habilitar salida de datos
            conexion.setDoOutput(true);
            if (conexion.getResponseCode()==HttpURLConnection.HTTP_OK){
                BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String linea = reader.readLine();
                while(linea!=null){
                    aux = aux+linea;
                    linea = reader.readLine();
                }
                if (aux.equals("2002")) {
                    aux = "ERROR DE CONEXION AL SERVIDOR DE DATOS";
                } else if (aux.equals("001")) {
                    aux = "Sin ID para validar";
                } else if (aux.equals("000")) {
                    aux = "No se pudo mostrar la ID";
                } else if (aux.equals("010")) {
                    aux = "La ID no existe en la Base de Datos";
                }
                reader.close();
            }
            else{
                aux = "ERROR al procesar servicio: " + conexion.getResponseCode();
            }

            conexion.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
            aux = "Error: " + e.getMessage();
        }
        return aux;
    }

}
