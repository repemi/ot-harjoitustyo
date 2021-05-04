package expensecounter.domain;

import expensecounter.dao.ExpenseDao;
import expensecounter.dao.UserDao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Luokka, jossa tapahtuu menolaskurin toiminnot.
 */
public class ExpenseCounterService {

    private ExpenseDao expenseDao;
    private UserDao userDao;
    private User loggedIn;

    public ExpenseCounterService(ExpenseDao expenseDao, UserDao userDao) {
        this.userDao = userDao;
        this.expenseDao = expenseDao;
    }

    /**
     *
     * Lisätään uusi tuote, josta on kuluja käyttäjälle.
     *
     * @param product uusi tuote
     */
    public boolean createExpense(String product) {
        Expense expense = new Expense(product, loggedIn);
        try {
            expenseDao.create(expense);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public List<Expense> getExpenses() {

        if (loggedIn == null) {
            return new ArrayList<>();
        }
        return expenseDao.getAll()
                .stream()
                .filter(e -> e.getUser().equals(loggedIn))
                .filter(e -> !e.getProduct().isEmpty())
                .collect(Collectors.toList());

    }

    /**
     * sisäänkirjautuminen
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
     * kertoo käyttäjän, joka on kirjautuneena sisään.
     *
     * @return palauttaa käyttäjän, joka on kirjautunut sisään.
     */
    public User getLoggedUser() {
        return loggedIn;
    }

    /**
     * kirjaa ulos sovelluksesta.
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

        User user = new User(name, username);
        try {
            userDao.create(user);

        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
