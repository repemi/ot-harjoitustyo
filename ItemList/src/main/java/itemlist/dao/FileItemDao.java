package itemlist.dao;

import itemlist.domain.Item;
import itemlist.domain.User;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Luokka, jossa käsitellään tuotteiden tiedostoon tallettamista.
 *
 */
public class FileItemDao implements ItemDao {

    public List<Item> items;
    private String file;

    public FileItemDao(String file, UserDao users) throws Exception {
        items = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                int id = Integer.parseInt(parts[0]);
                String product = parts[1];
                boolean check = Boolean.parseBoolean(parts[2]);
                User user = users.getAll().stream().filter(u -> u.getUsername().equals(parts[3])).findFirst().orElse(null);
                Item item = new Item(id, product, check, user);
                items.add(item);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    private void save() throws Exception {
        try ( FileWriter writer = new FileWriter(new File(file))) {
            for (Item item : items) {
                writer.write(item.getId() + ";" + item.getProduct() + ";" + item.isCheck() + ";" + item.getUser().getUsername() + "\n");
            }
        }
    }

    private int generateId() {
        return items.size() + 1;
    }

    @Override
    public List<Item> getAll() {
        return items;
    }

    @Override
    public Item create(Item expense) throws Exception {
        expense.setId(generateId());
        items.add(expense);
        save();
        return expense;
    }

    @Override
    public void setCheck(int id) throws Exception {
        for (Item item : items) {
            if (item.getId() == id) {
                item.setCheck();
            }
        }
        save();
    }

}
