import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
 

public class csvwriter {
     
    //Delimiter used in CSV file
    static String seperator = ",";
    static String newLine = "\n";

    // CSV file header
    static String header = "chromosome,type,startsite,endsite";

    public static void writecsvFile(List<List<String>> l1, String fileName) {
        FileWriter fileWriter = null;
        String pathName = fileName + ".csv"; 
        try {
            fileWriter = new FileWriter(pathName);

            // Write the CSV file header
            fileWriter.append(header.toString());

            // Add a new line separator after the header
            fileWriter.append(newLine);

            // Write a new student object list to the CSV file
            for (List<String> l2 : l1) {
                for (String s : l2) {
                    fileWriter.write(s);
                    fileWriter.write(seperator);
                }
                fileWriter.write(newLine);
            }
 
             
             
            System.out.println("CSV file was created successfully !!!");
             
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
             
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
             
        }
    }
}