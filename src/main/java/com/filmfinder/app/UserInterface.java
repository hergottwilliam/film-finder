package src.main.java.com.filmfinder.app;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Finder finder;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.finder = new Finder();
    }

    public void start() {
        System.out.println("\nFILM FINDER V.1.0\n");
        System.out.println("type 'quit' at anytime to quit\ntype 'help' for instructions");

        while (true) {
            System.out.println("\n>");

            String input = scanner.nextLine();

            if (input.equals("quit")) {
                System.out.println("Bye bye!");
                break;
            } else if (input.equals("help")) {
                String helpMessage = "\nFilm Finder is a movie selection tool, that provides random \nmovie suggestions. Type the number of random suggestions you would like.";
                helpMessage += "\nFilm finder uses the non-commercial data provides by the IMDB movie database.";
                System.out.println(helpMessage);
            } else {
                try {
                    int num = Integer.valueOf(input);
                    System.out.println("\nLoading...\n");

                    List<String> randomMovies = this.finder.getRandomMovies(Integer.valueOf(num));
                    System.out.println("\nHere are your movie suggestions:\n");

                    for (int i = 0; i < randomMovies.size(); i++) {
                        System.out.println((i + 1) + ". " + randomMovies.get(i));
                    }
                } catch (Exception e) {
                    System.out.println("\nTry a number...");
                }
            }
        }
    }

}
