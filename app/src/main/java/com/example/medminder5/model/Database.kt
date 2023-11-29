package com.example.medminder5.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Obat::class, Riwayat::class], version = 1)
abstract class ObatDatabase : RoomDatabase() {
    abstract fun obatDao(): ObatDao

    companion object {
        @Volatile
        private var INSTANCE: ObatDatabase? = null

        fun getDatabase(context: Context): ObatDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ObatDatabase::class.java,
                    "obat_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}



fun getDatabase(context: Context): ObatDatabase {
    val db by lazy {
        Room.databaseBuilder(
            context,
            ObatDatabase::class.java,
            "habby.db"
        ).build()
    }
    return db
}