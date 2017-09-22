package com.example.hesham.diffrentorderrecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.hesham.diffrentorderrecycle.Adapter.MoviesAdapter;
import com.example.hesham.diffrentorderrecycle.InterfaceCLICK.RecyclerTouchListener;
import com.example.hesham.diffrentorderrecycle.Model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new MoviesAdapter(movieList);
        recyclerView.setHasFixedSize(true);

        mLayoutManager   = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Movie movie = movieList.get(position);
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareMovieData();

    }

    private void prepareMovieData() {
            Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
            movieList.add(movie);

            movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
            movieList.add(movie);

            movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
            movieList.add(movie);

            movie = new Movie("Shaun the Sheep", "Animation", "2015");
            movieList.add(movie);

            movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
            movieList.add(movie);

            movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
            movieList.add(movie);

            movie = new Movie("Up", "Animation", "2009");
            movieList.add(movie);

            movie = new Movie("Star Trek", "Science Fiction", "2009");
            movieList.add(movie);

            movie = new Movie("The LEGO Movie", "Animation", "2014");
            movieList.add(movie);

            movie = new Movie("Iron Man", "Action & Adventure", "2008");
            movieList.add(movie);

            movie = new Movie("Aliens", "Science Fiction", "1986");
            movieList.add(movie);

            movie = new Movie("Chicken Run", "Animation", "2000");
            movieList.add(movie);

            movie = new Movie("Back to the Future", "Science Fiction", "1985");
            movieList.add(movie);

            movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
            movieList.add(movie);

            movie = new Movie("Goldfinger", "Action & Adventure", "1965");
            movieList.add(movie);

            movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
            movieList.add(movie);

            mAdapter.notifyDataSetChanged();
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LinearLayoutManager linearLayoutManager;
        GridLayoutManager gridLayoutManager;
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        switch (item.getItemId()) {

            case R.id.LinearVertical:
                linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView

                return true;

            case R.id.LinearHorizontal:
                 linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); // set Horizontal Orientation
                recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView
                return true;
            case R.id.GridLayoutVertical:
// set a GridLayoutManager with default vertical orientation and 3 number of columns
                 gridLayoutManager    = new GridLayoutManager(getApplicationContext(),3);
                recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
                return true;
            case R.id.GridLayoutHorizontal:
                 gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);
                gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); // set Horizontal Orientation
                recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
                return true;
            case R.id.StaggeredVertical:
                staggeredGridLayoutManager   = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(staggeredGridLayoutManager); // set LayoutManager to RecyclerView
                return true;
            case R.id.StaggeredHorizontal:
                staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(staggeredGridLayoutManager); // set LayoutManager to RecyclerView
                return true;



        }



            return super.onOptionsItemSelected(item);
    }
}

