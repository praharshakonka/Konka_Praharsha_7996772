package JDBCProject;

import java.sql.*;
public class JDBCDemo {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:students.db";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection(url);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS students (" +
                "id INTEGER PRIMARY KEY, " +
                "name TEXT, " +
                "age INTEGER)"
            );
            System.out.println("Running updated code...");
            stmt.executeUpdate(
            "UPDATE students SET name='Praha' WHERE id=1"
            );
             stmt.executeUpdate(
             "UPDATE students SET name='Saha' WHERE id=2"
             );
             stmt.executeUpdate(
             "UPDATE students SET name='Raina' WHERE id=3"
            );
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            System.out.println("ID\tName\tAge");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getInt("age")
                );
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}