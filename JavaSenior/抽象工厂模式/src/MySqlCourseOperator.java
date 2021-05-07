import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 黎云龙
 * @class
 */
public class MySqlCourseOperator implements CourseOperator {
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;

    public MySqlCourseOperator(Connection coonection) {
        super();
        this.connection = coonection;
    }

    @Override
    public boolean addCourse(Course course) {
        return false;
    }

    @Override
    public boolean deleteCourse(Integer courseId) {
        return false;
    }

    @Override
    public boolean modifyCourse(Integer courseId) {
        return false;
    }

    @Override
    public Course queryCourse(Integer courseId) {
        String sql = "select * from course where cId = ?";
        Course course = new Course();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,courseId);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                course.setcId(resultSet.getInt(1));
                course.setcName(resultSet.getString(2));
                course.setcScore(resultSet.getInt(3));
                course.setcType(resultSet.getString(4));
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return course;
    }

}
