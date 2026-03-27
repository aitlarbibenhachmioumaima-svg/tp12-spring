package ma.ens.security.spring_jwt_api.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/user/profile")
    public String userProfile() {
        return "Contenu accessible aux USER et ADMIN";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "Contenu réservé à l'ADMIN uniquement";
    }
}