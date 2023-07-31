package src.main.java.com.filmfinder.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Finder finder;
    private ArrayList<String> genres;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.finder = new Finder();
        this.genres = new ArrayList<>();
        genres.add("Drama");
        genres.add("Horror");
        genres.add("Crime");
        genres.add("Comedy");
        genres.add("Adventure");
        genres.add("Romance");
        genres.add("Action");
        genres.add("Documentary");
        genres.add("Sci-Fi");
        genres.add("Fantasy");
        genres.add("Animation");
    }

    public void start() {
        System.out.println("\nFILM FINDER V.1.0\n");
        System.out.println("type 'quit' at anytime to quit\ntype 'help' for instructions");

        while (true) {
            System.out.println("\nHow many movie suggestions would you like?");

            String numOfMovies = scanner.nextLine();
            int num = 0;

            if (numOfMovies.equals("quit")) {
                System.out.println("Bye bye!");
                break;
            } else if (numOfMovies.equals("help")) {
                String helpMessage = "\nFilm Finder is a movie selection tool, that provides random movie suggestions.";
                helpMessage += "\nFilm finder uses the non-commercial data provides by the IMDB movie database.";
                helpMessage += "\nThe prompts will guide you through filtering your movie suggestions, and you may leave";
                helpMessage += "\n an input empty or type 'any', if you dont want to filter based on the provides choice.";
                System.out.println(helpMessage);
            } else {
                try {
                    num = Integer.valueOf(numOfMovies);

                } catch (Exception e) {
                    System.out.println("\nTry a number...");
                }
            }
            System.out.println(
                    "\nWhat genre would you like?\ntype 'list' for available genres\ntype 'any' or hit enter for any genre");
            String genreChoice = scanner.nextLine();

            if (genreChoice.equals("any") || genreChoice.equals("")) {
                System.out.println("\nLoading...\n");
                List<String> movieTitles = finder.getRandomMovies(num);
                for (int i = 0; i < movieTitles.size(); i++) {
                    System.out.println((i + 1) + ". " + movieTitles.get(i));
                }

            } else if (genres.contains(genreChoice)) {
                System.out.println("\nLoading...\n");
                List<String> movieTitles = finder.getRandomMoviesOfGenre(num, genreChoice);
                for (int i = 0; i < movieTitles.size(); i++) {
                    System.out.println((i + 1) + ". " + movieTitles.get(i));
                }
            } else {
                System.out.println(genreChoice + " is not a recognized genre....");
            }

        }
    }

}
