package com.onelenyk.mybootcounterapplication.ui

import androidx.lifecycle.ViewModel
import com.onelenyk.mybootcounterapplication.local.database.provider.DBProvider

class FirstViewModel : ViewModel() {

    val eventDao = DBProvider.getBootEventDao()


    fun getAllBootEvents() = eventDao.getAllBootEventsFlow()

}