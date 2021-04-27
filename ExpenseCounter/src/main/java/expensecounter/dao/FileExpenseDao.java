package expensecounter.dao;

import expensecounter.domain.Expense;
import expensecounter.domain.User;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileExpenseDao implements ExpenseDao {

    public List<Expense> expenses;
    private String file;

    public FileExpenseDao(String file, UserDao users) throws Exception {
        expenses = new ArrayList<>();
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                int id = Integer.parseInt(parts[0]);
                String product = parts[1];
                int cost = Integer.parseInt(parts[2]);
                User user = users.getAll().stream().filter(u -> u.getUsername().equals(parts[3])).findFirst().orElse(null);
                Expense expense = new Expense(id, product, cost, user);
                expenses.add(expense);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    private void save() throws Exception {
        try ( FileWriter writer = new FileWriter(new File(file))) {
            for (Expense expense : expenses) {
                writer.write(expense.getId() + ";" + expense.getProduct() + ";" + expense.getCost() + ";" + expense.getUser().getUsername() + "\n");
            }
        }
    }

    private int generateId() {
        return expenses.size() + 1;
    }

    @Override
    public Expense create(Expense expense) throws Exception {
        expense.setId(generateId());
        expenses.add(expense);
        save();
        return expense;
    }

    @Override
    public List<Expense> getAll() {
        return expenses;
    }

  
}
