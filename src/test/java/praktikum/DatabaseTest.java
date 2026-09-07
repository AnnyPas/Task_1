package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabaseTest {

    @Test
    void availableBunsReturnsThreeBuns() {
        Database database = new Database();

        assertEquals(3, database.availableBuns().size());
    }

    @Test
    void availableIngredientsReturnsSixIngredients() {
        Database database = new Database();

        assertEquals(6, database.availableIngredients().size());
    }
}
