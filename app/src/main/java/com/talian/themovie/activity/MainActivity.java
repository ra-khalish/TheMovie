package com.talian.themovie.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.talian.themovie.R;
import com.talian.themovie.model.Movie;
import com.talian.themovie.services.MovieDataService;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.movieLists);

        fetchMovie();

    }

    private void fetchMovie() {
        final MovieDataService movieDataService = new MovieDataService(MainActivity.this);
        movieDataService.getPopularMovie(new MovieDataService.MovieResponseListener() {
            @Override
            public void onError(String message) {

            }

            @Override
            public void onResponse(List<Movie> movies) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_expandable_list_item_1, movies);
                listView.setAdapter(arrayAdapter);

            }
        });
    }
}