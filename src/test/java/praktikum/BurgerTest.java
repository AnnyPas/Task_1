package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient sauce;
    private Ingredient filling;

    @BeforeEach
    void setUp() {
        burger = new Burger();

        bun = mock(Bun.class);
        sauce = mock(Ingredient.class);
        filling = mock(Ingredient.class);
    }

    @Test
    void setBunsSetsBun() {
        burger.setBuns(bun);

        assertSame(bun, burger.bun);
    }

    @Test
    void addIngredientAddsIngredient() {
        burger.addIngredient(sauce);

        assertEquals(List.of(sauce), burger.ingredients);
    }

    @Test
    void removeIngredientRemovesIngredientByIndex() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        burger.removeIngredient(0);

        assertEquals(List.of(filling), burger.ingredients);
    }

    @Test
    void moveIngredientMovesIngredientToNewIndex() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        burger.moveIngredient(0, 1);

        assertEquals(List.of(filling, sauce), burger.ingredients);
    }

    @Test
    void getPriceReturnsDoubleBunPricePlusIngredients() {
        when(bun.getPrice()).thenReturn(100.0f);
        when(sauce.getPrice()).thenReturn(20.0f);
        when(filling.getPrice()).thenReturn(30.0f);

        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        float expectedPrice = 250.0f;

        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }

    @Test
    void getReceiptReturnsFormattedReceipt() {
        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100.0f);

        when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        when(sauce.getName()).thenReturn("hot sauce");
        when(sauce.getPrice()).thenReturn(50.0f);

        burger.setBuns(bun);
        burger.addIngredient(sauce);

        String expectedReceipt = String.format(
                "(==== black bun ====)%n" +
                        "= sauce hot sauce =%n" +
                        "(==== black bun ====)%n" +
                        "%n" +
                        "Price: %f%n",
                250.0f
        );

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}