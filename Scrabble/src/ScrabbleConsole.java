/* TCHIASSO NONO ARMEL
TP2 Réalisation d'un Scrabble
Dernière modification : 04/12/19
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ScrabbleConsole {
    private Dictionnary frenchDictionary;

    public ScrabbleConsole() {
        System.out.println("Welcome to the Scrabble assistant");

        try {
            File file = new File("src/" + Dictionnary.DICTIONARY_FILENAME);
            if (!file.exists()) {
                file = new File("./" + Dictionnary.DICTIONARY_FILENAME);
            }

            frenchDictionary = new Dictionnary(file.getPath());
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ScrabbleConsole scrabbleConsole = new ScrabbleConsole();

        System.out.println("Please enter a letters list:");
        String letters = Dictionnary.replaceFrenchCharacter(sc.nextLine());
        char[] lettersArray = letters.toCharArray();
        System.out.println("letters = " + letters);

        List<String> wordsThatCanBeComposed = scrabbleConsole.frenchDictionary.getWordsThatCanBeComposed(lettersArray);
        System.out.println(wordsThatCanBeComposed.size() + " matching word(s) found: " + wordsThatCanBeComposed.toString());

        sc.close();

    }
}
