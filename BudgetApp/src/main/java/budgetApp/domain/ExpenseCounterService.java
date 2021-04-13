package budgetApp.domain;

import budgetApp.dao.FileExpenseDao;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class ExpenseCounterService {

    private Expense expense;
    private ArrayList<Expense> list;
    private Scanner reader;

    public ExpenseCounterService(Scanner reader){
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

    public void addExpense() {
        System.out.println("Mikä: ");
        String name = reader.nextLine();
        System.out.println("Summa: ");
        int sum = Integer.parseInt(reader.nextLine());
        Expense e = new Expense(name, sum);
        list.add(e);
        System.out.println("Lisätty onnistuneesti:");
        System.out.println(e);

    }

    public void getMenot() {
        System.out.println("Listataan menot:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    public void getSumMenot() {
        System.out.println("Rahaa kulunut: ");
        int sumOfAll = 0;
        for (int i = 0; i < list.size(); i++) {
            sumOfAll += list.get(i).getSumma();
        }
        System.out.println(sumOfAll);
    }

    public void getAllMenot() {
        System.out.println("Mihin rahaa on kulunut: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getMeno());
        }
    }

    public void clearList() {
        System.out.println("Lista on tyhjennetty");
        list.clear();
//        System.out.println("Oletko varma, että haluat tyhjentää listan ?");
//        System.out.println("Jos haluat, vastaa: kyllä");
//        String ans = reader.nextLine();
//        if (ans.equals("kyllä")) {
//            list.clear();
//            System.out.println("Lista on nyt tyhjennetty");
//        } else {
//            System.out.println("Listan tyhjennys peruttu.");
//        }

    }

    public void removeMeno() {
        System.out.println("Minkä haluat poistaa ?");
        String ans = reader.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMeno().equalsIgnoreCase(ans)) {
                list.remove(i);
            }
        }
    }
}
