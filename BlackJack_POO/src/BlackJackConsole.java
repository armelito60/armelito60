import java.util.LinkedList;
import java.util.Scanner;

public class BlackJackConsole {

	public BlackJackConsole() throws EmptyDeckException, InterruptedException {
		System.out.println("Welcome to the BlackJack table. Let's play !");
		Deck deck = new Deck(2);
		BlackJack blackjack = new BlackJack();
		LinkedList<Card> cardList = new LinkedList<>();

		blackjack.reset();
		System.out.println("The bank draw : "+ blackjack.getBankHandString() +" "+ blackjack.getBankBest());
		System.out.println("Your draw : "+ blackjack.getPlayerHandString() +" "+ blackjack.getPlayerBest());

		Scanner choice = new Scanner(System.in);

		do {
			System.out.println("Do you want another card ? [y/n] ");
			String str = choice.nextLine();
			char character = str.charAt(0);
			switch(character) {
				case 'y' :
					blackjack.playerDrawAnotherCard();
					System.out.println("Your new hand : "+ blackjack.getPlayerHandString() +" "+ blackjack.getPlayerBest());
					break;
				case 'n' :
					blackjack.bankLastTurn();
					System.out.println("The bank draw cards. New hand : "+ blackjack.getBankHandString() +" "+ blackjack.getBankBest());
					break;
			}
		} while(!blackjack.isGameFinished());

		System.out.println("Player best : "+ blackjack.getPlayerHandString());
		System.out.println("Bank best : "+ blackjack.getBankHandString());
	}
	public static void main (String[]args) throws EmptyDeckException, InterruptedException {

		new BlackJackConsole();
	}
}
