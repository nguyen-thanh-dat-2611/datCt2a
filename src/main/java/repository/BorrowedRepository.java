
package repository;

import entity.BorrowedDetailEntity;
import entity.BorrowedEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowedRepository extends CrudRepository<BorrowedEntity, Integer>{
    BorrowedEntity findById(int id);
}
