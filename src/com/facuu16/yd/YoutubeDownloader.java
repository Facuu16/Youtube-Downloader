package com.facuu16.yd;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class YoutubeDownloader {
    public static void main(String[] args) {
        new UserInterface();
    }

    public static String getDataFolder() {
        final String path = YoutubeDownloader.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        return URLDecoder.decode(path, StandardCharsets.UTF_8);
    }
}