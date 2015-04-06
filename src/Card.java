public class Card {

	private int suit;
	private int number;
	private boolean covered;

	public Card(int suit, int number, boolean covered) {
		this.number = number;
		this.suit = suit;
		this.covered = covered;
	}

	public boolean isCovered() {
		return covered;
	}

	@Override
	public boolean equals(Object object){
		assert object instanceof Card;
		Card card = (Card) object;
		return card.suit == suit && card.number == number;	
	}
}
