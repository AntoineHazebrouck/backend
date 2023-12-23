package fr.but3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App
{

    private static final String database = "spring";
    private static final String url = "jdbc:postgresql://90.110.246.238/" + database;
    private static final String user = "postgres";
    private static final String password = "12345678aAbB!";


    public static void main(String[] args)
            throws SQLException, URISyntaxException, FileNotFoundException, IOException
    {
        Connection connection = connect();

        connection.close();


        File f = new File(App.class.getClassLoader().getResource("data.txt").toURI());
        System.out.println(new FileReader(f));
        System.out.println("TOTO!");
    }

    public static Connection connect()
    {
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
