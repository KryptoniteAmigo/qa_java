import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private final boolean hasMane;

    public LionParameterizedTest(String sex, boolean hasMane) {
        this.hasMane = hasMane;
        this.sex = sex;
    }

    @Parameterized.Parameters(name = "Пол: {0}, наличие гривы: {1}")
    public static Object[][] getData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
                {"Другое", false}
        };
    }

    @Test
    public void lionHasManeTest() {
        final String exceptionText = "Используйте допустимые значения пола животного - самей или самка";
        try {
            Feline felineMock = Mockito.mock(Feline.class);
            Lion lion = new Lion(sex, felineMock);
            Assert.assertEquals("Ошибка в методе проверки наличия гривы", hasMane, lion.doesHaveMane());
        } catch (Exception e) {
            if ("Другое".equals(sex)) {
                Assert.assertEquals("Сообщение исключения некорректно", exceptionText, e.getMessage());
            } else {
                Assert.fail("Исключение не ожидалось для значения: " + sex);
            }
        }
    }

}
