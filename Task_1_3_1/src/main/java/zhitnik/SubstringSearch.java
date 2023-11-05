package zhitnik;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import java.io.InputStreamReader;

/**основной класс, содержит метод find.*/
public class SubstringSearch {
    /**метод принимает имя файла и подстроку - возвращает
     * список целых чисел,которые представляют индексы
     * вхождений подстроки в файле.*/
    public static List<Integer> find(String filename, String substring) {
        /**создается пустой список, который будет содержать найденнын индексы.*/
        List<Integer> indices = new ArrayList<>();
        try (InputStream inputStream = SubstringSearch.class.getResourceAsStream(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            /**index - хранение текущего элемента,
             * line - для чтения каждой строки файла.*/
            int index = 0;
            String line;
            /**цикл чтения строк из файла.*/
            while ((line = reader.readLine()) != null) {
                int lineIndex = line.indexOf(substring);
                while (lineIndex >= 0) {
                    indices.add(index + lineIndex);
                    lineIndex = line.indexOf(substring, lineIndex + 1);
                }
                index += line.length();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return indices;
    }
}

