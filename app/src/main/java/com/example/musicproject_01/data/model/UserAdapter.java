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

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> mUsers;
    private String mURL;
    private OnItemClickArtistListeners mOnItemClickArtistListeners;

    public UserAdapter(List<User> users) {
        mUsers = users;
    }

    public void setOnItemClickArtistListeners(
            OnItemClickArtistListeners onItemClickArtistListeners) {
        mOnItemClickArtistListeners = onItemClickArtistListeners;
    }


    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_artist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UserAdapter.ViewHolder holder, int position) {
        User user = mUsers.get(position);
        mURL = user.getAvatarUrl();
        holder.mTextArtist.setText(user.getName());

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
                holder.mImageArtist.setImageBitmap(bitmap);
            }
        }
        new ImageDownloadAsync().execute(mURL);
    }

    @Override
    public int getItemCount() {
        return mUsers == null ? 0 : mUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageArtist;
        private TextView mTextArtist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageArtist = itemView.findViewById(R.id.image_artist);
            mTextArtist = itemView.findViewById(R.id.text_name_artist);

            mImageArtist.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.image_artist:
                    mOnItemClickArtistListeners.onItemClick(
                            mUsers.get(getAdapterPosition())
                            , getAdapterPosition()
                    );
                    break;
                default:
                    break;
            }
        }
    }

    public interface OnItemClickArtistListeners {

        void onItemClick(User user, int position);

    }
}
