import org.junit.*;

import children.GoodnessRank;
import children.XmasChild;
import lists.XmasChildrenList;
import lists.XmasNaughtyChildrenList;
import lists.XmasNiceChildrenList;

public class TestXmasChildrenAdd {

	@Test
	public void addNiceChildrenToList() {
		
		XmasChildrenList list = new XmasChildrenList();
		
		XmasChild[] clist = {
				new XmasChild("Gabriel", "Santiago", 12, GoodnessRank.Nice),
				new XmasChild("John", "Appleseed", 9, GoodnessRank.Nice),
		};
		
		
		for(XmasChild c : clist) {
			list.AddXmasChild(c);
		}
		
		System.out.println(list);
	}

	@Test
	public void addNewChildToList() {
		
		XmasChildrenList list = new XmasChildrenList();
		
		XmasChild[] clist = {
				new XmasChild("Gabriel", "Santiago", 12, GoodnessRank.Naughty),
				new XmasChild("John", "Appleseed", 9, GoodnessRank.Naughty),
		};
		
		for(XmasChild c : clist) {
			list.AddXmasChild(c);
		}
		
		System.out.println(list);
	}
	

	@Test
	public void addNiceChildToList() {
		
		XmasNiceChildrenList  list = new XmasNiceChildrenList();
		
		XmasChild[] clist = {
				new XmasChild("Gabriel", "Santiago", 12, GoodnessRank.Nice),
				new XmasChild("John", "Appleseed", 9, GoodnessRank.Nice),
		};
		
		for(XmasChild c : clist) {
			list.AddNiceChild(c);
		}
		
		System.out.println(list);
	}
	

	@Test
	public void addNaughtyChildToList() {
		
		XmasNaughtyChildrenList  list = new XmasNaughtyChildrenList();
		
		XmasChild[] clist = {
				new XmasChild("Gabriel", "Santiago", 12, GoodnessRank.Naughty),
				new XmasChild("John", "Appleseed", 9, GoodnessRank.Naughty),
				new XmasChild("Juan", "Mayor", 16, GoodnessRank.Nice),
		};
		
		for(XmasChild c : clist) {
			System.out.println(list.AddXmasChild(c));
		}
		
		System.out.println(list);
	}
}
