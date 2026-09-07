package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IngredientTypeTest {

    @Test
    void ingredientTypeContainsExpectedValues() {
        IngredientType[] expected = {
                IngredientType.SAUCE,
                IngredientType.FILLING
        };

        assertArrayEquals(expected, IngredientType.values());
    }
}