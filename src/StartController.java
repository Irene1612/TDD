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
			do{
				Random r = new Random();
				card = new Card(r.nextInt(3), r.nextInt(11));
				
			}while(peekEachTableau.contains(card));
			peekEachTableau.add(card);
		}
		return peekEachTableau;
	}

	
}
