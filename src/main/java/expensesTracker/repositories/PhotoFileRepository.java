package expensesTracker.repositories;

import expensesTracker.models.PhotoFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoFileRepository extends CrudRepository<PhotoFile, Long> {
}
