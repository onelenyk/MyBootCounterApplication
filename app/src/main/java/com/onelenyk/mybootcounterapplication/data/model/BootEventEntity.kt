package com.onelenyk.mybootcounterapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "boot_event")
data class BootEventEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    var timestamp: Long
)