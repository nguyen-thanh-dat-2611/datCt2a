
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
@Table(name = "cardLibary")
public class CardLibaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;
    private double price;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String libarycode;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfError;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;
    
    @OneToMany(mappedBy = "cardLibary",fetch = FetchType.LAZY)
    List<BorrowedEntity> borrowedList;
    
    @ManyToOne
    @JoinColumn(name = "studentId")
    private StudentEntity student;

    public CardLibaryEntity() {
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDate getDateOfError() {
        return dateOfError;
    }

    public void setDateOfError(LocalDate dateOfError) {
        this.dateOfError = dateOfError;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public List<BorrowedEntity> getBorrowedList() {
        return borrowedList;
    }

    public void setBorrowedList(List<BorrowedEntity> borrowedList) {
        this.borrowedList = borrowedList;
    }

    

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
    
    
    
    public String getpaymentDateFormatted(){
        DateTimeFormatter paymentDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return paymentDateFormat.format(paymentDate);
    }
    
    public String getdateOfErrorFormatted(){
        DateTimeFormatter dateOfErrorFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateOfErrorFormat.format(dateOfError);
    }
    public String getexpirationDateFormatted(){
        DateTimeFormatter expirationDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return expirationDateFormat.format(expirationDate);
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

    public String getLibarycode() {
        return libarycode;
    }

    public void setLibarycode(String libarycode) {
        this.libarycode = libarycode;
    }
    
    
}
