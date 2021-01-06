
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "studentsCourse")
public class StudentsCourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentsCourseID;
    private String studentsCourseName;
    
    @ManyToOne
    @JoinColumn(name = "studentId")
    private StudentEntity student;
    
    @ManyToOne
    @JoinColumn(name = "courseID")
    private CourseEntity course;

    public StudentsCourseEntity() {
    }

    public int getStudentsCourseID() {
        return studentsCourseID;
    }

    public void setStudentsCourseID(int studentsCourseID) {
        this.studentsCourseID = studentsCourseID;
    }

    public String getStudentsCourseName() {
        return studentsCourseName;
    }

    public void setStudentsCourseName(String studentsCourseName) {
        this.studentsCourseName = studentsCourseName;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }
    
    
    
}
