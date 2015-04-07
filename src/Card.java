public class Card {

	private int suit;
	private int number;
	private boolean covered;

	public Card(int suit, int number, boolean covered) {
		this.number = number;
		this.suit = suit;
		this.covered = covered;
	}
	
	public int getSuit() {
		return suit;
	}

	public int getNumber() {
		return number;
	}

	public boolean isCovered() {
		return covered;
	}

	public Card uncover() {
		this.covered = false;
		return this;
	}
	
	@Override
	public boolean equals(Object object){
		assert object instanceof Card;
		Card card = (Card) object;
		return card.suit == suit && card.number == number && card.covered == covered;	
	}

	@Override
	public String toString() {
		return "N�mero: " + this.number + " - Palo: " + this.suit + " - �Tapada?: " + this.covered;
	}

	public Card cover() {
		this.covered = true;
		return this;
	}
	
	
}
