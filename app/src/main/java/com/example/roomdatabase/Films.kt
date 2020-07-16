package com.example.roomdatabase

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/*
    Created by Neel.K (M1045247) on 09 - Mar - 2020
*/
@Entity(tableName = "Films")
class Films {
    @PrimaryKey(autoGenerate = true)
    var _id: Int = 0
    var filmName: String = ""
    var genre: String = ""
    var releaseYear: String = ""
}

