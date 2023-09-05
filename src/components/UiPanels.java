package components;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UiPanels {
    JFrame frame;
    IoCharts charts = new IoCharts();

    public UiPanels(JFrame frame){
        this.frame = frame;
    }
    public JPanel getIOSetupPanel(){
        JPanel jPanel = new JPanel();//new FlowLayout(FlowLayout.LEFT));

        JLabel minIoiLabel = new JLabel("Enter Min Ioi");
        JTextField minIoi = new JTextField(); minIoi.setColumns(20);
        JLabel maxIoiLabel = new JLabel("Enter Max Ioi");
        JTextField maxIoi = new JTextField(); maxIoi.setColumns(20);

        ((AbstractDocument) minIoi.getDocument()).setDocumentFilter(new NumericFilter());
        ((AbstractDocument) maxIoi.getDocument()).setDocumentFilter(new NumericFilter());

        JButton submit = new JButton("Submit");

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String minIoiVal = minIoi.getText();
                String maxIoiVal = maxIoi.getText();

                int minIoiIntVal = Integer.parseInt(minIoiVal);
                int maxIoiIntVal = Integer.parseInt(maxIoiVal);

                charts.addCharts(minIoiIntVal, maxIoiIntVal, frame);
            }
        });

        jPanel.add(minIoiLabel);
        jPanel.add(minIoi);

        jPanel.add(maxIoiLabel);
        jPanel.add(maxIoi);

        jPanel.add(submit);

        return jPanel;
    }

    private static class NumericFilter extends DocumentFilter {
        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
            if (isNumeric(text)) {
                super.insertString(fb, offset, text, attr);
            }
        }

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (isNumeric(text)) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        private boolean isNumeric(String text) {
            return text.matches("\\d*");
        }
    }
}
