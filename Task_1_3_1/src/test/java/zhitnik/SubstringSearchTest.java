package zhitnik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

/**some tests.*/
public class SubstringSearchTest {

    @Test
    public void BasicTest() {
        List<Integer> indices = SubstringSearch.find("/Test1.txt", "бра");
        Assertions.assertEquals(2, indices.size());
        Assertions.assertEquals(1, (int) indices.get(0));
        Assertions.assertEquals(8, (int) indices.get(1));
    }

    @Test
    public void testFindLargeSubstring() {
        List<Integer> indices = SubstringSearch.find("/Test2.txt", "small");
        Assertions.assertEquals(4, indices.size());
        Assertions.assertEquals(6, (int) indices.get(0));
        Assertions.assertEquals(14, (int) indices.get(1));
        Assertions.assertEquals(24, (int) indices.get(2));
        Assertions.assertEquals(62, (int) indices.get(3));
    }
}
