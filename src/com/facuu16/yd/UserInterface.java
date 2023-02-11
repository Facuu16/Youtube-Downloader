package com.facuu16.yd;

import com.facuu16.yd.listener.DownloadButtonListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import java.io.File;

public class UserInterface {
    private JButton download;
    private JFrame frame;
    private JTextField url;

    public UserInterface() {
        createUIComponents();
        download.addActionListener(new DownloadButtonListener(this));
    }

    public void createUIComponents() {
        frame = new JFrame("Youtube Downloader");
        frame.setSize(600, 400);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Font font = new Font("Consolas", Font.PLAIN, 14);
        final Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);

        download = new JButton("DOWNLOAD");
        download.setBounds(200, 150, 180, 30);
        download.setFont(font);
        download.setBorder(border);

        url = new JTextField("PASTE URL HERE");
        url.setBounds(200, 100, 180, 30);
        url.setFont(font);
        url.setBorder(border);

        frame.add(download);
        frame.add(url);
        frame.setVisible(true);
    }

    public String getDataFolder() {
        final String jarPath = UserInterface.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        final String parentPath = new File(jarPath).getParent();
        return new File(parentPath).getAbsolutePath();
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JTextField getUrl() {
        return this.url;
    }
}
