package itemlist.domain;

import static java.lang.Integer.parseInt;

/**
 * Luokka,joka kuvaa tavaraa/tuotetta pakkauslistalla.
 */
public class Item {

    private int id;
    private String product;
    private boolean check;
    private User user;

    public Item(int id, String product, boolean check, User user) {
        this.id = id;
        this.product = product;
        this.check = check;
        this.user = user;

    }

    public Item(String product, User user) {
        this.product = product;
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
     * Päivittää tuotteen.
     *
     * @param product uusi tuote
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * Palauttaan tuotteen id:n
     *
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     *
     * Palauttaa tuotteen.
     *
     */
    public String getProduct() {
        return this.product;
    }

    /**
     *
     * Palauttaa käyttäjän.
     *
     */
    public User getUser() {
        return this.user;
    }

    /**
     *
     * Palauttaa onko tuotteen tilan, jos pakattu niin true, muutoin false.
     *
     */
    public boolean isCheck() {
        return check;

    }

    /**
     *
     * Asettaa tuotteen pakatuksi.
     *
     */
    public void setCheck() {
        check = true;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Item)) {
            return false;
        }
        Item other = (Item) o;
        return id == other.id;
    }

}
