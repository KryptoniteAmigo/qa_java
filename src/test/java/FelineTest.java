import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkGetFamilyMethod() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        Assert.assertEquals("Семейство должно быть 'Кошачьи'", expected, actual);
    }

    @Test
    public void getFelineKittensNotNullTest() {
        int expected = 2;
        int actual = feline.getKittens(2);
        Assert.assertEquals("Метод выполнен с ошибкой", expected, actual);
    }

    @Test
    public void getFelineKittensWithNullTest() {
        int expected = 1;
        int actual = feline.getKittens();
        Assert.assertEquals("Метод выполнен с ошибкой", expected, actual);
    }

    @Test
    public void eatMeatFelineTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = feline.eatMeat();
        Assert.assertEquals("Метод eatMeat() вернул некорректный результат", expected, actual);
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}
