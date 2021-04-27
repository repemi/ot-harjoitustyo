
package expensecounter.domain;

public class User {
    
    private String name;
    private String username;
    
    public User(String name, String username){
        this.name = name;
        this.username = username;
    }
    
    public String getName(){
        return this.name;
    }
    public String getUsername(){
        return this.username;
    }
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof User)){
            return false;
        }
        
        User other = (User) o;
        return username.equals(other.username);
    }
            
    
}
