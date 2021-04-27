package expensecounter;

import expensecounter.dao.FileExpenseDao;
import expensecounter.dao.FileUserDao;
import expensecounter.domain.Expense;
import expensecounter.domain.ExpenseCounterService;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private ExpenseCounterService expensecounter;

    private Scene expensesScene;
    private Scene loginScene;
    private Scene newUserScene;

    private VBox expenseNodes;
    private Label menuLabel = new Label();

    @Override
    public void init() throws Exception {
        Properties properties = new Properties();

        properties.load(new FileInputStream("config.properties"));

        String userFile = properties.getProperty("userFile");
        String expenseFile = properties.getProperty("expenseFile");

        FileUserDao userDao = new FileUserDao(userFile);
        FileExpenseDao expenseDao = new FileExpenseDao(expenseFile, userDao);
        expensecounter = new ExpenseCounterService(expenseDao, userDao);
    }
    
    public Node createExpenseNode(Expense expense){
        HBox box = new HBox(10);
        Label label = new Label(expense.getProduct());
        label.setMinHeight(28);
        Button button = new Button("ok");
        //Tähän tulee tuotteen hinnan lisäys ? 
     
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        box.setPadding(new Insets(0, 5, 0, 5));
        
        box.getChildren().addAll(label, spacer, button);
        return box;
    }
    
    public void redrawExpenseList() {
        expenseNodes.getChildren().clear();
        
        List<Expense> expenses = expensecounter.getExpenses();
        expenses.forEach(expense->{
            expenseNodes.getChildren().add(createExpenseNode(expense));
        });
    }

    @Override
    public void start(Stage stage) {

        //login Scene
        VBox loginPane = new VBox(10);
        HBox inputPane = new HBox(10);
        loginPane.setPadding(new Insets(10));
        Label loginLabel = new Label("username");
        TextField usernameInput = new TextField();

        inputPane.getChildren().addAll(loginLabel, usernameInput);
        Label loginMessage = new Label();

        Button loginButton = new Button("login");
        Button createButton = new Button("create new user");
        loginButton.setOnAction(e -> {
            String username = usernameInput.getText();
            menuLabel.setText(username + " logged in...");
            if (expensecounter.login(username)) {
                loginMessage.setText("Tervetuloa");
                stage.setScene(expensesScene);
                usernameInput.setText("");
            } else {
                loginMessage.setText("user does not exist");
                loginMessage.setTextFill(Color.BLUEVIOLET);
            }

        });
        createButton.setOnAction(e -> {
            usernameInput.setText("");
            stage.setScene(newUserScene);
        });

        loginPane.getChildren().addAll(loginMessage, inputPane, loginButton, createButton);

        loginScene = new Scene(loginPane, 300, 250);

        //new createNewUserScene
        VBox newUserPane = new VBox(10);

        HBox newUsernamePane = new HBox(10);
        newUsernamePane.setPadding(new Insets(10));
        TextField newUsernameInput = new TextField();
        Label newUsernameLabel = new Label("username");
        newUsernameLabel.setPrefWidth(100);
        newUsernamePane.getChildren().addAll(newUsernameLabel, newUsernameInput);

        HBox newNamePane = new HBox(10);
        newNamePane.setPadding(new Insets(10));
        TextField newNameInput = new TextField();
        Label newNameLabel = new Label("name");
        newNameLabel.setPrefWidth(100);
        newNamePane.getChildren().addAll(newNameLabel, newNameInput);

        Label userCreationMessage = new Label();

        Button createNewUserButton = new Button("create");
        createNewUserButton.setPadding(new Insets(10));

        createNewUserButton.setOnAction(e -> {
            String username = newUsernameInput.getText();
            String name = newNameInput.getText();

            if (username.length() == 2 || name.length() < 2) {
                userCreationMessage.setText("username or name too short");
                userCreationMessage.setTextFill(Color.BLUEVIOLET);
            } else if (expensecounter.createUser(username, name)) {
                userCreationMessage.setText("");
                loginMessage.setText("new user created");
                loginMessage.setTextFill(Color.GREEN);
                stage.setScene(loginScene);
            } else {
                userCreationMessage.setText("Username hast to be unique");
                userCreationMessage.setTextFill(Color.BLUEVIOLET);
            }

        });

        newUserPane.getChildren().addAll(userCreationMessage, newUsernamePane, newNamePane, createNewUserButton);

        newUserScene = new Scene(newUserPane, 300, 250);

        //main scene
        ScrollPane expenseScrollbar = new ScrollPane();
        BorderPane mainPane = new BorderPane(expenseScrollbar);
        expensesScene = new Scene(mainPane, 300, 250);

        HBox menuPane = new HBox(10);
        Region menuSpacer = new Region();
        HBox.setHgrow(menuSpacer, Priority.ALWAYS);
        Button logoutButton = new Button("logout");
        menuPane.getChildren().addAll(menuLabel, menuSpacer, logoutButton);
        logoutButton.setOnAction(e -> {
            expensecounter.logout();
            stage.setScene(loginScene);
        });

        HBox createForm = new HBox(10);
        Button createExpense = new Button("create");
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        TextField newExpenseInput = new TextField();
        createForm.getChildren().addAll(newExpenseInput, spacer, createExpense);

        expenseNodes = new VBox(10);
        expenseNodes.setMaxWidth(280);
        expenseNodes.setMinWidth(280);
        redrawExpenseList();

        expenseScrollbar.setContent(expenseNodes);
        mainPane.setBottom(createForm);
        mainPane.setTop(menuPane);

        createExpense.setOnAction(e -> {
            expensecounter.createExpense(newExpenseInput.getText());
            newExpenseInput.setText("");
            redrawExpenseList();
        });

        //setUp first stage
        stage.setTitle("Expenses");
        stage.setScene(loginScene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            System.out.println("closing");
            System.out.println(expensecounter.getLoggedUser());
            if (expensecounter.getLoggedUser() != null) {
                System.out.println("Tee jotain!");
            }
        });

    }

    @Override
    public void stop() {
        System.out.println("Sovellus sulkeutuu");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
