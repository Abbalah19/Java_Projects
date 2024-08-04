package com.secondeye;

import com.secondeye.database.DatabaseManager;
import com.secondeye.gui.LogInPage;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.connect();
        dbManager.createTableAndInsertDefaultUser();
        dbManager.close();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LogInPage().setVisible(true);
            }
        });
    }
}