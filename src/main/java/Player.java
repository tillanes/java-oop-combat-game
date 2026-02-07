import java.io.Serializable;

public class Player  extends GameCharacter implements Serializable {



    public Player(String name, int hitPoints,Weapon weapon) {
        super(name, hitPoints,weapon);
        this.dexterity = 0.8;

    }
}
