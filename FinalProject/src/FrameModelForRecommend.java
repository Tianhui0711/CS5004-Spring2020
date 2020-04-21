import javax.swing.*;
import java.awt.*;

public class FrameForRecommend extends MyFrame{
    JTextArea breakfast;
    JTextArea lunch;
    JTextArea dinner;
    JTextArea dessert;
    CrawlerController crawlerController;

    public FrameForRecommend() {
        super();
        window.setTitle("Daily Recipes Recommendation");
        label.setText("Today's Special:");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        crawlerController = new CrawlerController();
        String[] recommend = crawlerController.recipeCollect();

        JTextArea[] mealList = new JTextArea[]{breakfast, lunch, dinner,dessert};

        for (int i = 0; i < 4; i++) {
            mealList[i] = new JTextArea(6,2);
            mealList[i].setText(recommend[i]);
            mealList[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel.add(mealList[i]);
        }

        panel.setLayout(new GridLayout(5, 1, 10, 10));

        window.pack();
        window.setVisible(true);
    }

//    public static void main(String[] args) {
//        FrameForRecommend f = new FrameForRecommend();
//    }
}