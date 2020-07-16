package com.example.roomdatabase

import java.util.Comparator

/**
 * Created by Neel.K (I197214).
 */
class FilmsComparator : Comparator<Films> {
    override fun compare(o1: Films, o2: Films): Int {
        return when (val value1 = o2.releaseYear.compareTo(o1.releaseYear)) {
            0 -> {
                when (val value2 = o2.filmName.compareTo(o1.filmName)) {
                    0 -> {
                        o2.genre.compareTo(o1.genre)
                    }
                    else -> {
                        value2
                    }
                }
            }
            else -> value1
        }
    }
}