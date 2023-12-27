package zhitnik;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывающий заметки в блокноте.
 */
public class Notebook {
    private List<Note> notes = new ArrayList<>();

    /**
     * Добавляет новую заметку в блокнот.
     */
    public void addNote(String title, String content) {
        notes.add(new Note(title, content, LocalDateTime.now()));
    }

    /**
     * Удаляет заметку из блокнота по названию.
     */
    public void removeNote(String title) {
        notes.removeIf(note -> note.getTitle().equals(title));
    }

    /**
     * Получает список всех заметок в отсортированном по времени создания порядке.
     */
    public List<Note> getAllNotes() {
        notes.sort((note1, note2) -> note1.getCreationTime().compareTo(note2.getCreationTime()));
        return notes;
    }

    /**
     * Сериализует объект блокнота в формат JSON и записывает его в файл.
     */
    public void serializeToJson(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(filePath), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}