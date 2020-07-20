import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

class LetterGame
{
    private String listFilePath;
    private String header;
    private int wrongMax;

    private String solutionString;
    private StringPuzzle puzzle;
    private Set<Character> wrongChars;

    /**
     * Constructor.
     */
    public LetterGame(String listFilePath, String header, int wrongMax)
    {
        this.listFilePath = listFilePath;
        this.header = header;
        this.wrongMax = wrongMax;

        this.solutionString = getStringFromList();
        this.puzzle = new StringPuzzle(solutionString);
        this.wrongChars = puzzle.getWrongChars();
    }

    /**
     * Start the game.
     */
    public void start()
    {
        while (true) {
            clearScreen();

            System.out.println("**" + header + "**");
            System.out.println(puzzle.getCurrentString());

            showWrongChars();

            if (puzzle.isSolved() || wrongChars.size() >= wrongMax) break;

            tryChars();
        }
    }

    /**
     * Print the list of incorrect chars.
     */
    public void showWrongChars()
    {
        if (wrongChars.size() == 0) return;

        String wrong = String.format(
            "Wrong: %s of %s %s",
            wrongChars.size(),
            wrongMax,
            wrongChars.toString()
            );

        System.out.println(wrong);
    }

    /**
     * Prompt for character guesses.
     */
    public void tryChars()
    {
        char[] chars = promptChars();

        for (int i = 0; i < chars.length; i++) {
            puzzle.tryChar(chars[i]);
        }
    }

    /**
     * End the game.
     */
    public void end()
    {
        if (puzzle.isSolved()) {
            System.out.println("Correct!");
        } else {
            System.out.println("Too many guesses!");
        }

        System.out.println("The answer is: " + solutionString);
    }

    /**
     * Clear the terminal screen.
     */
    private static void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Prompt the user for one or multiple characters and return them.
     */
    private static char[] promptChars()
    {
        System.out.print("Letter: ");

        Scanner scan = new Scanner(System.in);
        String string = scan.next().toUpperCase();

        return string.toCharArray();
    }

    /**
     * Get a string for this game.
     */
    private String getStringFromList()
    {
        try {
            return getRandomLineFromFile(this.listFilePath).toUpperCase();
        } catch (FileNotFoundException e) {
            System.out.println("List file not found!");
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * Chose a random line from a file.
     * https://stackoverflow.com/questions/2218005/how-to-get-a-random-line-of-a-text-file-in-java
     */
    private static String getRandomLineFromFile(String filename) throws FileNotFoundException
    {
        String result = null;
        Random random = new Random();
        File file = new File(filename);

        int n = 0;
        for (Scanner scanner = new Scanner(file); scanner.hasNext();) {
            ++n;
            String line = scanner.nextLine();
            if (random.nextInt(n) == 0) result = line;
        }

        return result;
    }
}
