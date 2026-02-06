import java.util.Random;

public class Npc extends GameCharacter{

    private static Random random = new Random();
    private static String[] guns = {"AK-47","MP5","Bamboo","fists","SKS","RPK","PPSh-41","M16","MAT-49"};
    private static String[] enemyTypes = {"Tunnel Fighter", "Jungle Ambusher", "Leaf-Covered Marksman",
            "Trench Defender","bamboo trap master","Village Defender"};

    private String enemyType;

    private Npc(String name, int hitPoints, Weapon weapon, String enemyType) {
        super(name, hitPoints, weapon);
        this.dexterity = 0.5;
        this.enemyType = enemyType;
    }

    private static Weapon createRandomWeapon() {
        int gunNum = random.nextInt(guns.length);
        int dmg = random.nextInt(5, 20);
        return new Weapon(guns[gunNum], dmg);
    }

    public static GameCharacter spawnNpc() {
        int enemyNum = random.nextInt(enemyTypes.length);
        String selectedEnemyType = enemyTypes[enemyNum];

        int hitPoints = random.nextInt(40, 60);
        Weapon weapon = createRandomWeapon();

        return new Npc("Vietkong", hitPoints, weapon, selectedEnemyType);
    }

    @Override
    public String getName() {
        return enemyType;
    }
}