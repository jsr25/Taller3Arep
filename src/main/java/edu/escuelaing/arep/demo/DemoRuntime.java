package edu.escuelaing.arep.demo;

import static edu.escuelaing.arep.sparkimplement.SparkImplement.*;

public class DemoRuntime {
    public static void main(String[] args) {
        // Cambiar Puerto
        port(getPort());
        //Metodo get Http
       get("/hello",(req, resp)->"hello.html");
       get("/img",(req, resp)->"Java-logo.jpg");
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
