package ToDo;

import org.springframework.data.jpa.repository.JpaRepository;
import ToDo.MainModel;

public interface MainRepository extends JpaRepository<MainModel,Integer> {

}
