
package controller;

import entity.BookEntity;
import entity.CategoryEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.BookRepository;
import repository.CategoryRepository;

@Controller
public class HomeController {
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private CategoryRepository categoryRepo;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showAllCity(Model model) {
        List<BookEntity> bookList = (List<BookEntity>) bookRepo.findAll();
        List<CategoryEntity> categoryList = (List<CategoryEntity>) categoryRepo.findAll();
        List<BookEntity> book1 = (List<BookEntity>) bookRepo.getBook1();
        List<BookEntity> book2 = (List<BookEntity>) bookRepo.getBook2();
        List<BookEntity> book3 = (List<BookEntity>) bookRepo.getBook3();
        List<BookEntity> book4 = (List<BookEntity>) bookRepo.getBook4();
        model.addAttribute("bookList", bookList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("book1", book1);
        model.addAttribute("book2", book2);
        model.addAttribute("book3", book3);
        model.addAttribute("book4", book4);
        return "home";
    }
    
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String showProductDetails(@PathVariable(value = "id") int id, Model model) {
        BookEntity book= (BookEntity) bookRepo.findById(id);
        model.addAttribute("book", book); 

        return "detail";
    }
    
    @RequestMapping(value = "/detail_1/{id}", method = RequestMethod.GET)
    public String showProductDetails1(@PathVariable(value = "id") int id, Model model) {
        BookEntity book= (BookEntity) bookRepo.findById(id);
        model.addAttribute("book", book); 

        return "detail_1";
    }
    
    @RequestMapping(value = "/textList/{id}", method = RequestMethod.GET)
    public String showGiaotrinh(@PathVariable(value = "id") int categoryId, Model model) {
       List<CategoryEntity> categoryList = (List<CategoryEntity>) categoryRepo.findAll();
       model.addAttribute("categoryList", categoryList);
       List<BookEntity> bookList = bookRepo.getBookByCategoryId(categoryId);
        model.addAttribute("bookList", bookList);
        
       return "bookList";
    }
    
    @RequestMapping(value ="/bookList", method = RequestMethod.GET)
    public String listBook(Model model){       
        List<BookEntity> bookList = (List<BookEntity>) bookRepo.findAll();
        
        model.addAttribute("bookList",bookList); 
        return "bookList"; 
    }
    
   @RequestMapping(value = "search",method = RequestMethod.GET)
       public String searchBook(@RequestParam(name = "searchText")String searchText, Model model){
                                
       //searchText="" + searchText + "%";
       List<BookEntity> bookList = bookRepo.findByBookNameContaining(searchText);
       
       model.addAttribute("bookList", bookList);
       
       return "search";
       }
}
