import java.util.*;

public class OR extends Gate {

	public Boolean decode (String command) {
		String[] tokens = tokenize(command);

		if (!tokens[1].equals("OR")) {
			return false;
		}

		inputs.add(tokens[0]);
		inputs.add(tokens[2]);
		output = tokens[4];

		return true;
	}

	public Boolean simulate (HashMap<String, Integer> wires, Boolean debug) {

		if (!ready(wires)) {
			return false;
		}

		// Bitwise OR
        int value = wires.get(inputs.get(0)) | wires.get(inputs.get(1));
        value &= 0xFFFF;
        wires.put(output, value);

        if (debug) {
        	System.out.println("[OR] Assigning " + output + " the value " + value + " (" + inputs.get(0) + " | " + inputs.get(1) + ")");
        }

        return true;
	}
}