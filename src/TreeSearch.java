import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreeSearch {

	public static BTree tree;

	static ArrayList<String> commands;

	public static void main(String[] args) {
		FileReader reader = new FileReader(args[0]);
		commands = reader.readFile();

		tree = new BTree(reader.getM());
		System.out.println("M: " + reader.getM());

		callCommands();
	}

	public static void callCommands() {
		for (String s : commands) {

			if (s.contains("Insert") || s.contains("insert")) {
				tree.insert(parseDouble(s), "null");
			} else if (s.contains("Search") || s.contains("search")) {
				if (s.contains(",")) {
					// there are two doubles that you need to parse
				}
				tree.search(parseDouble(s));
			}

		}
	}

	public static double parseDouble(String s) {
		Pattern p = Pattern.compile("-?\\d+(\\.\\d+)?");
		Matcher m;
		m = p.matcher(s);
		if (m.find()) {
			
			return Double.parseDouble(s.substring(m.start(), m.end()));
		}

		return 0.0;
	}

}
