import com.example.Feline;
import com.example.Lion;
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
public class LionTest {
    private Lion lion;

    @Mock
    private Feline felineMock;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion("Самец", felineMock);
    }

    @Test
    public void getLionKittensTest() {
        int expected = 1;
        Mockito.when(felineMock.getKittens()).thenReturn(expected);
        int actual = lion.getKittens();
        Assert.assertEquals("Метод getKittens() вернул некорректное количество львят", expected, actual);
        Mockito.verify(felineMock,Mockito.times(1)).getKittens();
    }

    @Test
    public void getLionFoodTest() throws Exception {
        List<String> expected = List.of("Животные", "Птица", "Рыба");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();
        Assert.assertEquals("Метод getFood() вернул некорректный результат", expected, actual);
        Mockito.verify(felineMock,Mockito.times(1)).getFood("Хищник");
    }
}
