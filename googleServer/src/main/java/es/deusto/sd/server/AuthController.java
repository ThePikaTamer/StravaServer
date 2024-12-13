package es.deusto.sd.server;

import es.deusto.sd.server.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/isRegistered")
    public boolean isEmailRegistered(@RequestParam String email) {
        return authService.isEmailRegistered(email);
    }

    @PostMapping("/validate")
    public boolean validateCredentials(@RequestParam String email, @RequestParam String password) {
        return authService.validateCredentials(email, password);
    }
}
