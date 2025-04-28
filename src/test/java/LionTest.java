import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class  LionTest {

    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private static final String EXCEPTION_SEX = "sexException";
    private static final String EXCEPTION_MESSAGE = "Используйте допустимые значения пола животного - самец или самка";
    private static final String EXCEPTION_MESSAGE_ACTUAL = "Ожидаемое значение не соответствует фактическому";
    private Lion lion;

    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        lion = new Lion(FEMALE, feline);
        Mockito.when(feline.getKittens()).thenReturn(5);
        int actualKittensCount = lion.getKittens();
        int expectedKittensCount = 5;
        assertEquals(EXCEPTION_MESSAGE_ACTUAL, expectedKittensCount, actualKittensCount);
    }

    @Test
    public void getFoodTest() throws Exception {
        lion = new Lion(MALE, feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(EXCEPTION_MESSAGE_ACTUAL, expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void LionSexTest() throws Exception {
        lion = new Lion(EXCEPTION_SEX, feline);
    }
}