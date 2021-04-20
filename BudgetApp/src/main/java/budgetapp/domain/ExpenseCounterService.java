package budgetapp.domain;

import budgetapp.dao.FileExpenseDao;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class ExpenseCounterService {

    private Expense expense;
    private ArrayList<Expense> list;
    private Scanner reader;

    public ExpenseCounterService(Scanner reader) {
        this.reader = reader;
    }

    public ExpenseCounterService(Expense expense, Scanner reader) {

        this.expense = expense;
        list = new ArrayList<>();
        this.reader = reader;
    }

    public void init() throws Exception {
        Properties properties = new Properties();

        properties.load(new FileInputStream("config.properties"));
        String expenseFile = properties.getProperty("expenseFile");

        FileExpenseDao expenseDao = new FileExpenseDao(expenseFile);

    }

    public void addExpense(Expense e) {
        list.add(e);
        System.out.println("Lisätty onnistuneesti:");
        System.out.println(e);

    }

    public void getMenot() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    public void getSumMenot() {
        int sumOfAll = 0;
        for (int i = 0; i < list.size(); i++) {
            sumOfAll += list.get(i).getSumma();
        }
        System.out.println(sumOfAll);
    }

    public void getAllMenot() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getMeno());
        }
    }

    public void clearList() {
        list.clear();

    }

    public void removeMeno(String ans) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMeno().equalsIgnoreCase(ans)) {
                list.remove(i);
            }
        }
    }
}
