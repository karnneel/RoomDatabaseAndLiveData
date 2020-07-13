package com.example.roomdatabase.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roomdatabase.Films
import com.example.roomdatabase.listeners.FilmsLoadedListener

/**
 * Created by Neel.K (I197214).
 */
class FilmRepository : FilmsLoadedListener {

    private var mFilmsLiveData: MutableLiveData<List<Films>>? = null

    fun getAllFilms(context: Context): LiveData<List<Films>> {
        mFilmsLiveData = MutableLiveData()
        val loadAllFilmsAsyncTask = FilmAsyncTask(context, this)
        loadAllFilmsAsyncTask.execute()
        return mFilmsLiveData as MutableLiveData<List<Films>>
    }

    override fun onFilmsLoaded(result: List<Films>) {
        mFilmsLiveData!!.postValue(result)
    }
}