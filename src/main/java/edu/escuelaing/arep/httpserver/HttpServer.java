package edu.escuelaing.arep.httpserver;

import edu.escuelaing.arep.sparkimplement.Process;
import edu.escuelaing.arep.sparkimplement.SparkImplementServer;
import edu.escuelaing.arep.util.ReaderFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpServer {
    private int port;

    Map<String,Process> routes = new HashMap();

    public void startServer(int httpPort) throws IOException {
        port=httpPort;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: "+ getPort());
            System.exit(1);
        }
        boolean running = true;
        while (running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir en el puerto: "+ getPort() + "...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(
                    clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;
            boolean isfirstLine= true;
            String path = "";

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Recibí: " + inputLine);
                if(isfirstLine){
                    path=inputLine.split(" ")[1];
                    isfirstLine=false;
                }
                if (!in.ready()) {
                    break;
                }
            }
            String res= null;
            for(String key: routes.keySet()){
                System.out.println(key);

                if(path.startsWith(key)){
                    String newPath = path.substring(key.length());
                    System.out.println(newPath);
                    res = routes.get(key).handle(newPath,null,null);
                }

            }

            if(res==null) {
                outputLine = validOkResponse();
            }
            else{
                outputLine = res;
            }
            out.println(outputLine);
            out.close();
            in.close();
            clientSocket.close();

        }
        serverSocket.close();
    }

    public void setPort(int Port) {
        this.port=port;
    }

    public int getPort() {
        return this.port=port;
    }


    public void regiserProcess(String path, Process proc) {
        routes.put(path,proc);
    }

    public String validOkResponse(){
        return"HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Title of the document</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Mi propio mensaje</h1>\n"
                + "</body>\n"
                + "</html>\n";
    }
}
