package human;

public class Human {
	protected String firstName;
	protected String lastName;
	protected int age;
	
	public Human(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	/**
	 * Get child first name
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Get child last name
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Get child age
	 * @return age
	 */
	public int getAge() {
		return age;
	}
}
