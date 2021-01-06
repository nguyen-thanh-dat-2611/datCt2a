
package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class BookEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookID;
    private String bookName;
    private String bookInformaton;
    private String author;
    private String producer;
    private String image;
    private double untiPrice;
    
    @ManyToOne
    @JoinColumn(name = "categoryID")
    private CategoryEntity category;
    
    @OneToMany(mappedBy = "book",fetch = FetchType.LAZY)
    List<OrderDetailEntity> OrderDetailsList;
    
    @OneToMany(mappedBy = "book",fetch = FetchType.LAZY)
    List<BorrowedDetailEntity> BorrowedDetailList;
    
    @OneToMany(mappedBy = "book",fetch = FetchType.LAZY)
    List<SubjectsBookEntity> subjectsBookList;

    public BookEntity() {
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookInformaton() {
        return bookInformaton;
    }

    public void setBookInformaton(String bookInformaton) {
        this.bookInformaton = bookInformaton;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

   

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public List<OrderDetailEntity> getOrderDetailsList() {
        return OrderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetailEntity> OrderDetailsList) {
        this.OrderDetailsList = OrderDetailsList;
    }

    public List<BorrowedDetailEntity> getBorrowedDetailList() {
        return BorrowedDetailList;
    }

    public void setBorrowedDetailList(List<BorrowedDetailEntity> BorrowedDetailList) {
        this.BorrowedDetailList = BorrowedDetailList;
    }

    public List<SubjectsBookEntity> getSubjectsBookList() {
        return subjectsBookList;
    }

    public void setSubjectsBookList(List<SubjectsBookEntity> subjectsBookList) {
        this.subjectsBookList = subjectsBookList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getUntiPrice() {
        return untiPrice;
    }

    public void setUntiPrice(double untiPrice) {
        this.untiPrice = untiPrice;
    }

    
}
