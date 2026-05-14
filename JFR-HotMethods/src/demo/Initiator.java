package demo;
import java.util.*;

public class Initiator {
	private Collection<Integer> collection;

	public Initiator() {
		collection = new HashSet<Integer>();
	}

	// Hint: This creates a list of unique elements!
	public void initiate(int seed) {
		collection.clear();
		for (Integer i = 1; i < 10000; i++) {
			if ((i % seed) != 0)
				collection.add(i);
		}
	}

	protected Collection<Integer> getCollection() {
		return collection;
	}

	public int countIntersection(Initiator other) {
		int count = 0;
		for (Integer i : collection) {
			if (other.getCollection().contains(i)) {
				count++;
			}
		}
		return count;
	}
}
