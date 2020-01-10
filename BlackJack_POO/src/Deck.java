import java.util.Collections;
import java.util.EmptyStackException;
import java.util.LinkedList;

public class Deck {
	// allocation d'une liste vide
	private LinkedList<Card> cardList = new LinkedList<>();
	public int nbBox;

	// constructeur par défaut
	Deck(int nbBox) {

		this.nbBox = nbBox;
		Value[] value = Value.values();
		Color[] color = Color.values();
		// on remplit ici notre liste de cartes...
		for (int a = 0; a <= nbBox; a++) {
			for(int i = 0; i < color.length; i++) {
				for(int j = 0; j < value.length; j ++) {
					Card card = new Card(value[j],color[i]);
					cardList.add(card);
				}
			}
		}
		// ... de façon quelconque
		Collections.shuffle(cardList);

	}

	public String toString() {

		return nbBox +" "+cardList;
	}

	// si la liste est vide, on affiche un message pour dire que la liste est vide
	public Card draw() throws EmptyDeckException {
		if(cardList.isEmpty()) {
			throw new EmptyDeckException("Deck Empty !");
		}
		else {
			return cardList.pollFirst();
		}

	}


}
