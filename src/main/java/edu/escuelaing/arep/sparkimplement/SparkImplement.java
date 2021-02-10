package edu.escuelaing.arep.sparkimplement;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.BiFunction;

public class SparkImplement {

    public static void get(String route, BiFunction<HttpRequest, HttpResponse, String> bifunc){
        SparkImplementServer server = SparkImplementServer.getIntance();
        server.get(route,bifunc);
    }

    public static void port(int port){
        SparkImplementServer server = SparkImplementServer.getIntance();
        server.port(port);
    }

    public static void startServer(){
        SparkImplementServer server = SparkImplementServer.getIntance();
        server.startServer();
    }

}
