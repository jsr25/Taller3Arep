package edu.escuelaing.arep.datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    ConnectionDb conection;
    Connection conn;

    public Controller() {
        this.conection = new ConnectionDb();
        conn= conection.getConnect();
    }


    public void insertData(String data){
        String insert="INSERT INTO usuario (nombre) VALUES(\'"+data+"\');";
        try {
            conn.prepareStatement(insert).execute();
            conn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<String> selectData(){
        List<String> list = new ArrayList<String>();
        String select="SELECT * FROM usuario;";
        try {
            ResultSet res =conn.prepareStatement(select).executeQuery();

            while(res.next()){
                list.add(res.getString("nombre"));
            }

                    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }
}
