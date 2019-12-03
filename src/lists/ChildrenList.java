package lists;

import children.Child;

import interfaces.AbstractHumanList;

public class ChildrenList extends AbstractHumanList {
	protected void AddChild(Child childToAdd) {
		add(childToAdd);
	}
	
	protected Child RemoveChild(int index) {
		return (Child) remove(index);
	}
}
