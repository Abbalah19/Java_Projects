package com.secondeye;

import javax.swing.SwingUtilities;

import com.secondeye.database.AccountManager;
import com.secondeye.gui.LogInPage;

public class Main {
    public static void main(String[] args) {
        AccountManager dbManager = new AccountManager();
        AccountManager.connect();
        dbManager.createTableAndInsertDefaultUser();


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LogInPage().setVisible(true);
            }
        });
        dbManager.close();
    }
}