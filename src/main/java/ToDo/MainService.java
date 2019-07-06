package ToDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ToDo.MainRepository;
import ToDo.MainModel;

import java.util.List;
import java.util.Optional;


@Service
public class MainService {
    @Autowired
    MainRepository mainRepository;


    public List<MainModel>findAll(){
        return mainRepository.findAll();
    }
    public Optional<MainModel> find(Integer id){
        return mainRepository.findById(id);
    }

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
