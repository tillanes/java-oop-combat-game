import java.util.Random;

public class Npc extends GameCharacter{

    private static Random random = new Random();
    private static String[] guns = {"AK-47","MP5","Bamboo","fists","SKS","RPK","PPSh-41","M16","MAT-49"};
    private String[] enemyTypes = {"Tunnel Fighter", "Jungle Ambusher", "Leaf-Covered Marksman", "Trench Defender","bamboo trap master","Village Defender"};

    private String enemyType;

    public Npc(String name, int hitPoints) {
        super(name, hitPoints, createRandomWeapon());
        this.dexterity = 0.5;


        int enemyNum = random.nextInt(enemyTypes.length);
        this.enemyType = enemyTypes[enemyNum];
    }

    private static Weapon createRandomWeapon() {
        int gunNum = random.nextInt(guns.length);
        int dmg = random.nextInt(5, 20);
        return new Weapon(guns[gunNum], dmg);
    }

    @Override
    public String getName() {
        return enemyType;
    }
}