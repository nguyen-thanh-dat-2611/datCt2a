
package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="borrowed")
public class BorrowedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int borrowedID;
    
    private String name;
    private String address;
    private String phone;
    private String email;
    private String librarycode;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate payDate;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowedDate;
    
    @OneToMany(mappedBy = "borrowed",fetch = FetchType.LAZY)
    List<BorrowedDetailEntity> borrowedDetailEntitysList;
    
    @ManyToOne
    @JoinColumn(name = "cardId")
    private CardLibaryEntity cardLibary;

    public BorrowedEntity() {
    }

    public int getBorrowedID() {
        return borrowedID;
    }

    public void setBorrowedID(int borrowedID) {
        this.borrowedID = borrowedID;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public List<BorrowedDetailEntity> getBorrowedDetailEntitysList() {
        return borrowedDetailEntitysList;
    }

    public void setBorrowedDetailEntitysList(List<BorrowedDetailEntity> borrowedDetailEntitysList) {
        this.borrowedDetailEntitysList = borrowedDetailEntitysList;
    }

    public CardLibaryEntity getCardLibary() {
        return cardLibary;
    }

    public void setCardLibary(CardLibaryEntity cardLibary) {
        this.cardLibary = cardLibary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLibrarycode() {
        return librarycode;
    }

    public void setLibrarycode(String librarycode) {
        this.librarycode = librarycode;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    
    
}
