import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Cat cat;
    private static final String EXCEPTION_MESSAGE = "Ожидаемое значение не соответствует фактическому";

    @Mock
    Feline feline;

    @Test
    public void getSound() {
        cat = new Cat(feline);
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals(EXCEPTION_MESSAGE,expected, actual);
    }

    @Test
    public void getFood() throws Exception {
        cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }
}