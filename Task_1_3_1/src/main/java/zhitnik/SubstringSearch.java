package zhitnik;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SubstringSearch {
    public static List<Integer> find(String filename, String substring) {
        List<Integer> indices = new ArrayList<>();
        InputStream resourceAsStream = SubstringSearch.class.getResourceAsStream(filename);
        if (resourceAsStream == null) {
            try {
                resourceAsStream = new FileInputStream(filename);
            } catch (FileNotFoundException e){
                System.err.println("Не удается найти файл " + filename);
                return indices;
            }
        }

        try (InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {
            int index = 0;
            char[] buffer = new char[1024];
            int bytesRead;
            while ((bytesRead = reader.read(buffer)) != -1) {
                String line = new String(buffer, 0, bytesRead);
                int lineIndex = line.indexOf(substring);
                int lineStartIndex = 0;
                while (lineIndex >= 0) {
                    indices.add(index + lineStartIndex + lineIndex);
                    lineIndex = line.indexOf(substring, lineIndex + 1);
                }
                index += bytesRead;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return indices;
    }
}
