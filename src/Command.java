
public class Command {

	String command;
	String value;

	double d1;
	double d2;

	public Command(String command) {
		this.command = command.toLowerCase();
	}

	public String getCommand() {
		return command;
	}

	public void setValue(String value) {
		if (command.equalsIgnoreCase("search")) {
			System.err.println("Error: search command cannot have Value element.");
		} else {
			this.value = value;
		}
	}

	public String getValue() {
		if (command.equalsIgnoreCase("search")) {
			System.err.println("Error: search command cannot have Value element.");
		} else {
			return value;
		}
		return null;
	}

	public void setD1(double d1) {
		this.d1 = d1;
	}

	public double getD1() {
		return d1;
	}

	public void setD2(double d2) {
		if (command.equalsIgnoreCase("insert")) {
			System.err.println("Error: insert command cannot have two doubles.");
		} else {
			this.d2 = d2;
		}
	}

	public double getD2() {
		if (command.equalsIgnoreCase("insert")) {
			System.err.println("Error: insert command cannot have two doubles.");
		} else {
			return d2;
		}
		return Double.MIN_VALUE;
	}

	public boolean rangeSearch() {
		if (d2 != Double.MIN_VALUE) {
			return true;
		} else {
			return false;
		}
	}

}
