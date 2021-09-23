package com.talian.themovie.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.talian.themovie.activity.MainActivity;
import com.talian.themovie.model.Movie;
import com.talian.themovie.singleton.MovieSingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieDataService {
    public static final String QUERY_FOR_POPULAR_MOVIE = "https://api.themoviedb.org/3/movie/popular?api_key=102712b591ea0a542a6e110ec1016132&language=en-US&page=1";
    public static final String QUERY_FOR_MOVIE_IMAGES = "https://image.tmdb.org/t/p/original";

    Context context;
    String poster;

    public MovieDataService(Context context) {
        this.context = context;
    }

    public interface MovieResponseListener {
        void onError(String message);

        void onResponse(List<Movie> movies);
    }

    public void getPopularMovie(MovieResponseListener movieResponseListener){
        List<Movie> movies = new ArrayList<>();

        String url = QUERY_FOR_POPULAR_MOVIE;

        //get the json object
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();

                try {
                    JSONArray results = response.getJSONArray("results");


                    for (int i=0; i<results.length(); i++){
                        Movie each_movie = new Movie();
                        JSONObject first_movie_from_api = (JSONObject) results.get(i);
                        each_movie.setMovieTitle(first_movie_from_api.getString("original_title"));
                        each_movie.setMovieDate(first_movie_from_api.getString("release_date"));
                        each_movie.setMoviePoster(first_movie_from_api.getString("poster_path"));
                        movies.add(each_movie);

                    }
                    movieResponseListener.onResponse(movies);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MovieSingleton.getInstance(context).addToRequestQueue(request);
    }

}
