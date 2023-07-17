package com.example.yourplace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class WS_PublicarAnuncio {

    public String insertar(String id, String nombre, String dis ,String pago,String des) {
        String aux = "";
        try {
            //Establecer URL a consultar en servidor
            URL url = new URL("http://192.168.0.9:80/usu/anuncio.php");
            //Establecer conexiÃ³n con el webservice
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            //Habilitar envÃ­o de datos mediante POST
            conexion.setRequestMethod("POST");
            //Habilitar salida de datos
            conexion.setDoOutput(true);
            //Abrir Buffer de salida asociado a la conexiÃ³n
            OutputStreamWriter datSal = new OutputStreamWriter(conexion.getOutputStream());
            //Agregar valores  en formato web --> atributo = "valor";
            //Atributo
            //Verificar si el signo "?" es necesario como primer atributo
            String data ="ID_ANUNCIO="+URLEncoder.encode(id, "UTF-8")
                    +"&NOMBRE="+ URLEncoder.encode(nombre, "UTF-8")
                    +"&DIST="+URLEncoder.encode(dis, "UTF-8")
                    +"&PAGO="+URLEncoder.encode(pago, "UTF-8")
                    +"&DE="+URLEncoder.encode(des, "UTF-8");
            datSal.write(data);
            //Enviar datos al servidor
            datSal.flush();
            datSal.close();//Cerrar buffer de escritura
            //SI LA CONEXIÃ“N SE ESTABLECE CON Ã‰XITO

            //SI LA CONEXIÓN SE ESTABLECE CON EXITO
            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                //Apertura de buffer de entrada de datos desde el servidor
                BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                //Leer primer linea de la respuesta del servidor
                String linea = reader.readLine();
                //Mientras existan datos en el buffer de respuesta
                while (linea != null) {
                    aux = aux + linea;//Concatenar datos linea por linea
                    linea = reader.readLine();//leer siguiente linea
                }
                reader.close();//Cerrar buffer de lectura
                if (aux.equals("2002")) {
                    aux = "ERROR DE CONEXION AL SERVIDOR DE DATOS";
                } else if (aux.equals("001")) {
                    aux = "Datos faltantes";
                } else if (aux.equals("000")) {
                    aux = "500 ";
                }else {
                    aux = "Registro insertado con exito!";
                }
            }//SI NO HAY CONEXIÃƒâ€œN CON EL SERVIDOR...
            else {   //Se asocia el error a la salida en pantalla
                aux = "ERROR al procesar servicio: " + conexion.getResponseCode();
            }
            conexion.disconnect();//Se cierra la conexiÃƒÂ³n con el servvidor

        } catch (Exception ex) {
            aux = "ERROR de SERVIDOR: " + ex.getMessage();
        }
        return aux;
    }

    public String buscar(String id) {
        String aux = "";
        try {
            //Establecer URL a consultar en servidor
            URL url = new URL("http://192.168.0.9:80/usu/buscanuncio.php");
            //Establecer conexiÃ³n con el webservice
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            //Habilitar envÃ­o de datos mediante POST
            conexion.setRequestMethod("POST");
            //Habilitar salida de datos
            conexion.setDoOutput(true);
            //Abrir Buffer de salida asociado a la conexiÃ³n
            OutputStreamWriter datSal = new OutputStreamWriter(conexion.getOutputStream());
            //Agregar valores  en formato web --> atributo = "valor";
            //Atributo

            //Verificar si el signo "?" es necesario como primer atributo
            String data ="&ID_ANUNCIO="+ URLEncoder.encode(id, "UTF-8");


            //monitor.append("Valor en buffer: "+data+"\n");
            //salida.append("dato enviado: " + data);
            datSal.write(data);
            //Enviar datos al servidor
            datSal.flush();
            datSal.close();//Cerrar buffer de escritura
            //SI LA CONEXIÃ“N SE ESTABLECE CON Ã‰XITO
            if (conexion.getResponseCode()==HttpURLConnection.HTTP_OK){
                BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String linea = reader.readLine();
                while(linea!=null){
                    aux = aux+linea;
                    linea = reader.readLine();
                }
                reader.close();
                if (aux.equals("2002")) {
                    aux = "ERROR DE CONEXION AL SERVIDOR DE DATOS";
                } else if (aux.equals("001")) {
                    aux = "Faltan datos!";
                } else if (aux.equals("000")) {
                    aux = "No existen registros ";
                }
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
    public String actualizar(String id,String nombre, String dis ,String pago,String des){
        String aux = "";
        try {
            //Establecer URL a consultar en servidor
            URL url = new URL("http://192.168.0.9:80/usu/anunedi.php");
            //Establecer conexiÃ³n con el webservice
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            //Habilitar envÃ­o de datos mediante POST
            conexion.setRequestMethod("POST");
            //Habilitar salida de datos
            conexion.setDoOutput(true);
            //Abrir Buffer de salida asociado a la conexiÃ³n
            OutputStreamWriter datSal = new OutputStreamWriter(conexion.getOutputStream());
            //Agregar valores  en formato web --> atributo = "valor";
            //Atributo
            //Verificar si el signo "?" es necesario como primer atributo
            String data ="ID_ANUNCIO"+URLEncoder.encode(id, "UTF-8")
                    +"&NOMBRE="+URLEncoder.encode(nombre, "UTF-8")
                    +"&DIST="+URLEncoder.encode(dis, "UTF-8")
                    +"&PAGO="+URLEncoder.encode(pago, "UTF-8")
                    +"&DE="+URLEncoder.encode(des, "UTF-8");
            datSal.write(data);
            //Enviar datos al servidor
            datSal.flush();
            datSal.close();//Cerrar buffer de escritura
            //SI LA CONEXIÃ“N SE ESTABLECE CON Ã‰XITO

            //SI LA CONEXIÓN SE ESTABLECE CON EXITO
            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                //Apertura de buffer de entrada de datos desde el servidor
                BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                //Leer primer linea de la respuesta del servidor
                String linea = reader.readLine();
                //Mientras existan datos en el buffer de respuesta
                while (linea != null) {
                    aux = aux + linea;//Concatenar datos linea por linea
                    linea = reader.readLine();//leer siguiente linea
                }
                reader.close();//Cerrar buffer de lectura
                if (aux.equals("2002")) {
                    aux = "ERROR DE CONEXION AL SERVIDOR DE DATOS";
                } else if (aux.equals("001")) {
                    aux = "Datos faltantes";
                } else if (aux.equals("000")) {
                    aux = "500 ";
                }else {
                    aux = "Registro insertado con exito!";
                }
            }//SI NO HAY CONEXIÃƒâ€œN CON EL SERVIDOR...
            else {   //Se asocia el error a la salida en pantalla
                aux = "ERROR al procesar servicio: " + conexion.getResponseCode();
            }
            conexion.disconnect();//Se cierra la conexiÃƒÂ³n con el servvidor

        } catch (Exception ex) {
            aux = "ERROR de SERVIDOR: " + ex.getMessage();
        }
        return aux;
    }




}