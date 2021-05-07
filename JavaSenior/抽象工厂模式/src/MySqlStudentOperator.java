import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 黎云龙
 * @class
 */
public class MySqlStudentOperator implements  StudentOperator {
    private Connection connection = null;
    static PreparedStatement preparedStatement =null;
    static ResultSet resultSet = null;

    public MySqlStudentOperator(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean addStu(Student Student) {
        return false;
    }

    @Override
    public boolean deleteStu(Integer studentId) {
        return false;
    }

    @Override
    public boolean modifyStu(Integer studentId) {
        return false;
    }

    @Override
    public Student queryStu(Integer studentId) {
        String sql = "select * from student where id = ?";

        Student student = new Student();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,studentId);//error
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setBrithday(resultSet.getDate(3));
                student.setAddress(resultSet.getString(4));
                student.setNumber(resultSet.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
}
