package com.example.tassioflix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context mContext;
    private List<Movie> moviesList;

    public Adapter(Context mContext, List<Movie> moviesList) {
        this.mContext = mContext;
        this.moviesList = moviesList;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.movie_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.id.setText(moviesList.get(position).getId());
        holder.title.setText(moviesList.get(position).getTitle());
        holder.overview.setText(moviesList.get(position).getOverview());
        holder.release_date.setText(moviesList.get(position).getRelease_date());
        holder.vote_average.setText(moviesList.get(position).getVote_average());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView title;
        TextView overview;
        TextView release_date;
        TextView vote_average;
        TextView poster_path;

        public MyViewHolder(View itemView) {
            super(itemView);

            poster_path = itemView.findViewById(R.id.movie_image);

            // id = itemView.findViewById(R.id.movie_id);
            // title = itemView.findViewById(R.id.movie_title);
            // overview = itemView.findViewById(R.id.movie_overview);
            // release_date = itemView.findViewById(R.id.movie_release_date);
            // vote_average = itemView.findViewById(R.id.movie_vote_average);
        }
    }
}
