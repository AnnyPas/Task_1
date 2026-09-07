package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BunTest {

    @Test
    void getNameAndPriceReturnsBunData() {
        Bun bun = new Bun("black bun", 100.0f);

        assertEquals("black bun", bun.getName());
        assertEquals(100.0f, bun.getPrice(), 0.001);
    }
}
