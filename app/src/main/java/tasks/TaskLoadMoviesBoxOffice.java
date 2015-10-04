package tasks;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;

import java.util.ArrayList;

import callbacks.BoxOfficeMoviesLoadedListener;
import extras.MovieUtils;
import fragments.FragmentBoxOffice;
import network.VolleySingleton;
import pojo.Movie;
import services.ServiceMoviesBoxOffice;

/**
 * Created by Windows on 02-03-2015.
 */
public class TaskLoadMoviesBoxOffice extends AsyncTask<Void, Void, ArrayList<Movie>> {
    private BoxOfficeMoviesLoadedListener myComponent;
    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;


    public TaskLoadMoviesBoxOffice(FragmentBoxOffice myComponent) {

        this.myComponent = myComponent;
        volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();
    }

    public TaskLoadMoviesBoxOffice(ServiceMoviesBoxOffice serviceMoviesBoxOffice) {

    }


    @Override
    protected ArrayList<Movie> doInBackground(Void... params) {

        ArrayList<Movie> listMovies = MovieUtils.loadBoxOfficeMovies(requestQueue);
        return listMovies;
    }

    @Override
    protected void onPostExecute(ArrayList<Movie> listMovies) {
        if (myComponent != null) {
            myComponent.onBoxOfficeMoviesLoaded(listMovies);
        }
    }


}
