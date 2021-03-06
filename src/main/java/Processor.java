
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Processor {

    private static final int NUM_LINES = 3;
    private static final int NUM_CHARACTERS = 9;

    private Parser parser;
    private ArrayList<String> file;

    private ArrayList<String[][]> arrayList;

    Processor () throws IOException {
        parser = new Parser();
        arrayList = new ArrayList<>();
        file = parser.getFileValues();
    }

    public ArrayList<String[][]> getArrayList() {
        return arrayList;
    }

    public void convertFile() {
        Iterator<String> iterator = file.iterator();
        while (iterator.hasNext()) {
            int size = 3;
            String[] strings = iterator.next().split("(?<=\\G.{"+size+"})");
            String[][] line = new String[NUM_LINES][NUM_CHARACTERS];
            int j = 0;
            int counter = 0;
            for(int i = 0; i<strings.length; i++) {
                line[j][counter] = strings[i];
                counter+=1;
                if (counter>8) {
                    j += 1;
                    counter = 0;
                }
            }
            arrayList.add(line);
        }



    }


}
