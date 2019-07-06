package ToDo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ToDo.MainModel;
import ToDo.MainService;

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


    @GetMapping(path="{id}")
    @ResponseBody
    public Optional<MainModel> getMemo(@PathVariable int id) {
        return mainService.find(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public MainModel postMemo(@RequestBody MainModel main){
        return mainService.create(main);
    }
    @PutMapping(path="{id}")
    public MainModel PutMemo(@PathVariable Integer id,@RequestBody MainModel mainModel){

        return mainService.update(mainModel);
    }
    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteMemo(@PathVariable Integer id){
        mainService.delete(id);
    }

}
