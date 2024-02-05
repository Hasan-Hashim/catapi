import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/")
    public String home() {
        return "index"; // Return the name of the HTML template or view you want to render for the root URL.
    }
}