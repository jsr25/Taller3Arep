package edu.escuelaing.arep.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
    private String url = "jdbc:postgresql://ec2-54-198-73-79.compute-1.amazonaws.com:5432/d26bqfsllrt7l0?sslmode=require";
    //private String driver="org.postgresql.Driver";
    private String usuario = "hnkjetvnwtrnil";
    private String contraseña = "69c5371fb42c6036ca4761c18369e7582d3af4343a41a44cb4d06eef747717cc";

    private Connection connect;

    public ConnectionDb() {
        try {
            //Class.forName(driver);
            org.postgresql.Driver val = new org.postgresql.Driver();
            DriverManager.registerDriver(val);
            while (connect == null) {
                connect = DriverManager.getConnection(url, usuario, contraseña);
            }
            connect.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnect() {
        return connect;
    }
}
