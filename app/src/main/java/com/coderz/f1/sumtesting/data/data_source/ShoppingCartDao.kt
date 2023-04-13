package com.coderz.f1.sumtesting.data.data_source

import androidx.room.*
import com.coderz.f1.sumtesting.domain.model.ShoppingCartItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingCartDao {
    @Query("SELECT * FROM ShoppingCart")
    fun getShoppingCartContent(): Flow<List<ShoppingCartItem>>

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ShoppingCartItem)

    @Delete
    suspend fun deleteItem(item: ShoppingCartItem)

    @Query("SELECT SUM(price) FROM ShoppingCart")
    suspend fun getCartTotal():Double

    @Query("SELECT * FROM ShoppingCart WHERE id=:id")
    suspend fun getCartItemById(id:Int):ShoppingCartItem?
}