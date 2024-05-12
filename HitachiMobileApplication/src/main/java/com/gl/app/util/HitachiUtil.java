package com.gl.app.util;

import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HitachiUtil {


	private static final String URL ="jdbc:postgresql://localhost:5432/capstone_Hitachi?currentSchema=hitachimobileapplication ";
    private static final String USER = "postgres";
    private static final String PASSWORD = "@17253Ec003";

    static AtomicInteger counter = new AtomicInteger();

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
        return conn;

    }
    public int generateUniqueId(String columnName, String tableName, int initialValue) {
       
        return 0;
    }

}
