package ToDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MainService {
    @Autowired
    MainRepository mainRepository;


    public List<MainModel>findAll(){
        return mainRepository.findAll();
    }
    public Optional<MainModel> findById(Integer id){
        return mainRepository.findById(id);
    }
    public void find(MainModel main) { return ;}

    public MainModel create(MainModel main){
        return mainRepository.save(main);
    }

    public MainModel update(MainModel main){
        return mainRepository.save(main);
    }

    public void delete(Integer id){
        mainRepository.deleteById(id);
    }
}
