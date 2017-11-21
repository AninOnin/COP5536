public class BTree {

	/* Root node (cannot be empty) */
	private Node root;
	/* Order of the B+ Tree */
	public int order;

	/* Max number of keys a node can have (m-1) */
	public int maxKeys;

	/**
	 * Creates and returns an empty BTree.
	 * 
	 * @param order
	 *            the max number of children this BTree is allowed to have
	 */
	public BTree(int order) {
		this.order = order;
		this.maxKeys = order - 1;

		root = new Node(order);
	}

	/**
	 * Does the exact same thing that calling the BTree constructor does, but
	 * conforms to the project requirements.
	 * 
	 * @param order
	 *            the max number of children this BTree is allowed to have
	 * @return BTree (this class)
	 */
	public BTree initialize(int order) {
		this.order = order;
		this.maxKeys = order - 1;

		root = new Node(order);
		return this;
	}

	public void insert(double key, String value) {
		if (!root.add(key, value)) {
			System.err.println("Insert failed.");
		}
	}

	/**
	 * Prints out the value(s) associated with the key. Will print up to
	 * NUM_OF_ALLOWED_DUPLICATES (default 5).
	 * 
	 * @param key
	 *            key being searched for values
	 */
	public void search(double key) {
		String[] values = root.getVal(key);

		int numCommas = -1;

		if (values == null) {
			System.err.println("Null");
		} else {

			for (int i = 0; i < values.length; i++) {
				if (values[i] != null) {
					numCommas++;
				}
			}

			System.out.printf("Key " + key + " has value(s) ");

			for (String s : values) {
				if (s != null) {
					System.out.printf("%s", s);
				}
				if (numCommas > 0) {
					System.out.printf(", ");
					numCommas--;
				}
			}

			System.out.println();
		}
	}

	public double[] search(double smallKey, double largeKey) {

		System.out.println("Search for keys between " + smallKey + " and " + largeKey + ".");
		// TODO: search(key1, key2) returns (all key-value pairs) such that key1 <= key
		// <= key2
		return null;
	}

}
