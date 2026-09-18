package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientTest {

    @ParameterizedTest
    @EnumSource(IngredientType.class)
    void getTypeReturnsIngredientType(IngredientType type) {
        Ingredient ingredient = new Ingredient(type, "hot sauce", 100.0f);
        assertEquals(type, ingredient.getType());
    }

    @ParameterizedTest
        @ValueSource(strings = {"hot sauce", "cutlet"})
        void getNameReturnsIngredientName(String name) {
            Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, 100.0f);
            assertEquals(name, ingredient.getName());
        }

        @ParameterizedTest
        @ValueSource(floats = {100.0f, 200.0f})
        void getPriceReturnsIngredientPrice(float price) {
            Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", price);
                    assertEquals(price, ingredient.getPrice(), 0.001);
        }

    }
