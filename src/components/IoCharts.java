package components;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class IoCharts {
    public void addCharts(int minIoi, int maxIoi, JFrame frame){
        JPanel chartPanel = getChartPanel(minIoi, maxIoi);
        frame.add(chartPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private static JPanel getChartPanel(int min, int max) {
        JPanel chartPanel = new JPanel();

        chartPanel.setLayout(new GridLayout(2,2));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

        chartPanel.setBorder(border);

        addIOCharts(chartPanel, min, max);

        return chartPanel;
    }

    private static void addIOCharts(JPanel chartPanel, int min, int max) {
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 1);
        JPanel roi = new JPanel();
        roi.setBorder(border1);


        Border border2 = BorderFactory.createLineBorder(Color.BLACK, 1);
        JPanel minIoi = new JPanel();
        minIoi.setBorder(border2);

        Border border3 = BorderFactory.createLineBorder(Color.BLACK, 1);
        JPanel maxIoi = new JPanel();
        maxIoi.setBorder(border3);

        Border border4 = BorderFactory.createLineBorder(Color.BLACK, 1);
        JPanel vol = new JPanel();
        vol.setBorder(border4);

        chartPanel.add(roi);
        chartPanel.add(minIoi);
        chartPanel.add(maxIoi);
        chartPanel.add(vol);
    }
}
