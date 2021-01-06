
package entity;

import java.time.LocalDate;
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
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate Date;
    
    private String name;
    private String address;
    private String phone;
    private String email;
    
    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY)
    List<OrderDetailEntity> OrderDetailsList;
    
    @ManyToOne
    @JoinColumn(name = "studentId")
    private StudentEntity student;

    public OrderEntity() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    public List<OrderDetailEntity> getOrderDetailsList() {
        return OrderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetailEntity> OrderDetailsList) {
        this.OrderDetailsList = OrderDetailsList;
    }
    
    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
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
    
    
    
}
