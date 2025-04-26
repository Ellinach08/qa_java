import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class  LionTest {

    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private static final String EXCEPTION_SEX = "sexException";
    private static final String EXCEPTION_MESSAGE = "Используйте допустимые значения пола животного - самец или самка";
    private Lion lion;

    @Mock
    Feline feline;

    @Test
    public void getKittens() throws Exception {
        lion = new Lion(FEMALE, feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void getFood() throws Exception {
        lion = new Lion(MALE, feline);
        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }

    @Test
    public void haveManeThrowsException() {
        try {
            lion = new Lion(EXCEPTION_SEX, feline);
        } catch (Exception exception) {
            assertEquals(EXCEPTION_MESSAGE, exception.getMessage());
        }
    }
}