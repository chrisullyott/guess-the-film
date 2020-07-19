/**
 * Guess the film!
 *
 * Like Hangman, but less risky.
 */
class GuessTheFilm
{
    public static void main(String[] args)
    {
        LetterGame game = new LetterGame("films.txt", "Guess the film!", 7);

        game.start();
        game.end();
    }
}
