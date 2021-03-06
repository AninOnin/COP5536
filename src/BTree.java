import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BTree {

	/* Root node (cannot be empty) */
	private Node root;
	/* Order of the B+ Tree */
	public int order;
	/* Max number of keys a node can have (m-1) */
	public int maxKeys;
	/* File that will hold the contents of our output. */
	public String fileName;
	/* Specifies the file that we will write to. */
	public FileWriter fileWriter;
	/* Writer that will allow us to write contents to output file. */
	public PrintWriter printWriter;

	/**
	 * Creates and returns an empty BTree.
	 * 
	 * @param order
	 *            the max number of children this BTree is allowed to have
	 */
	public BTree(int order) {
		this.order = order;
		this.maxKeys = order - 1;

		this.fileName = "output_file.txt";

		try {
			fileWriter = new FileWriter(fileName);
			printWriter = new PrintWriter(fileWriter, true);
		} catch (IOException e) {
			System.err.println("Error: Could not write to output file.");
			e.printStackTrace();
		}

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

		this.fileName = "output_file.txt";

		try {
			fileWriter = new FileWriter(fileName);
			printWriter = new PrintWriter(fileWriter);
		} catch (IOException e) {
			System.err.println("Error: Could not write to output file.");
			System.exit(1);
		}
		root = new Node(order);
		return this;
	}

	public void insert(double key, String value) {
		if (!root.add(key, value)) {
			System.err.println("Error: Insert failed.");
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
			printWriter.println("Null");
		} else {

			for (int i = 0; i < values.length; i++) {
				if (values[i] != null) {
					numCommas++;
				}
			}

			for (String s : values) {
				if (s != null) {
					printWriter.printf("%s", s);
				}
				if (numCommas > 0) {
					printWriter.printf(", ");
					numCommas--;
				}
			}

			printWriter.println();
		}
	}

	/**
	 * Search for the (key,value) pairs in the given range of keys, inclusive
	 * 
	 * @param smallKey
	 *            the small value of the range to be searched
	 * @param largeKey
	 *            the large value of the range to be searched
	 */
	public void search(double smallKey, double largeKey) {
		int numCommas = -1;
		for (double d : root.getKeys()) {
			if (d >= smallKey && d <= largeKey) {
				numCommas++;
			}
		}

		for (double d : root.getKeys()) {
			if (d >= smallKey && d <= largeKey) {
				printWriter.printf("(%.2f, %s)", d, root.getVal(d)[0]);
				if (numCommas > 0) {
					printWriter.printf(", ");
					numCommas--;
				}
			}

		}
		printWriter.println();
	}

}
