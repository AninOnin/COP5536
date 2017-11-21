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
	 * Reads in the file specified by parameter filename and parses it for command
	 * name and parameter(s). It will create an array list to hold Command objects
	 * and return it.
	 * 
	 * @param filename
	 *            name of the file to be read
	 * @return commands a list of Command objects
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

				String[] split = s.split("\\("); // split: split[0]==command ; split[1]==double,double/value)
				cmd = new Command(split[0]);

				if (split[0].contains("earch") && split[1].contains(",")) {
					cmd.setRangeSearch(true);
				}

				if (split[1].contains(",")) {
					split = split[1].split("\\,"); // split: split[0]==double ; split[1]==double/value)
					cmd.setD1(Double.parseDouble(split[0]));
				}

				if (cmd.getCommand().equals("insert")) {
					split = split[1].split("\\)"); // split: split[0]==value ; (no split[1])
					cmd.setValue(split[0]);
				} else if (cmd.getCommand().equals("search")) {
					split = split[1].split("\\)"); // split: split[0]==double ; (no split[1])
					cmd.setD2(Double.parseDouble(split[0]));
				}

				commands.add(cmd);

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
