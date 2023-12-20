package zhitnik;

import java.util.List;
import org.junit.jupiter.api.Assertions;
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
}