package shoaib.chatApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/home")
    private String greet(){
        return "hello welcome to my website";
    }
}
