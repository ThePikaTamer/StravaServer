
@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public User findByEmail(String email) {
        String query = "SELECT u FROM User u WHERE u.email = :email";
        return entityManager.createQuery(query, User.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        String query = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password";
        return entityManager.createQuery(query, User.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }
}
