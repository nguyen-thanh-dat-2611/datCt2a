
package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseID;
    private String courseName;
    
    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
    List<CurriculumEntity> curriculumList;
    
    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
    List<StudentsCourseEntity> studentsCourseList;

    public CourseEntity() {
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<CurriculumEntity> getCurriculumList() {
        return curriculumList;
    }

    public void setCurriculumList(List<CurriculumEntity> curriculumList) {
        this.curriculumList = curriculumList;
    }

    public List<StudentsCourseEntity> getStudentsCourseList() {
        return studentsCourseList;
    }

    public void setStudentsCourseList(List<StudentsCourseEntity> studentsCourseList) {
        this.studentsCourseList = studentsCourseList;
    }

    
    
}
