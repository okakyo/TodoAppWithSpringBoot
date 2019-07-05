package ToDo;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ToDo.MainModel;


@RestController
@RequestMapping("/api")
public class MainController {
    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public String getAllMemo() {
        return "index\n";
    }
    @RequestMapping(value="{id}",method=RequestMethod.GET)
    @ResponseBody
    public String getMemo(@PathVariable int id) {
        return "Hello Spring MVC"+id+"\n";
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public String InsertMemo(){
        return "Good Morning\n";
    }

    @RequestMapping(method=RequestMethod.PUT)
    @ResponseBody
    public String PutMemo(){
        return "Good Night\n";
    }
    @RequestMapping(method=RequestMethod.DELETE)
    @ResponseBody
    public String DeleteMemo(){
        return "Good Bye\n";
    }

}
