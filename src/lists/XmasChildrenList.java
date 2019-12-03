package lists;
import children.XmasChild;

public class XmasChildrenList extends ChildrenList {
	public boolean AddXmasChild(XmasChild childToAdd) {
		
		AddChild(childToAdd);
		
		return true;
	}
}
