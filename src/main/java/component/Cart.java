package component;

import entity.OrderDetailEntity;
import entity.BookEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session")
public class Cart {
    private List<OrderDetailEntity> OrderDetailsList;

    public Cart() {
        OrderDetailsList = new ArrayList<OrderDetailEntity>();
    }
    public void addItem(BookEntity book){
        boolean t=false;
        for (int i=0; i<OrderDetailsList.size(); i++){
            if (OrderDetailsList.get(i).getBook().getBookID()==book.getBookID()){
                OrderDetailEntity orderDetails = OrderDetailsList.get(i);
                orderDetails.setQuantity(orderDetails.getQuantity() +1);
                OrderDetailsList.set(i,orderDetails);
                t=true;
            }
        }
        if(!t){
            OrderDetailEntity orderDetails = new OrderDetailEntity();
            orderDetails.setBook(book);
            orderDetails.setQuantity(1);
            orderDetails.setUntiPrice(book.getUntiPrice());
            OrderDetailsList.add(orderDetails);
        }
    }
    
    public void removeItem(BookEntity book) {
        for (int i = 0; i < OrderDetailsList.size(); i++) {
            if (OrderDetailsList.get(i).getBook().getBookID() == book.getBookID()) {
                OrderDetailsList.remove(i);
            }
        }
    }


    public List<OrderDetailEntity> getOrderDetailsList() {
        return OrderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetailEntity> OrderDetailsList) {
        this.OrderDetailsList = OrderDetailsList;
    }
    public int getCount(){
        return OrderDetailsList.size();
    }
    public double getTotal(){
        double sum = 0;
        for(OrderDetailEntity orderDetails:OrderDetailsList){
            sum = sum+ orderDetails.getTotal();
            
        }
        return sum;
    }
 
}
