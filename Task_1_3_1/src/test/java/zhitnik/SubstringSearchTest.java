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
    private static final String BIG_FILE = "src/test/java/zhitnik/Test3.txt";
    private static final String CONTENT = "content";
    private static final int REPETITIONS = 10;
    private static final int CHUNK_SIZE = 1024 * 1024; // 1 MB
    private static final long FILE_SIZE = 1024L * 1024L * 1024L; // 1 GB

    private Path filePath;

    @BeforeEach
    public void setUp() {
        try {
            filePath = Paths.get(BIG_FILE);
            try (FileChannel fileChannel = FileChannel.open(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
                ByteBuffer buffer = ByteBuffer.allocate(CHUNK_SIZE);
                while (Files.size(filePath) < FILE_SIZE) {
                    for (int i = 0; i < REPETITIONS; i++) {
                        buffer.put(CONTENT.getBytes(StandardCharsets.UTF_8));
                    }
                    buffer.flip();
                    fileChannel.write(buffer);
                    buffer.clear();
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            fail("Failed to set up the test due to IOException: " + e.getMessage());
        }
    }

    @Test
    public void find() {
        List<Integer> indices = SubstringSearch.find(BIG_FILE, "content");
        assertNotNull(indices);
        assertTrue(indices.size() > 0);
    }

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
