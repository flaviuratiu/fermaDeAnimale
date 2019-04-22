package org.fastrackit.ferma.jdbc.repository;

import org.fastrackit.ferma.domain.Animal;
import org.fastrackit.ferma.exception.ValidationException;
import org.fastrackit.ferma.jdbc.example.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ttritean
 * @since 4/22/2019
 */
public class AnimalRepository {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String USERNAME = "postgres";

    private static final String PASSWORD = "postgres";


    public static Animal getAnimalById(Long id) throws ValidationException {


        try {
            Class.forName("org.postgresql.Driver");


            Connection conn = DriverManager.getConnection(URL, USERNAME,
                    PASSWORD);
            PreparedStatement st = conn.prepareStatement("SELECT animal_type,age FROM animal where id=" +id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Animal resultat = new Animal(rs.getString(1),null);
                System.out.println(resultat);
            }

            // 7. close the objects
            rs.close();
            st.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Eroare de conexiune. "+ e);
        } catch (ClassNotFoundException e) {

            System.out.println("Eroare driver");
        }

        return null;
    }

    public static void main(String args[]) {
        try {
            getAnimalById(1L);
        }catch (ValidationException ve) {
            System.out.println("Validation exception");
        }
    }
}
