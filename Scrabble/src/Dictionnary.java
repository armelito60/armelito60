/* TCHIASSO NONO ARMEL
TP2 Réalisation d'un Scrabble
Dernière modification : 04/12/19
 */

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Dictionnary {

    private String[] wordList;
    private final char SCRABBLE_JOKER = '*';
    public static final String DICTIONARY_FILENAME = "fr_FR_utf8.dico";

    public Dictionnary(String filename) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filename));
        this.wordList = new String[Integer.parseInt(scan.next())];
        for(int i = 0; scan.hasNext(); i++) {
            this.wordList[i] = scan.next();
        }
        scan.close();
    }

    public boolean isValidWord(String word) { return Arrays.asList(this.wordList).contains(word); }

    // Méthode qui renvoie vrai ou faux en fonction de si le mot "word" peut être composé à partir des lettres letters
    public boolean mayBeComposed(String word, char[] letters) {
        word = replaceFrenchCharacter(word);
        word = word.toLowerCase();
        String lettersString = new String(letters);
        lettersString = replaceFrenchCharacter(lettersString.toLowerCase());

        int nbJoker = 0;

        Collection<Character> lettersList = new LinkedList<Character>();
        for (int i = 0; i < lettersString.length(); i++) {
            lettersList.add(lettersString.charAt(i));
        }

        for (char c : letters) {
            if (c == SCRABBLE_JOKER)
                nbJoker++;
        }

        char[] wordArray = word.toCharArray();
        for (char c : wordArray) {
            if (lettersList.contains(c)) {
                lettersList.remove(c);
            } else {
                if (nbJoker > 0) {
                    lettersList.remove('*');
                    nbJoker--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    // Méthode qui va effectuer les remplacements
    public static String replaceFrenchCharacter(String s) {
        List<Character> l = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        for (int i = 0; i < l.size(); i++) {
            switch (l.get(i)) {
                case 'à':
                case 'â':
                case 'ä':
                    l.set(i, 'a');
                    break;

                case 'ç':
                    l.set(i, 'c');
                    break;

                case 'é':
                case 'è':
                case 'ê':
                case 'ë':
                    l.set(i, 'e');
                    break;

                case 'î':
                case 'ï':
                    l.set(i, 'i');
                    break;

                case 'ô':
                case 'ö':
                    l.set(i, 'o');
                    break;

                case 'ù':
                case 'û':
                case 'ü':
                    l.set(i, 'u');
                    break;

                case 'œ':
                    l.set(i, 'o');
                    l.add(i + 1, 'e');
                    break;

                case 'æ':
                    l.set(i, 'a');
                    l.add(i + 1, 'e');
                    break;

                default:
                    break;
            }
        }

        return l.stream().map(String::valueOf).collect(Collectors.joining());
    }

    // Méthode qui retourne un tableau contenant tous les mots du dictionnaire pouvant être écrit à partir de la liste letters
    public List<String> getWordsThatCanBeComposed(char[] letters) {
        List<String> wordsThatCanBeComposed = new LinkedList<String>();
        for (String word : wordList) {
            if (mayBeComposed(word, letters))
                wordsThatCanBeComposed.add(word);
        }
        return wordsThatCanBeComposed;
    }

    // Méthode qui renvoie les lettres effectivement utilisée pour composer le mot sous la forme d'un nouveau tableau de char
    public static char[] getComposition(String word, char[] letters) {
        List<Character> testList = new LinkedList<Character>();
        for(char c : letters) {
            testList.add(c);
        }
        List<Character> result = new LinkedList<Character>();
        for(char c : word.toLowerCase().toCharArray()) {
            if(testList.contains(c)) {
                result.add(testList.get(testList.indexOf(c)));
                testList.remove(testList.indexOf(c));
            }
            else if(testList.contains('*')) {
                result.add(testList.get(testList.indexOf('*')));
                testList.remove(testList.indexOf('*'));
            }
            else {
                return null;
            }
        }
        if(result.size() != 0) {
            return (char[]) result.stream().map(String::valueOf).collect(Collectors.joining()).toCharArray();
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            Dictionnary dico = new Dictionnary("fr_FR_utf8.dico");
            char[] test = {'a', 'e', 'n','o', 'o', 'b', 'j', '*', '*'};
            boolean tt = dico.mayBeComposed("Bonjour",  test);
            System.out.println(tt);
            System.out.println(dico.getComposition("Bonjour", test));
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

}