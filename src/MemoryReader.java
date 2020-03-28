import java.io.*;

public class MemoryReader {
    public static void main (String[] args) throws FileNotFoundException, IOException, NullPointerException {
        String strategy;
        String fileName;
        if (args.length == 2){
            strategy = args[0];
            fileName = args[1];
        }else {
            strategy = "Memory";
            fileName = args[0];
        }
        Memory memory = null;

        switch (strategy) {
            case "Cyclic":
                memory = new Cyclic(4);
                break;
            case "LRU":
                memory = new LRU(4);
                break;
            case "Random":
                memory = new Random(4);
                break;
            case "Memory":
                memory = new Memory();
        }
        File file = new File(fileName);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        while (line != null){
            int address = Integer.parseInt(line);
            System.out.println(memory.lookup(address));
            line = bufferedReader.readLine();
        }
        System.out.printf("Memory Hit: %d \nMethod Name:%s", memory.getHitCount(), memory.getName());

    }
}
