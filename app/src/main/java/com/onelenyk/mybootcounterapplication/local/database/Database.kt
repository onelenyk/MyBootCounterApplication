package com.onelenyk.mybootcounterapplication.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.onelenyk.mybootcounterapplication.data.model.BootEventEntity
import com.onelenyk.mybootcounterapplication.local.database.dao.BootEventDao

@Database(
    entities = [
        BootEventEntity::class,
    ], version = 1, exportSchema = false
)
abstract class Database : RoomDatabase() {
    abstract fun bootEventDao(): BootEventDao
}