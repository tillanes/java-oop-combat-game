import java.util.Random;
import java.util.Scanner;

abstract public class GameCharacter {

    private String name;
    private int hitPoints,damage;
    private Weapon equippedWeapon;
    public Double dexterity;

    public GameCharacter(String name, int hitPoints, Weapon equippedWeapon) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.equippedWeapon = equippedWeapon;
        this.dexterity = 0.0;
    }

    public String getName(){
        return name;
    }

    private void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
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

    Random random = new Random();
    public int attack(GameCharacter defender){
        double rand = random.nextDouble(dexterity, 1.0);
        int dmg = (int) (equippedWeapon.damage * rand);
        defender.hitPoints -= dmg;
        return dmg;
    }

    Scanner scanner = new Scanner(System.in);
    public int heal(){
        int rand = random.nextInt(1,5);
        //System.out.println("random number"+rand);
        int x = scanner.nextInt();

        if (x == rand){
                int currentHealth = getHitPoints();
                int randValue = random.nextInt(50,101);
                currentHealth += randValue;

                if(currentHealth > 100) currentHealth = 100;
                setHitPoints(currentHealth);
                return 0;
        }
        else
        {
            return 1;

        }
    }



}
