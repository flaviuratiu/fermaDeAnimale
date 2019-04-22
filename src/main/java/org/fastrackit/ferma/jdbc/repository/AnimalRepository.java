package org.fastrackit.ferma.jdbc.repository;

import org.fastrackit.ferma.domain.Animal;
import org.fastrackit.ferma.exception.ValidationException;

import java.sql.*;

/**
 * @author ttritean
 * @since 4/22/2019
 */
public class AnimalRepository {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String USERNAME = "postgres";

    private static final String PASSWORD = "postgres";


    public static void deleteAnimalById(Long id) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USERNAME,
                    PASSWORD);
            PreparedStatement st = conn.prepareStatement(
                    "delete from animal where id=?");
            st.setLong(1, id);
            st.execute();

            st.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

    public static void createAnimal(Animal toSaveAnimal) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USERNAME,
                    PASSWORD);
            PreparedStatement st = conn.prepareStatement(
                    "insert into animal values(10, ?,?,2)");
            st.setString(1, toSaveAnimal.getName());
            st.setInt(2, toSaveAnimal.getAge());

            st.execute();

            st.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static Animal getAnimalById(Long id) throws ValidationException {
        try {
            Animal resultat = null;
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USERNAME,
                    PASSWORD);
            PreparedStatement st = conn.prepareStatement("SELECT animal_type,age FROM animal where id=" + id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                resultat = new Animal(rs.getString(1), null);
                System.out.println(resultat);

            }
            rs.close();
            st.close();
            conn.close();
            return resultat;

        } catch (SQLException e) {
            System.out.println("Eroare de conexiune. " + e);
            return null;

        } catch (ClassNotFoundException e) {
            System.out.println("Eroare driver");
            return null;

        }

    }

    public static void main(String args[]) {
        try {
            getAnimalById(10L);

            Animal animal = new Animal("vipera", "porecla");
            animal.setAge(4);
//            createAnimal(animal);

            deleteAnimalById(10L);

            getAnimalById(10L);

        } catch (ValidationException ve) {
            System.out.println("Validation exception");
        }
    }
}
