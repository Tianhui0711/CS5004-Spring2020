/**
 * The frame for the Download page, extending the FrameModel
 */

import javax.swing.*;
import java.awt.*;

public class FrameForDownload extends FrameDefault {
    JLabel message;
    CrawlerControllerImpl crawlerControllerImpl;

    public FrameForDownload() {
        super();
        window.setTitle("Daily Recipes Download");
        label.setText("Recipes have been downloaded successfully!");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        message = new JLabel("Saved as breakfast.csv, lunch.csv, dinner.csv and " +
                "dessert.csv in your folder.");

        crawlerControllerImpl = new CrawlerControllerImpl();
        crawlerControllerImpl.downLoadDiet();

        panel.add(message);
        panel.setLayout(new GridLayout(2, 1));

        window.pack();
        window.setVisible(true);
    }
}
