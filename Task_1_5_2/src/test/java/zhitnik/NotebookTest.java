package zhitnik;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NotebookTest {
    @Test
    public void testAddNote() {
        Notebook notebook = new Notebook();
        notebook.addNote("AHAnote", "lalala");
        List<Note> notes = notebook.getAllNotes();
        assertEquals(1, notes.size());
    }

    @Test
    public void testAddAndRemoveNote() {
        Notebook notebook = new Notebook();
        notebook.addNote("SuperTitle", "aoaoaoaoa");
        notebook.addNote("MegaTitle", "hihihaha");
        assertEquals(2, notebook.getAllNotes().size());

        notebook.removeNote("SuperTitle");
        assertEquals(1, notebook.getAllNotes().size());
    }

    @Test
    public void testSerializeToJson() {
        Notebook notebook = new Notebook();
        notebook.addNote("Testovaya Nota 1", "SuperskiyContent 1");
        notebook.addNote("Testovaya Nota 2", "SuperskiyContent 2");
        notebook.serializeToJson("test.json");
    }
}