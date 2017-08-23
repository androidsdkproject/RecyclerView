package com.example.android1.recyclerview.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.android1.recyclerview.MovieModel;
import com.example.android1.recyclerview.R;

import java.util.List;

/**
 * Created by Android1 on 8/22/2017.
 */

public class MoviesRecylerViewAdapter extends RecyclerView.Adapter<MoviesRecylerViewAdapter.MyViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FOOTER = 2;

    public MoviesRecylerViewAdapterListener moviesRecylerViewAdapterListener;
    List<MovieModel> movieModelList;

    public MoviesRecylerViewAdapter(List<MovieModel> movieModelList, MoviesRecylerViewAdapterListener moviesRecylerViewAdapterListener) {
        this.movieModelList = movieModelList;
        this.moviesRecylerViewAdapterListener = moviesRecylerViewAdapterListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesRecylerViewAdapter.MyViewHolder holder, int position) {
        MovieModel movieModel = movieModelList.get(position);
        holder.title.setText(movieModel.getTitle());
        holder.genre.setText(movieModel.getGenre());
        holder.year.setText(movieModel.getYear());
    }

    @Override
    public int getItemCount() {
        return movieModelList.size();
    }


    public interface MoviesRecylerViewAdapterListener {

        void testButtonOnClick(View v, int position);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public Button testbutton;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            testbutton = (Button) view.findViewById(R.id.testbutton);


            testbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    moviesRecylerViewAdapterListener.testButtonOnClick(view, getAdapterPosition());
                }
            });
        }


    }


}
