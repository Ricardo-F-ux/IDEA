/**
 * @author 黎云龙
 * @class
 */
public class Course {
    private Integer cId;
    private String cName;
    private String cType;
    private Integer cScore;

    public Course() {
    }

    public Course(Integer cId, String cName, String cType, Integer cScore) {
        this.cId = cId;
        this.cName = cName;
        this.cType = cType;
        this.cScore = cScore;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public Integer getcScore() {
        return cScore;
    }

    public void setcScore(Integer cScore) {
        this.cScore = cScore;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cType='" + cType + '\'' +
                ", cScore=" + cScore +
                '}';
    }
}
