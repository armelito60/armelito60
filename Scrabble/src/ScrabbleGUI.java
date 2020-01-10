/* TCHIASSO NONO ARMEL
TP2 Réalisation d'un Scrabble
Dernière modification : 04/12/19
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;

public class ScrabbleGUI implements ActionListener {

    private Dictionnary dico;
    private JTextField letterTextField;
    private JButton searchButton;
    private JTextArea wordListTextArea;
    private JScrollPane scrollpane;
    private JFrame frame;

    public ScrabbleGUI() {
        System.out.println("Welcome to the Scrabble assistant");

        this.frame = new JFrame("Scrabble GUI");
        this.frame.setMinimumSize(new Dimension(640, 480));
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new BorderLayout());

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.letterTextField = new JTextField();
        this.letterTextField.setPreferredSize(new Dimension(250, 30));;
        top.add(this.letterTextField);

        this.searchButton = new JButton("Search");
        this.searchButton.setSize(140, letterTextField.getHeight());
        this.searchButton.addActionListener(this);
        this.searchButton.setActionCommand("search");
        top.add(this.searchButton);

        this.wordListTextArea = new JTextArea();
        this.scrollpane = new JScrollPane(this.wordListTextArea);

        this.frame.add(top, BorderLayout.PAGE_START);
        this.frame.add(this.scrollpane, BorderLayout.CENTER);

        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.pack();
        this.frame.revalidate();
        this.frame.repaint();

        try {
            File file = new File("src/" + Dictionnary.DICTIONARY_FILENAME);
            if (!file.exists()) {
                file = new File("./" + Dictionnary.DICTIONARY_FILENAME);
            }

            this.dico = new Dictionnary(file.getPath());
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }

    }

    @Override
    // Méthode permettant que l'appuie d'un bouton provoque la lecture du champ de saisie, le calcul des mots et l'affichage dans la zone d'affichage
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "search":
                String letters = Dictionnary.replaceFrenchCharacter(letterTextField.getText());
                char[] lettersArray = letters.toCharArray();
                List<String> wordsThatCanBeComposed = dico.getWordsThatCanBeComposed(lettersArray);
                ScrabbleComparator sc = new ScrabbleComparator(lettersArray);
                String[] wordsThatCanBeComposedArray = wordsThatCanBeComposed.toArray(new String[0]);
                Arrays.sort(wordsThatCanBeComposedArray, sc);
                wordListTextArea.setText(wordsThatCanBeComposed.size() + " word(s) found :\n");

                // on va ici afficher tous les mots correspondants et leur score respectif
                for (String word : wordsThatCanBeComposedArray) {
                    wordListTextArea.append(" - " + word + " ➔ "+ ScrabbleComparator.wordValue(word) + " point(s)\n");
                }
                wordListTextArea.append("\nTHAT'S IT !");
                this.frame.revalidate();
                this.frame.repaint();
                break;

            default:
                break;
        }
    }

    public static void main(String[] args) {
        new ScrabbleGUI();
    }
}
