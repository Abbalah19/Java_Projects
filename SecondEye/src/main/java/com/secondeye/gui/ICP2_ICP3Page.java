package com.secondeye.gui;

import javax.swing.JFrame;

public class ICP2_ICP3Page extends JFrame {
    private JFrame frame = new JFrame();

    public ICP2_ICP3Page() {
                // Set up the frame
        frame = this;
        setTitle("SecondEye");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        setUpMenu();

        
    }

    private void setUpMenu() {
        MenuBarUtil.setupMenuBar(this);
    }

}
