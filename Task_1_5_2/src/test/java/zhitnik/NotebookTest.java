package zhitnik;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**super-cool-tests.*/
public class NotebookTest {
    @Test
    public void testAddNote() {
        Notebook notebook = new Notebook();
        notebook.addNote("AHAnote", "lalala");
        List<Note> notes = notebook.getAllNotes();
        Assertions.assertEquals(1, notes.size());
    }

    @Test
    public void testAddAndRemoveNote() {
        Notebook notebook = new Notebook();
        notebook.addNote("SuperTitle", "aoaoaoaoa");
        notebook.addNote("MegaTitle", "hihihaha");
        Assertions.assertEquals(2, notebook.getAllNotes().size());

        notebook.removeNote("SuperTitle");
        Assertions.assertEquals(1, notebook.getAllNotes().size());
    }

    @Test
    public void testSerializeToJson() {
        Notebook notebook = new Notebook();
        notebook.addNote("Testovaya Nota 1", "SuperskiyContent 1");
        notebook.addNote("Testovaya Nota 2", "SuperskiyContent 2");
        notebook.serializeToJson("test.json");
    }

    private Notebook notebook;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @BeforeEach
    void setUp() {
        notebook = new Notebook();
        notebook.addNote("Заголовок 1", "Содержание 1");
        notebook.addNote("Заголовок 2", "Содержание 2");
        startTime = LocalDateTime.of(2022, 1, 1, 0, 0);
        endTime = LocalDateTime.of(2022, 12, 31, 23, 59);
    }

    @Test
    void addNote() {
        Assertions.assertEquals(2, notebook.getAllNotes().size());
        notebook.addNote("Новая заметка", "Новое содержание");
        Assertions.assertEquals(3, notebook.getAllNotes().size());
    }

    @Test
    void removeNote() {
        Assertions.assertEquals(2, notebook.getAllNotes().size());
        notebook.removeNote("Заголовок 1");
        Assertions.assertEquals(1, notebook.getAllNotes().size());
    }

    @Test
    void getAllNotes() {
        List<Note> notes = notebook.getAllNotes();
        Assertions.assertEquals(2, notes.size());
        Assertions.assertEquals("Заголовок 1", notes.get(0).getTitle());
        Assertions.assertEquals("Содержание 2", notes.get(1).getContent());
    }

    @Test
    public void testGetAllNotes() {
        Notebook notebook = new Notebook();
        notebook.addNote("Title1", "Content1");
        notebook.addNote("Title2", "Content2");
        Assertions.assertEquals(2, notebook.getAllNotes().size());
    }

    @Test
    public void testSerializeToJson2() {
        Notebook notebook = new Notebook();
        notebook.addNote("Title1", "Content1");
        notebook.serializeToJson("testFile.json");
        File file = new File("testFile.json");
        Assertions.assertTrue(file.exists());
    }
}