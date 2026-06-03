package JDBCProject;
import java.sql.*;
class StudentDAO {
    private Connection con;
    public StudentDAO(Connection con) {
        this.con = con;
    }
    public void insertStudent(int id, String name, int age) throws SQLException {
        String query = "INSERT INTO students(id, name, age) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, age);
        int rows = ps.executeUpdate();
        System.out.println(rows + " record inserted.");
        ps.close();
    }
    public void updateStudent(int id, String name, int age) throws SQLException {
        String query = "UPDATE students SET name=?, age=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setInt(3, id);
        int rows = ps.executeUpdate();
        System.out.println(rows + " record updated.");
        ps.close();
    }
}
public class JDBCInsertUpdateDemo {
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
            StudentDAO dao = new StudentDAO(con);
            dao.insertStudent(4, "Praha", 20);
            dao.updateStudent(4, "Praha R", 21);
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            System.out.println("\nID\tName\tAge");
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