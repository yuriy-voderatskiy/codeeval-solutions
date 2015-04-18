import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if(args.length != 0) {
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
        int cnt = in.nextInt();

        Map<Integer, String> linesMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            linesMap.put(line.length(), line);
        }

        Iterator<String> iter = linesMap.values().iterator();

        while (cnt > 0) {
            System.out.println(iter.next());
            cnt--;
        }
    }
}
