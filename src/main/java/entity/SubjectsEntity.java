
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
@Table(name="subjects")
public class SubjectsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectsID;
    private String subjectsName;
    
    @OneToMany(mappedBy = "subjects",fetch = FetchType.LAZY)
    List<CurriculumEntity> curriculumList;
    
     @OneToMany(mappedBy = "subjects",fetch = FetchType.LAZY)
    List<SubjectsBookEntity> subjectsBookList;

    public SubjectsEntity() {
    }

    public int getSubjectsID() {
        return subjectsID;
    }

    public void setSubjectsID(int subjectsID) {
        this.subjectsID = subjectsID;
    }

    public String getSubjectsName() {
        return subjectsName;
    }

    public void setSubjectsName(String subjectsName) {
        this.subjectsName = subjectsName;
    }

    public List<CurriculumEntity> getCurriculumList() {
        return curriculumList;
    }

    public void setCurriculumList(List<CurriculumEntity> curriculumList) {
        this.curriculumList = curriculumList;
    }

    public List<SubjectsBookEntity> getSubjectsBookList() {
        return subjectsBookList;
    }

    public void setSubjectsBookList(List<SubjectsBookEntity> subjectsBookList) {
        this.subjectsBookList = subjectsBookList;
    }

    
     
     
}
