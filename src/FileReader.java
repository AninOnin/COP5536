import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

	String filename;
	Command cmd;
	ArrayList<Command> commands;

	int order;

	public FileReader(String filename) {
		this.filename = filename;
		this.order = -1;

		cmd = null;

		commands = new ArrayList<Command>();
	}

	/**
	 * Reads in the file specified by parameter filename and stores it in a string
	 * array. One line per one index.
	 * 
	 * @param filename
	 *            name of the file to be read
	 */
	public ArrayList<Command> getCommands() {
		File file = new File(filename);
		Scanner reader;

		try {
			reader = new Scanner(file);

			order = reader.nextInt();
			reader.nextLine();

			while (reader.hasNext()) {
				String s = reader.nextLine();
				s.split("\\(");
			}

			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found.");
			System.exit(1);
		}

		return commands;
	}

	public int getOrder() {
		return order;
	}

}
