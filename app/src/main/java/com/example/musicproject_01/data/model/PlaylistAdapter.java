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
import java.net.URL;
import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder> {

    private List<Playlist> mPlaylistList;
    private OnItemClickPlaylistListeners mOnItemClickPlaylistListeners;
    private String mURL;

    public PlaylistAdapter(List<Playlist> playlistList) {
        mPlaylistList = playlistList;
    }

    public void setOnItemClickPlaylistListeners(
            OnItemClickPlaylistListeners onItemClickPlaylistListeners) {
        mOnItemClickPlaylistListeners = onItemClickPlaylistListeners;
    }

    @NonNull
    @Override
    public PlaylistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_playlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PlaylistAdapter.ViewHolder holder, int position) {
        Playlist playlist = mPlaylistList.get(position);
        mURL = playlist.getArtworkUrl();
        holder.mTextTitlePlaylist.setText(playlist.getTitle());
        holder.mTextArtistPlaylist.setText(playlist.getUser().getName());

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
                    e.getCause();
                }
                return bitmap;
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                holder.mImagePlaylist.setImageBitmap(bitmap);
            }
        }
        new ImageDownloadAsync().execute(mURL);
    }

    @Override
    public int getItemCount() {
        return mPlaylistList == null ? 0 : mPlaylistList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImagePlaylist;
        private TextView mTextTitlePlaylist;
        private TextView mTextArtistPlaylist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImagePlaylist = itemView.findViewById(R.id.image_playlist);
            mTextArtistPlaylist = itemView.findViewById(R.id.text_artist_playlist);
            mTextTitlePlaylist = itemView.findViewById(R.id.text_title_playlist);

            mImagePlaylist.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.image_playlist:
                    mOnItemClickPlaylistListeners.onItemClick(
                            mPlaylistList.get(getAdapterPosition())
                            , getAdapterPosition());
            }
        }
    }

    public void addPlaylist(List<Playlist> playlistList) {
        mPlaylistList = playlistList;
    }

    public interface OnItemClickPlaylistListeners {

        void onItemClick(Playlist playlist, int position);

    }

}
