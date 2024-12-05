
public class UserInMemoryDAO implements UserDAO 
{
    private final Map<String, User> users = new HashMap<>();

    @Override
    public User findByEmail(String email) 
    {
        return users.get(email);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) 
    {
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) 
        {
            return user;
        }
        return null;
    }

    @Override
    public void save(User user) 
    {
        users.put(user.getEmail(), user);
    }
}
