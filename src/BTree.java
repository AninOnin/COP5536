public class BTree {

	/* Root node (cannot be empty) */
	private Node root;
	private Node current;

	/* Order of the B+ Tree */
	public int order;

	/* Max number of keys a node can have (m-1) */
	public int maxKeys;

	public BTree(int order) {
		this.order = order;
		this.maxKeys = order - 1;

		root = new Node(order);
		current = root;
	}

	public BTree initialize(int m) {
		System.out.println("Calling the initialize() function.");
		// TODO: create a new order m B+ Tree
		return null;
	}

	public void insert(double key, String value) {
		if (root.add(key, value)) {
			System.out.println("Insert successful.");
		} else {
			System.err.println("Insert failed.");
		}
	}

	public void search(double key) {
		System.out.println("Search for " + key + ".");
		String[] values = root.getVal(key);

		if (values == null) {
			System.err.println("Null");
		} else {
			System.out.printf("Key " + key + " has value(s) ");

			for (String s : values) {
				if (s != null) {
					System.out.printf("%s", s);
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
