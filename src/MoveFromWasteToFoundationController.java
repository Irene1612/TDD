import java.util.ArrayList;
import java.util.Random;


public class MoveFromWasteToFoundationController {
	
	ArrayList<Card> wasteSet;
	
	public MoveFromWasteToFoundationController(){
		this.initializeWaste();
	}

	private void initializeWaste() {
		wasteSet = new ArrayList<Card>();
		Random r = new Random();
		int wasteSize = r.nextInt(24);
		for (int i = 0; i < wasteSize; i++) {
			Card card;
			do {
				r = new Random();
				card = new Card(r.nextInt(3), r.nextInt(11), false);
			} while (wasteSet.contains(card));
			wasteSet.add(card);
		}		
	}

	public ArrayList<Card> getWasteSet() {
		return wasteSet;
	}

}
