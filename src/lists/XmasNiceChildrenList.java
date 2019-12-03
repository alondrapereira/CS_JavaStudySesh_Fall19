package lists;
import children.Child;
import children.GoodnessRank;
import children.XmasChild;

public class XmasNiceChildrenList extends XmasChildrenList {
	public void AddNiceChild(Child childToAdd) {
		XmasChild niceChild = new XmasChild(childToAdd, GoodnessRank.Nice);
		
		AddChild(niceChild);
	}
	
	public boolean AddNiceChild(XmasChild childToAdd) {
		if (!childToAdd.isNice()) {
			return false;
		}
		
		AddChild(childToAdd);
		
		return true;
	}
}
