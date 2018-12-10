import java.sql.*;

public class Main {

    static Connection conn;

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/university?useSSL=false";
        String username = "zavada"; // root
        String password = "zavada";

        conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connected? " + !conn.isClosed());

        createTable();
        insertData();

//        for (int i = 0; i < 20; i++) {
//            insertData(i);
//        }

        selectData();
//        deleteData(34);
//        deleteData(43);
//        deleteData(2);
//        deleteData(11);
        updateData("Petro", 20);
        updateData("Ivan", 21);
        updateData("Vasyl", 22);
        selectData();

        conn.close();
    }

    private static void createTable() throws SQLException {
        String dropQuery = "DROP TABLE IF EXISTS student;";
        String query = "CREATE TABLE IF NOT EXISTS student(" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "first_name VARCHAR(45) NOT NULL," +
                "last_name VARCHAR(45) NOT NULL," +
                "age INT NOT NULL" +
                ");";

        Statement stmt = conn.createStatement();
        stmt.execute(dropQuery);
        stmt.execute(query);
        System.out.println("Created table 'student'");
        stmt.close();
    }

    private static void insertData() throws SQLException {
        String query = "INSERT INTO student (first_name, last_name, age) " +
                "VALUES (?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, "John");
        pstmt.setString(2, "Doe");
        pstmt.setInt(3, 28);
        // INSERT INTO student (first_name, last_name, age) " +
        //                "VALUES (John, Doe, 28)
        pstmt.executeUpdate();
        pstmt.close();
    }

    private static void selectData() throws SQLException {
        String query = "SELECT * FROM student;";

        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println(
                    "ID: " + rs.getInt("id") + "\t" +
                    "FIRST NAME: " + rs.getString("first_name") + "\t" +
                    "LAST NAME: " + rs.getString("last_name") + "\t" +
                    "AGE: " + rs.getInt("age")
            );
        }
    }

    private static void insertData(int i) throws SQLException {
        String query = "INSERT INTO student (first_name, last_name, age) " +
                "VALUES (?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, "John-" + i);
        pstmt.setString(2, "Doe-" + i);
        pstmt.setInt(3, 28 + i);

        pstmt.executeUpdate();
        pstmt.close();
    }

    private static void deleteData(int id) throws SQLException {
        String query = "DELETE FROM student WHERE id = ?";

        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        pstmt.close();
    }

    private static void updateData(String firstName, int id) throws SQLException {
        String query = "UPDATE student SET first_name = ? WHERE id = ?;";

        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, firstName);
        pstmt.setInt(2, id);

        pstmt.executeUpdate();
        pstmt.close();
    }

}
