package itemlist.domain;

import itemlist.dao.UserDao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import itemlist.dao.ItemDao;

/**
 * Luokka, jossa tapahtuu pakkauslistan luominen.
 */
public class ItemList {

    private ItemDao itemDao;
    private UserDao userDao;
    private User loggedIn;

    public ItemList(ItemDao itemDao, UserDao userDao) {
        this.userDao = userDao;
        this.itemDao = itemDao;
    }

    /**
     *
     * Lisää uuden tuotteen kirjautuneena olevan käyttäjän pakkauslistalle.
     *
     * @param product uusi tuote
     */
    public boolean createItem(String product) {
        Item item = new Item(product, loggedIn);
        try {
            itemDao.create(item);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    /**
     *
     * Merkkaa tuotteen pakatuksi.
     *
     * @param id tuotteen tunniste, joka on pakattu.
     */
    public void packed(int id) {
        try {
            itemDao.setCheck(id);
        } catch (Exception exp) {

        }
    }

    /**
     *
     * Pakkauslista, eli tuotteet, jotka ovat vielä pakkaamatta.
     *
     * @return kirjautuneen käyttäjän pakkauslistan tuotteet.
     */
    public List<Item> unPacked() {
        if (loggedIn == null) {
            return new ArrayList<>();
        }
        return itemDao.getAll()
                .stream()
                .filter(i -> i.getUser().equals(loggedIn))
                .filter(i -> !i.isCheck())
                .collect(Collectors.toList());
    }

    /**
     * Sisäänkirjautuminen
     *
     * @param username käyttäjätunnus
     *
     * @return palauttaa true, jos käyttäjä on kirjautunut sisään muutoin false
     */
    public boolean login(String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return false;
        }

        loggedIn = user;

        return true;
    }

    /**
     *
     * Kertoo käyttäjän, joka on kirjautuneena sisään.
     *
     * @return palauttaa käyttäjän, joka on kirjautunut sisään.
     */
    public User getLoggedUser() {
        return loggedIn;
    }

    /**
     * Kirjaa käyttäjän ulos sovelluksesta.
     *
     */
    public void logout() {
        loggedIn = null;
    }

    /**
     * Uuden käyttäjän luonti
     *
     * @param username käyttäjätunnus
     * @param name käyttäjän nimi
     *
     * @return palauttaa true, jos käyttäjän luonti on onnistunut, muutoin
     * false.
     */
    public boolean createUser(String username, String name) {
        if (userDao.findByUsername(username) != null) {
            return false;
        }

        User user = new User(username, name);
        try {
            userDao.create(user);

        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
