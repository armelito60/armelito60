import java.util.LinkedList;
import java.util.List;

public class Hand {

    // allocation d'une liste de type Card et de type Integer
    private LinkedList<Card> cardList = new LinkedList<>();
    private LinkedList<Integer> list = new LinkedList<Integer>();

    // constructeur par défaut vide
    Hand() {
    }

    public String toString() {
        return cardList.toString();
    }

    // méthode permettant d'ajouter une carte à  notre main
    public void add(Card card) {
        cardList.add(card);
    }

    // méthode permettant de vider notre main
    public void clear() {
        cardList.clear();
    }

    // méthode permettant de retourner les points de la carte prise en main
    public List<Integer> count() {
        LinkedList<Integer> list = new LinkedList<>();
        for (Card card : cardList) {
            list.add(card.getPoints());
        }
        return list;
    }

    // méthode permettant de calculer le nombre de points total en main
    public int best() {
        List<Integer> list = count();
        int bestScore = 0;
        int compt = 0;

        for (int i : list) {
            bestScore += i;
            if(i == 1)
                compt++;
        }
        if(bestScore + 10 <= 21 && compt >= 1) {
            bestScore += 10;
        }
        return bestScore;

    }

    public List<Card> getCardList() {
        return new LinkedList<Card>(this.cardList);
    }
}
