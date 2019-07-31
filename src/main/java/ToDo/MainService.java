package ToDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RESTService {
    @Autowired
    RESTRepository mainRepository;


    public List<RESTModel>findAll(){
        return mainRepository.findAll();
    }
    public Optional<RESTModel> findById(Integer id){
        return mainRepository.findById(id);
    }
    public void find(RESTModel main) { return ;}

    public RESTModel create(RESTModel main){
        return mainRepository.save(main);
    }

    public RESTModel update(RESTModel main){
        return mainRepository.save(main);
    }

    public void delete(Integer id){
        mainRepository.deleteById(id);
    }
}
