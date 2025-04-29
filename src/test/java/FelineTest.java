import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    private Feline feline;
    private static final String EXCEPTION_MESSAGE = "Ожидаемое значение не соответствует фактическому";

    @Test
    public void eatMeatTest() throws Exception {
        feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(EXCEPTION_MESSAGE, expectedFood, actualFood);
    }

    @Test
    public void getFamilyTest() {
        feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(EXCEPTION_MESSAGE, expectedFamily, actualFamily);
    }

    @Test
    public void getKittensTest() {
        feline = new Feline();
        int expectedKittensCount = 1;
        int actualKittensCount = feline.getKittens();
        assertEquals(EXCEPTION_MESSAGE, expectedKittensCount, actualKittensCount);
    }

    @Test
    public void getKittensCountTest() {
        feline = new Feline();
        int expectedKittensCount = 3;
        int actualKittensCount = feline.getKittens(3);
        assertEquals(EXCEPTION_MESSAGE, expectedKittensCount, actualKittensCount);
    }
}