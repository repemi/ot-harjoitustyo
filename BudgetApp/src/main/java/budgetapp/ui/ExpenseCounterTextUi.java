package budgetapp.ui;

import budgetapp.dao.FileExpenseDao;
import budgetapp.domain.Expense;
import budgetapp.domain.ExpenseCounterService;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.TreeMap;


public class ExpenseCounterTextUi {

    private Scanner reader;
    private Map<String, String> commands;
    private Expense expense;
//    private ArrayList<Expense> list;
    private ExpenseCounterService service;

    public ExpenseCounterTextUi(Scanner reader
    ) {
        this.reader = reader;
        commands = new TreeMap<>();
//        list = new ArrayList<>();
        service = new ExpenseCounterService(expense, reader);

        commands.put("x", "x lopeta");
        commands.put("1", "lisää meno");
        commands.put("2", "näytä lista menoista ja käytetystä rahasta");
        commands.put("3", "hae kaikkien menojen yhteenlaskettu summa");
        commands.put("4", "hae kaikki tuotteet mihin on mennyt rahaa");
        commands.put("5", "poista meno");
        commands.put("6", "tyhjentää listan");

    }

//    public void init() throws Exception {
//        Properties properties = new Properties();
//
//        properties.load(new FileInputStream("config.properties"));
//        String expenseFile = properties.getProperty("expenseFile");
//
//        FileExpenseDao expenseDao = new FileExpenseDao(expenseFile);
//
//    }
    public void start() {
        System.out.println("Menolaskuri");
        printManual();
        while (true) {
            System.out.println("Komento: ");
            String command = reader.nextLine();
            if (!commands.keySet().contains(command)) {
                System.out.println("Virhe, komentoa ei löydy !");
                printManual();
            }
            if (command.equals("x")) {
                System.out.println("Ohjelma päättyy, kiitos hei!");
                break;
            } else if (command.equals("1")) {
                addExpense();
            } else if (command.equals("2")) {
                getMenot();
            } else if (command.equals("3")) {
                getSumMenot();
            } else if (command.equals("4")) {
                getAllMenot();
            } else if (command.equals("5")) {
                removeMeno();
            } else if (command.equals("6")) {
                clearList();
            }
        }
    }

    private void printManual() {

        System.out.println("Näillä komennoilla käytät menolaskuria: ");
        System.out.println("x  - lopettaa");
        System.out.println("1  - lisää meno");
        System.out.println("2  - listaa kaikki menot");
        System.out.println("3  - kuinka paljon rahaa on käytetty");
        System.out.println("4  - mihin rahaa on käytetty");
        System.out.println("5  - poista meno listalta");
        System.out.println("6  - tyhjennä koko lista");
    }

    private void addExpense() {
        System.out.println("Mikä: ");
        String name = reader.nextLine();
        System.out.println("Summa: ");
        int sum = Integer.parseInt(reader.nextLine());
        Expense e = new Expense(name, sum);

        service.addExpense(e);

        //        list.add(e);
//        System.out.println("Lisätty onnistuneesti:");
//        System.out.println(e);
    }

    private void getMenot() {
        System.out.println("Listataan menot:");

        service.getMenot();
    }

    private void getSumMenot() {
        System.out.println("Rahaa kulunut yhteensä: ");

        service.getSumMenot();
    }

    private void getAllMenot() {
        System.out.println("Mihin tuotteisiin rahaa on kulunut: ");

        service.getAllMenot();
    }

    private void clearList() {
//        System.out.println("Oletko varma, että haluat tyhjentää listan ?");
//        System.out.println("Jos haluat, vastaa: kyllä");
//        String ans = reader.nextLine();
//        if (ans.equalsIgnoreCase("kyllä")) {
//            list.clear();
//            System.out.println("Lista on nyt tyhjennetty");
//        } else {
//            System.out.println("Listan tyhjennys peruttu.");
//        }
        service.clearList();

    }

    private void removeMeno() {
        System.out.println("Minkä haluat poistaa ?");
        String ans = reader.nextLine();

        service.removeMeno(ans);
    }
}
