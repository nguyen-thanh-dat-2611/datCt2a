
package controller;

import component.Rental;
import entity.BookEntity;
import entity.BorrowedDetailEntity;
import entity.BorrowedEntity;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.BookRepository;
import repository.BorrowedDetailRepository;
import repository.BorrowedRepository;

@Controller
@Scope(value = "session")
public class RentalController {
    @Autowired
    BookRepository bookRepo;
    
    @Autowired
    Rental rental;
    
    @Autowired
    BorrowedDetailRepository borrowedDetailRepo;
    
    @Autowired
    BorrowedRepository borrowedRepo;
    
    @RequestMapping(value = "/addRental/{id}", method = RequestMethod.GET)
    public String addNewItem(@PathVariable(value = "id") int id, Model model) {
        BookEntity book = (BookEntity) bookRepo.findById(id);
        rental.addItem(book);

        model.addAttribute("rental", rental);

        return "rental";
    }
    
    @RequestMapping(value = "/delete1/{id}", method = RequestMethod.GET)
    public String removeCarts(@PathVariable(value = "id") int id, Model model) {
        BookEntity book = (BookEntity) bookRepo.findById(id);
        rental.removeItem(book);
        model.addAttribute("rental", rental);
        return "rental";
    }
    
    @RequestMapping(value="/update1", method = RequestMethod.POST)
    public String updateQuantity(Model model,@RequestParam(name= "id")int id,
            @RequestParam(name= "quantity")int quantity, BookEntity book){
        List<BorrowedDetailEntity> BorrowedDetailList = rental.getBorrowedDetailList();
        for(int i= 0; i<BorrowedDetailList.size();i++){
            if(BorrowedDetailList.get(i).getBook().getBookID() == book.getBookID()){
                BorrowedDetailEntity borrowedDetail = BorrowedDetailList.get(i);
                borrowedDetail.setQuantity(quantity);
                BorrowedDetailList.set(i, borrowedDetail);
                rental.setBorrowedDetailList(BorrowedDetailList);
            }
        }
        model.addAttribute("rental", rental);
        return "rental";
    }
    
    @RequestMapping(value = "/newBorrowed",method = RequestMethod.GET)
    public String showNewBorrowed(Model model){
        
        BorrowedEntity borrowed = new BorrowedEntity();
        BorrowedDetailEntity borrowedDetail = new BorrowedDetailEntity();
        model.addAttribute("borrowed", borrowed);
        model.addAttribute("borrowedDetail", borrowedDetail);
        
        return "newBorrowed";
    }
    
    @RequestMapping(value = "/newBorrowed1",method = RequestMethod.POST)
    public String saveNewBorrowed(BorrowedEntity borrowed,Model model){
         
        borrowed.setBorrowedDate(LocalDate.now());
        BorrowedEntity newBorrowed = borrowedRepo.save(borrowed);

        List<BorrowedDetailEntity> borrowedDetailList = rental.getBorrowedDetailList();
        for(BorrowedDetailEntity borrowedDetail : borrowedDetailList){
            borrowedDetail.setBorrowed(newBorrowed);
            borrowedDetailRepo.save(borrowedDetail);
        } 
          
        return "redirect:/";
      } 
}
