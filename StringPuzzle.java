import java.util.HashMap;
import java.util.Set;

class StringPuzzle
{
    private String solutionString;
    private HashMap<Character, Integer> solutionMap;
    private HashMap<Character, Integer> wrongChars;
    private HashMap<Character, Integer> rightChars;

    /**
     * Constructor.
     */
    StringPuzzle(String string)
    {
        this.solutionString = string;
        this.solutionMap = makeCharMap(string);
        this.wrongChars = new HashMap<Character, Integer>();
        this.rightChars = new HashMap<Character, Integer>();
    }

    /**
     * Whether the puzzle is solved.
     */
    public boolean isSolved()
    {
        return rightChars.size() == solutionMap.size();
    }

    /**
     * Guess a particular character.
     */
    public boolean tryChar(char c)
    {
        if (solutionMap.containsKey(c)) {
            rightChars.put(c, 1);
            return true;
        }

        wrongChars.put(c, 1);
        return false;
    }

    /**
     * Get the set of wrong character tries.
     */
    public Set<Character> getWrongChars()
    {
        return wrongChars.keySet();
    }

    /**
     * Get the set of correct character tries.
     */
    public Set<Character> getRightChars()
    {
        return rightChars.keySet();
    }

    /**
     * Get a string representation of the puzzle in its current state.
     */
    public String getCurrentString()
    {
        char[] chars = solutionString.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (isAlphabetChar(chars[i]) && !rightChars.containsKey(chars[i])) {
                chars[i] = '_';
            }
        }

        return new String(chars);
    }

    /**
     * Check whether a character is a letter.
     */
    private static boolean isAlphabetChar(char c)
    {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    /**
     * Build a hashmap of character occurrences from a string.
     */
    private static HashMap<Character, Integer> makeCharMap(String string)
    {
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (!isAlphabetChar(c)) continue;
            if (!charMap.containsKey(c)) charMap.put(c, 0);
            charMap.put(c, charMap.get(c) + 1);
        }

        return charMap;
    }
}
