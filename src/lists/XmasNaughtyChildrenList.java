package lists;
import children.Child;
import children.GoodnessRank;
import children.XmasChild;

public class XmasNaughtyChildrenList extends XmasChildrenList {
	public void AddXmasChild(Child childToAdd) {
		XmasChild niceChild = new XmasChild(childToAdd, GoodnessRank.Naughty);
		
		AddChild(niceChild);
	}
	
	public boolean AddXmasChild(XmasChild childToAdd) {
		if (!childToAdd.isNaughty()) {
			return false;
		}
		
		AddChild(childToAdd);
		
		return true;
	}
}
