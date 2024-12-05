@RestController
@RequestMapping("/google")

public class GoogleLoginController
{
    @Autowired
    private UserDAO userDAO;

    @GetMapping("/checkEmail")
    public Map<String, Boolean> checkEmail(@RequestParam String email) 
    {
        boolean registered = userDAO.findByEmail(email) != null;
        return Map.of("registered", registered);
    }

    @PostMapping("/validateCredentials")
    public Map<String, Boolean> validateCredentials(@RequestBody Map<String, String> body) 
    {
        String email = body.get("email");
        String password = body.get("password");
        boolean valid = userDAO.findByEmailAndPassword(email, password) != null;
        return Map.of("valid", valid);
    }
}

//Código dado por chatGPT, habrá que cambiar direcciones