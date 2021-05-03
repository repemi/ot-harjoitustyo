package expensecounter.domain;

import expensecounter.dao.ExpenseDao;
import expensecounter.dao.UserDao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
     * Add new expense to user who is logged in
     *
     * @param expense new expense
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
     * logging in
     *
     * @param username käyttäjätunnus
     *
     * @return true if username is created, else return false
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
     * user has logged in
     *
     * @return user who is logged in
     */
    public User getLoggedUser() {
        return loggedIn;
    }

    /**
     * log out
     *
     */
    public void logout() {
        loggedIn = null;
    }

    /**
     * create new user
     *
     * @param username käyttäjätunnus
     * @param name käyttäjän nimi
     *
     * @return true if username is created successfully, else false
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
