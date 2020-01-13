package com.example.musicproject_01.utils;

import com.example.musicproject_01.constant.Constant;

public class StringUtil {
    public static String formatTrackAPI() {
        return String.format("%s%s%s%s",
                Constant.BASE_URL,
                Constant.URL_TRACK,
                Constant.URL_CLIENT_ID,
                Constant.API_KEY);
    }

    public static String formatPlaylistAPI(){
        return String.format("%s%s%s%s",
                Constant.BASE_URL,
                Constant.URL_PLAYLIST,
                Constant.URL_CLIENT_ID,
                Constant.API_KEY);
    }

}
