package services;

import java.util.ArrayList;

import tasks.TaskLoadMoviesBoxOffice;
import callbacks.BoxOfficeMoviesLoadedListener;
import login.L;
import me.tatarka.support.job.JobParameters;
import me.tatarka.support.job.JobService;
import pojo.Movie;

/**
 * Created by Windows on 23-02-2015.
 */
public class ServiceMoviesBoxOffice extends JobService implements BoxOfficeMoviesLoadedListener {
    private JobParameters jobParameters;

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        L.t(this, "onStartJob");
        this.jobParameters = jobParameters;
        new TaskLoadMoviesBoxOffice(this).execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        L.t(this, "onStopJob");
        return false;
    }


    @Override
    public void onBoxOfficeMoviesLoaded(ArrayList<Movie> listMovies) {
        L.t(this, "onBoxOfficeMoviesLoaded");
        jobFinished(jobParameters, false);
    }
}

