package com.example.musicproject_01.screen.main.home;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicproject_01.R;
import com.example.musicproject_01.base.BaseFragment;
import com.example.musicproject_01.constant.Constant;
import com.example.musicproject_01.data.model.Track;
import com.example.musicproject_01.data.model.TrackAdapter;
import com.example.musicproject_01.data.source.TrackDataSource;
import com.example.musicproject_01.data.source.remote.FetchTrackFromUrl;
import com.example.musicproject_01.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment implements HomeContract.View,
        TrackAdapter.OnItemClickListeners, TrackDataSource.OnFetchDataListener<Track> {

    private HomeContract.Presenter mHomePresenter;
    private RecyclerView mRecyclerRecentSong;
    private TrackAdapter mTrackAdapter;
    private List<Track> mAddTrackList;

    private FetchTrackFromUrl mFetchTrackFromUrl;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initComponents(View view) {
        mRecyclerRecentSong = view.findViewById(R.id.recycler_recent_song);
        mFetchTrackFromUrl = new FetchTrackFromUrl();
        mAddTrackList = new ArrayList<>();
    }

    @Override
    protected void registerListeners() {
        mFetchTrackFromUrl.setListener(this);
        mFetchTrackFromUrl.execute(StringUtil.formatTrackAPI());
    }

    private void setupRecyclerView() {
        mTrackAdapter = new TrackAdapter(new ArrayList<Track>());
        mTrackAdapter.setOnItemClickListeners(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getContext(),
                RecyclerView.HORIZONTAL,
                false
        );

        mRecyclerRecentSong.setLayoutManager(linearLayoutManager);
        mRecyclerRecentSong.setHasFixedSize(true);
        mRecyclerRecentSong.setAdapter(mTrackAdapter);
        mTrackAdapter.addTrack(mAddTrackList);
        mTrackAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFetchDataSuccess(List<Track> tracks) {
        for (int i = 0; i < tracks.size(); i++) {
            mAddTrackList.add(tracks.get(i));
            setupRecyclerView();
        }
    }

    @Override
    public void onFetchDataFailure(Exception e) {
        String error = getString(R.string.error);
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRecentSong(List<Track> tracks) {

    }

    @Override
    public void onItemClick(Track track, int position) {
        track = mAddTrackList.get(position);

    }

}
