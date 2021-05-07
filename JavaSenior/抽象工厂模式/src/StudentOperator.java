/**
 * @author 黎云龙
 * @class
 */
public interface StudentOperator {
    public boolean addStu(Student Student);
    public boolean deleteStu(Integer studentId);
    public boolean modifyStu(Integer studentId);
    public Student queryStu(Integer studentId);

}
