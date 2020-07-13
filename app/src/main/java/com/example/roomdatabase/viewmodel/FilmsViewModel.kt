package com.example.roomdatabase.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomdatabase.Films
import com.example.roomdatabase.repository.FilmRepository

/**
 * Created by Neel.K (I197214).
 */
class FilmsViewModel : ViewModel() {

    fun getAllFilms(context: Context): LiveData<List<Films>> {
        val filmRepository: FilmRepository = FilmRepository()
        return filmRepository.getAllFilms(context)
    }
}