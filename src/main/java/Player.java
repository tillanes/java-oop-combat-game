public class Player extends GameCharacter{

    static Weapon vapen = new Weapon("fists",5);
    public Player(String name, int hitPoints){
        super(name, hitPoints,vapen);
    }

    public Player(String name, int hitPoints,Weapon weapon) {
        super(name, hitPoints,weapon);
    }
}
