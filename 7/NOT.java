// Advent of Code, day 7
// Luke Mitchell
// github.com/lukem512

import java.util.*;

public class NOT extends Gate {

	public Boolean decode (String command) {
		String[] tokens = tokenize(command);

		if (!tokens[0].equals("NOT")) {
			return false;
		}

		inputs.add(tokens[1]);
		output = tokens[3];

		return true;
	}

	public Boolean simulate (HashMap<String, Integer>  wires, Boolean debug) {

		if (!ready(wires)) {
			return false;
		}

        // Bitwise complement
        int value = ~wires.get(inputs.get(0));
        value &= 0xFFFF;
        wires.put(output, value);

        if (debug) {
	        System.out.println("[NOT] Assigning " + output + " the value " + value + " (~" + inputs.get(0) + ")");
        }

        return true;
	}
}