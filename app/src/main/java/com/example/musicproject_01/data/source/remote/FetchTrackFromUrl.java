package com.example.musicproject_01.data.source.remote;

import android.os.AsyncTask;

import com.example.musicproject_01.constant.Constant;
import com.example.musicproject_01.constant.TrackEntity;
import com.example.musicproject_01.data.model.Track;
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

    public FetchTrackFromUrl(TrackDataSource.OnFetchDataListener<Track> mListener) {
        this.mListener = mListener;
    }

    @Override
    protected List<Track> doInBackground(String... strings) {
        String url = strings[0];
        String data;
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
        JSONObject object = new JSONObject(data);
        JSONArray jsonArray = object.getJSONArray(TrackEntity.COLLECTION);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i).getJSONObject(TrackEntity.TRACK);

            String artworkUrl = jsonObject.optString(TrackEntity.ARTWORK_URL);
            String downloadUrl = jsonObject.optString(TrackEntity.DOWNLOAD_URL);
            String genre = jsonObject.optString(TrackEntity.GENRE);
            String title = jsonObject.optString(TrackEntity.TITLE);
            String uri = jsonObject.optString(TrackEntity.URI);
            int downloadCount = jsonObject.getInt(TrackEntity.DOWNLOAD_COUNT);
            int duration = jsonObject.getInt(TrackEntity.DURATION);
            int id = jsonObject.getInt(TrackEntity.ID);
            boolean downloadable = jsonObject.getBoolean(TrackEntity.DOWNLOADABLE);

            Track track = new Track.Builder()
                    .withArtworkUrl(artworkUrl)
                    .withTitle(title)
                    .withGenre(genre)
                    .withDuration(duration)
                    .withUri(uri)
                    .withId(id)
                    .withDownloadUrl(downloadUrl)
                    .withDownloadCount(downloadCount)
                    .withIsDownloadable(downloadable)
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
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line).append(Constant.BREAK_LINE);
        }

        br.close();
        connection.disconnect();

        return sb.toString();
    }

    public void setListener(TrackDataSource.OnFetchDataListener<Track> listener) {
        mListener = listener;
    }
}
