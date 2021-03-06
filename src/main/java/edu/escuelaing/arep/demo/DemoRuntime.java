package edu.escuelaing.arep.demo;

import edu.escuelaing.arep.datos.Controller;

import static edu.escuelaing.arep.sparkimplement.SparkImplement.*;

public class DemoRuntime {
    public static void main(String[] args) {

        // Cambiar Puerto
        port(getPort());
        //Metodo get Http
       get("/hello",(req, resp)->"hello2.html");
       get("/img",(req, resp)->"Java-logo.jpg");
       get("/info",(req, resp)->"info.c");
       get("/index",(req, resp)->"index.html");
        get("/App.js",(req, resp)->"App.js");
        get("/valores", (req,resp)->"valores");
       //Iniciar servidor
       startServer();

    }

    private static int getPort() {
        if(System.getenv("PORT")!= null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 3478;
    }
}
