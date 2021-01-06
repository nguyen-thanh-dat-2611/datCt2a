
package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    private String studentClassr;
    private String address;
    private String city;
    private String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birDate;
    
     @OneToMany(mappedBy = "student",fetch = FetchType.LAZY)
    List<OrderEntity> orderList;
     
     @OneToMany(mappedBy = "student",fetch = FetchType.LAZY)
    List<UserEntity> userList;
     
     @OneToMany(mappedBy = "student",fetch = FetchType.LAZY)
    List<StudentsCourseEntity> studentsCourseList;
     
     @OneToMany(mappedBy = "student",fetch = FetchType.LAZY)
    List<CardLibaryEntity> cardLibaryList;

    public StudentEntity() {
    }

    

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClassr() {
        return studentClassr;
    }

    public void setStudentClassr(String studentClassr) {
        this.studentClassr = studentClassr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<OrderEntity> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderEntity> orderList) {
        this.orderList = orderList;
    }

    public List<UserEntity> getUserList() {
        return userList;
    }

    public void setUserList(List<UserEntity> userList) {
        this.userList = userList;
    }

    public List<StudentsCourseEntity> getStudentsCourseList() {
        return studentsCourseList;
    }

    public void setStudentsCourseList(List<StudentsCourseEntity> studentsCourseList) {
        this.studentsCourseList = studentsCourseList;
    }

    public List<CardLibaryEntity> getCardLibaryList() {
        return cardLibaryList;
    }

    public void setCardLibaryList(List<CardLibaryEntity> cardLibaryList) {
        this.cardLibaryList = cardLibaryList;
    }

   

    

    public LocalDate getBirDate() {
        return birDate;
    }

    public void setBirDate(LocalDate birDate) {
        this.birDate = birDate;
    }
     
    public String getbirDateFormatted(){
        DateTimeFormatter birDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return birDateFormat.format(birDate);
    }
}
