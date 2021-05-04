package expensecounter.domain;

/**
 * Luokka, jossa on käyttäjää koskevat tiedot.
 */
public class User {

    private String name;
    private String username;

    public User(String name, String username) {
        this.name = name;
        this.username = username;
    }

     /**
     *
     * Palauttaa rekisteröityneen käyttäjän nimen.
     *
     * 
     */
    public String getName() {
        return this.name;
    }

     /**
     *
     * Palauttaa rekisteröityneen käyttäjän (käyttäjä)tunnuksen.
     *
     *
     */
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) {
            return false;
        }

        User other = (User) o;
        return username.equals(other.username);
    }

}
