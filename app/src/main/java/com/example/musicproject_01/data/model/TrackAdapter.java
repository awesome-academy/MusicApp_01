package com.example.musicproject_01.data.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicproject_01.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {

    private List<Track> mTrackList;
    private OnItemClickListeners mOnItemClickListeners;
    private String mURL;

    public TrackAdapter(List<Track> trackList) {
        mTrackList = trackList;
    }

    public void setOnItemClickListeners(OnItemClickListeners onItemClickListeners) {
        mOnItemClickListeners = onItemClickListeners;
    }

    @NonNull
    @Override
    public TrackAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_track, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TrackAdapter.ViewHolder holder, int position) {
        Track track = mTrackList.get(position);
        mURL = track.getArtworkUrl();
        holder.mTextTitleTrack.setText(track.getTitle());
        holder.mTextNameArtist.setText(track.getUser().getName());
        class ImageDownloadAsync extends AsyncTask<String, Void, Bitmap> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Bitmap doInBackground(String... strings) {
                Bitmap bitmap = null;
                try {
                    String link = strings[0];
                    URL url = new URL(link);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = connection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return bitmap;
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);

            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                holder.mImageTrack.setImageBitmap(bitmap);
            }
        }
        new ImageDownloadAsync().execute(mURL);
    }

    @Override
    public int getItemCount() {
        return mTrackList == null ? 0 : mTrackList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageTrack;
        private TextView mTextTitleTrack;
        private TextView mTextNameArtist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageTrack = itemView.findViewById(R.id.image_track);
            mTextTitleTrack = itemView.findViewById(R.id.text_title_track);
            mTextNameArtist = itemView.findViewById(R.id.text_name_artist);

            mImageTrack.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.image_track:
                    mOnItemClickListeners.onItemClick(mTrackList.get(getAdapterPosition()), getAdapterPosition());
            }
        }
    }

    public void addTrack(List<Track> tracks) {
        mTrackList = tracks;
    }

    public interface OnItemClickListeners {
        void onItemClick(Track track, int position);
    }

}
