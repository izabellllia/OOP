package zhitnik;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**The NotebookApp class provides
 *  an interactive command-line
 *  interface for managing notes in a notebook.*/
public class NotebookApp {
    private static final String FILE_NAME = "notebook.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final List<String> notes = new ArrayList<>(); // List to store notes

    /**main.*/
    public static void main(String[] args) {
        Options options = new Options();
        CommandLineParser parser = new DefaultParser();

        options.addOption("add", true, "Add a note to the notebook");
        options.addOption("rm", true, "Remove a note from the notebook");
        options.addOption("show", "Show notes");
        options.addOption("show_interval", true, "Show notes within a specific time interval");
        options.addOption("save", "Save notes to file");

        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("add")) {
                String[] addArgs = cmd.getOptionValues("add");
                String note = addArgs[0] + " - " + addArgs[1];
                notes.add(note);
            } else if (cmd.hasOption("rm")) {
                String rmArg = cmd.getOptionValue("rm");
                notes.remove(rmArg);
            } else if (cmd.hasOption("show")) {
                showNotes();
            } else if (cmd.hasOption("show_interval")) {
                String[] showIntervalArgs = cmd.getOptionValues("show_interval");
                System.out.println("Showing notes within the specified time interval:");
            } else if (cmd.hasOption("save")) {
                saveNotesToFile();
            }
        } catch (ParseException e) {
            System.err.println("Error parsing command line arguments: " + e.getMessage());
        }
    }

    private static void showNotes() {
        for (String note : notes) {
            System.out.println(note);
        }
    }

    private static void saveNotesToFile() {
        try {
            objectMapper.writeValue(new File(FILE_NAME), notes);
        } catch (IOException e) {
            System.err.println("Error saving notes to file: " + e.getMessage());
        }
    }
}
