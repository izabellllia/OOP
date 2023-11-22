package zhitnik;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubstringSearchTest {

    @Test
    public void basicTest() {
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
