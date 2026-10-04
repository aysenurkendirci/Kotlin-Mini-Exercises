package com.example.kisileruygulamasi.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kisileruygulamasi.data.entity.Kisiler

@Database(entities = [Kisiler::class], version = 1, exportSchema = false)
abstract class Veritabani : RoomDatabase() {

    abstract fun getKisilerDao(): KisilerDao

    companion object {
        @Volatile
        private var INSTANCE: Veritabani? = null

        fun getDatabase(context: Context): Veritabani {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Veritabani::class.java,
                    "kisiler_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
