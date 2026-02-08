import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NpcTest {

    @Test
    void spawnNpc_shouldNotReturnNull() {
        GameCharacter npc = Npc.spawnNpc();
        assertNotNull(npc);
    }


    @Test
    void spawnNpc_hitPointsShouldBeInRange() {
        GameCharacter npc = Npc.spawnNpc();
        int hp = npc.getHitPoints();

        assertTrue(hp >= 40 && hp < 60,
                "Hit points should be between 40 and 59");
    }

    @Test
    void getName_shouldReturnEnemyTypeNotLiteralName() {
        Npc npc = (Npc) Npc.spawnNpc();
        String name = npc.getName();

        assertNotNull(name);
        assertNotEquals("Vietkong", name,
                "getName() should return enemyType, not constructor name");
    }
}
