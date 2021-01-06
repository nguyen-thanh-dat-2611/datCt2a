/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "curriculum")
public class CurriculumEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int curriculumID;
    private String corriculumName;
    private double price;
    
    @ManyToOne
    @JoinColumn(name = "courseID")
    private CourseEntity course;
    
    @ManyToOne
    @JoinColumn(name = "subjectsID")
    private SubjectsEntity subjects;

    public CurriculumEntity() {
    }

    public int getCurriculumID() {
        return curriculumID;
    }

    public void setCurriculumID(int curriculumID) {
        this.curriculumID = curriculumID;
    }

    public String getCorriculumName() {
        return corriculumName;
    }

    public void setCorriculumName(String corriculumName) {
        this.corriculumName = corriculumName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public SubjectsEntity getSubjects() {
        return subjects;
    }

    public void setSubjects(SubjectsEntity subjects) {
        this.subjects = subjects;
    }
    
    
    
}
