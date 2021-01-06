
package controller;

import component.Cart;
import entity.BookEntity;
import entity.OrderDetailEntity;
import entity.OrderEntity;
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
import repository.OrderDetailRepository;
import repository.OrderRepository;

@Controller
@Scope(value = "session")
public class CartController {
    @Autowired
    BookRepository bookRepo;
    
    @Autowired
    Cart cart;
    
    @Autowired
    OrderRepository orderRepo;
    
    @Autowired
    OrderDetailRepository orderDetailsRepo;
    
    @RequestMapping(value = "/addToCart/{id}", method = RequestMethod.GET)
    public String addNewItem(@PathVariable(value = "id") int id, Model model) {
        BookEntity book = (BookEntity) bookRepo.findById(id);
        cart.addItem(book);

        model.addAttribute("cart", cart);

        return "cart";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String removeCarts(@PathVariable(value = "id") int id, Model model) {
        BookEntity book = (BookEntity) bookRepo.findById(id);
        cart.removeItem(book);
        model.addAttribute("cart", cart);
        return "cart";
    }
    
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String updateQuantity(Model model,@RequestParam(name= "id")int id,
            @RequestParam(name= "quantity")int quantity, BookEntity book){
        List<OrderDetailEntity> OrderDetailsList = cart.getOrderDetailsList();
        for(int i= 0; i<OrderDetailsList.size();i++){
            if(OrderDetailsList.get(i).getBook().getBookID() == book.getBookID()){
                OrderDetailEntity orderDetails = OrderDetailsList.get(i);
                orderDetails.setQuantity(quantity);
                OrderDetailsList.set(i, orderDetails);
                cart.setOrderDetailsList(OrderDetailsList);
            }
        }
        model.addAttribute("cart", cart);
        return "cart";
    }
    
    @RequestMapping(value = "/newOrder",method = RequestMethod.GET)
    public String showNewOrder(Model model){
          
        OrderEntity order = new OrderEntity();
        OrderDetailEntity orderDetails = new OrderDetailEntity();
        model.addAttribute("order", order);
        model.addAttribute("orderDetails", orderDetails);
        return "newOrder";
    }
      
    @RequestMapping(value = "/newOrder1",method = RequestMethod.POST)
    public String saveNewOrder(OrderEntity order,Model model){
         
        order.setDate(LocalDate.now());
        OrderEntity newOrder = orderRepo.save(order);

        List<OrderDetailEntity> orderDetailList = cart.getOrderDetailsList();
        for(OrderDetailEntity orderDetails : orderDetailList){
            orderDetails.setOrder(newOrder);
            orderDetailsRepo.save(orderDetails);
        } 
          
        return "redirect:/";
      } 
}
