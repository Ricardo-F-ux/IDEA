import java.sql.*;

/**
 * @author 黎云龙
 * @class
 */
public class MySqlFactory implements DataBaseFactory{
    static Connection connection = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    static String url = "jdbc:mysql://localhost:3306/mysqloperate?characterEncoding=utf-8&serverTimezone=UTC";
    static String user = "root";
    static String password = "123456";
    static String driver = "com.mysql.cj.jdbc.Driver";

    @Override
    public StudentOperator createStudentOperator() {
        connection = getConnection();
        return new MySqlStudentOperator(connection);

    }

    @Override
    public CourseOperator createCourseOperator() {
        connection = getConnection();
        return new MySqlCourseOperator(connection);
    }

    @Override
    public Connection getConnection() {
        if (connection==null)
            try {
                Class.forName(driver);
                try {
                    connection = DriverManager.getConnection(url, user, password);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        return connection;

    }
}
