package com.onelenyk.mybootcounterapplication.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.*
import androidx.room.OnConflictStrategy
import com.onelenyk.mybootcounterapplication.data.model.BootEventEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BootEventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBootEvent(bootEvent: BootEventEntity): Long

    @Delete
    fun deleteBootEvent(bootEvent: BootEventEntity)

    @Query("SELECT * FROM boot_event ORDER BY id ASC")
    fun getAllBootEvents(): List<BootEventEntity>

    @Query("SELECT COUNT(*) FROM boot_event")
    fun getBootEventCount(): Int

    @Query("SELECT * FROM boot_event ORDER BY timestamp ASC")
    fun getAllBootEventsFlow(): LiveData<List<BootEventEntity>>
}
