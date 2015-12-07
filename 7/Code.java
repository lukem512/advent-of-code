import java.util.*;
import java.io.*;

public class Code {
    // Note: int is 32-bit but Java doesn't have
    // a 16-bit unsigned type
    public HashMap<String, Integer> wires;
    private ArrayList<Gate> stack;

    public Code() {
        wires = new HashMap<String, Integer>();
        stack = new ArrayList<Gate>();
    }

    private void go(Gate g, String command) {
        g.decode(command);
        stack.add(g);
    }

    public Boolean finished() {
        return (stack.size() == 0);
    }

    public void queue(String command) {
        String tokens[] = command.split(" ");
        if (command.lastIndexOf("NOT") != -1) {
            go (new NOT(), command);
        } else
        if (command.lastIndexOf("AND") != -1) {
            go (new AND(), command);
        } else
        if (command.lastIndexOf("OR") != -1) {
            go (new OR(), command);
        } else
        if (command.lastIndexOf("RSHIFT") != -1) {
            go (new RSHIFT(), command);
        } else
        if (command.lastIndexOf("LSHIFT") != -1) {
            go (new LSHIFT(), command);
        } else {
            go (new ASSIGN(), command);
        }
    }

    public void simulate(Boolean debug) {
        Iterator<Gate> i = stack.iterator();
        while (i.hasNext()) {
            Gate g = i.next();

            if (g.simulate(wires, debug)) {
                i.remove();
            }
        }
    }

    public static void main (String[] args) {
        Boolean debug = false;
        Code c = new Code();

        File file = new File("input");
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                c.queue(line);
            }
        } catch (FileNotFoundException e) {
            System.err.print(e);
        } catch (IOException e) {
            System.err.print(e);
        }

        while (!c.finished()) {
            c.simulate(debug);
        }

        if (debug) {
            for (Map.Entry<String, Integer> entry : c.wires.entrySet()) {
              String key = entry.getKey();
              Integer value = entry.getValue();
              System.out.print(key);
              System.out.print(" = ");
              System.out.print(value);
              System.out.print("\n");
            }
        }

        System.out.println("The output of wire a in little Bobby\'s kit is " + c.wires.get("a"));
    }
}