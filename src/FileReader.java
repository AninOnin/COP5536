import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

	String filename;

	ArrayList<String> fileContents;

	public FileReader(String filename) {
		this.filename = filename;

		fileContents = new ArrayList<String>();
	}

	/**
	 * Reads in the file specified by parameter filename and stores it in a string
	 * array. One line per one index.
	 * 
	 * @param filename
	 *            name of the file to be read
	 */
	public ArrayList<String> readFile() {
		File file = new File(filename);
		Scanner reader;

		try {
			reader = new Scanner(file);

			while (reader.hasNext()) {
				fileContents.add(reader.nextLine());
				// System.out.println("fileContents: " + fileContents.get(i++));
			}

			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found.");
			System.exit(1);
		}

		return fileContents;
	}

	public int getM() {
		if (fileContents.size() != 0) {
			return Integer.parseInt(fileContents.get(0));
		} else {
			return -1;
		}
	}

}
