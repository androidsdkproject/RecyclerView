package com.example.android1.recyclerview;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.android1.recyclerview.recyclerView.DividerItemDecoration;
import com.example.android1.recyclerview.recyclerView.MoviesRecylerViewAdapter;
import com.example.android1.recyclerview.recyclerView.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android1 on 8/22/2017.
 */

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";
    private List<MovieModel> movieModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesRecylerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        MoviesRecylerViewAdapter.MoviesRecylerViewAdapterListener moviesRecylerViewAdapterListener = new MoviesRecylerViewAdapter.MoviesRecylerViewAdapterListener() {
            @Override
            public void testButtonOnClick(View v, int position) {
                String title = movieModelList.get(position).getTitle();
                Snackbar.make(v, "test button clicked " + title, Snackbar.LENGTH_LONG).show();
            }
        };

        mAdapter = new MoviesRecylerViewAdapter(movieModelList, moviesRecylerViewAdapterListener);


        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                MovieModel movieModel = movieModelList.get(position);
                Snackbar.make(view, movieModel.getTitle() + " is selected!", Snackbar.LENGTH_LONG).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                MovieModel movieModel = movieModelList.get(position);
                Snackbar.make(view, movieModel.getTitle() + " is Long Clicked", Snackbar.LENGTH_LONG).show();
            }
        }));

        prepareMovieData();
    }


    private void prepareMovieData() {
        MovieModel movieModel = new MovieModel("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieModelList.add(movieModel);

        movieModel = new MovieModel("Inside Out", "Animation, Kids & Family", "2015");
        movieModelList.add(movieModel);

        movieModel = new MovieModel("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieModelList.add(movieModel);

        movieModel = new MovieModel("Shaun the Sheep", "Animation", "2015");
        movieModelList.add(movieModel);

        movieModel = new MovieModel("The Martian", "Science Fiction & Fantasy", "2015");
        movieModelList.add(movieModel);

        movieModel = new MovieModel("Mission: Impossible Rogue Nation", "Action", "2015");
        movieModelList.add(movieModel);

        movieModel = new MovieModel("Up", "Animation", "2009");
        movieModelList.add(movieModel);

        movieModel = new MovieModel("Star Trek", "Science Fiction", "2009");
        movieModelList.add(movieModel);

        movieModel = new MovieModel("The LEGO MovieModel", "Animation", "2014");
        movieModelList.add(movieModel);

        movieModel = new MovieModel("Iron Man", "Action & Adventure", "2008");
        movieModelList.add(movieModel);

        movieModel = new MovieModel("Aliens", "Science Fiction", "1986");
        movieModelList.add(movieModel);

        movieModel = new MovieModel("Chicken Run", "Animation", "2000");
        movieModelList.add(movieModel);

        movieModel = new MovieModel("Back to the Future", "Science Fiction", "1985");
        movieModelList.add(movieModel);

        movieModel = new MovieModel("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieModelList.add(movieModel);

        movieModel = new MovieModel("Goldfinger", "Action & Adventure", "1965");
        movieModelList.add(movieModel);

        movieModel = new MovieModel("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieModelList.add(movieModel);

        mAdapter.notifyDataSetChanged();
    }
}