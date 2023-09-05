import components.UiPanels;

import javax.swing.*;
import java.awt.*;

public class IOTrade {

    public static void main(String[] args) {

        JFrame frame = new JFrame("IOTrading");
        //frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setLayout(new BorderLayout());

        UiPanels uiPanels = new UiPanels(frame);

        // set frame site
        //frame.setMinimumSize(new Dimension(800, 600));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(uiPanels.getIOSetupPanel(), BorderLayout.NORTH);

        // display it
        frame.pack();
        frame.setVisible(true);

    }
}