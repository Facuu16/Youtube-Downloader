package com.facuu16.yd.listener;

import com.facuu16.yd.UserInterface;
import com.facuu16.yd.YoutubeDownloader;
import com.sapher.youtubedl.YoutubeDL;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.YoutubeDLRequest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

public final class DownloadButtonListener implements ActionListener {
    private final UserInterface ui;

    public DownloadButtonListener(final UserInterface ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(final ActionEvent event) {
        final String url = ui.getUrl().getText().trim();

        if (!url.startsWith("https://youtu.be/")) {
            JOptionPane.showMessageDialog(ui.getFrame(), "Please enter a valid URL (https://youtu.be/XXXXXXXXXXX)");
            return;
        }

        final String directory = YoutubeDownloader.getDataFolder();
        final File youtubeDl = new File(directory + "\\youtube-dl.exe");

        if (!youtubeDl.exists()) {
            JOptionPane.showMessageDialog(ui.getFrame(), "youtube-dl.exe not found!");
            return;
        }

        YoutubeDL.setExecutablePath(directory + "\\youtube-dl");

        final YoutubeDLRequest request = new YoutubeDLRequest(url, directory);
        request.setOption("ignore-errors");
        request.setOption("output", "%(title)s.mp4");
        request.setOption("retries", 10);

        JOptionPane.showMessageDialog(ui.getFrame(), "Press OK to start the download");

        try {
            YoutubeDL.execute(request);
            JOptionPane.showMessageDialog(ui.getFrame(), "Video downloaded successfully!");
        } catch (YoutubeDLException e) {
            JOptionPane.showMessageDialog(ui.getFrame(), "An error occurred installing on video!");
            throw new RuntimeException(e);
        }
    }
}

