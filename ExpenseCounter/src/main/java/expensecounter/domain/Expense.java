package expensecounter.domain;

public class Expense {

    private int id;
    private String product;
    private int cost;
    private User user;

    public Expense(int id, String product, int cost, User user) {
        this.id = id;
        this.product = product;
        this.cost = cost;
        this.user = user;

    }

    public Expense(String product, User user) {
        this.product = product;
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(String product) {

    }

    public void setCost(int cost) {

    }

    public int getId() {
        return this.id;
    }

    public String getProduct() {
        return this.product;
    }

    public int getCost() {
        return this.cost;
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
