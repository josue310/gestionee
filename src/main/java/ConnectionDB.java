import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gestion_admin_etud";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "josue2005";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver JDBC chargé avec succès.");

            // Établir la connexion
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            System.out.println("Connexion établie avec succès.");

        } catch (ClassNotFoundException e) {
            System.err.println("Erreur: le driver JDBC n'a pas été trouvé.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erreur: échec de la connexion.");
            e.printStackTrace();
        } finally {
            // Fermer la connexion
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connexion fermée avec succès.");
                } catch (SQLException e) {
                    System.err.println("Erreur lors de la fermeture de la connexion.");
                    e.printStackTrace();
                }
            }
        }
    }
}
