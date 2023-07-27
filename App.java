import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String titleBasicsFile = "data/title.basics.tsv/data.tsv";

        ArrayList<String[]> basicsData = new ArrayList<>();
        // each String[] == one movie
        // [tconst, titleType, primaryTitle, orginalTitle, isAdult, startYear, endYear
        // runtimeMinutes, genres]

        try (Scanner scanner = new Scanner(Paths.get(titleBasicsFile))) {
            while (scanner.hasNextLine()) {
                System.out.println("file scanning");
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                basicsData.add(parts);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }

        // so the data may be too large, might have to trim it up
        // then start organizing the project into objects
        // yep
        System.out.println("ran");
        System.out.println(basicsData.get(0)[0]);
        System.out.println(basicsData.get(1)[0]);
    }
}