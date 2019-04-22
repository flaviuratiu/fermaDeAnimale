package org.fastrackit.ferma.jdbc.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by condor on 26/02/15.
 * FastTrackIT, 2015
 * <p/>
 * DEMO ONLY PURPOSES, IT MIGHT CONTAINS INTENTIONALLY ERRORS OR ESPECIALLY BAD PRACTICES
 *
 * make sure you refactor it and remove lots of bad practices like loading the driver multiple times or
 * repeating the same common code multiple times
 *
 * BTW, exercise 1: how we reorg this/refactor in small pieces
 */
public class DemoCRUDOperations {


    public static void main(String[] args) {
        System.out.println("Hello database users! We are going to call DB from Java");
        try {
            //demo CRUD operations
            demoCreate();


            List l = demoRead();

            for (int i = 0; i < l.size(); i++) {

                Users u = (Users)l.get(i);

                System.out.println(u.getUsername());
                System.out.println(u.getPassword());
                System.out.println("--------------");

            }



      // demoUpdate();
//      demoDelete();

           // demoBlobInsert();
           // demoBlobRead();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * aceasta metoda e varza, nu o folositi va rog ca va faceti rau nu binr sdgdfhgs
     * sdhfdfghdgh
     * dsfhdfsgfgmnbgdx
     * dfjdfsgfdfgjnhsd
     *  dfjzd
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void demoCreate() throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://localhost:5432/postgres";
        final String USERNAME = "postgres";
        final String PASSWORD = "postgres";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?,?)");
        pSt.setString(1, "ioniliescu");
        pSt.setString(2, "maianimalule");

        // 5. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    private static List demoRead() throws ClassNotFoundException, SQLException {
               // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/ionel7";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        // 5. execute a query
        ResultSet rs = st.executeQuery("SELECT username,password FROM users");

        // 6. iterate the result set and print the values
        List<Users> listaDeUser = new ArrayList();
        while (rs.next()) {
            Users u = new Users();
            u.setUsername(rs.getString("username").trim());
            u.setPassword(rs.getString("password").trim());

            listaDeUser.add(u);
        }

        // 7. close the objects
        rs.close();
        st.close();
        conn.close();

        return listaDeUser;

    }

    private static void demoUpdate() throws ClassNotFoundException, SQLException {

                // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/ionel7";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("UPDATE USERS SET PASSWORD=? WHERE USERNAME=?"); //so we have 3 params
        pSt.setString(1, "incatraieste");
        pSt.setString(2, "ioniliescu");



        // 5. execute a prepared statement
        int rowsUpdated = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }


    private static void demoDelete() throws ClassNotFoundException, SQLException {

               // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/ionel7";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("DELETE FROM USERS WHERE id=?");
        pSt.setLong(1, 3);

        // 5. execute a prepared statement
        int rowsDeleted = pSt.executeUpdate();
        System.out.println(rowsDeleted + " rows were deleted.");
        // 6. close the objects
        pSt.close();
        conn.close();
    }
}

