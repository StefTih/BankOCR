


import java.io.*;

import java.util.ArrayList;


public class Parser {

    private ArrayList<String> fileValues;

    Parser () throws IOException {
        fileValues = new ArrayList<>();
        extractFile();
    }

    public ArrayList<String> getFileValues() {
        return fileValues;
    }


    public void extractFile() throws IOException {


        File file = new File("C:\\Users\\Admin\\Desktop\\IntelijIDEA Projects\\BankOCR\\src\\main\\resources\\bank.txt");
        StringBuilder stringbuilder = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            int counter = 1;
            while ((line = reader.readLine()) != null)
            {
                if(line.length()<27 && !line.equals(""))
                {
                    stringbuilder.append(line).append(" ");
                }
                else
                {
                    stringbuilder.append(line);
                }

                counter+=1;
                if (counter > 4)
                {
                    fileValues.add(stringbuilder.toString());
                    stringbuilder.delete(0,stringbuilder.length());
                    counter = 0;
                }
            }
            fileValues.add(stringbuilder.toString());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

//        String values = "";
//        try (Scanner file = new Scanner(new File("C:\\Users\\Admin\\Desktop\\IntelijIDEA Projects\\BankOCR\\src\\main\\resources\\bank.txt")))
//        {
//            int counter = 1;
//            while (file.hasNext())
//            {
//                if(counter > 4)
//                {
//                    fileValues.add(values);
//                    values = file.nextLine();
//                    counter = 2;
//                }
//                else
//                {
//                    values = values + file.nextLine();
//                    counter+=1;
//                }
//
//            }
//            fileValues.add(values);
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//    }
}
