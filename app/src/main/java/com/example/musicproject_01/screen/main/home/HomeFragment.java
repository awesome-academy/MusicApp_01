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
import com.example.musicproject_01.data.model.GenreAdapter;
import com.example.musicproject_01.data.model.PlaylistAdapter;
import com.example.musicproject_01.data.model.Track;
import com.example.musicproject_01.data.model.TrackAdapter;

import java.util.List;

public class HomeFragment extends Fragment implements HomeContract.View {

    private HomeContract.Presenter mHomePresenter;

    private RecyclerView mRecyclerSong;
    private RecyclerView mRecyclerPlaylist;
    private RecyclerView mRecyclerGenre;

    private TrackAdapter mTrackAdapter;
    private PlaylistAdapter mPlaylistAdapter;
    private GenreAdapter mGenreAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mHomePresenter = new HomePresenter(this);
        mHomePresenter.getTrackList();
        mRecyclerSong = view.findViewById(R.id.recycler_all_song);

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
        Toast.makeText(getContext(), "ERROR Track", Toast.LENGTH_SHORT).show();
    }
}
