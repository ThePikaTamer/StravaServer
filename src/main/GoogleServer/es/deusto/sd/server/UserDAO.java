
public interface UserDAO 
{
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    void save(User user);
}
