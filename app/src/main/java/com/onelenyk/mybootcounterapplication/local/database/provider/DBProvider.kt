package com.onelenyk.mybootcounterapplication.local.database.provider

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.onelenyk.mybootcounterapplication.MainApplication
import com.onelenyk.mybootcounterapplication.local.database.Database
import com.onelenyk.mybootcounterapplication.local.database.dao.BootEventDao

object DBProvider {
    private var roomInstance: Database? = null

    private fun getDb(context:Context): Database {
        if (roomInstance == null) {
            roomInstance = Room.databaseBuilder(
                context, Database::class.java, "Database"
            )
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .addCallback(object : RoomDatabase.Callback() {
                    //if need callback
                }).build()
        }

        return roomInstance as Database
    }

    fun getBootEventDao(context:Context = MainApplication.context): BootEventDao {
        return getDb(context).bootEventDao()
    }


}