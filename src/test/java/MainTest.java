import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMain() {

        Weapon m4 = new Weapon("M4",20);

        assertEquals("M4", m4.getName());



        /*
        assertTrue(true);

        GameCharacter g = new GameCharacter("foo", 100);

        assertEquals("foo",g.getName());

        GameCharacter b = new GameCharacter("faa", 100);
        b.takeDamage(30);
        assertEquals(70, b.getHitPoints());
        */
    }


}