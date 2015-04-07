import java.util.ArrayList;
import java.util.Random;


public class MoveFromWasteToFoundationController {
	
	ArrayList<Card> wasteSet;
	ArrayList<ArrayList<Card>> foundationsSet;
	
	public MoveFromWasteToFoundationController(){
		this.initializeWaste();
	}

	public void initializeFoundations(int number, int suit) {
		foundationsSet = new ArrayList<ArrayList<Card>>();
		for (int i = 0; i < 4; i++) {			
			ArrayList<Card> oneFoundation = new ArrayList<Card>();
			if(i==suit){
				for(int j = 0; j < number; j++){
					Card card = new Card(suit, j, false);
					oneFoundation.add(card);
				}
			}			
			foundationsSet.add(oneFoundation);
		}
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

	public ArrayList<ArrayList<Card>> getFoundationsSet() {		
		return foundationsSet;
	}

	public void moveFromWasteToFoundation() {
		Card cardToMove = wasteSet.get(wasteSet.size());
		foundationsSet.get(cardToMove.getSuit()).add(cardToMove);
		wasteSet.remove(wasteSet.size());
	}

}
