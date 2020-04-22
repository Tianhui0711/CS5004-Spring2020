/**
 * Extract the text in the element obtained by JSoup and save them as csv file
 */

import com.csvreader.CsvWriter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class CSVEditor {
    public static void write(String meal, ArrayList<String[]> dietList){
        String filePath = meal + ".csv";
        try {
            // create a csvwriter to write csv file
            CsvWriter csvWriter = new CsvWriter(filePath,',', Charset.forName("GBK"));

            // write the top row of the csv file
            String[] headers = {"Name","Rating","Ingredient","Reviewer", "Url"};
            csvWriter.writeRecord(headers);
            // write the information line by line
            for (String[] l : dietList) {
                csvWriter.writeRecord(l);
            }
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
