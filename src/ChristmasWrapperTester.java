import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
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

	ChristmasWrapper[] trueWishList2 = {
			new ChristmasWrapper(ChristmasWrapper.Toy.EASYBAKE, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.MOONSHOES, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.NERFGUN, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.WATERSQUIRTER, true)
	};
	
	ChristmasWrapper[] wishList3 = {
			new ChristmasWrapper(ChristmasWrapper.Toy.RC, false),
			new ChristmasWrapper(ChristmasWrapper.Toy.EASYBAKE, false),
			new ChristmasWrapper(ChristmasWrapper.Toy.NERFGUN, false),
			new ChristmasWrapper(ChristmasWrapper.Toy.WATERSQUIRTER, false),
			new ChristmasWrapper(ChristmasWrapper.Toy.BOARDGAME, false)
	};

	ChristmasWrapper[] trueWishList3 = {
			new ChristmasWrapper(ChristmasWrapper.Toy.RC, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.EASYBAKE, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.NERFGUN, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.WATERSQUIRTER, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.BOARDGAME, true)
	};	
	
	ChristmasWrapper[] santaBag1 = { //based on wishList1
			new ChristmasWrapper(ChristmasWrapper.Toy.BOARDGAME, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.MOONSHOES, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.WATERSQUIRTER, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.RC, true)
	};
	
	ChristmasWrapper[] santaBag2 = { //based on wishList2
			new ChristmasWrapper(ChristmasWrapper.Toy.EASYBAKE, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.MOONSHOES, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.WATERSQUIRTER, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.WATERSQUIRTER, true)
	};
	
	ChristmasWrapper[] santaBag3 = {
			new ChristmasWrapper(ChristmasWrapper.Toy.RC, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.EASYBAKE, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.WATERSQUIRTER, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.WATERSQUIRTER, true),
			new ChristmasWrapper(ChristmasWrapper.Toy.BOARDGAME, true)
	};
	
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

		assertTrue("Toy is equal to itself.", 0 == comp.compare(toy1, toy1));
		assertTrue("Toy is equal to itself.", 0 == comp.compare(toy1, toy1Copy));
		assertTrue("Isn't working when comparing to a more important toy.", 0 > comp.compare(toy1, moreImportantToy));
		assertTrue("Isn't working when comparing to a less important toy.", 0 < comp.compare(toy1, lessImportantToy));
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
	@Test
	public void testNamingFilter() {
		Stack<ChristmasWrapper> toyBagInput1 = new Stack<ChristmasWrapper>();
		for (int i = 0; i < wishList1.length; i++) {
			toyBagInput1.add(wishList1[i]);
		}
		Stack<ChristmasWrapper> toyBagOutput1 = new Stack<ChristmasWrapper>();
		for (int i = 0; i < wishList1.length; i++) {
			toyBagOutput1.add(wishList1[i]);
		}
		Stack<ChristmasWrapper> toyBagInput2 = new Stack<ChristmasWrapper>();
		for (int i = 0; i < wishList2.length; i++) {
			toyBagInput2.add(wishList2[i]);
		}
		Stack<ChristmasWrapper> toyBagOutput2 = new Stack<ChristmasWrapper>();
		for (int i = 0; i < trueWishList2.length; i++) {
			toyBagOutput2.add(trueWishList2[i]);
		}
		Stack<ChristmasWrapper> toyBagInput3 = new Stack<ChristmasWrapper>();
		for (int i = 0; i < wishList3.length; i++) {
			toyBagInput2.add(wishList3[i]);
		}
		Stack<ChristmasWrapper> toyBagOutput3 = new Stack<ChristmasWrapper>();
		for (int i = 0; i < trueWishList3.length; i++) {
			toyBagOutput2.add(trueWishList3[i]);
		}
		
		assertTrue("Output is incorrect", ChristmasWrapper.stacksAreEqual(toyBagOutput1, ChristmasWrapper.namingFilter(toyBagInput1)));
		assertTrue("Output is incorrect", ChristmasWrapper.stacksAreEqual(toyBagOutput2, ChristmasWrapper.namingFilter(toyBagInput2)));
		assertTrue("Output is incorrect", ChristmasWrapper.stacksAreEqual(toyBagOutput3, ChristmasWrapper.namingFilter(toyBagInput3)));

	}
	@Test
	public void testLoadToys() {
		Queue<ChristmasWrapper> productionLine1 = new LinkedList<ChristmasWrapper>();
		Queue<ChristmasWrapper> productionLine2 = new LinkedList<ChristmasWrapper>();
		Queue<ChristmasWrapper> productionLine3 = new LinkedList<ChristmasWrapper>();
		Stack<ChristmasWrapper> santaBagOutput1 = new Stack<ChristmasWrapper>();
		Stack<ChristmasWrapper> santaBagOutput2 = new Stack<ChristmasWrapper>();
		Stack<ChristmasWrapper> santaBagOutput3 = new Stack<ChristmasWrapper>();
		
		for (int i = 0; i < wishList1.length; i++) {
			productionLine2.add(wishList1[i]);
		}

		for (int i = 0; i < santaBag1.length; i++) {
			santaBagOutput2.add(santaBag1[i]);
		}
		
		for (int i = 0; i < wishList2.length; i++) {
			productionLine2.add(wishList2[i]);
		}

		for (int i = 0; i < santaBag2.length; i++) {
			santaBagOutput2.add(santaBag2[i]);
		}
		
		for (int i = 0; i < wishList3.length; i++) {
			productionLine3.add(wishList3[i]);
		}

		for (int i = 0; i < santaBag3.length; i++) {
			santaBagOutput3.add(santaBag3[i]);
		}
		
		assertTrue("Output is incorrect", ChristmasWrapper.stacksAreEqual(santaBagOutput1, ChristmasWrapper.loadToys(productionLine1)));
		assertTrue("Output is incorrect", ChristmasWrapper.stacksAreEqual(santaBagOutput2, ChristmasWrapper.loadToys(productionLine2)));
		assertTrue("Output is incorrect", ChristmasWrapper.stacksAreEqual(santaBagOutput3, ChristmasWrapper.loadToys(productionLine3)));

	}
}
