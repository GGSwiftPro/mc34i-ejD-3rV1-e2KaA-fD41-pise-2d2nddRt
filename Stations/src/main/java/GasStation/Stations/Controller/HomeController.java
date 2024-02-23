package GasStation.Stations.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class HomeController {

    @GetMapping("/home")
    public ResponseEntity<?> displayHome(){
        return ResponseEntity.ok("ITs ALIVE");
    }
}
