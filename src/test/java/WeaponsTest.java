import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeaponsTest {

    @Test
    void testWeapons() {
        Weapon m4 = new Weapon("M4",20);

        assertEquals("M4", m4.getName());

    }
}
