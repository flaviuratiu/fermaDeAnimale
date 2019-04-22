package org.fastrackit.ferma.jdbc.repository;

import org.fastrackit.ferma.domain.Animal;

import java.sql.*;

/**
 * @author ttritean
 * @since 4/22/2019
 */
public class AnimalRepository {

    private static final String URL = "http://localhost:5432/postgres";

    private static final String USERNAME = "postgres";

    private static final String PASSWORD = "postgres";


    public static Animal getAnimalById(Long id) {


        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME,
                    PASSWORD);
            // 4. create a query statement
            PreparedStatement st = conn.prepareStatement("SELECT name,porecla FROM animal");

//            creatStatement();

            // 5. execute a query
            ResultSet rs = st.executeQuery();


            System.out.println(rs);

        } catch (SQLException e) {
            System.out.println("Eroare de conexiune. "+ e);
        }

        return null;
    }

    public static void main(String args[]) {
        getAnimalById(1L);
    }
}
