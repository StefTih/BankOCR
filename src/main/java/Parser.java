
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    private ArrayList<String> fileValues;

    Parser () throws FileNotFoundException {
        fileValues = new ArrayList<>();
        extractFile();
    }

    public ArrayList<String> getFileValues() {
        return fileValues;
    }


    public void extractFile() throws FileNotFoundException {

        String values = "";
        try (Scanner file = new Scanner(new File("C:\\Users\\Admin\\Desktop\\IntelijIDEA Projects\\BankOCR\\src\\main\\resources\\bank.txt")))
        {
            int counter = 1;
            while (file.hasNext())
            {
                if(counter > 4)
                {
                    fileValues.add(values);
                    values = file.nextLine();
                    counter = 2;
                }
                else
                {
                    values = values + file.nextLine();
                    counter+=1;
                }

            }
            fileValues.add(values);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
