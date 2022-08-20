package sia.tacocloud.home;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

}
