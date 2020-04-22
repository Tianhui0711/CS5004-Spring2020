import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameModelForStart extends FrameModel {
    JCheckBox download;
    JCheckBox recommend;
    JButton enter;

    public FrameModelForStart() {
        super();
        window.setTitle("Daily Recipes Download and Recommendation");
        label.setText("--- Daily Recipes Download and Recommendation ---");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.black));

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

    private class buttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (download.isSelected() && ! recommend.isSelected()) {
                FrameModelForDownload d = new FrameModelForDownload();
            } else if (! download.isSelected() && recommend.isSelected()) {
                FrameModelForRecommend r = new FrameModelForRecommend();
            } else {
                FrameModelForDownload d = new FrameModelForDownload();
                FrameModelForRecommend r = new FrameModelForRecommend();
            }
        }
    }
}
