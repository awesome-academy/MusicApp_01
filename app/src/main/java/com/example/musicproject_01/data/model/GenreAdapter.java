package com.example.musicproject_01.data.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicproject_01.R;

import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.ViewHolder> {

    private List<Genre> mGenres;
    private OnItemClickGenreListeners mOnItemClickGenreListeners;

    public GenreAdapter(List<Genre> genres) {
        mGenres = genres;
    }

    public void setOnItemClickGenreListeners(OnItemClickGenreListeners onItemClickGenreListeners) {
        mOnItemClickGenreListeners = onItemClickGenreListeners;
    }

    @NonNull
    @Override
    public GenreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_genres, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreAdapter.ViewHolder holder, int position) {
        Genre genre = mGenres.get(position);
        holder.mImageGenre.setImageResource(genre.getImage());
        holder.mTextGenre.setText(genre.getTitle());
    }

    @Override
    public int getItemCount() {
        return mGenres == null ? 0 : mGenres.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageGenre;
        private TextView mTextGenre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageGenre = itemView.findViewById(R.id.image_item_genres);
            mTextGenre = itemView.findViewById(R.id.text_item_genres);

            mImageGenre.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.image_item_genres:
                    mOnItemClickGenreListeners.onItemClick(
                            mGenres.get(getAdapterPosition()),
                            getAdapterPosition()
                    );
                    break;
                default:
                    break;
            }
        }
    }

    public void addGenre(List<Genre> genreList) {
        mGenres = genreList;
    }

    public interface OnItemClickGenreListeners {

        void onItemClick(Genre genre, int position);

    }

}
