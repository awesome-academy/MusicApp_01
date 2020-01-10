package com.example.musicproject_01.data.source.remote;

import android.os.AsyncTask;

import com.example.musicproject_01.constant.Constant;
import com.example.musicproject_01.constant.TrackEntity;
import com.example.musicproject_01.constant.UserEntity;
import com.example.musicproject_01.data.model.Track;
import com.example.musicproject_01.data.model.User;
import com.example.musicproject_01.data.source.TrackDataSource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FetchTrackFromUrl extends AsyncTask<String, Void, List<Track>> {

    private TrackDataSource.OnFetchDataListener<Track> mListener;
    private Exception mException;

    public void setListener(TrackDataSource.OnFetchDataListener<Track> listener) {
        mListener = listener;
    }

    @Override
    protected List<Track> doInBackground(String... strings) {
        String url = strings[0];
        String data = null;
        try {
            data = getJsonStringFromUrl(url);
            return getTracksFromJson(data);
        } catch (Exception e) {
            mException = e;
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Track> tracks) {
        if (mListener == null) {
            return;
        }
        if (mException == null) {
            mListener.onFetchDataSuccess(tracks);
        } else {
            mListener.onFetchDataFailure(mException);
        }
    }

    private List<Track> getTracksFromJson(String data) throws JSONException {
        List<Track> tracks = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(data);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            String artworkUrl = jsonObject.getString(TrackEntity.ARTWORK_URL);
            String title = jsonObject.getString(TrackEntity.TITLE);
            String genre = jsonObject.getString(TrackEntity.GENRE);
            String permalinkUrl = jsonObject.getString(TrackEntity.PERMALINK_URL);
            String uri = jsonObject.getString(TrackEntity.URI);
            String streamUrl = jsonObject.getString(TrackEntity.STREAM_URL);
            int id = jsonObject.getInt(TrackEntity.ID);
            int duration = jsonObject.getInt(TrackEntity.DURATION);
            int downloadCount = jsonObject.getInt(TrackEntity.DOWNLOAD_COUNT);
            boolean isDownloadable = jsonObject.getBoolean(TrackEntity.DOWNLOADABLE);

            JSONObject objectUser = jsonArray.getJSONObject(i).getJSONObject(TrackEntity.USER);
            String username = objectUser.getString(UserEntity.NAME);
            String avatarUrl = objectUser.getString(UserEntity.AVATAR_URL);
            String idUser = objectUser.getString(UserEntity.ID);

            User user = new User(username, avatarUrl, idUser);

            Track track = new Track.Builder()
                    .withArtworkUrl(artworkUrl)
                    .withTitle(title)
                    .withGenre(genre)
                    .withPermalinkUrl(permalinkUrl)
                    .withUri(uri)
                    .withStreamUrl(streamUrl)
                    .withId(id)
                    .withDuration(duration)
                    .withDownloadCount(downloadCount)
                    .withIsDownloadable(isDownloadable)
                    .withUser(user)
                    .build();

            tracks.add(track);

        }
        return tracks;
    }

    private String getJsonStringFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod(Constant.REQUEST_METHOD_GET);
        connection.setConnectTimeout(Constant.CONNECTED_TIME_OUT);
        connection.setReadTimeout(Constant.READ_TIME_OUT);
        connection.setDoOutput(true);
        connection.connect();

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

        StringBuilder sb = new StringBuilder();
        String line = "";

        while ((line = br.readLine()) != null) {
            sb.append(line).append(Constant.BREAK_LINE);
        }

        br.close();
        connection.disconnect();

        return sb.toString();
    }

}

