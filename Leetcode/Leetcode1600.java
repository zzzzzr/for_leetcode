package Leetcode;

import java.util.*;

class ThroneInheritance {
	class People{
		String name;
		boolean isAlive;
		People child;
		People nextBrother;

		public People(String name, boolean isAlive, People child, People nextBrother) {
			this.name = name;
			this.isAlive = isAlive;
			this.child = child;
			this.nextBrother = nextBrother;
		}

		public People() {
		}

		@Override
		public String toString() {
			return "People{" +
					"name='" + name + '\'' +
					", isAlive=" + isAlive +
					'}';
		}
	}

	Map<String, People> map;
	int diedCounts;
	People rootKing;

	public ThroneInheritance(String kingName) {
		map = new HashMap<>();
		People king = new People(kingName, true, null, null);
		map.put(kingName, king);
		diedCounts = 0;
		rootKing = king;
	}

	public void birth(String parentName, String childName) {
		System.out.println(map);
		People parent = map.get(parentName);
		People child = new People(childName, true, null, null);
		if (parent.child == null){
			parent.child = child;
			map.put(childName, child);
		} else {
			People curChild = parent.child;
			while (curChild.nextBrother != null){
				curChild = curChild.nextBrother;
			}
			curChild.nextBrother = child;
			map.put(childName, child);
		}
	}

	public void death(String name) {
		People diedPeople = map.get(name);
		diedPeople.isAlive = false;
		diedCounts++;
	}

	public List<String> getInheritanceOrder() {
		List<String> family = new ArrayList<>(map.size() - diedCounts);
		dfs(rootKing, family);
		return family;
	}

	public void dfs(People curPeople, List<String> family){
		if (curPeople.isAlive){
			family.add(curPeople.name);
		}
		People child = curPeople.child;
//		while (child != null){
//			dfs(child, family);
//			child = child.nextBrother;
//		}
		if (child != null){
			dfs(child, family);
		}
		People brother = curPeople.nextBrother;
//		while (brother != null){
//			dfs(brother, family);
//			brother = brother.nextBrother;
//		}
		if (brother != null){
			dfs(brother, family);
		}
	}
}

public class Leetcode1600 {
	public static void main(String[] args) {
//		Leetcode.ThroneInheritance t= new Leetcode.ThroneInheritance("king");     // 继承顺序：king
//		t.birth("king", "andy");                    // 继承顺序：king > andy
//		t.birth("king", "bob");                     // 继承顺序：king > andy > bob
//		t.birth("king", "catherine");               // 继承顺序：king > andy > bob > catherine
//		t.birth("andy", "matthew");                 // 继承顺序：king > andy > matthew > bob > catherine
//		t.birth("bob", "alex");                     // 继承顺序：king > andy > matthew > bob > alex > catherine
//		t.birth("bob", "asha");                     // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
//		System.out.println(t.getInheritanceOrder());                     // ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
//		t.death("bob");                                            // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
//		System.out.println(t.getInheritanceOrder());                     // ["king", "andy", "matthew", "alex", "asha", "catherine"]

		ThroneInheritance t = new ThroneInheritance("king");
		t.birth("king", "Alice");
		t.birth("king", "Bob");
		t.birth("Alice", "Jack");
		System.out.println(t.getInheritanceOrder());
	}
}
