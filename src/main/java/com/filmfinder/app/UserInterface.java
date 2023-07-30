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
        System.out.println("\nFILM FINDER V.1\ntype 'quit' at anytime to quit program\n");

        while (true) {
            System.out.println("What would you like to watch? (show/movie)");
            String input = scanner.nextLine();
            if (input.equals("movie")) {
                this.movieMenu();

            } else if (input.equals("show")) {

            } else if (input.equals("quit")) {
                System.out.println("Bye bye!");
                return;
            } else {
                System.out.println(input + " is not a recognized command.");
            }
        }
    }

    public void movieMenu() {
        System.out.println("\nMOVIES\ntype 'quit' to return to main menu\n");
        while (true) {
            System.out.println("\nHow many movie suggestions would you like?");
            String input = scanner.nextLine();
            if (input.equals("quit")) {
                return;
            } else if (Integer.valueOf(input) > 0) {
                System.out.println("\nHere are your movie suggestions:\n");
                List<String> randomMovies = this.finder.getRandomMovies(Integer.valueOf(input));
                for (int i = 0; i < randomMovies.size(); i++) {
                    System.out.println(i + ". " + randomMovies.get(i));
                }
            } else {
                System.out.println(input + " is not a valid command.");
            }
        }
    }
}
