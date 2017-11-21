import java.util.ArrayList;

public class TreeSearch {

	public static BTree tree;

	static ArrayList<Command> commands;

	public static void main(String[] args) {
		FileReader reader = new FileReader(args[0]);
		commands = reader.getCommands();

		tree = new BTree(reader.getOrder());
		System.out.println("M: " + reader.getOrder());

		callCommands();
	}

	public static void callCommands() {
		for (Command c : commands) {

			if (c.getCommand().equals("insert")) {
				tree.insert(c.getD1(), c.getValue());
			} else if (c.getCommand().equals("search")) {
				if (c.isRangeSearch()) {
					// there are two doubles that you need to parse
					tree.search(c.getD1(), c.getD2());
				} else {
					tree.search(c.getD2()); // have to use D2 instead of D1 because of the parsing algorithm
				}
			}

		}
	}

}
