package com.facuu16.yd.listener;

import com.facuu16.yd.UserInterface;
import com.sapher.youtubedl.YoutubeDL;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.YoutubeDLRequest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

public class DownloadButtonListener implements ActionListener {
    final private UserInterface ui;

    public DownloadButtonListener(UserInterface ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        final String urlText = ui.getUrl().getText().trim();
        if (!urlText.startsWith("https://youtu.be/")) {
            JOptionPane.showMessageDialog(ui.getFrame(), "Please enter a valid URL (https://youtu.be/XXXXXXXXXXX)");
            return;
        }

        final String directory = ui.getDataFolder();

        final File youtubeDl = new File(directory + "\\youtube-dl.exe");

        if (!youtubeDl.exists()) {
            JOptionPane.showMessageDialog(ui.getFrame(), "youtube-dl.exe not found!");
            return;
        }

        YoutubeDL.setExecutablePath(directory + "\\youtube-dl");

        final YoutubeDLRequest request = new YoutubeDLRequest(urlText, directory);
        request.setOption("ignore-errors");
        request.setOption("output", "%(title)s.mp4");
        request.setOption("retries", 10);

        JOptionPane.showMessageDialog(ui.getFrame(), "Press OK to start the download");

        try {
            YoutubeDL.execute(request);
            JOptionPane.showMessageDialog(ui.getFrame(), "Video downloaded successfully!");
        } catch (YoutubeDLException exception) {
            JOptionPane.showMessageDialog(ui.getFrame(), "An error occurred installing on video!");
            throw new RuntimeException(exception);
        }
    }
}

