package com.example.musicproject_01.data.source.remote.user;

import android.os.AsyncTask;

import com.example.musicproject_01.constant.Constant;
import com.example.musicproject_01.constant.TrackEntity;
import com.example.musicproject_01.constant.UserEntity;
import com.example.musicproject_01.data.model.User;
import com.example.musicproject_01.data.source.UserDataSource;

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

public class FetchUserFromUrl extends AsyncTask<String, Void, List<User>> {

    private UserDataSource.OnFetchUserDataListeners mListeners;
    private Exception mException;

    public FetchUserFromUrl(UserDataSource.OnFetchUserDataListeners listeners) {
        mListeners = listeners;
    }

    @Override
    protected List<User> doInBackground(String... strings) {

        String url = strings[0];
        String data = null;

        try {
            data = getJsonStringFromUrl(url);
            return getUserFromJson(data);
        } catch (Exception e) {
            mException = e;
        }

        return null;
    }

    private List<User> getUserFromJson(String data) throws JSONException {
        List<User> users = new ArrayList<>();
        List<User> userChecked = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(data);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject objectUser = jsonArray.getJSONObject(i).getJSONObject(TrackEntity.USER);
            String username = objectUser.getString(UserEntity.NAME);
            String avatarUrl = objectUser.getString(UserEntity.AVATAR_URL);
            String userLink = objectUser.getString(UserEntity.PERMALINK_URL);

            User user = new User(username, avatarUrl, userLink);
            users.add(user);
        }

        for (int i = 0; i < users.size(); i++) {
            boolean flag = true;
            for (int j = i + 1; j < users.size(); j++) {
                if ((users.get(i).getName()).equals(users.get(j).getName())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                userChecked.add(users.get(i));
            }
        }
        return userChecked;
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

    @Override
    protected void onPostExecute(List<User> users) {
        if (mListeners == null) {
            return;
        }
        if (mException == null) {
            mListeners.onFetchUserSuccess(users);
        } else {
            mListeners.onFetchUserFail(mException);
        }
    }
}
