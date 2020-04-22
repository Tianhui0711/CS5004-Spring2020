import com.csvreader.CsvWriter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Extract the text in the element obtained by JSoup and save them as csv file
 */

public class CSVEditor {
    public static void write(String meal, ArrayList<String[]> dietList){
        String filePath = meal + ".csv";
        File diet = new File(filePath);
        try {
            // 创建CSV写对象
            // 中文乱码，修改编码为gbk
            CsvWriter csvWriter = new CsvWriter(filePath,',', Charset.forName("GBK"));

            // 写表头
            String[] headers = {"Name","Rating","Ingredient","Reviewer", "Url"};
            csvWriter.writeRecord(headers);
            for (String[] l : dietList) {
                csvWriter.writeRecord(l);
            }
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        HTMLGetter html = new HTMLGetter("breakfast");
//        String h = html.getHTML(1);
//        HTMLParser p = new HTMLParser(h);
//        ArrayList l = p.getMeals();
//        write("Breakfast", l);
//    }
}
