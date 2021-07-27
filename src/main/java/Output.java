import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class Output {

    private HashMap<String,String> mapping;
    Processor processor;
    String accountNumbers;

    Output() throws IOException {
        accountNumbers = "";
        mapping = new HashMap<>();
        loadMappings();
        processor = new Processor();
        processor.convertFile();

    }

    public void loadMappings()
    {
        mapping.put("   "+"\n"+"  |"+"\n"+"  |","1");
        mapping.put(" _ "+"\n"+" _|"+"\n"+"|_ ","2");
        mapping.put(" _ "+"\n"+" _|"+"\n"+" _|","3");
        mapping.put("   "+"\n"+"|_|"+"\n"+"  |","4");
        mapping.put(" _ "+"\n"+"|_ "+"\n"+" _|","5");
        mapping.put(" _ "+"\n"+"|_ "+"\n"+"|_|","6");
        mapping.put(" _ "+"\n"+"  |"+"\n"+"  |","7");
        mapping.put(" _ "+"\n"+"|_|"+"\n"+"|_|","8");
        mapping.put(" _ "+"\n"+"|_|"+"\n"+" _|","9");
    }

    public String getAccountNumbers()
    {
        Iterator iterator = processor.getArrayList().iterator();
        while (iterator.hasNext())
        {
            String[][] line = (String[][]) iterator.next();
            String accountNumber = "";
            for(int i = 0; i<line[0].length; i++)
            {
                accountNumber = accountNumber + mapping.get(line[0][i]+"\n"+line[1][i]+"\n"+line[2][i]);
            }
            if (accountNumber.contains("null"))
            {
                accountNumbers = accountNumbers + "This is a invalid account number" + "\n";
            }
            else
            {
                accountNumbers = accountNumbers + accountNumber + "\n";
            }

        }
        return accountNumbers;
    }

    public static void main(String[] args) throws IOException {
        Output output = new Output();
        System.out.println(output.getAccountNumbers());
    }
}
