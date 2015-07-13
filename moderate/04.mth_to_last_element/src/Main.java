import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 0) {
            Scanner in = null;
            try {
                in = new Scanner(new File(args[0]));
                processFile(in);
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        } else {
            System.err.println("Error: no arguments specified");
        }
    }

    private static void processFile(Scanner in) {
        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            processLine(line);
        }

    }

    private static void processLine(String line) {
        String[] tokens = line.split("\\s+");

        int len = tokens.length - 1;
        int index = Integer.valueOf(tokens[len]);
        int pos = len - index;

        if (pos >= 0 && (pos < len) ) {
            System.out.println(tokens[pos]);
        }
    }
}