package interfaces;

import java.util.ArrayList;
import java.util.Arrays;

import children.Child;
import human.Human;

public class AbstractHumanList implements IHumanListable {
	/**
	 * Inner list
	 */
	private ArrayList<Human> innerHumanList = new ArrayList<>();

	@Override
	public boolean add(Human human) {
		innerHumanList.add(human);
		return true;
	}

	@Override
	public Human remove(int index) {
		return innerHumanList.remove(index);
	}

	@Override
	public int length() {
		return innerHumanList.size();
	}
	
	@Override
	public String toString() {
		return Arrays.toString(innerHumanList.toArray());
	}
}
