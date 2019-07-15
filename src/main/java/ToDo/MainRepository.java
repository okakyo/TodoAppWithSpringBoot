package ToDo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends JpaRepository<MainModel,Integer> {

}
