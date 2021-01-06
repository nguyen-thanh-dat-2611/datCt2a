
package component;

import entity.BookEntity;
import entity.BorrowedDetailEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session")
public class Rental {
    
    private List<BorrowedDetailEntity> BorrowedDetailList;
    
    public Rental() {
        BorrowedDetailList = new ArrayList<BorrowedDetailEntity>();
    }
    
    public void addItem(BookEntity book){
        boolean t=false;
        for (int i=0; i<BorrowedDetailList.size(); i++){
            if (BorrowedDetailList.get(i).getBook().getBookID()==book.getBookID()){
                BorrowedDetailEntity borrowedDetail = BorrowedDetailList.get(i);
                borrowedDetail.setQuantity(borrowedDetail.getQuantity() +1);
                BorrowedDetailList.set(i,borrowedDetail);
                t=true;
            }
        }
        if(!t){
            BorrowedDetailEntity borrowedDetail = new BorrowedDetailEntity();
            borrowedDetail.setBook(book);
            borrowedDetail.setQuantity(1);
            borrowedDetail.setUntiPrice(book.getUntiPrice());
            BorrowedDetailList.add(borrowedDetail);
        }
    }
    
    public void removeItem(BookEntity book) {
        for (int i = 0; i < BorrowedDetailList.size(); i++) {
            if (BorrowedDetailList.get(i).getBook().getBookID() == book.getBookID()) {
                BorrowedDetailList.remove(i);
            }
        }
    }
    
    public List<BorrowedDetailEntity> getBorrowedDetailList(){
        return BorrowedDetailList;
    }
    
    public void setBorrowedDetailList(List<BorrowedDetailEntity> BorrowedDetailList) {
        this.BorrowedDetailList = BorrowedDetailList;
    }
    
    public int getCount(){
        return BorrowedDetailList.size();
    }
    
    public double getTotal(){
        double sum = 0;
        for(BorrowedDetailEntity borrowedDetail:BorrowedDetailList){
            sum = sum+ borrowedDetail.getTotal();
            
        }
        return sum;
    }

}
