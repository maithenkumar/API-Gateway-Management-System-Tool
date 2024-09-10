import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GatewayController {
    @GetMapping("test")
    public String Test(@RequestParam String param) {
        return new String("this s the demo test !");
    }
    
}
