/**
 * @author 黎云龙
 * @class
 */
public interface CourseOperator {

    public boolean addCourse(Course course);
    public boolean deleteCourse(Integer courseId);
    public boolean modifyCourse(Integer courseId);
    public Course queryCourse(Integer courseId);

}
