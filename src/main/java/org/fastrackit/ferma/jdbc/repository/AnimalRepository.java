package org.fastrackit.ferma.jdbc.repository;

import org.fastrackit.ferma.domain.Animal;

import java.sql.*;

/**
 * @author ttritean
 * @since 4/22/2019
 */
public class AnimalRepository {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String USERNAME = "postgres";

    private static final String PASSWORD = "postgres";


    public static Animal getAnimalById(Long id) {


        try {
            Class.forName("org.postgresql.Driver");


            Connection conn = DriverManager.getConnection(URL, USERNAME,
                    PASSWORD);
            PreparedStatement st = conn.prepareStatement("SELECT name,porecla FROM animal");
            ResultSet rs = st.executeQuery();

            System.out.println(rs);

        } catch (SQLException e) {
            System.out.println("Eroare de conexiune. "+ e);
        } catch (ClassNotFoundException e) {

            System.out.println("Eroare driver");
        }

        return null;
    }

    public static void main(String args[]) {
        getAnimalById(1L);
    }
}
