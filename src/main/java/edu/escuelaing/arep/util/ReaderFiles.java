package edu.escuelaing.arep.util;

import java.io.*;

public class ReaderFiles {

    private static String path = "src/main/resources/template";

    public static String reader(String file){
        String path = ReaderFiles.path+"/"+file;
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
