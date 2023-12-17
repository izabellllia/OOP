import com.fasterxml.jackson.databind.ObjectMapper;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

class Note {
    String text;
    LocalDateTime time;

    public Note(String text, LocalDateTime time) {
        this.text = text;
        this.time = time;
    }
}

public class Notebook {
    @Parameter(names = "-add")
    private List<String> addNotes = new ArrayList<>();

    @Parameter(names = "-rm")
    private List<String> removeNotes = new ArrayList<>();

    @Parameter(names = "-show")
    private List<String> showArgs = new ArrayList<>();

    private List<Note> notes;

    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        JCommander.newBuilder()
                .addObject(notebook)
                .build()
                .parse(args);
        notebook.run();
    }

    public void run() {
        // Десериализация записей из файла или создание новой записной книжки, если файла нет
        notes = readNotesFromFile("notes.json");

        if (!addNotes.isEmpty()) {
            String noteText = addNotes.get(0);
            LocalDate noteDate = LocalDate.now();
            if (addNotes.size() > 1) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                noteDate = LocalDateTime.parse(addNotes.get(1), formatter);
            }
            notes.add(new Note(noteText, noteDate));
            System.out.println("Запись добавлена: " + noteText);
        }

        if (!removeNotes.isEmpty()) {
            String noteToRemove = removeNotes.get(0);
            notes.removeIf(note -> note.text.equals(noteToRemove));
            System.out.println("Запись удалена: " + noteToRemove);
        }

        if (!showArgs.isEmpty()) {
            if (showArgs.size() == 2) {
                List<Note> filteredNotes = getNotesInTimeInterval(showArgs.get(0), showArgs.get(1));
                filteredNotes.forEach(note -> System.out.println(note.text + " - " + note.time));
            } else {
                // Вывести все записи, отсортированные по времени добавления
                notes.stream()
                        .sorted(Comparator.comparing(note -> note.time))
                        .forEach(note -> System.out.println(note.text + " - " + note.time));
            }
        }

        saveNotesToFile("notes.json", notes);
    }

    private List<Note> getNotesInTimeInterval(String startStr, String endStr) {
        LocalDateTime start = LocalDateTime.parse(startStr, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        LocalDateTime end = LocalDateTime.parse(endStr, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        String[] keywords = Arrays.copyOfRange(showArgs.toArray(new String[0]), 2, showArgs.size());

        return notes.stream()
                .filter(note -> note.time.isAfter(start) && note.time.isBefore(end))
                .filter(note -> Arrays.stream(keywords).anyMatch(note.text::contains))
                .sorted(Comparator.comparing(note -> note.time))
                .collect(Collectors.toList());
    }

    private List<Note> readNotesFromFile(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(fileName);
        if (file.exists()) {
            try {
                return Arrays.asList(objectMapper.readValue(file, Note[].class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    private void saveNotesToFile(String fileName, List<Note> notes) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(fileName), notes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
