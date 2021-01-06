
package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "borrowedDetail")
public class BorrowedDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int borrowedDetailID;
    private double untiPrice;
    private int quantity;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate payDay;
    
    @ManyToOne
    @JoinColumn(name = "bookID")
    private BookEntity book;
    
    @ManyToOne
    @JoinColumn(name = "borrowedID")
    private  BorrowedEntity borrowed;

    public BorrowedDetailEntity() {
    }

    public int getBorrowedDetailID() {
        return borrowedDetailID;
    }

    public void setBorrowedDetailID(int borrowedDetailID) {
        this.borrowedDetailID = borrowedDetailID;
    }

    public double getUntiPrice() {
        return untiPrice;
    }

    public void setUntiPrice(double untiPrice) {
        this.untiPrice = untiPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getPayDay() {
        return payDay;
    }

    public void setPayDay(LocalDate payDay) {
        this.payDay = payDay;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public BorrowedEntity getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(BorrowedEntity borrowed) {
        this.borrowed = borrowed;
    }
    
    
    public double getTotal(){
        double total = book.getUntiPrice() * quantity;
        return total;
    }
}
