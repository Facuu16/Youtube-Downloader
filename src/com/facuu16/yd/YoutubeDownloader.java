package com.facuu16.yd;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public final class YoutubeDownloader {
    public static void main(String[] args) {
        new UserInterface();
    }

    public static String getDataFolder() {
        return URLDecoder.decode(YoutubeDownloader.class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath(), StandardCharsets.UTF_8);
    }
}