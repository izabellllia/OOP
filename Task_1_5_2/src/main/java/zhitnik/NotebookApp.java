package zhitnik;

/**Класс NotebookApp представляет собой приложение
 * для управления заметками в блокноте. Он предоставляет
 * основной метод взаимодействия с записной книжкой через
 * аргументы командной строки.
 */
import org.apache.commons.cli.*;

public class NotebookApp {
    public static void main(String[] args) {
        Options options = new Options();
        CommandLineParser parser = new DefaultParser();

        options.addOption("add", true, "Add a note to the notebook");
        options.addOption("rm", true, "Remove a note from the notebook");
        options.addOption("show", "Show notes");
        options.addOption("show_interval", true, "Show notes within a specific time interval");

        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("add")) {
                String[] addArgs = cmd.getOptionValues("add");
                System.out.println("notebook -add \"" + addArgs[0] + "\" \"" + addArgs[1] + "\"");
            } else if (cmd.hasOption("rm")) {
                String rmArg = cmd.getOptionValue("rm");
                System.out.println("notebook -rm \"" + rmArg + "\"");
            } else if (cmd.hasOption("show")) {
                System.out.println("notebook -show");
            } else if (cmd.hasOption("show_interval")) {
                String[] showIntervalArgs = cmd.getOptionValues("show_interval");
                System.out.print("notebook -show");
                for(String arg : showIntervalArgs){
                    System.out.print(" \"" + arg + "\"");
                }
                System.out.println();
            }
        } catch (ParseException e) {
            System.err.println("Error parsing command line arguments: " + e.getMessage());
            // Handle parsing exception
        }
    }
}