package com.example.musicproject_01.screen.main.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicproject_01.R;
import com.example.musicproject_01.data.model.Genre;
import com.example.musicproject_01.data.model.GenreAdapter;
import com.example.musicproject_01.data.model.Playlist;
import com.example.musicproject_01.data.model.PlaylistAdapter;
import com.example.musicproject_01.data.model.Track;
import com.example.musicproject_01.data.model.TrackAdapter;
import com.example.musicproject_01.data.model.User;
import com.example.musicproject_01.data.model.UserAdapter;

import java.util.List;

public class HomeFragment extends Fragment implements HomeContract.View {

    private HomeContract.Presenter mHomePresenter;

    private RecyclerView mRecyclerSong;
    private RecyclerView mRecyclerPlaylist;
    private RecyclerView mRecyclerGenre;
    private RecyclerView mRecyclerUser;

    private TrackAdapter mTrackAdapter;
    private PlaylistAdapter mPlaylistAdapter;
    private GenreAdapter mGenreAdapter;
    private UserAdapter mUserAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mHomePresenter = new HomePresenter(this);
        mHomePresenter.getTrackList();
        mRecyclerSong = view.findViewById(R.id.recycler_all_song);
        mHomePresenter.getPlaylist();
        mRecyclerPlaylist = view.findViewById(R.id.recycler_playlist);
        mRecyclerGenre = view.findViewById(R.id.recycler_genres);
        mHomePresenter.loadGenres();
        mHomePresenter.getUser();
        mRecyclerUser = view.findViewById(R.id.recycler_user);

        return view;
    }

    @Override
    public void onGetTrackSuccess(List<Track> trackList) {
        mTrackAdapter = new TrackAdapter(trackList);
        mRecyclerSong.setAdapter(mTrackAdapter);
        mTrackAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetTrackFailure(String message) {
        String error = getString(R.string.error_track_exception);
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetPlaylistSuccess(List<Playlist> playlist) {
        mPlaylistAdapter = new PlaylistAdapter(playlist);
        mRecyclerPlaylist.setAdapter(mPlaylistAdapter);
        mPlaylistAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetPlaylistFailure(String message) {
        String error = getString(R.string.error_playlist_exception);
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGenres(List<Genre> genres) {
        mGenreAdapter = new GenreAdapter(genres);
        mRecyclerGenre.setAdapter(mGenreAdapter);
        mGenreAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetUserSuccess(List<User> users) {
        mUserAdapter = new UserAdapter(users);
        mRecyclerUser.setAdapter(mUserAdapter);
        mUserAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetUserFail(String message) {
        String error = getString(R.string.error_user_exception);
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }
}
