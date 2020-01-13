package com.example.musicproject_01.screen.main.home;

import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicproject_01.R;
import com.example.musicproject_01.base.BaseFragment;
import com.example.musicproject_01.data.model.Playlist;
import com.example.musicproject_01.data.model.PlaylistAdapter;
import com.example.musicproject_01.data.model.Track;
import com.example.musicproject_01.data.model.TrackAdapter;
import com.example.musicproject_01.data.source.PlaylistDataSource;
import com.example.musicproject_01.data.source.TrackDataSource;
import com.example.musicproject_01.data.source.remote.FetchPlaylistFromUrl;
import com.example.musicproject_01.data.source.remote.FetchTrackFromUrl;
import com.example.musicproject_01.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment implements HomeContract.View,
        TrackAdapter.OnItemClickListeners,
        TrackDataSource.OnFetchDataListener<Track>,
        PlaylistDataSource.OnFetchDataListener<Playlist>,
        PlaylistAdapter.OnItemClickPlaylistListeners {

    private HomeContract.Presenter mHomePresenter;
    private RecyclerView mRecyclerRecentSong;
    private RecyclerView mRecyclerPlaylist;
    private TrackAdapter mTrackAdapter;
    private PlaylistAdapter mPlaylistAdapter;
    private List<Track> mTrackListAdd;
    private List<Playlist> mPlaylistAdd;

    private FetchTrackFromUrl mFetchTrackFromUrl;
    private FetchPlaylistFromUrl mFetchPlaylistFromUrl;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initComponents(View view) {
        mRecyclerRecentSong = view.findViewById(R.id.recycler_recent_song);
        mRecyclerPlaylist = view.findViewById(R.id.recycler_playlist);
        mFetchTrackFromUrl = new FetchTrackFromUrl();
        mFetchPlaylistFromUrl = new FetchPlaylistFromUrl();
        mTrackListAdd = new ArrayList<>();
        mPlaylistAdd = new ArrayList<>();
    }

    @Override
    protected void registerListeners() {
        mFetchTrackFromUrl.setListener(this);
        mFetchPlaylistFromUrl.setListener(this);
        mFetchTrackFromUrl.execute(StringUtil.formatTrackAPI());
        mFetchPlaylistFromUrl.execute(StringUtil.formatPlaylistAPI());
    }

    private void setupRecyclerViewTrack() {
        mTrackAdapter = new TrackAdapter(new ArrayList<Track>());
        mTrackAdapter.setOnItemClickListeners(this);
        mRecyclerRecentSong.setHasFixedSize(true);
        mRecyclerRecentSong.setAdapter(mTrackAdapter);
        mTrackAdapter.addTrack(mTrackListAdd);
        mTrackAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFetchDataSuccess(List<Track> tracks) {
        for (int i = 0; i < tracks.size(); i++) {
            mTrackListAdd.add(tracks.get(i));
            setupRecyclerViewTrack();
        }
    }

    @Override
    public void onFetchDataFailure(Exception e) {
        String error = getString(R.string.error_track_exception);
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(Track track, int position) {
        track = mTrackListAdd.get(position);

    }

    @Override
    public void onFetchDataPlaylistSuccess(List<Playlist> playlistList) {
        for (int i = 0; i < playlistList.size(); i++) {
            mPlaylistAdd.add(playlistList.get(i));
            setupRecyclerViewPlaylist();
        }
    }

    private void setupRecyclerViewPlaylist() {
        mPlaylistAdapter = new PlaylistAdapter(new ArrayList<Playlist>());
        mPlaylistAdapter.setOnItemClickPlaylistListeners(this);
        mRecyclerPlaylist.setHasFixedSize(true);
        mRecyclerPlaylist.setAdapter(mPlaylistAdapter);
        mPlaylistAdapter.addPlaylist(mPlaylistAdd);
        mPlaylistAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFetchDataPlaylistFailure(Exception e) {
        String error = getString(R.string.error_playlist_exception);
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(Playlist playlist, int position) {
        playlist = mPlaylistAdd.get(position);
    }

    @Override
    public void showRecentSong(List<Track> tracks) {

    }

}
