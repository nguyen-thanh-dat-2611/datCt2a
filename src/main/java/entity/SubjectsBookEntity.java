
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "subjectsBook")
public class SubjectsBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectsBookId;
    
    @ManyToOne
    @JoinColumn(name = "subjectsID")
    private SubjectsEntity subjects;
    
    @ManyToOne
    @JoinColumn(name = "bookID")
    private BookEntity book;

    public SubjectsBookEntity() {
    }

    public int getSubjectsBookId() {
        return subjectsBookId;
    }

    public void setSubjectsBookId(int subjectsBookId) {
        this.subjectsBookId = subjectsBookId;
    }

    public SubjectsEntity getSubjects() {
        return subjects;
    }

    public void setSubjects(SubjectsEntity subjects) {
        this.subjects = subjects;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }
    
    
}
