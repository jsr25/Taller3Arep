package edu.escuelaing.arep.sparkimplement;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.BiFunction;

/**
 * Fachada para el uso del Framework
 *
 * Autor Juan Sebastian Ramos
 */
public class SparkImplement {

    /**
     * creacion de metodo get http
     * @param route path que se quiere tener en el navegador
     * @param bifunc funcion anonima con req res y un String con el archivo que se queire leer
     */
    public static void get(String route, BiFunction<HttpRequest, HttpResponse, String> bifunc){
        SparkImplementServer server = SparkImplementServer.getIntance();
        server.get(route,bifunc);
    }

    /**
     * Metodo para cambiar el puerto que se tiene por defecto
     * @param port entero que indica el puerto que se desea
     */
    public static void port(int port){
        SparkImplementServer server = SparkImplementServer.getIntance();
        server.port(port);
    }

    /**
     * Metodo que Inicia el servidor para poder visualizar las vistas
     */
    public static void startServer(){
        SparkImplementServer server = SparkImplementServer.getIntance();
        server.startServer();
    }

}
