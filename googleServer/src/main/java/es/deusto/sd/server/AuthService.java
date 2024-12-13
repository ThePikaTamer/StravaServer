package es.deusto.sd.server;

import es.deusto.sd.server.User;
import es.deusto.sd.server.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean isEmailRegistered(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public boolean validateCredentials(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent() && user.get().getPassword().equals(password);
    }
}
