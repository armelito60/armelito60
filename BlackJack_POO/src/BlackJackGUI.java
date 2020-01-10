import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class BlackJackGUI implements ActionListener {

    private JPanel bankPanel = null;
    private JPanel playerPanel = null;
    private JFrame frame;
    private BlackJack blackJack = new BlackJack();
    private JButton anotherCardButton;
    private JButton noMoreCardButton;
    private JButton resetButton;

    public BlackJackGUI(JPanel bankPanel, JPanel playerPanel) throws FileNotFoundException {
        JFrame frame = new JFrame("BlackJack GUI");
        frame.setMinimumSize(new Dimension(640,480));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        this.bankPanel = bankPanel;
        bankPanel.setBorder(BorderFactory.createTitledBorder("Bank"));
        this.playerPanel = playerPanel;
        playerPanel.setBorder(BorderFactory.createTitledBorder("Player"));

        this.anotherCardButton = new JButton("Another card");
        this.noMoreCardButton = new JButton("No more card");
        this.resetButton = new JButton("Reset");
        topPanel.add(anotherCardButton);
        topPanel.add(noMoreCardButton);
        topPanel.add(resetButton);
        anotherCardButton.setActionCommand("key1");
        anotherCardButton.addActionListener(this);
        noMoreCardButton.setActionCommand("key2");
        noMoreCardButton.addActionListener(this);
        resetButton.setActionCommand("key3");
        resetButton.addActionListener(this);

        centerPanel.add(bankPanel);
        centerPanel.add(playerPanel);
        centerPanel.setLayout(new GridLayout(2,0));

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel);
        frame.pack();
        frame.setVisible(true);

        updateBankPanel();
        updatePlayerPanel();

    }

    private void addToPanel(JPanel p, String token) throws FileNotFoundException {
        File file = new File("./src/img/card_"+token+".png");
        if (!file.exists()) {
            throw new FileNotFoundException("Can't find "+file.getPath());
        }
        ImageIcon icon = new ImageIcon(file.getPath()); // Create the image from the filename
        JLabel label = new JLabel(icon); // Associate the image to a label
        p.add(label); // Add the label to a panel
    }

    // met à jour le panneau playerPanel en fonction de la main du joueur
    private void updatePlayerPanel() throws FileNotFoundException {
        playerPanel.removeAll();
        List<Card> player = blackJack.getPlayerCardList();
        for (Card i : player) {
            String nameCard = i.getColorName() +"_"+ i.getValueSymbole();
            addToPanel(playerPanel, nameCard);
        }
        playerPanel.updateUI();
    }

    // met à jour le panneau bankPanel en fonction de la main de la banque
    private void updateBankPanel() throws FileNotFoundException {
        bankPanel.removeAll();
        List<Card> bank = blackJack.getBankCardList();
        for (Card i : bank) {
            String nameCard = i.getColorName() +"_"+ i.getValueSymbole();
            addToPanel(bankPanel, nameCard);
        }
        bankPanel.updateUI();
    }

    @Override
    // méthode permettant de décrire ce qu'il se passe lors de l'appui sur un bouton
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "key1": // bouton Another Card
                try {
                    blackJack.playerDrawAnotherCard();
                    updatePlayerPanel();
                    if(blackJack.isGameFinished()) {
                        addToPanel(playerPanel, "looser");
                        bankPanel.updateUI();
                        addToPanel(bankPanel, "winner");
                        playerPanel.updateUI();
                        anotherCardButton.setEnabled(false);
                        noMoreCardButton.setEnabled(false);
                    }
                } catch (EmptyDeckException | FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(-1);
                }
                break;
            case "key2": // bouton No more Card
                try {
                    blackJack.bankLastTurn();
                    updateBankPanel();
                    anotherCardButton.setEnabled(false);
                    noMoreCardButton.setEnabled(false);
                    if (blackJack.isBankWinner()) {
                        addToPanel(bankPanel, "winner");
                        bankPanel.updateUI();
                        addToPanel(playerPanel, "looser");
                        playerPanel.updateUI();
                    }
                    else if (blackJack.isPlayerWinner()) {
                        addToPanel(bankPanel, "looser");
                        bankPanel.updateUI();
                        addToPanel(playerPanel, "winner");
                        playerPanel.updateUI();
                    }
                    else if (!blackJack.isBankWinner() && !blackJack.isPlayerWinner()) {
                        addToPanel(bankPanel, "draw");
                        bankPanel.updateUI();
                        addToPanel(playerPanel, "draw");
                        playerPanel.updateUI();
                    }
                } catch (EmptyDeckException | FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(-1);
                }
                break;
            case "key3": // bouton reset
                try {
                    blackJack.reset();
                    updatePlayerPanel();
                    updateBankPanel();
                    anotherCardButton.setEnabled(true);
                    noMoreCardButton.setEnabled(true);
                } catch (EmptyDeckException | FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(-1);
                }
                break;
            default:
                break;
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
        JPanel playerPanel = new JPanel();
        JPanel bankPanel = new JPanel();
        new BlackJackGUI(playerPanel, bankPanel);
    }

}
