import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.Stack;

import org.junit.Test;

public class ChristmasWrapperTester {

	ChristmasWrapper[] wishList1 = {
			new ChristmasWrapper(ChristmasWrapper.Toy.BOARDGAME, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.MOONSHOES, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.NERFGUN, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.RC, true)
	};

	ChristmasWrapper[] wishList2 = {
			new ChristmasWrapper(ChristmasWrapper.Toy.EASYBAKE, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.MOONSHOES, false),
			new ChristmasWrapper(ChristmasWrapper.Toy.NERFGUN, false),
			new ChristmasWrapper(ChristmasWrapper.Toy.WATERSQUIRTER, false)
	};

	Stack<ChristmasWrapper> toyBag1 = new Stack<ChristmasWrapper>();


	//		[new ChristmasToy(ChristmasToy.Toy.RC, false)],
	//			[new ChristmasToy(ChristmasToy.Toy.MOONSHOES, false)],
	//			[new ChristmasToy(ChristmasToy.Toy.HOTWHEELS, false)],
	//			[new ChristmasToy(ChristmasToy.Toy.WATERSQUIRTER, false)]);


	@Test
	public void testComparator() {
		Comparator<ChristmasWrapper> comp = new ChristmasWrapper.ToyComparator();
		ChristmasWrapper toy1 = new ChristmasWrapper(ChristmasWrapper.Toy.BOARDGAME, true);
		ChristmasWrapper toy1Copy = new ChristmasWrapper(ChristmasWrapper.Toy.BOARDGAME, true);
		ChristmasWrapper moreImportantToy = new ChristmasWrapper(ChristmasWrapper.Toy.RC, true);
		ChristmasWrapper lessImportantToy = new ChristmasWrapper(ChristmasWrapper.Toy.MOONSHOES, true);

		assertTrue("Card is equal to itself.", 0 == comp.compare(toy1, toy1));
		assertTrue("Card is equal to itself.", 0 == comp.compare(toy1, toy1Copy));
		assertTrue("Card is equal to itself.", 0 > comp.compare(toy1, moreImportantToy));
		assertTrue("Card is equal to itself.", 0 < comp.compare(toy1, lessImportantToy));
	}
	@Test
	public void testPriorityToy() {
		ChristmasWrapper[] toBeScannedList1 = ChristmasWrapper.copyOf(wishList1);
		ChristmasWrapper priorityToy1 = new ChristmasWrapper(ChristmasWrapper.Toy.RC, true);
		ChristmasWrapper[] toBeScannedList2 = ChristmasWrapper.copyOf(wishList2);
		ChristmasWrapper priorityToy2 = new ChristmasWrapper(ChristmasWrapper.Toy.NERFGUN, true);
		ChristmasWrapper[] emptyList = null;
		Comparator<ChristmasWrapper> comp = new ChristmasWrapper.ToyComparator();

		assertTrue("Priority toy for the first wish list should be RC.", 0 == comp.compare(ChristmasWrapper.priorityToy(comp, toBeScannedList1), priorityToy1));
		assertTrue("Priority toy for the second wish list should be RC.", 0 == comp.compare(ChristmasWrapper.priorityToy(comp, toBeScannedList2), priorityToy2));
		assertTrue("Empty lists should return null.", null == ChristmasWrapper.priorityToy(comp, emptyList));

	}

	//	public void testNamingFilter() {
	//		assertFalse("Not yet implemented", true);
	//	}
}
