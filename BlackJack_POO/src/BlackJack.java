import java.util.LinkedList;
import java.util.List;

public class BlackJack {

    private Deck deck;
    private Hand playerHand;
    private Hand bankHand;
    public boolean gameFinished;

    BlackJack() {
        deck = new Deck(1);
        playerHand = new Hand();
        bankHand = new Hand();
        gameFinished = false;
        try {
            reset();
        }
        catch(EmptyDeckException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
    }

    // méthode qui videra les mains de la banque et du joueur
    // puis ajoutera 1 carte à la banque et 2 au joueur
    public void reset() throws EmptyDeckException {
        gameFinished = false;
        playerHand.clear();
        bankHand.clear();
        playerHand.add(deck.draw());
        playerHand.add(deck.draw());
        bankHand.add(deck.draw());

    }

    // ces getters permettent d'accéder aux informations des différentes parties (banque et joueur)
    public String getPlayerHandString() {
        return playerHand.toString();
    }

    public String getBankHandString() {
        return bankHand.toString();
    }

    public int getPlayerBest() {
        return playerHand.best();
    }

    public int getBankBest() {
        return bankHand.best();
    }

    // ces deux méthodes permettent de déterminer le gagnant entre le joueur et la banque
    public boolean isPlayerWinner() {
        if((getPlayerBest() <= 21 && getBankBest() < getPlayerBest()) || getBankBest() > 21)
            return true;
        else
            return false;
    }

    public boolean isBankWinner() {
        if((getBankBest() <= 21 && getBankBest() > getPlayerBest()) || getPlayerBest() > 21)
            return true;
        else
            return false;
    }

    // méthode permettant de savoir si la partie est terminée ou pas
    public boolean isGameFinished() {
        return gameFinished;
    }

    // méthode permettant au joueur de tirer une nouvelle carte..
    // ..si la partie n'est pas finie et si son nombre de points en main est supérieur à 21
    public void playerDrawAnotherCard() throws EmptyDeckException {
        if(!gameFinished) {
            playerHand.add(deck.draw());
            if(getPlayerBest() > 21) {
                gameFinished = true;
            }
        }

    }

    public void bankLastTurn() throws EmptyDeckException {
        if(!gameFinished && bankHand.best() <= 21 && playerHand.best() <= 21) {
            // tant que la banque n'a pas gagné, elle continue à tirer des cartes
            do {
                bankHand.add(deck.draw());
            } while(getBankBest() < getPlayerBest());

            if(isBankWinner())
                System.out.println("Bank win");
            else if(isPlayerWinner())
                System.out.println("Player win");
            else if(!isPlayerWinner() && !isBankWinner())
                System.out.println("Null match");
            gameFinished = true;
        }
    }

    public List<Card> getPlayerCardList() {
        List<Card> originalList = playerHand.getCardList();
        LinkedList<Card> copyList = new LinkedList<Card>(originalList);
        return copyList;
    }

    public List<Card> getBankCardList() {
        List<Card> originalList = bankHand.getCardList();
        LinkedList<Card> copyList = new LinkedList<Card>(originalList);
        return copyList;
    }
}
