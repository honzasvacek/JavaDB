import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] data = {"nula", "jedna", "dva", "tri", "ctyri", "pet", "sest", "sedm", "osm", "devet", "deset",
                "jedenact", "dvanact", "trinact", "ctrnact", "patnact", "sestnact", "sedmnact", "osmnact", "devatenact", "dvacet"};

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db1006",
                "db1006",
                "Uqu0uvi3ekaa8chiexai"
        )) {
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("DROP TABLE CISLO;");
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS CISLO (n INT,nazev VARCHAR);");

                //delej();
                for (int i = 0; i < 8; i++) {
                    System.out.println("INSERT INTO CISLO VALUES (" + i + ", '" + data[i] + "')");
                    stmt.executeUpdate("INSERT INTO CISLO VALUES(" + i + ", '" + data[i] + "' );");
                }

            }

            Scanner sc = new Scanner(System.in);
            int cislo = sc.nextInt();

            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("SELECT FROM cislo;")) {
                    while (rs.next()) {
                        int n = rs.getInt(1);
                        String p = rs.getString(2);
                        if (cislo == rs.getInt(1)){
                            System.out.println("hotovo");
                        }

                    }
                }

            }


            try(Statement stmt = conn.createStatement()){
                stmt.executeUpdate("SELECT * FROM CISLO WHERE (n=" + cislo + " ;");
            }
        } catch (SQLException e) {
            System.out.println("chyba " + e);
        }
    }
}
