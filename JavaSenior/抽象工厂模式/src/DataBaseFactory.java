import java.sql.Connection;

/**
 * @author 黎云龙
 * @class
 */
public interface DataBaseFactory {
    public StudentOperator createStudentOperator();
    public CourseOperator createCourseOperator();
    public Connection getConnection();

}
