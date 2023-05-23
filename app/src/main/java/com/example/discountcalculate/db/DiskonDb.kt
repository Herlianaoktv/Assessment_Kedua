package com.example.discountcalculate.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DiskonEntity::class], version = 1, exportSchema = false)
abstract class DiskonDb : RoomDatabase() {
    abstract val dao: DiskonDao
    companion object {
        @Volatile
        private var INSTANCE: DiskonDb? = null
        fun getInstance(context: Context): DiskonDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DiskonDb::class.java,
                        "diskon.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance }
        }
    }
}