public class Card {

	private int suit;
	private int number;

	public Card(int suit, int number) {
		this.number = number;
		this.suit = suit;
	}

	public boolean uncovered() {
		return true;
	}

	@Override
	public boolean equals(Object object){
		assert object instanceof Card;
		Card card = (Card) object;
		return card.suit == suit && card.number == number;	
	}
}
