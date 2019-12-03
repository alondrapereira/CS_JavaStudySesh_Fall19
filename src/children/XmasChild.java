package children;

public class XmasChild extends Child {
	
	private GoodnessRank rank;

	public XmasChild(String firstName, String lastName, int age, GoodnessRank rank) {
		super(firstName, lastName, age);
		this.rank = rank;
	}
	
	public XmasChild(Child child, GoodnessRank rank) {
		super(child.getFirstName(), child.getLastName(), child.getAge());

		this.rank = rank;
	}
	
	public boolean isNice() {
		return rank == GoodnessRank.Nice;
	}

	public boolean isNaughty() {
		return rank == GoodnessRank.Naughty;
	}
	
	@Override
	public String toString() {
		return "XmasChild[name:'" + firstName + " " + lastName + 
				"', age: " + age + ", Rank: " + rank.toString() + "]";
	}
}
