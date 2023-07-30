package src.main.java.com.filmfinder.app;

public class App {
    public static void main(String[] args) {
        // until the functionality is large enough, main method will be UI

        Finder finder = new Finder();

        System.out.println(finder.getRandomTitles(5));
        System.out.println(finder.getRandomMovies(5));
    }
}