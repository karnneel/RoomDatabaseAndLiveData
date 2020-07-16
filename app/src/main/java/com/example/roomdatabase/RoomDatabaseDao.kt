package com.example.roomdatabase

import androidx.room.*


/**
 * Created by Neel.K (M1045247) on 10-Sep-19.
 */
@Dao
interface RoomDatabaseDao {


    @Query("Select * from Films")
    fun getFilms(): List<Films>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilmsIntoDataBase(filmsList : List<Films>)

    @Query("Delete from Films")
    fun deleteFilmsTable()
}