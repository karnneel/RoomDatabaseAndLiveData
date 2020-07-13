package com.example.roomdatabase.listeners

import com.example.roomdatabase.Films

interface FilmsLoadedListener {
    fun onFilmsLoaded(result: List<Films>)
}