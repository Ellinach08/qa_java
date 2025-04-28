import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Cat cat;
    private static final String EXCEPTION_MESSAGE = "Ожидаемое значение не соответствует фактическому";

    @Mock
    Feline feline;

    @Before
    public void setUp(){
        cat = new Cat(feline);
    }

    @Test
    public void getSoundTest() {
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals(EXCEPTION_MESSAGE,expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        cat.getFood();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        assertEquals(EXCEPTION_MESSAGE, expectedFood, actualFood);
    }
}