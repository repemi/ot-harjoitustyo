/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetApp.dao;

import budgetApp.domain.Expense;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author erepo
 */
public class FileExpenseDao implements ExpenseDao {

    public List<Expense> expenses;
    private String file;

    public FileExpenseDao(String file) {
        expenses = new ArrayList<>();
        this.file = file;
        load();

    }

    private void load() {
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                Expense e = new Expense(parts[0], Integer.parseInt(parts[1]));
                expenses.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void save() {
        try {
            FileWriter writer = new FileWriter(new File(file));
            for (Expense expense : expenses) {
                writer.write(expense.getMeno() + ";" + expense.getSumma() + "\n");
            }
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Expense create(Expense expense) {
        expenses.add(expense);
        save();
        return expense;

    }

    @Override
    public List<Expense> getAll() {
        return expenses;
    }

}
