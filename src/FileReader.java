import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	String filename;

	String fileContents[];

	public FileReader(String filename) {
		this.filename = filename;
	}

	/**
	 * Reads in the file specified by parameter filename and stores it in a string
	 * array. One line per one index.
	 * 
	 * @param filename
	 *            name of the file to be read
	 */
	public void readFile() {
		File file = new File(filename);
		Scanner reader;

		try {
			reader = new Scanner(file);
			int i = 0;

			while (reader.hasNext()) {
				fileContents[i++] = reader.nextLine();
			}

			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found.");
			System.exit(1);
		}
	}

	public int getM() {
		if (fileContents.length != 0) {
			return Integer.parseInt(fileContents[0]);
		} else {
			return -1;
		}
	}

}
