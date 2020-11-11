package com.creation.view.core;

import javax.swing.*;
import java.awt.*;

public class SwingProps {
    public static void setStartWindowCenter(JFrame frame, int sizeWidth, int sizeHeight) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((screenSize.width - sizeWidth) / 2, (screenSize.height - sizeHeight) / 2);
    }

    public static void setStartWindowCenter(JDialog dialog, int sizeWidth, int sizeHeight) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setLocation((screenSize.width - sizeWidth) / 2, (screenSize.height - sizeHeight) / 2);
    }

    public static void setStandardSettings(JFrame frame) {
        frame.setTitle("Market Place");
        frame.setPreferredSize(new Dimension(200, 100));
        SwingProps.setStartWindowCenter(frame, 200, 100);
    }
}
