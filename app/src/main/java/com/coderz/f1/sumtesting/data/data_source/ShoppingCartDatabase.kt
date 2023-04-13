package com.coderz.f1.sumtesting.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.coderz.f1.sumtesting.domain.model.ShoppingCartItem

@Database(entities = [ShoppingCartItem::class], version = 1)
abstract class ShoppingCartDatabase:RoomDatabase() {
    abstract val shoppingCardDao:ShoppingCartDao
    companion object{
        const val DATABASE_NAME="shopping_cart_db"
    }
}