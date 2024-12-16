package es.deusto.sd.server;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserRepository implements IUserRepository{

	@Override
	public Optional<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
