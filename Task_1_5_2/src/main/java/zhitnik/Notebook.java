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
     * Получает список заметок, созданных в указанный временной интервал и содержащих указанные ключевые слова.
     */
    public List<Note> getNotesInIntervalAndWithKeywords(LocalDateTime startTime, LocalDateTime endTime, String... keywords) {
        List<Note> filteredNotes = new ArrayList<>();
        for (Note note : notes) {
            if (note.getCreationTime().isAfter(startTime) &&
                    note.getCreationTime().isBefore(endTime) &&
                    containsKeywords(note, keywords)) {
                filteredNotes.add(note);
            }
        }
        return filteredNotes;
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

    private boolean containsKeywords(Note note, String... keywords) {
        for (String keyword : keywords) {
            if (note.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    note.getContent().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
