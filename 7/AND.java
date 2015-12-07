import java.util.*;

public class AND extends Gate {

	public Boolean decode (String command) {
		String[] tokens = tokenize(command);

		if (!tokens[1].equals("AND")) {
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

		inputs.add(tokens[2]);
		output = tokens[4];

		return true;
	}

	public Boolean simulate (HashMap<String, Integer>  wires, Boolean debug) {

		if (!ready(wires)) {
			return false;
		}

		// Bitwise AND
		int value = (useConstant ? constants.get(0) : wires.get(inputs.get(0)));
		if (useConstant) {
			value &= wires.get(inputs.get(0));
		} else {
			value &= wires.get(inputs.get(1));
		}
        value &= 0xFFFF;
        wires.put(output, value);

        if (debug) {
        	System.out.print("[AND] Assigning " + output + " the value " + value);
        }

        return true;
	}
}