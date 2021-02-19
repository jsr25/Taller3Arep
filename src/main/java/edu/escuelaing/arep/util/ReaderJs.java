package edu.escuelaing.arep.util;

import java.io.*;
import java.net.Socket;

public class ReaderJs implements Reader{

    @Override
    public void reader(String path, Socket clientSocket) {
        String fpath = pathA + "/" + path;
        String temp = "";
        String cadena = "";
        try {
            File f = new File(fpath);
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            while ((cadena = bf.readLine()) != null) {
                temp = temp + cadena+"\r\n";
            }
            clientSocket.getOutputStream().write((validOkHttpHeader()+temp).getBytes());
        } catch (FileNotFoundException e) {
            error(clientSocket);
        } catch (IOException e) {
            error(clientSocket);
        }
    }

    private String validOkHttpHeader() {
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/javascript\r\n"
                + "\r\n";
    }
    }
