import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionManeParameterizedTest {

    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private Lion lion;
    private final String sex;
    private final boolean hasMane;
    private static final String EXCEPTION_MESSAGE = "Ожидаемое значение не соответствует фактическому";

    public LionManeParameterizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Mock
    Feline feline;

    @Parameterized.Parameters()
    public static Object[][] getData() {
        return new Object[][]{
                {MALE, true},
                {FEMALE, false}
        };
    }

    @Test
    public void haveManeTest() throws Exception {
        lion = new Lion(sex, feline);
        assertEquals(EXCEPTION_MESSAGE, hasMane, lion.doesHaveMane());
    }
}