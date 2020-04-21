import javax.swing.*;
import java.awt.*;

public class FrameForDownload extends MyFrame{
    JLabel message;
    CrawlerController crawlerController;

    public FrameForDownload() {
        super();
        window.setTitle("Daily Recipes Download");
        label.setText("Recipes have been downloaded successfully!");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        message = new JLabel("Saved as breakfast.csv, lunch.csv, dinner.csv and " +
                "dessert.csv in your folder.");

        crawlerController = new CrawlerController();
        crawlerController.downLoadDiet();

        panel.add(message);
        panel.setLayout(new GridLayout(2, 1));

        window.pack();
        window.setVisible(true);
    }

//    public static void main(String[] args) {
//        FrameForDownload f = new FrameForDownload();
//    }
}
