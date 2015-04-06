import java.util.ArrayList;
import java.util.Random;

public class StartController {

	public boolean isEmptyAllFoundations() {
		return true;
	}

	public int deckCoverCardsSize() {
		return 24;
	}

	public ArrayList<Card> peekEachTableau() {
		ArrayList<Card> peekEachTableau = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			Card card;
			do {
				Random r = new Random();
				card = new Card(r.nextInt(3), r.nextInt(11), false);
			} while (peekEachTableau.contains(card));
			peekEachTableau.add(card);
		}
		return peekEachTableau;
	}

	public boolean isEmptyTheWaste() {
		return true;
	}

	public ArrayList<ArrayList<Card>> coveredTableauCards() {
		ArrayList<ArrayList<Card>> coveredTableauCards = new ArrayList<ArrayList<Card>>();
		for (int i = 0; i < 7; i++) {
			coveredTableauCards.add(new ArrayList<Card>());
			for (int j = 0; j < i; j++){
				Card card;
				do {
					Random r = new Random();
					card = new Card(r.nextInt(3), r.nextInt(11), true);
				} while (coveredTableauCards.get(i).contains(card));
				coveredTableauCards.get(i).add(card);
			}
		}
		return coveredTableauCards;
	}

}
