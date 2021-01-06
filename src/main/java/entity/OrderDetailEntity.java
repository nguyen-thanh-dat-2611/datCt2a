
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderDetail")
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailID;
    private double untiPrice;
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrderEntity order;
    
    @ManyToOne
    @JoinColumn(name = "bookID")
    private BookEntity book;

    public OrderDetailEntity() {
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
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

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }
    
    public double getTotal(){
        double total = book.getUntiPrice() * quantity;
        return total;
    }
    
}
