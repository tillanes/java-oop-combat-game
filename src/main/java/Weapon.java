import java.io.Serializable;

public class Weapon implements Serializable {
    String name;
    int damage;

    public Weapon(String name, int damage){
        this.name = name;
        this.damage = damage;
    }



    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return name + " : " + damage + " damage";
    }
}
