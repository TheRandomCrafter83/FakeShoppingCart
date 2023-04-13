package com.coderz.f1.sumtesting.data

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.coderz.f1.sumtesting.data.data_source.ShoppingCartDatabase


class ShoppingCartDatabaseClient {

    private var databaseClient:ShoppingCartDatabase? = null

    fun getShoppingCartDatabaseClient(application: Application): ShoppingCartDatabase? {
        if (databaseClient == null){
            databaseClient = Room.databaseBuilder(
                application,
                ShoppingCartDatabase::class.java,
                ShoppingCartDatabase.DATABASE_NAME
            ).build()
        }
        return databaseClient
    }
}