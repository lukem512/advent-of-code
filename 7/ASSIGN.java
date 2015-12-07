// Advent of Code, day 7
// Luke Mitchell
// github.com/lukem512

import java.util.*;

public class ASSIGN extends Gate {
	public Boolean decode (String command) {
		String[] tokens = tokenize(command);

		if (!tokens[1].equals("->")) {
			return false;
		}

		useConstant = true;
		try {
	        int value = Integer.parseInt(tokens[0]);
	        constants.add(value);
	    } catch (NumberFormatException e) {
	        useConstant = false;
	        inputs.add(tokens[0]);
	    }
		
		output = tokens[2];

		return true;
	}

	public Boolean simulate (HashMap<String, Integer>  wires, Boolean debug) {

		if (!ready(wires)) {
			return false;
		}

		// Assignment
		int value = (useConstant ? constants.get(0) : wires.get(inputs.get(0)));
        wires.put(output, value);

        if (debug) {
        	System.out.println("[ASSIGN] Assigning " + output + " the value " + value);
        }

        return true;
	}
}