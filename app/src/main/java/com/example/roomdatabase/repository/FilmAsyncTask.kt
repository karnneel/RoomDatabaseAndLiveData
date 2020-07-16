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
        APPRoomDatabase.getDatabase(mContext)!!.facilityDao()!!.deleteFilmsTable()
        APPRoomDatabase.getDatabase(mContext)!!.facilityDao()!!.insertFilmsIntoDataBase(listFilms)

        return APPRoomDatabase.getDatabase(mContext)!!.facilityDao()!!.getFilms()
    }

    override fun onPostExecute(result: List<Films>) {
        super.onPostExecute(result)
        mListener.onFilmsLoaded(result)
    }

    private fun prepareMovieData(): MutableList<Films> {
        val movieList: MutableList<Films> = ArrayList()

        var movie = Films()
        movie.filmName = "Mad Max: Fury Road"
        movie.genre = "Action & Adventure"
        movie.releaseYear= "2015"
        movieList.add(movie)

        movie = Films()
        movie.filmName = "Inside Out"
        movie.genre = "Animation, Kids & Family"
        movie.releaseYear= "2015"
        movieList.add(movie)

        movie = Films()
        movie.filmName = "Star Wars: Episode VII - The Force Awakens"
        movie.genre = "Action"
        movie.releaseYear= "2015"
        movieList.add(movie)

        movie = Films()
        movie.filmName = "Shaun the Sheep"
        movie.genre = "Animation"
        movie.releaseYear= "2015"
        movieList.add(movie)

        movie = Films()
        movie.filmName = "The Martian"
        movie.genre = "Science Fiction & Fantasy"
        movie.releaseYear= "2015"
        movieList.add(movie)

        movie = Films()
        movie.filmName = "Mission: Impossible Rogue Nation"
        movie.genre = "Action"
        movie.releaseYear= "2015"
        movieList.add(movie)

        movie = Films()
        movie.filmName = "Up"
        movie.genre = "Animation"
        movie.releaseYear= "2009"
        movieList.add(movie)

        movie = Films()
        movie.filmName = "Star Trek"
        movie.genre = "Science Fiction"
        movie.releaseYear= "2009"
        movieList.add(movie)

        movie = Films()
        movie.filmName = "The LEGO Films"
        movie.genre = "Animation"
        movie.releaseYear= "2014"
        movieList.add(movie)

        movie = Films()
        movie.filmName = "Iron Man"
        movie.genre = "Action & Adventure"
        movie.releaseYear= "2008"
        movieList.add(movie)

        movie = Films()
        movie.filmName = "Aliens"
        movie.genre = "Science Fiction"
        movie.releaseYear= "1986"
        movieList.add(movie)

        movie = Films()
        movie.filmName = "Chicken Run"
        movie.genre = "Animation"
        movie.releaseYear= "2000"
        movieList.add(movie)

        movie = Films()
        movie.filmName = "Back to the Future"
        movie.genre = "Science Fiction"
        movie.releaseYear= "1985"
        movieList.add(movie)

        movie = Films()
        movie.filmName = "Raiders of the Lost Ark"
        movie.genre = "Action & Adventure"
        movie.releaseYear= "1981"
        movieList.add(movie)

        movie = Films()
        movie.filmName = "Goldfinger"
        movie.genre = "Action & Adventure"
        movie.releaseYear= "1965"
        movieList.add(movie)

        movie = Films()
        movie.filmName = "Guardians of the Galaxy"
        movie.genre = "Science Fiction & Fantasy"
        movie.releaseYear= "2014"
        movieList.add(movie)
        return movieList
    }
}