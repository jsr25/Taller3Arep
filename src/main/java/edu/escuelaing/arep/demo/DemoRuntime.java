package edu.escuelaing.arep.demo;

import static edu.escuelaing.arep.sparkimplement.SparkImplement.*;

public class DemoRuntime {
    public static void main(String[] args) {
        port(getPort());
       get("/hello",(req, resp)->"Hello world!");
       startServer();

    }

    private static int getPort() {
        if(System.getenv("PORT")!= null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 3478;
    }
}