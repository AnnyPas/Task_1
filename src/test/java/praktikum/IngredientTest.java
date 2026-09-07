package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientTest {

    @ParameterizedTest
    @CsvSource({
            "SAUCE, hot sauce, 100.0",
            "FILLING, cutlet, 200.0"
    })
    void getIngredientDataReturnsCorrectValues(
            IngredientType type,
            String name,
            float price
    ) {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.001);
    }
}