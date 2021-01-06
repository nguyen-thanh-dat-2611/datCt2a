    
package repository;


import entity.BookEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer>{
    BookEntity findById(int id);
    
    @Query(value="select * from book limit 4;", nativeQuery = true)
    List<BookEntity> getBook1();
    
    @Query(value="select * from book limit 4,4;", nativeQuery = true)
    List<BookEntity> getBook2();
    
    @Query(value="select * from book limit 8,4;", nativeQuery = true)
    List<BookEntity> getBook3();
    
    @Query(value="select * from book limit 12,4;", nativeQuery = true)
    List<BookEntity> getBook4();
    
    @Query(value="select * from book where categoryid=?1 ", nativeQuery = true)
    List<BookEntity> getBookByCategoryId(int categoryId);
    
    List<BookEntity>findByBookNameContaining(String bookName);
}
