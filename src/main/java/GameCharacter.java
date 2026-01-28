abstract public class GameCharacter {

    String name;
    int hitPoints,damage;
    Weapon equippedWeapon;

    public GameCharacter(String name, int hitPoints, Weapon equippedWeapon) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.equippedWeapon = equippedWeapon;
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

    public String getEquippedWeapon() {
        return equippedWeapon.name;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public void attack(GameCharacter defender){
        defender.hitPoints -= equippedWeapon.damage;
    }
}
