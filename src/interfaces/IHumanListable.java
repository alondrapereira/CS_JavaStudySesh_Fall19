package interfaces;

import human.Human;

public interface IHumanListable {
	public boolean add(Human human);
	
	public Human remove(int index);
	
	public int length(); 
}
