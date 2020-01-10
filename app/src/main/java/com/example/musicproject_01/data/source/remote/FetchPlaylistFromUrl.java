package com.example.musicproject_01.data.source.remote;

import android.os.AsyncTask;

import com.example.musicproject_01.constant.Constant;
import com.example.musicproject_01.constant.PlaylistEntity;
import com.example.musicproject_01.constant.TrackEntity;
import com.example.musicproject_01.constant.UserEntity;
import com.example.musicproject_01.data.model.Playlist;
import com.example.musicproject_01.data.model.Track;
import com.example.musicproject_01.data.model.User;
import com.example.musicproject_01.data.source.PlaylistDataSource;

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

public class FetchPlaylistFromUrl extends AsyncTask<String, Void, List<Playlist>> {

    private PlaylistDataSource.OnFetchDataListener<Playlist> mListener;
    private Exception mException;

    public void setListener(PlaylistDataSource.OnFetchDataListener<Playlist> listener) {
        mListener = listener;
    }

    @Override
    protected List<Playlist> doInBackground(String... strings) {
        String url = strings[0];
        String data = null;

        try {
            data = getJsonStringFromUrl(url);
            return getPlaylistFromJson(data);
        } catch (IOException | JSONException e) {
            mException = e;
        }
        return null;
    }

    private List<Playlist> getPlaylistFromJson(String data) throws JSONException {
        List<Playlist> playlistArrayList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(data);
        int duration = jsonObject.getInt(PlaylistEntity.DURATION);
        String permalinkUrl = jsonObject.getString(PlaylistEntity.PERMALINK_URL);
        String genre = jsonObject.getString(PlaylistEntity.GENRE);
        String uri = jsonObject.getString(PlaylistEntity.URI);
        String trackCount = jsonObject.getString(PlaylistEntity.TRACK_COUNT);
        String title = jsonObject.getString(PlaylistEntity.TITLE);
        String artwork = jsonObject.getString(PlaylistEntity.ARTWORK_URL);
        JSONArray arrayTrack = jsonObject.getJSONArray(PlaylistEntity.TRACK);
        Track track = null;
        for (int i = 0; i < arrayTrack.length(); i++) {
            JSONObject objectTrack = arrayTrack.getJSONObject(i);
            String artworkTrack = objectTrack.getString(TrackEntity.ARTWORK_URL);
            String titleTrack = objectTrack.getString(TrackEntity.TITLE);
            String genreTrack = objectTrack.getString(TrackEntity.GENRE);
            String permalinkUrlTrack = objectTrack.getString(TrackEntity.PERMALINK_URL);
            String uriTrack = objectTrack.getString(TrackEntity.URI);
            String streamUrlTrack = objectTrack.getString(TrackEntity.STREAM_URL);
            int idTrack = objectTrack.getInt(TrackEntity.ID);
            int durationTrack = objectTrack.getInt(TrackEntity.DURATION);
            int downloadCountTrack = objectTrack.getInt(TrackEntity.DOWNLOAD_COUNT);
            boolean downloadableTrack = objectTrack.getBoolean(TrackEntity.DOWNLOADABLE);

            JSONObject objectUserTrack = arrayTrack.getJSONObject(i).getJSONObject(TrackEntity.USER);
            String idUserTrack = objectUserTrack.getString(UserEntity.ID);
            String nameUserTrack = objectUserTrack.getString(UserEntity.NAME);
            String avatarUrlUserTrack = objectUserTrack.getString(UserEntity.AVATAR_URL);

            User user = new User(idUserTrack, nameUserTrack, avatarUrlUserTrack);

            track = new Track.Builder()
                    .withArtworkUrl(artworkTrack)
                    .withTitle(titleTrack)
                    .withGenre(genreTrack)
                    .withPermalinkUrl(permalinkUrlTrack)
                    .withUri(uriTrack)
                    .withStreamUrl(streamUrlTrack)
                    .withId(idTrack)
                    .withDuration(durationTrack)
                    .withDownloadCount(downloadCountTrack)
                    .withIsDownloadable(downloadableTrack)
                    .withUser(user)
                    .build();
        }

        JSONObject objectUser = jsonObject.getJSONObject(PlaylistEntity.USER);
        String idUserPlaylist = objectUser.getString(UserEntity.ID);
        String nameUserPlaylist = objectUser.getString(UserEntity.NAME);
        String avatarUserPlaylist = objectUser.getString(UserEntity.AVATAR_URL);

        User user = new User(idUserPlaylist, nameUserPlaylist, avatarUserPlaylist);

        Playlist playlist = new Playlist.Builder()
                .withDuration(duration)
                .withPermalinkUrl(permalinkUrl)
                .withGenre(genre)
                .withUri(uri)
                .withTrackCount(trackCount)
                .withTitle(title)
                .withArtworkUrl(artwork)
                .withTrack(track)
                .withUser(user)
                .build();

        playlistArrayList.add(playlist);

        return playlistArrayList;
    }

    private String getJsonStringFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod(Constant.REQUEST_METHOD_GET);
        connection.setConnectTimeout(Constant.CONNECTED_TIME_OUT);
        connection.setReadTimeout(Constant.READ_TIME_OUT);

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

    @Override
    protected void onPostExecute(List<Playlist> playlistList) {
        if (mListener == null) {
            return;
        }

        if (mException == null) {
            mListener.onFetchDataPlaylistSuccess(playlistList);
        } else {
            mListener.onFetchDataPlaylistFailure(mException);
        }
    }
}
