/* TCHIASSO NONO ARMEL
TP2 Réalisation d'un Scrabble
Dernière modification : 04/12/19
 */

import java.util.*;

public class ScrabbleComparator implements Comparator<String> {

    private char[] letters;

    ScrabbleComparator(char[] letters) {
        this.letters = letters;
    }

    // Méthode permettant de renvoyer une valeur d'une lettre dans les règles du Scrabble français
    public static int letterValue(char letter) {
        switch(letter) {
            case '*':
                return 0;
            case 'e':
            case 'a':
            case 'i':
            case 'n':
            case 'o':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'l':
                return 1;
            case 'd':
            case 'm':
            case 'g':
                return 2;
            case 'b':
            case 'c':
            case 'p':
                return 3;
            case 'f':
            case 'h':
            case 'v':
                return 3;
            case 'j':
            case 'q':
                return 4;
            case 'k':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                return 10;
        }
        return 0;
    }

    // Méthode qui renvoie la valeur d'un ensemble de lettres
    public static int lettersValue(char[] letters) {
        int sum = 0;
        for(char c : letters) { sum += letterValue(c); }
        return sum;
    }

    // Méthode qui renvoie le nombre de point pour un mot donné
    public static int wordValue(String word) {
        return lettersValue(word.toCharArray());
    }

    public int compare(String s1, String s2) {
        if(wordValue(s1) > wordValue(s2)) {
            return -1;
        }
        else if(wordValue(s1) == wordValue(s2)) {
            return 0;
        }
        return 1;
    }

}
