package zhitnik;

import java.time.LocalDateTime;

/**
 * Класс Note представляет собой заметку в блокноте,
 * хранящую заголовок, содержимое и время создания.
 */
public class Note {
    private String title; // Заголовок заметки
    private String content; // Содержимое заметки
    private LocalDateTime creationTime; // Время создания заметки

    /**
     * Конструирует заметку с указанным заголовком, содержимым и временем создания.
     */
    public Note(String title, String content, LocalDateTime creationTime) {
        this.title = title;
        this.content = content;
        this.creationTime = creationTime;
    }

    /**
     * Возвращает заголовок заметки.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Возвращает содержимое заметки.
     */
    public String getContent() {
        return content;
    }

    /**
     * Возвращает время создания заметки.
     */
    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
