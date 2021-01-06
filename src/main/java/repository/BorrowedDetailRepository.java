
package repository;

import entity.BorrowedDetailEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowedDetailRepository extends CrudRepository<BorrowedDetailEntity, Integer>{
    BorrowedDetailEntity findById(int id);
}
