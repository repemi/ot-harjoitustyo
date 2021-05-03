package expensecounter.dao;

import expensecounter.domain.User;
import java.util.List;

public interface UserDao {

    User create(User user) throws Exception;

    User findByUsername(String username);

    List<User> getAll();

}
