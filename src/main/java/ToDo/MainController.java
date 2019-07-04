package ToDo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
@RestController
@RequestMapping("/")
public class MainController {
    @RequestMapping(method=RequestMethod.GET)
    public String getAllMemo() {
        return "Hello Spring MVC\n";
    }
    @RequestMapping(value="{id}",method=RequestMethod.GET)
    public String getMemo(@PathVariable int id) {
        return "Hello Spring MVC"+id+"\n";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String InsertMemo(){
        return "Good Morning\n";
    }

    @RequestMapping(method=RequestMethod.PUT)
    public String PutMemo(){
        return "Good Night\n";
    }
    @RequestMapping(method=RequestMethod.DELETE)
    public String DeleteMemo(){
        return "Good Bye\n";
    }

}
