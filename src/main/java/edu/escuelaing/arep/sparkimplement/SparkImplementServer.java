package edu.escuelaing.arep.sparkimplement;

import edu.escuelaing.arep.datos.Controller;
import edu.escuelaing.arep.httpserver.HttpServer;
import edu.escuelaing.arep.util.ReaderHtml;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Servidor que proporciona las funcionalidades
 * principales del Framework
 *
 * Autor Juan Sebastian Ramos
 */
public class SparkImplementServer implements Process {

    private static SparkImplementServer _intance = new SparkImplementServer();
    private int httpPort=36000;
    Map<String,BiFunction<HttpRequest, HttpResponse, String>> functions = new HashMap();
    HttpServer httpServer= new HttpServer();

    public static SparkImplementServer getIntance() {
        return _intance;
    }

    private SparkImplementServer(){
        httpServer.regiserProcess("/Apps",this);
    }


    /**
     * Metodo Get Http
     * @param route path que se desea ver en el navegador
     * @param bifunc funcion anonima con los datos necesarios
     */
    public void get(String route, BiFunction<HttpRequest, HttpResponse, String> bifunc) {
        functions.put(route, bifunc);
    }

    /**
     * Metodo para iniciar el servidor y poder
     * visualizar las vistas creadas
     */
    public void startServer(){
        try {
            httpServer.startServer(httpPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para cambiar el puerto
     * @param serverport entero que indica el puerto
     */
    public void port(int serverport) {
        this.httpPort=serverport;
    }

    @Override
    public String handle(String path, HttpRequest req, HttpResponse res) {
        if(functions.containsKey(path)){
            return functions.get(path).apply(req , res);
        }
        else if(path.contains("get")){
            Controller conn=new Controller();
            System.out.println(path);
//            conn.insertData();
        }
        return validErrorHttpHeader()+"Error";
    }

    private String validErrorHttpHeader() {
        return "HTTP/1.1 404 Not Found\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Error 404</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Error 404</h1>\n"
                + "</body>\n"
                + "</html>\n";
    }

    private String validOkHttpHeader() {
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n";
    }
}
