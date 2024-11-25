import com.example.LionAlex;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {
    private LionAlex lionAlex;

    @Mock
    private Feline felineMock;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lionAlex = new LionAlex(felineMock);
    }

    @Test
    public void getAlexLionFriendsTest() {
        List<String> expected = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
        List<String> actual = lionAlex.getFriends();
        Assert.assertEquals("Некорректный список друзей!", expected, actual);
    }

    @Test
    public void getAlexLionsPlaceOfLivingTest() {
        String expected = "Нью-Йоркский зоопарк";
        String actual = lionAlex.getPlaceOfLiving();
        Assert.assertEquals("Место проживания не совпадает с ожидаемым", expected, actual);
    }

    @Test
    public void getAlexLionKittensTest() {
        int expected = 0;
        int actual = lionAlex.getKittens();
        Assert.assertEquals("Неверное количество львят", expected, actual);
    }
}
