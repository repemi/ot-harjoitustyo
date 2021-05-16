package itemlist.ui;

import itemlist.dao.FileItemDao;
import itemlist.dao.FileUserDao;
import itemlist.domain.Item;
import itemlist.domain.ItemList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Luokka, jossa on sovelluksen käyttöliittymä. JavaFX App
 */
public class App extends Application {

    private ItemList itemList;

    private Scene itemListScene;
    private Scene loginScene;
    private Scene newUserScene;

    private VBox itemNode;
    private Label menuLabel = new Label();
    private Label loginMessage = new Label();
    private Text packedItem = new Text();

    /**
     * Lataa tiedostot, joihin talletetaan syötteitä.
     *
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        Properties properties = new Properties();

        properties.load(new FileInputStream("config.properties"));

        String userFile = properties.getProperty("userFile");
        String itemFile = properties.getProperty("itemFile");

        FileUserDao userDao = new FileUserDao(userFile);
        FileItemDao itemDao = new FileItemDao(itemFile, userDao);
        itemList = new ItemList(itemDao, userDao);
    }

    /**
     * Luo jokaiselle tuotteelle oman napin, josta tuotteen voi kuitata
     * pakatuksi.
     *
     * @param item
     * @return
     */
    public Node createItemNode(Item item) {
        HBox box = new HBox(10);
        Label label = new Label(item.getProduct());
        label.setMinHeight(28);
        Image check = new Image("file:check.png", 20, 20, false, false);

        Button button = new Button();
        button.setGraphic(new ImageView(check));
        button.setMaxSize(10, 10);

        button.setOnAction(e -> {
            itemList.packed(item.getId());
            redrawItemList();
        });

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        box.setPadding(new Insets(0, 5, 0, 5));

        box.getChildren().addAll(label, spacer, button);
        return box;
    }

    /**
     * Listaa tuotteet, jotka ovat vielä pakkaamatta.
     */
    public void redrawItemList() {
        itemNode.getChildren().clear();

        List<Item> unPackedItems = itemList.unPacked();
        unPackedItems.forEach(item -> {
            itemNode.getChildren().add(createItemNode(item));
        });

    }

    /**
     * Kirjautumisnäkymä.
     *
     * @param stage
     */
    public void login(Stage stage) {
        //login Scene
        BorderPane border = new BorderPane();
        VBox loginPane = new VBox(10);
        HBox inputPane = new HBox(10);
        loginPane.setPadding(new Insets(10));
        Label loginLabel = new Label("Tunnus:");
        loginLabel.setTextFill(Color.WHITE);

        TextField usernameInput = new TextField();

        inputPane.getChildren().addAll(loginLabel, usernameInput);
        border.setLeft(loginPane);

        Button loginButton = new Button("Kirjaudu");
        Button createButton = new Button("Luo uusi käyttäjä");
        loginButton.setOnAction(e -> {
            String username = usernameInput.getText();
            
            menuLabel.setText( "Tervetuloa " + username + " !");
            if (itemList.login(username)) {
                loginMessage.setText("Tervetuloa");
                stage.setScene(itemListScene);
                usernameInput.setText("");
                redrawItemList();
            } else {
                loginMessage.setText("Käyttäjää ei löydy");
                loginMessage.setTextFill(Color.YELLOW);
            }

        });
        createButton.setOnAction(e -> {
            usernameInput.setText("");
            stage.setScene(newUserScene);
        });

        loginPane.getChildren().addAll(loginMessage, inputPane, loginButton, createButton);

        Image backgroundImage = new Image("file:luggage.jpg");
        BackgroundImage bImage = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background bground = new Background(bImage);
        border.setBackground(bground);
        loginScene = new Scene(border, 400, 300);

    }

    /**
     * Sovelluksen uusi käyttäjä näkymä.
     *
     * @param stage
     */
    public void createNewUserScene(Stage stage) {
        //create new user
        VBox newUserPane = new VBox(10);
        BorderPane border = new BorderPane();
        border.setLeft(newUserPane);

        HBox newUsernamePane = new HBox(10);
        newUsernamePane.setPadding(new Insets(10));
        TextField newUsernameInput = new TextField();
        Label newUsernameLabel = new Label("Tunnus:");
        newUsernameLabel.setTextFill(Color.WHITE);
        newUsernameLabel.setPrefWidth(100);
        newUsernamePane.getChildren().addAll(newUsernameLabel, newUsernameInput);

        HBox newNamePane = new HBox(10);
        newNamePane.setPadding(new Insets(10));
        TextField newNameInput = new TextField();
        Label newNameLabel = new Label("Nimi:");
        newNameLabel.setTextFill(Color.WHITE);
        newNameLabel.setPrefWidth(100);
        newNamePane.getChildren().addAll(newNameLabel, newNameInput);

        Label userCreationMessage = new Label();

        Button createNewUserButton = new Button("Luo");
        createNewUserButton.setPadding(new Insets(10));

        createNewUserButton.setOnAction(e -> {
            String username = newUsernameInput.getText();
            String name = newNameInput.getText();

            if (username.length() == 2 || name.length() < 2) {
                userCreationMessage.setText("Käyttäjätunnus tai nimen pituus on liian lyhyt");
                userCreationMessage.setTextFill(Color.YELLOW);
            } else if (itemList.createUser(username, name)) {
                userCreationMessage.setText("");
                loginMessage.setText("Uusi käyttäjä luotu onnistuneesti, nyt voit kirjautua sisään");
                loginMessage.setTextFill(Color.WHITE);
                stage.setScene(loginScene);
            } else {
                userCreationMessage.setText("Tunnus on jo käytössä kokeile toista.");
                userCreationMessage.setTextFill(Color.YELLOW);
            }

        });

        newUserPane.getChildren().addAll(userCreationMessage, newUsernamePane, newNamePane, createNewUserButton);
        Image backgroundImage = new Image("file:luggage.jpg");
        BackgroundImage bImage = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background bground = new Background(bImage);
        border.setBackground(bground);
        newUserScene = new Scene(border, 400, 300);

    }

    /**
     * Luo sovelluksen pakkauslista näkymän.
     *
     * @param stage
     */
    public void mainScene(Stage stage) {
        //main
        ScrollPane itemScrollBar = new ScrollPane();
        BorderPane mainPane = new BorderPane(itemScrollBar);

        itemListScene = new Scene(mainPane, 400, 500);

        HBox menuPane = new HBox(10);
        Region menuSpacer = new Region();
        HBox.setHgrow(menuSpacer, Priority.ALWAYS);
        Button logoutButton = new Button("Kirjaudu ulos");
        menuPane.getChildren().addAll(menuLabel, menuSpacer, logoutButton);
        logoutButton.setOnAction(e -> {
            itemList.logout();
            stage.setScene(loginScene);
        });

        HBox createForm = new HBox(10);
        Button createItem = new Button("Lisää");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        TextField newItemInput = new TextField();

        createForm.getChildren().addAll(newItemInput, spacer, createItem);

        itemNode = new VBox(10);
        itemNode.setMaxWidth(280);
        itemNode.setMinWidth(280);
        redrawItemList();

        itemScrollBar.setContent(itemNode);
        mainPane.setBottom(createForm);
        mainPane.setTop(menuPane);

        createItem.setOnAction(e -> {
            itemList.createItem(newItemInput.getText());
            newItemInput.setText("");
            redrawItemList();
        });
    }

    /**
     * Sovelluksen pohja.
     *
     * @param stage
     */
    public void setUpFirstStage(Stage stage) {
        //setUp first stage
        stage.setTitle("Pakkauslista");

        stage.setScene(loginScene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            System.out.println("suljetaan");
            System.out.println(itemList.getLoggedUser());
            if (itemList.getLoggedUser() != null) {
                System.out.println("Sovelluksen saat suljettua, kun kirjaudut ulos ja klikkaat: x");
                e.consume();

            }
        });
    }

    /**
     * Sovelluksen käynnistäminen.
     *
     * @param stage
     */
    @Override
    public void start(Stage stage) {

        login(stage);
        createNewUserScene(stage);
        mainScene(stage);
        setUpFirstStage(stage);

    }

    /**
     * Sovelluksen sulkeutuminen.
     */
    @Override
    public void stop() {
        System.out.println("Sovellus sulkeutuu");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
