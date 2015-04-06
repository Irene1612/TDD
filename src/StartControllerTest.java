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
		}
	}
	

}
