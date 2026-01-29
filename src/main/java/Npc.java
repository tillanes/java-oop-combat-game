import java.util.Random;

public class Npc extends GameCharacter{

    private static Random random = new Random();
    private static String[] guns = {"AK-47","MP5","Bamboo","fists","SKS","RPK"};

    public Npc(String name, int hitPoints) {
        super(name, hitPoints, createRandomWeapon());
        this.dexterity = 0.5;
    }

    private static Weapon createRandomWeapon() {
        int gunNum = random.nextInt(guns.length);
        int dmg = random.nextInt(5, 20);
        return new Weapon(guns[gunNum], dmg);
    }
}