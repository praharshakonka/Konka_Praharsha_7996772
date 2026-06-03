package JDBCProject;

import java.sql.*;

public class TransactionDemo {

    public static void main(String[] args) {

        String url = "jdbc:sqlite:students.db";

        try {
            Class.forName("org.sqlite.JDBC");

            Connection con = DriverManager.getConnection(url);

            Statement stmt = con.createStatement();

            // CREATE TABLE
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS accounts (" +
                "id INTEGER PRIMARY KEY, " +
                "name TEXT, " +
                "balance INTEGER)"
            );

            // SAMPLE DATA
            stmt.executeUpdate("INSERT OR IGNORE INTO accounts VALUES (1,'Praha',5000)");
            stmt.executeUpdate("INSERT OR IGNORE INTO accounts VALUES (2,'Saha',3000)");

            // START TRANSACTION
            con.setAutoCommit(false);

            int fromId = 1;
            int toId = 2;
            int amount = 1000;

            System.out.println("Debiting " + amount + " from Alice");
            PreparedStatement debit = con.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE id = ?"
            );
            debit.setInt(1, amount);
            debit.setInt(2, fromId);
            debit.executeUpdate();

            System.out.println("Crediting " + amount + " to Bob");
            PreparedStatement credit = con.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE id = ?"
            );
            credit.setInt(1, amount);
            credit.setInt(2, toId);
            credit.executeUpdate();

            con.commit();
            System.out.println("\nTransaction Successful!");

            // SHOW RESULT
            ResultSet rs = stmt.executeQuery("SELECT * FROM accounts");

            System.out.println("\nID\tName\tBalance");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getInt("balance")
                );
            }

            rs.close();
            debit.close();
            credit.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}