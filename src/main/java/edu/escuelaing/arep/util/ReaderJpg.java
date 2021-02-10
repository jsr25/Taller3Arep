package edu.escuelaing.arep.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;



public class ReaderJpg {
    private static String pathA = "src/main/resources/template";
    public static void reader(String path, Socket clientSocket) {

        try {

            BufferedImage in = ImageIO.read(new File(pathA+"/"+path));
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
            ImageIO.write(in, "PNG", buffer);
            dataOutputStream.writeBytes( "HTTP/1.1 200 \r\n");
            dataOutputStream.writeBytes("Content-Type: image/jpeg \r\n");
            dataOutputStream.writeBytes("\r\n");
            dataOutputStream.write(buffer.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
