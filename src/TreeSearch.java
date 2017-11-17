public class TreeSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader reader = new FileReader(args[0]);

		reader.readFile();
		System.out.println("M: " + reader.getM());
	}

}
