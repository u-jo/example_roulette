package util;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


/**
 * Provides variety of methods to simplify getting user input from console.
 * 
 * @author Robert C. Duvall
 */
public class ConsoleReader
{
    // by default, read input from the user's console
    private static Scanner in = new Scanner(new InputStreamReader(System.in));


    /**
     * Prompts the user to input an integer value.
     * 
     * @param prompt output to the user before waiting for input
     * @return the value entered, waiting if necessary until one is given
     */
    public static int promptInt (String prompt)
    {
        System.out.print(prompt);
        return in.nextInt();
    }


    /**
     * Prompts the user to input an real value.
     * 
     * @param prompt output to the user before waiting for input
     * @return the value entered, waiting if necessary until one is given
     */
    public static double promptDouble (String prompt)
    {
        System.out.print(prompt);
        return in.nextDouble();
    }


    /**
     * Prompts the user to input a word.
     * 
     * @param prompt output to the user before waiting for input
     * @return the value entered, waiting if necessary until one is given
     */
    public static String promptString (String prompt)
    {
        System.out.print(prompt);
        return in.next();
    }


    /**
     * Prompts the user to input an integer value between the given values,
     * inclusive. Note, repeatedly prompts the user until a valid value is
     * entered.
     * 
     * @param prompt output to the user before waiting for input
     * @param low minimum possible valid value allowed
     * @param hi maximum possible valid value allowed
     * @return the value entered, waiting if necessary until one is given
     */
    public static int promptRange (String prompt, int low, int hi)
    {
        final String FULL_PROMPT = String.format("%s between %d and %d? ",
                                                 prompt, low, hi);
        int answer;
        do
        {
            answer = promptInt(FULL_PROMPT);
        }
        while (low > answer || answer > hi);
        return answer;
    }


    /**
     * Prompts the user to input one of the given choices to the question. Note,
     * repeatedly prompts the user until a valid choice is entered.
     * 
     * @param prompt output to the user before waiting for input
     * @param choices possible valid responses user can enter
     * @return the value entered, waiting if necessary until one is given
     */
    public static String promptOneOf (String prompt, String ... choices)
    {
        final String FULL_PROMPT = prompt + " one of " + Arrays.asList(choices) + "? ";
        return promptString(FULL_PROMPT, choices);
    }


    /**
     * Prompts the user to input yes or no to the given question. Note,
     * repeatedly prompts the user until yes or no is entered.
     * 
     * @param prompt output to the user before waiting for input
     * @return the value entered, waiting if necessary until one is given
     */
    public static boolean promptYesNo (String prompt)
    {
        String answer = promptString(prompt, "yes", "Yes", "y", "Y", "no", "No", "n", "N");
        return (answer.toLowerCase().startsWith("y"));
    }
    


    /**
     * Prompts the user to input one of the given choices to the question. 
     * 
     * Note, repeatedly prompts the user until a valid choice is entered.
     * 
     * @param prompt output to the user before waiting for input
     * @param choices possible valid responses user can enter
     * @return the value entered, waiting if necessary until one is given
     */
    private static String promptString (String prompt, String ... choices)
    {
        Set<String> set = new TreeSet<String>(Arrays.asList(choices));
        String result;
        do
        {
            result = promptString(prompt);
        }
        while (!set.contains(result));
        return result;
    }
}
