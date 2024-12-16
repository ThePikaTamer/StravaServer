package es.deusto.sd.server;

import es.deusto.sd.server.User;

import java.util.Optional;

public interface IUserRepository {
	Optional<User> findByEmail(String email);
}
