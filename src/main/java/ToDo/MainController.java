package ToDo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ToDo.MainModel;
import ToDo.MainService;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping()
    public List<MainModel> getAllMemo() {
        List<MainModel> getAll=mainService.findAll();
        return getAll;
    }


    @GetMapping(path="/{id}")
    @ResponseBody
    public Optional<MainModel> getMemo(@PathVariable int id) {
        return mainService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public MainModel postMemo(@RequestBody MainModel main) {
        return mainService.create(main);
    }

    @PutMapping(path="/{id}")
    public MainModel putMemo(@PathVariable Integer id,@RequestBody MainModel mainModel){
        mainModel.setId(id);
        return mainService.update(mainModel);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMemo(@PathVariable Integer id){
        mainService.delete(id);
    }

}
