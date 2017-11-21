import java.util.TreeMap;
import java.util.Set;

public class Node {

	private int NUM_OF_DUPLICATES_ALLOWED = 5;

	public int order;

	public int numPairs;

	public TreeMap<Double, String[]> pairs;

	public Node[] children;

	public Node(int order) {
		this.order = order;

		// B+ Tree of order m can have m children, but only up to m-1 pairs
		this.numPairs = 0;
		this.pairs = new TreeMap<Double, String[]>();

		this.children = new Node[order];
	}

	/**
	 * Returns the value of the node.
	 * 
	 * @param key
	 *            the key whose value is being searched
	 * @return value of the node, null if doesn't exist
	 */
	public String[] getVal(double key) {
		return pairs.get(key);
	}

	public Set<Double> getKeys() {
		return pairs.keySet();
	}

	/**
	 * Adds a child specified by the parameter input to the node called. Breaks if
	 * the child is able to be added to the children array (not full), or calls
	 * split if the array is full and needs to be split.
	 * 
	 * @param key
	 *            key of the pair to be added
	 * @param value
	 *            value of the pair to be added
	 * @return true if the key/value pair was successfully added, false if it
	 *         couldn't be added
	 */
	public boolean add(double key, String value) {
		String[] values = new String[NUM_OF_DUPLICATES_ALLOWED];

		// Node still has space for at least one more key/value pair
		if (!pairs.containsKey(key)) {
			values[0] = value;
			pairs.put(key, values);
		} else {
			// Duplicate value, add it to the value array
			values = pairs.get(key);
			for (int i = 0; i < values.length; i++) {
				if (values[i] == null) {
					values[i] = value;
					break;
				}
			}
		}

		return true;

	}

}
