// Advent of Code, day 7
// Luke Mitchell
// github.com/lukem512

import java.util.*;

public abstract class Gate {
	protected ArrayList<String> inputs;
	protected ArrayList<Integer> constants;
	protected String output;
	protected Boolean useConstant;

	protected String[] tokenize (String command) {
		return command.split(" ");
	}

	protected Boolean ready(HashMap<String, Integer> wires) {
		for (String input : inputs) {
			Integer value = wires.get(input);
			if (value == null) {
				return false;
			}
		}
		return true;
	}

	protected Gate() {
		inputs = new ArrayList<String>();
		constants = new ArrayList<Integer>();
		useConstant = false;
	}

	public abstract Boolean decode (String command);
	public abstract Boolean simulate (HashMap<String, Integer> wires, Boolean debug);
}