/**
 * The frame for the launch window, extending the FrameModel
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameForStart extends FrameDefault {
    JCheckBox download;
    JCheckBox recommend;
    JButton enter;

    public FrameForStart() {
        super();
        window.setTitle("Daily Recipes Download and Recommendation");
        label.setText("--- Daily Recipes Download and Recommendation ---");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.black));

        // use the checkbox to let the user decide which action to do
        download = new JCheckBox("Download Recipes for your breakfast, lunch, dinner and dessert.");
        recommend = new JCheckBox("Recommend today's meals.");

        enter = new JButton("GO!");

        enter.addActionListener(new buttonListener());

        panel.add(download);
        panel.add(recommend);
        panel.add(enter);
        panel.setLayout(new GridLayout(4,2));

        window.pack();
        window.setVisible(true);
    }

    // create a listener to keep track of the button
    private class buttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // open new windows according to the select status of the checkboxes
            if (download.isSelected() && ! recommend.isSelected()) {
                FrameForDownload d = new FrameForDownload();
            } else if (! download.isSelected() && recommend.isSelected()) {
                FrameForRecommendation r = new FrameForRecommendation();
            } else {
                FrameForDownload d = new FrameForDownload();
                FrameForRecommendation r = new FrameForRecommendation();
            }
        }
    }
}
