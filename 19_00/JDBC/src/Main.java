import java.sql.*;

public class Main {

    static Connection conn;

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/university?useSSL=false&serverTimezone=UTC";
        String username = "zavada"; // root
        String password = "zavada"; // root, 1-8

        conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connected? " + !conn.isClosed());

        createTable();
        insertData();

        for (int i = 1; i <= 10; i++) {
            insertData(i);
        }

        selectData();

        conn.close();
    }

    private static void createTable() throws SQLException {

        String query = "CREATE TABLE student(" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "full_name VARCHAR(80) NOT NULL," +
                "age INT NOT NULL," +
                "univer_id INT" +
                ");";

        String table2Query = "CREATE TABLE univer(" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(80) NOT NULL" +
                ");";

        String dropQueryUniver = "DROP TABLE IF EXISTS univer;";
        String dropQuery = "DROP TABLE IF EXISTS student;";

        Statement stmt = conn.createStatement();
        stmt.execute(dropQuery);
        stmt.execute(query);

        stmt.execute(dropQueryUniver);
        stmt.execute(table2Query);

        String fkQuery = "ALTER TABLE student " +
                "ADD FOREIGN KEY (univer_id) " +
                "REFERENCES univer(id);";
        stmt.execute(fkQuery);

        System.out.println("Table 'student' created");
        stmt.close();
    }

    private static void insertData() throws SQLException {
        String query = "INSERT INTO student(full_name, age) VALUES(?,?);";

        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, "John Doe");
        // INSERT INTO student(full_name, age) VALUES('John Doe',?)

        pstmt.setInt(2, 19);
        // INSERT INTO student(full_name, age) VALUES('John Doe', 19)
        pstmt.executeUpdate();

        pstmt.close();
    }

    private static void insertData(int i) throws SQLException {
        String query = "INSERT INTO student(full_name, age) VALUES(?,?);";

        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, "John Doe" + i);
        pstmt.setInt(2, 19 + i);
        pstmt.executeUpdate();

        pstmt.close();
    }

    private static void selectData() throws SQLException {
        String query = "SELECT * FROM student";

        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println(
                    "ID: " + rs.getInt("id") + "\t" +
                    "FULL NAME: " + rs.getString("full_name") + "\t" +
                    "AGE: " + rs.getInt("age")
            );
        }
    }

}
