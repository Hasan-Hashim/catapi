import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cats")
public class CatController {

    @GetMapping("/random")
    public String getRandomCat() {
        try {
            // Call the getCatData method from CatApiConnector class
            CatApiConnector.getCatData();
            return "Cat data retrieved successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error retrieving cat data";
        }
    }
}
