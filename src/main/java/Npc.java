public class Npc extends GameCharacter{
    static Weapon vapen = new Weapon("fists",5);

    public Npc(String name, int hitPoints) {
        super(name, hitPoints,vapen);
    }

    public Npc(String name, int hitPoints,Weapon weapon) {
        super(name, hitPoints,weapon);
    }
}
