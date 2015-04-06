import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class StartControllerTest {

	StartController startController;

	@Before
	public void before() {
		startController = new StartController();
	}

	@Test
	public void isEmptyAllFoundationsTest() {
		assertTrue(startController.isEmptyAllFoundations());
	}

	@Test
	public void deckCoverCardsSizeTest() {
		assertEquals(24, startController.deckCoverCardsSize());
	}

	@Test
	public void peekEachTableauTest() {
		ArrayList<Card> peekEachTableu = startController.peekEachTableau();
		assertEquals(7, peekEachTableu.size());
		for (int i=0; i < peekEachTableu.size(); i++) {
			Card card = peekEachTableu.get(i);
			assertNotNull(card);
			assertFalse(card.isCovered());
			// Elimino la carta para comprobar que era la unica y luego la
			// vuelvo a meter
			peekEachTableu.remove(card);
			assertFalse(peekEachTableu.contains(card));
			peekEachTableu.add(card);
		}
	}

	@Test
	public void isEmptyTheWasteTest() {
		assertTrue(startController.isEmptyTheWaste());
	}	
	
	@Test
	public void coveredTableauCardsTest(){
		ArrayList<ArrayList<Card>> coveredTableauCards = startController.coveredTableauCards();
		assertEquals(7, coveredTableauCards.size());
		for (int i=0; i < coveredTableauCards.size(); i++) {
			assertEquals(i, coveredTableauCards.get(i).size());
			for(int j=0; j<coveredTableauCards.get(i).size(); j++){
				Card card = coveredTableauCards.get(i).get(j);
				assertNotNull(card);
				assertTrue(card.isCovered());
			}
		}
	}
}
