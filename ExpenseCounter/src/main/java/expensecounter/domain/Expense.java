package expensecounter.domain;

import static java.lang.Integer.parseInt;

/**
 * Luokka, jossa luodaan tuotteen tiedot eli meno.
 */
public class Expense {

    private int id;
    private String product;
    private String cost;
    private User user;

    public Expense(int id, String product, String cost, User user) {
        this.id = id;
        this.product = product;
        this.cost = cost;
        this.user = user;

    }

    public Expense(String product, User user) {
        this.product = product;
        this.user = user;
    }

    public Expense(String product, String cost, User user) {
        this.product = product;
        this.cost = cost;
        this.user = user;
    }
 /**
     *
     * Asettaa uuden id:n.
     *
     * @param id uusi id
     */
    public void setId(int id) {
        this.id = id;
    }
 /**
     *
     *Päivittää tuotteen.
     *
     * @param product uusi tuote
     */
    public void setProduct(String product) {
        this.product = product;
    }
 /**
     *
     * Asettaa tuotteelle uuden hinnan.
     *
     * @param cost uusi hinta/kulu
     */
    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getId() {
        return this.id;
    }

    public String getProduct() {
        return this.product;
    }
 /**
     *
     * Palauttaa merkkijonomuodossa tuotteen hinnan.
     *
     */
    public String getCost() {
        return this.cost;
    }
/**
     *
     * Palauttaa tuotteen hinnan int tyyppinä.
     *
     */
    public int getCostInt() {
        return parseInt(this.cost);
    }

    public User getUser() {
        return this.user;
    }

    @Override
    public String toString() {
        return product + ", " + cost;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Expense)) {
            return false;
        }
        Expense other = (Expense) o;
        return id == other.id;
    }

}
