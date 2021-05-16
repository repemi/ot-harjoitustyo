/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itemlist.domain;

import itemlist.dao.UserDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erepo
 */
public class FakeUserDao implements UserDao {

    List<User> users = new ArrayList<>();

    public FakeUserDao() {
        users.add(new User("pipsa", "possu"));

    }

    @Override
    public User create(User user) throws Exception {
        users.add(user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username))
                .findFirst().orElse(null);

    }

    @Override
    public List<User> getAll() {
        return users;
    }

}
