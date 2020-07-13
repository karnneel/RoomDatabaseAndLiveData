package com.example.roomdatabase.repository

import android.content.Context
import android.os.AsyncTask
import com.example.roomdatabase.APPRoomDatabase
import com.example.roomdatabase.Films
import com.example.roomdatabase.listeners.FilmsLoadedListener


/**
 * Created by Neel.K (I197214).
 */
class FilmAsyncTask(private val mContext: Context, private val mListener: FilmsLoadedListener) :
    AsyncTask<Void, Void, List<Films>>() {

    override fun doInBackground(vararg params: Void): List<Films> {
        val listFilms: List<Films> = prepareMovieData()

        APPRoomDatabase.getDatabase(mContext)!!.facilityDao()!!.insertFilmsIntoDataBase(listFilms)

        return APPRoomDatabase.getDatabase(mContext)!!.facilityDao()!!.getFilms()
    }

    override fun onPostExecute(result: List<Films>) {
        super.onPostExecute(result)
        mListener.onFilmsLoaded(result)
    }

    private fun prepareMovieData(): MutableList<Films> {
        val movieList: MutableList<Films> = ArrayList()
        var movie = Films(0, "Mad Max: Fury Road", "Action & Adventure", "2015")
        movieList.add(movie)
        movie = Films(1, "Inside Out", "Animation, Kids & Family", "2015")
        movieList.add(movie)
        movie = Films(2, "Star Wars: Episode VII - The Force Awakens", "Action", "2015")
        movieList.add(movie)
        movie = Films(3, "Shaun the Sheep", "Animation", "2015")
        movieList.add(movie)
        movie = Films(4, "The Martian", "Science Fiction & Fantasy", "2015")
        movieList.add(movie)
        movie = Films(5, "Mission: Impossible Rogue Nation", "Action", "2015")
        movieList.add(movie)
        movie = Films(6, "Up", "Animation", "2009")
        movieList.add(movie)
        movie = Films(7, "Star Trek", "Science Fiction", "2009")
        movieList.add(movie)
        movie = Films(8, "The LEGO Films", "Animation", "2014")
        movieList.add(movie)
        movie = Films(9, "Iron Man", "Action & Adventure", "2008")
        movieList.add(movie)
        movie = Films(10, "Aliens", "Science Fiction", "1986")
        movieList.add(movie)
        movie = Films(11, "Chicken Run", "Animation", "2000")
        movieList.add(movie)
        movie = Films(12, "Back to the Future", "Science Fiction", "1985")
        movieList.add(movie)
        movie = Films(13, "Raiders of the Lost Ark", "Action & Adventure", "1981")
        movieList.add(movie)
        movie = Films(14, "Goldfinger", "Action & Adventure", "1965")
        movieList.add(movie)
        movie = Films(15, "Guardians of the Galaxy", "Science Fiction & Fantasy", "2014")
        movieList.add(movie)
        return movieList
    }

}