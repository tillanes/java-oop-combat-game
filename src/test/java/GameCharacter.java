public class GameCharacter {

    String name;
    int hitPoints;

    public GameCharacter(String name, int hitPoints) {
        this.name = name;
        this.hitPoints = hitPoints;
    }

    public String getName(){
        return name;
    }

    public int getHitPoints(){
        return hitPoints;
    }

    public void takeDamage(int Damage){
        this.hitPoints -= Damage;

    }

}
