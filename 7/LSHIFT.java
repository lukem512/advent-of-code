// Advent of Code, day 7
// Luke Mitchell
// github.com/lukem512

import java.util.*;

public class LSHIFT extends Gate {

	public Boolean decode (String command) {
		String[] tokens = tokenize(command);

		if (!tokens[1].equals("LSHIFT")) {
			return false;
		}

		inputs.add(tokens[0]);

		int value = Integer.parseInt(tokens[2]);
		constants.add(value);
		output = tokens[4];

		return true;
	}

	public Boolean simulate (HashMap<String, Integer>  wires, Boolean debug) {

		if (!ready(wires)) {
			return false;
		}

		// Right-shift
        int value = wires.get(inputs.get(0)) << constants.get(0);
        value &= 0xFFFF;
        wires.put(output, value);

        if (debug) {
        	System.out.println("[LSHIFT] Assigning " + output + " the value " + value + " (" + inputs.get(0) + " << " + constants.get(0) + ")");
        }

        return true;
	}
}