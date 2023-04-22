package com.facuu16.yd;

import com.facuu16.yd.listener.DownloadButtonListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public final class UserInterface {
    private final JFrame frame;

    private final JTextField url;

    public UserInterface() {
        frame = new JFrame("Youtube Downloader");
        frame.setSize(600, 400);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Font font = new Font("Consolas", Font.PLAIN, 14);
        final Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);

        JButton download = new JButton("DOWNLOAD");
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

        download.addActionListener(new DownloadButtonListener(this));
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getUrl() {
        return url;
    }
}
