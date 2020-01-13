package com.example.musicproject_01.screen.main.home;

import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicproject_01.R;
import com.example.musicproject_01.base.BaseFragment;
import com.example.musicproject_01.constant.GenreEntity;
import com.example.musicproject_01.data.model.Genre;
import com.example.musicproject_01.data.model.GenreAdapter;
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
        PlaylistAdapter.OnItemClickPlaylistListeners,
        GenreAdapter.OnItemClickGenreListeners {

    private HomeContract.Presenter mHomePresenter;

    private RecyclerView mRecyclerRecentSong;
    private RecyclerView mRecyclerPlaylist;
    private RecyclerView mRecyclerGenre;

    private TrackAdapter mTrackAdapter;
    private PlaylistAdapter mPlaylistAdapter;
    private GenreAdapter mGenreAdapter;

    private List<Track> mTrackListAdd;
    private List<Playlist> mPlaylistAdd;
    private List<Genre> mGenreAdd;

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
        mRecyclerGenre = view.findViewById(R.id.recycler_genres);

        mFetchTrackFromUrl = new FetchTrackFromUrl();
        mFetchPlaylistFromUrl = new FetchPlaylistFromUrl();

        mTrackListAdd = new ArrayList<>();
        mPlaylistAdd = new ArrayList<>();
        mGenreAdd = new ArrayList<>();

        setupRecyclerViewGenre();
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

    private void setupRecyclerViewGenre() {
        mGenreAdapter = new GenreAdapter(new ArrayList<Genre>());
        mGenreAdapter.setOnItemClickGenreListeners(this);
        mRecyclerGenre.setHasFixedSize(true);
        mRecyclerGenre.setAdapter(mGenreAdapter);
        mGenreAdapter.addGenre(addGenre());
        mGenreAdapter.notifyDataSetChanged();

    }

    private List<Genre> addGenre() {
        mGenreAdd = new ArrayList<>();

        Genre ambient = new Genre(GenreEntity.AMBIENT_TITLE, R.raw.ambient_genre);
        Genre alternative = new Genre(GenreEntity.ALTERNATIVE_TITLE, R.raw.alternative_genre);
        Genre classical = new Genre(GenreEntity.CLASSICAL_TITLE, R.raw.classical_genre);
        Genre country = new Genre(GenreEntity.COUNTRY_TITLE, R.raw.country_genre);
        Genre hip_hop = new Genre(GenreEntity.HIP_HOP_TITLE, R.raw.hip_hop);
        Genre indie = new Genre(GenreEntity.INDIE_TITLE, R.raw.indie_genre);
        Genre pop = new Genre(GenreEntity.POP_TITLE, R.raw.pop_music);
        Genre other = new Genre(GenreEntity.OTHER_TITLE, R.raw.other_genre);

        mGenreAdd.add(ambient);
        mGenreAdd.add(alternative);
        mGenreAdd.add(classical);
        mGenreAdd.add(country);
        mGenreAdd.add(hip_hop);
        mGenreAdd.add(indie);
        mGenreAdd.add(pop);
        mGenreAdd.add(other);

        return mGenreAdd;
    }

    @Override
    public void onItemClick(Genre genre, int position) {

    }

    @Override
    public void showRecentSong(List<Track> tracks) {

    }
}
