package zhitnik;

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
    public static void main(String[] args) {
        // Создаем новый блокнот
        Notebook notebook = new Notebook();

        // Перебираем все аргументы командной строки
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            switch (arg) {
                case "-add":
                    // Добавляем запись в блокнот
                    notebook.addNote(args[i+1], args[i+2]);
                    i += 2;
                    break;
                case "-rm":
                    // Удаляем запись из блокнота
                    notebook.removeNote(args[i+1]);
                    i++;
                    break;
                case "-show":
                    if (i + 1 < args.length && args[i+1].equals("interval")) {
                        // Фильтруем записи по временному интервалу и ключевым словам
                        LocalDateTime start = LocalDateTime.parse(args[i+2]);
                        LocalDateTime end = LocalDateTime.parse(args[i+3]);
                        String[] keywords = Arrays.copyOfRange(args, i+4, args.length);
                        List<Note> filteredNotes = notebook.getNotesInIntervalAndWithKeywords(start, end, keywords);
                        // Выводим отфильтрованные записи
                        for (Note note : filteredNotes) {
                            System.out.println(note.getTitle() + " - " + note.getContent());
                        }
                        i = args.length;
                    } else {
                        // Выводим все записи из блокнота
                        List<Note> allNotes = notebook.getAllNotes();
                        for (Note note : allNotes) {
                            System.out.println(note.getTitle() + " - " + note.getContent());
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
