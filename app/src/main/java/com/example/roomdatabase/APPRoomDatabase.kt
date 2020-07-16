package com.example.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * Created by Neel.K (M1045247) on 09-Sep-19.
 */
@Database(
    entities = [Films::class],
    version = 3, exportSchema = true
)
abstract class APPRoomDatabase : RoomDatabase() {
    abstract fun facilityDao(): RoomDatabaseDao?

    companion object {
        // marking the instance as volatile to ensure atomic access to the variable
        @Volatile
        private var INSTANCE: APPRoomDatabase? = null
        private val MIGRATION_1_2: Migration = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }

        @JvmStatic
        fun getDatabase(context: Context): APPRoomDatabase? {
            if (null == INSTANCE) {
                synchronized(APPRoomDatabase::class.java) {
                    if (null == INSTANCE) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            APPRoomDatabase::class.java, "films.db"
                        )
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            // Migration is not part of this codelab.
                            .addMigrations(MIGRATION_1_2)
                            .addCallback(sRoomDatabaseCallback)
                            .build()
                    }
                }
            }
            return INSTANCE
        }

        /**
         * Override the onOpen method to populate the database.
         * For this sample, we clear the database every time it is created or opened.
         *
         *
         * If you want to populate the database only when the database is created for the 1st time,
         * override RoomDatabase.Callback()#onCreate
         */
        private val sRoomDatabaseCallback: Callback = object : Callback() {}
    }
}