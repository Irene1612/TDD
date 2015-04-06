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
		for(Card card : peekEachTableu){
			assertNotNull(card);
			assertTrue(card.uncovered());
			//Elimino la carta para comprobar que era la unica y luego la vuelvo a meter
			peekEachTableu.remove(card);
			assertFalse(peekEachTableu.contains(card));
			peekEachTableu.add(card);
		}
	}
	
	@Test
	public void isEmptyTheWasteTest(){
		assertTrue(startController.isEmptyTheWaste());
	}
	
	
}
