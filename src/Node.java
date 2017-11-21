public class Node {

	public int order;

	public int numPairs;
	public double[] keys;
	public String[] values;

	public int numChildren;
	public Node[] children;

	public Node(int order) {
		this.order = order;

		// B+ Tree of order m can have m children, but only up to m-1 pairs
		this.numPairs = 0;
		this.keys = new double[order - 1];
		this.values = new String[order - 1];

		this.numChildren = 0;
		this.children = new Node[order];
	}

	/**
	 * Returns the key of the node.
	 * 
	 * @return key of the node
	 */
	public double[] getKeys() {
		return keys;
	}

	/**
	 * Returns the value of the node.
	 * 
	 * @return value of the node, null if doesn't exist
	 */
	public String getVal(double key) {
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] == key) {
				// Returns corresponding value
				return values[i];
			}
		}

		return null;
	}

	/**
	 * Adds a child specified by the parameter input to the node called. Breaks if
	 * the child is able to be added to the children array (not full), or calls
	 * split if the array is full and needs to be split.
	 * 
	 * @param child
	 * @return
	 */
	public boolean add(double key, String value) {
		if (numPairs < order - 1) {
			// Node still has space for at least one more key/value pair
			keys[numPairs] = key;
			values[numPairs] = value;
			numPairs++;

			return true;
		}

		return false;
	}

}
