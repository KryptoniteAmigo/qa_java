import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat cat;

    @Mock
    private Feline felineMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cat = new Cat(felineMock);
    }

    @Test
    public void getCatSound() {
        String expected = "Мяу";
        String actual = cat.getSound();
        Assert.assertEquals("Кошка издает другой звук!", expected, actual);
    }

    @Test
    public void getFoodMethodTest() throws Exception {
        List<String> expected = List.of("Животные", "Птица", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expected);
        List<String> actual = cat.getFood();
        Assert.assertEquals("Метод getFood() вернул некорректный результат", expected, actual);
        Mockito.verify(felineMock,Mockito.times(1)).eatMeat();
    }
}
