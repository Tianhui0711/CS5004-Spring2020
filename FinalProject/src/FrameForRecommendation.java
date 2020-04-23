/**
 * The frame for the Recipe Recommend, extending the FrameModel
 */

import javax.swing.*;
import java.awt.*;

public class FrameForRecommendation extends FrameDefault {
    JTextArea breakfast;
    JTextArea lunch;
    JTextArea dinner;
    JTextArea dessert;
    CrawlerControllerImpl crawlerControllerImpl;

    public FrameForRecommendation() {
        super();
        window.setTitle("Daily Recipes Recommendation");
        label.setText("Today's Special:");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        crawlerControllerImpl = new CrawlerControllerImpl();
        String[] recommend = crawlerControllerImpl.recipeCollect();

        JTextArea[] mealList = new JTextArea[]{breakfast, lunch, dinner,dessert};

        // add recipes to the panel
        for (int i = 0; i < 4; i++) {
            mealList[i] = new JTextArea(6,2);
            mealList[i].setText(recommend[i]);
            mealList[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel.add(mealList[i]);
        }

        panel.setLayout(new GridLayout(5, 2, 10, 10));

        window.pack();
        window.setVisible(true);
    }
}
