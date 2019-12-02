import java.util.Comparator;
import java.util.Queue;
import java.util.Stack;

public class ChristmasWrapper {

	//Enumerated type for a suit
	public enum Toy {RC(3000, 100), HOTWHEELS(100, 5), NERFGUN(300, 20), WATERSQUIRTER(175, 15), EASYBAKE(100, 15), BOARDGAME(200, 15), MOONSHOES(75, 10);
		private final int demand; //kids who want it, "popularity"
		private final int price; //price to get it

		Toy(int demand, int price) {
			this.demand = demand;
			this.price = price;
		}
		int demand() {
			return demand;
		}
		int price() {
			return price;
		}
	};

	private Toy toy;
	private boolean named;

	public ChristmasWrapper(Toy toy, boolean named) {
		this.toy = toy;
		this.named = named;
	}

	public Toy getToy() {
		return this.toy;
	}

	public void setToy(Toy toy) {
		this.toy = toy;
	}

	public int getDemand() {
		return this.toy.demand();
	}

	public int getPrice() {
		return this.toy.price();
	}

	public boolean isNamed() {
		return this.named;
	}

	public void setNamed(boolean isNamed) {
		this.named = isNamed;
	}

	public boolean equals(Object obj) {
		if(!(obj instanceof ChristmasWrapper))
			return false;
		ChristmasWrapper other = (ChristmasWrapper) obj;
		return this.getDemand() == other.getDemand() && this.getPrice() == other.getPrice();
	}

	/**
	 * A method to return a copy of the given array
	 * @param deck - Original Array
	 * @return - Copy of Toys
	 */
	public static ChristmasWrapper[] copyOf(ChristmasWrapper[] toys) {
		ChristmasWrapper[] copy = new ChristmasWrapper[toys.length];
		for(int i = 0; i < toys.length; i++) {
			copy[i] = toys[i];
		}
		return copy;
	}

	/**
	 * Method to find the toy in an wish list with the highest priority
	 * @param toys - Array of toys to search
	 * @param comp - comparator object to compare toys
	 */
	public static ChristmasWrapper priorityToy(Comparator<ChristmasWrapper> comp, ChristmasWrapper[] wishList) {
		/*
		 *  TODO find the priority toy to begin working on given an array of toys
		 *  
		 *  The method must be used recursively
		 *  Hint: Use the helper method below
		 */

		return null; //Dummy return
	}

	public static ChristmasWrapper[] priorityToyHelper(Comparator<ChristmasWrapper> comp, ChristmasWrapper[] wishList, ChristmasWrapper first, ChristmasWrapper last) {
		/*
		 * TODO Complete the helper method for the priorityToy method
		 * 
		 * Hint: Use the comparator to compare the priority between 2 toys
		 */

		return null; //Dummy return
	}

	public static Stack<ChristmasWrapper> namingFilter(Stack<ChristmasWrapper> bag){
		/*
		 * TODO Sometimes in a bag of gifts an elf might forget to put the name of the kid the bag is meant for. 
		 * Complete this method so that it goes through a given stack, names all the unnamed gifts, and returns the stack 
		 * in the same order as it was.
		 * 
		 * 
		 * Hint: As you look through a bag, set the toys aside in order to then put them back
		 */

		return bag;
	}

	/**
	 * @param factoryLine - Production line of toys
	 * @return stack - Stack representing a new bag of toys for Santa to deliver
	 */
	public static Stack<ChristmasWrapper> loadToys(Queue<ChristmasWrapper> factoryLine) {
		/*
		 * TODO You have a production line of toys. You want to pass these toys onto
		 * Santa's bag.
		 * However, the nerf guns have been found to be defective. If you find one, replace it
		 * with a watersquirter.
		 * 
		 * If the toy is not named, "name" it (set to true) but send it to the back of the line. 
		 * 
		 * Repeat this process until the production line is empty
		 * return the array of stacks created
		 * 
		 */

		Stack<ChristmasWrapper> santaBag = new Stack<ChristmasWrapper>();

		while(factoryLine.size() > 0) {
			ChristmasWrapper toy = factoryLine.poll();

			if (toy.getToy().equals(Toy.NERFGUN)) 
			{
				toy.setToy(Toy.WATERSQUIRTER);
			}

			if (toy.isNamed()) 
			{
				santaBag.add(toy);
			} 
			else 
			{
				toy.setNamed(true);
				factoryLine.add(toy);
			}
		}


		return santaBag;
	}



	/**
	 * Comparator for class type card
	 */
	public static class ToyComparator implements Comparator<ChristmasWrapper> {

		public ToyComparator() {

		}

		@Override
		public int compare(ChristmasWrapper first, ChristmasWrapper second) {
			/* TODO To find a toy with the higher priority, you must compare the relation of (demand / price) and return the difference
			 * 
			 * If the first toy has a higher demand to price ratio, the comparison must return a positive integer, 
			 * 0 if they're the same, and negative otherwise.
			 * 
			 */
			return -1; //Dummy return
		}	
	}


}
