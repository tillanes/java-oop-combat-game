import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

abstract public class GameCharacter implements Serializable {

    private String name;
    private int hitPoints,damage;
    private Weapon equippedWeapon;
    public Double dexterity;
    private ArrayList<Weapon> weapons;

    public GameCharacter(String name, int hitPoints, Weapon equippedWeapon) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.equippedWeapon = equippedWeapon;
        this.dexterity = 0.0;
        this.weapons = new ArrayList<>();
        this.weapons.add(equippedWeapon);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getHitPoints(){
        return hitPoints;
    }


    public String getEquippedWeapon() {
        return equippedWeapon.name;
    }



    Random random = new Random();
    public int attack(GameCharacter defender,Weapon weapon){

        double rand = random.nextDouble(dexterity, 1.0);
        int dmg = (int) (weapon.damage * rand);
        defender.hitPoints -= dmg;
        return dmg;
    }

    transient Scanner scanner = new Scanner(System.in);
    public int heal(){
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }

        int rand = random.nextInt(1,5);
        //System.out.println("random number"+rand);

        int x;
        while(true) {
            try {
                x = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                System.out.println("Guess a number between 1-4");
                scanner.next();
            }
        }
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
            return rand;

        }
    }

    public void setWeapons(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public String getWeapons() {
        if (weapons.isEmpty()) {
            return "Inventory ----\nNo weapons in inventory";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Inventory ----\n");
        for (int i = 0; i < weapons.size(); i++) {
            sb.append((i + 1)).append(" - ").append(weapons.get(i).name)
                    .append(" (").append(weapons.get(i).damage).append(")\n");
        }
        return sb.toString();
    }

    public int getInventorySize() {
        return weapons.size();
    }

    public Weapon chooseGun(int choice) {
        return weapons.get(choice -1);
    }

    public Weapon GetGun(){
        return equippedWeapon;
    }
}
