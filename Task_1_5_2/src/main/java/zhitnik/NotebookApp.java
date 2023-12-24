package zhitnik;

import org.apache.commons.cli.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Класс NotebookApp представляет собой приложение
 * для управления заметками в блокноте. Он предоставляет
 * основной метод взаимодействия с записной книжкой через
 * аргументы командной строки.
 */
public class NotebookApp {
    /**main void.*/
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("add", true, "Add a note to the notebook");
        options.addOption("rm", true, "Remove a note from the notebook");
        options.addOption("show", false, "Show notes in the notebook");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.err.println("Error parsing command line arguments: " + e.getMessage());
            System.exit(1);
            return;
        }

        Notebook notebook = loadNotebook(); // загрузить блокнот из файла

        if (cmd.hasOption("add")) {
            String[] addArgs = cmd.getOptionValues("add");
            notebook.addNote(addArgs[0], addArgs[1]);
            saveNotebook(notebook); // сохранить блокнот в файл
        } else if (cmd.hasOption("rm")) {
            String rmArg = cmd.getOptionValue("rm");
            notebook.removeNote(rmArg);
            saveNotebook(notebook); // сохранить блокнот в файл
        } else if (cmd.hasOption("show")) {
            String[] showArgs = cmd.getArgs();
            if (showArgs.length > 0 && showArgs[0].equals("interval")) {
                LocalDateTime start = LocalDateTime.parse(showArgs[1]);
                LocalDateTime end = LocalDateTime.parse(showArgs[2]);
                String[] keywords = Arrays.copyOfRange(showArgs, 3, showArgs.length);
                List<Note> filteredNotes = notebook.getNotesInIntervalAndWithKeywords(start, end, keywords);
                for (Note note : filteredNotes) {
                    System.out.println(note.getTitle() + " - " + note.getContent());
                }
            }
        }
    }

    private static final String FILE_PATH = "notebook.txt"; // Путь к файлу с записями блокнота

    private static Notebook loadNotebook() {
        File file = new File(FILE_PATH);
        Notebook notebook = new Notebook();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Разбиваем каждую строку на заголовок и текст заметки
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    notebook.addNote(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading notebook from file: " + e.getMessage());
        }
        return notebook;
    }

}
