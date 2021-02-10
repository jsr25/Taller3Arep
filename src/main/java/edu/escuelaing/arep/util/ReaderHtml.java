package edu.escuelaing.arep.util;

import java.io.*;
import java.net.Socket;

public class ReaderHtml {

    private static String path = "src/main/resources/template";

    public static String reader(String file){
        String path = ReaderHtml.path+"/"+file;
        String temp="";
        String cadena="";
        File f = new File(path);
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            while((cadena=bf.readLine())!=null) {
                 temp= temp + cadena;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        return temp;
    }
}
