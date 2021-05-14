package itemlist.dao;

import itemlist.domain.User;
import java.util.List;

/**
 * Rajapinta käyttäjälle.
 * 
 */

public interface UserDao {

    /**
     * Luo uuden käyttäjän.
     * @param user
     * @return
     * @throws Exception 
     */
    User create(User user) throws Exception;

    /**
     * Etsii käyttäjän tunnuksen perusteella.
     * @param username
     * @return 
     */
    User findByUsername(String username);

    /**
     * Listaa kaikki käyttäjät.
     * @return palauttaa listan käyttäjistä.
     */
    List<User> getAll();

}
